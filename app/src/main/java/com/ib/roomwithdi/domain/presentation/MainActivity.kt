package com.ib.roomwithdi.domain.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ib.roomwithdi.R
import com.ib.roomwithdi.adapter.MyAdapter
import com.ib.roomwithdi.data.User
import com.ib.roomwithdi.domain.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val myViewModel: MyViewModel by viewModels()
    private val myAdapter = MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveName = findViewById<EditText>(R.id.editTextSaveName)
        val btnSave = findViewById<Button>(R.id.buttonSaveName)
        val btnGet = findViewById<Button>(R.id.buttonGetName)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        btnSave.setOnClickListener {
            val user = User(saveName.text.toString())
            myViewModel.addName(user)
        }

        btnGet.setOnClickListener {
            myViewModel.getName.observe(this, Observer { name ->
                myAdapter.setNames(name)
            })
        }
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}