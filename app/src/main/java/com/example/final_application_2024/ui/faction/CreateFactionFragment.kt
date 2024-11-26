package com.example.final_application_2024.ui.faction

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.example.final_application_2024.R
import com.example.final_application_2024.databinding.FragmentCreateFactionBinding
import kotlinx.coroutines.launch

class CreateFactionFragment : Fragment() {

    companion object {
        fun newInstance() = CreateFactionFragment()
    }

    private val viewModel: CreateFactionViewModel by viewModels()
    private lateinit var binding: FragmentCreateFactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCreateFactionBinding.inflate(
            inflater,
            container,
            false
        ).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {}
            }
        }
        binding.saveFaction.setOnClickListener {
            val action = CreateFactionFragmentDirections.actionCreateFactionFragmentToFactionFragment()
            view.findNavController().navigate(action)
        }
    }
}