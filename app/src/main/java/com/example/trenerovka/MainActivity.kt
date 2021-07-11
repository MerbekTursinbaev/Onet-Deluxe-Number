package com.example.trenerovka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   private val mAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = mAdapter
        setData()
    }

  private fun setData() {
        val list: MutableList<User> = mutableListOf()
        for (i in 1..25) {
            var user = User(i,true)
            list.add(user)
        }
      for (i in 1..25) {
          var user = User(i,true)
          list.add(user)
      }
      mAdapter.models = list
      list.shuffle()
    }
}