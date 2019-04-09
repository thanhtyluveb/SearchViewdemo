package com.example.searchviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapterString: ArrayAdapter<String>


    var listString: List<String> = listOf("1", "2", "3", "4")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapterString = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, listString
        )
        listview.adapter = adapterString

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapterString.filter.filter(newText)

                return false
            }

        })

    }
}


