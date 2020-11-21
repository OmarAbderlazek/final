package com.example.finalproject.avtivities

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.Adapter
import com.example.finalproject.R
import com.example.finalproject.retrofit.ApiClient
import com.example.finalproject.retrofit.PostsInterface
import com.example.finalproject.retrofit.RecyclerviewData
import kotlinx.android.synthetic.main.activity_recycler_view_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import kotlin.math.log

class RecyclerViewScreen : AppCompatActivity() {
    lateinit var api: PostsInterface
    lateinit var Adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_screen)
        supportActionBar?.hide()
        //   val gettingUserPhone = intent.getStringExtra("phone_info")
        //   val gettingUserPass = intent.getStringExtra("pass_info")

        Recycler_View.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        Recycler_View.setHasFixedSize(true)

        api = ApiClient.getClient(this).create(PostsInterface::class.java)
        api.getAllPosts().enqueue(object : Callback<List<RecyclerviewData>> {
            override fun onResponse(call: Call<List<RecyclerviewData>>, response: Response<List<RecyclerviewData>>) {
                if (response.isSuccessful) {
                    response.body()
                    Recycler_View.adapter = Adapter(response.body()!!)
                    Adapter.notifyDataSetChanged()
                    Log.d("test",response.code().toString())
                }
            }

            override fun onFailure(call: Call<List<RecyclerviewData>>, t: Throwable) {
                Log.d("failure",t.message.toString())
            }

        }
        )


    }
}