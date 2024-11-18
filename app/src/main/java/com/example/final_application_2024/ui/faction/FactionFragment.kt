package com.example.final_application_2024.ui.faction

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.final_application_2024.databinding.FragmentFactionBinding

class FactionFragment : Fragment() {

    companion object {
        fun newInstance() = FactionFragment()
    }

    private val viewModel: FactionViewModel by viewModels()
    private lateinit var binding: FragmentFactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactionBinding.inflate(inflater, container, false)
        return binding.root
    }

}