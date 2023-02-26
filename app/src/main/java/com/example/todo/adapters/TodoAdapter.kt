package com.example.todo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.TodoItemBinding

class TodoAdapter() : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    var todoList: ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = todoList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    // Set View Holder
    inner class TodoViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.deleteButton.setOnClickListener{
                removeItem(adapterPosition)
            }
        }
        fun bind(data: String) {
            binding.todo.text = data
        }
    }

    fun addItem (item : String){
        todoList.add(item)
        // notifyDataSetChanged() 보다 notifyItemInserted(Index) 사용하는게 속도가 빠름
        notifyItemInserted(todoList.size -1)
    }
    fun removeItem (index : Int){
        todoList.removeAt(index)
        // notifyDataSetChanged() 보다 notifyItemRemoved(Index) 사용하는게 속도가 빠름
        notifyItemRemoved(index)
    }

}
