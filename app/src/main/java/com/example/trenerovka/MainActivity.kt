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
        mAdapter.onClick = { }
    }

    private fun setData() {
        mAdapter.onClick = { }
        val list: MutableList<User> = mutableListOf()
        val list1: MutableList<User> = mutableListOf()
        for (i in 1..25) {
            var user = User(i, true)
            list.add(user)
        }
        for (i in 1..25) {
            var user = User(i, true)
            list1.add(user)
        }
        mAdapter.models = list
        mAdapter.models = list1
        list1.shuffle()
        list.shuffle()
    }
}