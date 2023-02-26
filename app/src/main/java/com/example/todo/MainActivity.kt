package com.example.todo

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.adapters.TodoAdapter
import com.example.todo.api.ApiService
import com.example.todo.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity(){

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var todoAdapter: TodoAdapter = TodoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.recyclerView.apply {
            adapter = todoAdapter
            layoutManager = LinearLayoutManager(context)
        }
        binding.addTodo.setOnClickListener {
            todoAdapter.addItem(binding.inputTodo.text.toString())
        }
        getStationList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private suspend fun getStationList(){
        try {
            val response = ApiService
                .builder
                .getStationList().execute()
            if (response.isSuccessful) {
                val stations = response.body()
                Log.d(TAG,stations.toString())
                // 성공적으로 응답을 받은 경우 stations를 처리
            } else {
                // 응답 코드가 200 이외인 경우 에러 처리
            }
        } catch (e: IOException) {
            // 네트워크 에러 처리
        }

    }
}

