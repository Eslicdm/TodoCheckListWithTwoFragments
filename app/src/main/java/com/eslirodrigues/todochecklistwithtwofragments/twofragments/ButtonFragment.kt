package com.eslirodrigues.todochecklistwithtwofragments.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eslirodrigues.todochecklistwithtwofragments.R
import com.eslirodrigues.todochecklistwithtwofragments.databinding.FragmentButtonBinding

class ButtonFragment : Fragment() {

    private var _binding: FragmentButtonBinding? = null
    private val binding get() = _binding!!
    var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentButtonBinding.inflate(inflater, container, false)

        binding.buttonFragmentAdd.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key", count++.toString())

            val fragment = CountFragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.containerCount, fragment)?.commit()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}