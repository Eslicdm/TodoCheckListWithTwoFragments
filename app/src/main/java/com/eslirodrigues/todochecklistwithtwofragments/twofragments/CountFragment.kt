package com.eslirodrigues.todochecklistwithtwofragments.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eslirodrigues.todochecklistwithtwofragments.databinding.FragmentCountBinding

class CountFragment : Fragment() {

    private var _binding: FragmentCountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountBinding.inflate(inflater, container, false)

        val bundle: Bundle? = this.arguments

        val data: String? = bundle?.getString("key")

        binding.textViewFragmentCount.text = data

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}