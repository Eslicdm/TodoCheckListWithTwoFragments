package com.eslirodrigues.todochecklistwithtwofragments.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eslirodrigues.todochecklistwithtwofragments.databinding.FragmentTodoListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)

        todoAdapter = TodoAdapter(mutableListOf(), fragmentManager?.beginTransaction())

        binding.recyclerList.adapter = todoAdapter
        binding.recyclerList.layoutManager = LinearLayoutManager(context)

        binding.buttonSend.setOnClickListener {
            val text = binding.editTextMessage.text.toString()
            if (text.isNotEmpty()) {
                val todo = Todo(text)
                todoAdapter.addTodo(todo)
                binding.editTextMessage.text.clear()
            }
        }

        binding.buttonDelete.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}