package com.example.final_application_2024.ui.faction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.final_application_2024.R
import com.example.final_application_2024.data.FactionRepository
import com.example.final_application_2024.databinding.FragmentFactionEditBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FactionEditFragment @Inject constructor() : Fragment() {
    @Inject
    lateinit var repository:FactionRepository
    private val args: FactionEditFragmentArgs by navArgs()
    private lateinit var binding: FragmentFactionEditBinding
    private val viewModel: CreateFactionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactionEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.Id
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState2.collect {
                    uiState -> when(uiState) {
                        is EditFactionUiState.InitialState -> {
                            viewModel.getFaction(id)
                        }
                        is EditFactionUiState.Error -> {}
                        is EditFactionUiState.Loading -> {}
                        is EditFactionUiState.Finished -> {
                            val action = CreateFactionFragmentDirections.actionCreateFactionFragmentToFactionFragment()
                            view.findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        binding.updateFaction.setOnClickListener {
            viewModel.updateFaction(id)
        }
        binding.appBarButton.setNavigationOnClickListener {
            view.findNavController().popBackStack()
        }
    }
}