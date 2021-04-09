package com.eslirodrigues.todochecklistwithtwofragments.checklist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.eslirodrigues.todochecklistwithtwofragments.R
import com.eslirodrigues.todochecklistwithtwofragments.databinding.TodoListItemBinding

class TodoAdapter(private var todos: MutableList<Todo>, var ft: FragmentTransaction?) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    class TodoViewHolder(val binding: TodoListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(TodoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.binding.apply {
            textViewItem.text = curTodo.todo
            checkboxItem.isChecked = curTodo.isChecked
            strikeThrough(textViewItem, curTodo.isChecked)
            checkboxItem.setOnCheckedChangeListener { _, isChecked ->
                strikeThrough(textViewItem, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }

            imageViewNewListItem.setOnClickListener {
                if (ft?.isEmpty == true){
                    ft?.replace(R.id.containerMainList, NewListFragment())?.addToBackStack(null)?.commit()
                }
            }
        }
    }

    override fun getItemCount() = todos.size

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemChanged(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun strikeThrough(textView: TextView, isChecked: Boolean) {
        if (isChecked) {
            textView.paintFlags = textView.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            textView.paintFlags = textView.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}