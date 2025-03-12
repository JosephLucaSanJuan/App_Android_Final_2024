package com.example.final_application_2024.ui.transformer

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
import com.example.final_application_2024.data.Transformer
import com.example.final_application_2024.data.TransformersRepository
import com.example.final_application_2024.databinding.FragmentTransformerEditBinding
import com.example.final_application_2024.ui.create_transformer.CreateRobotViewModel
import com.example.final_application_2024.ui.create_transformer.EditTransformerUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TransformerEditFragment @Inject constructor() : Fragment() {
    @Inject
    lateinit var repository: TransformersRepository
    private val args: TransformerEditFragmentArgs by navArgs()
    private lateinit var binding: FragmentTransformerEditBinding
    private val viewModel: CreateRobotViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransformerEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.ID
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState2.collect {
                    uiState2 -> when(uiState2) {
                        is EditTransformerUiState.InitialState -> {}
                        is EditTransformerUiState.Error -> {}
                        is EditTransformerUiState.Loading -> {}
                        is EditTransformerUiState.Finished -> {
                            val action = TransformerEditFragmentDirections.actionTransformerEditFragmentToTransformerListFragment()
                            view.findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        binding.updateTransformer.setOnClickListener {
            viewModel.updateRobot(
                id,
                Transformer(
                    id,
                    binding.nameInput.text.toString(),
                    binding.altModeInput.text.toString(),
                    binding.genderInput.text.toString()
                )
            )
        }
        binding.appBarButton.setNavigationOnClickListener {
            view.findNavController().popBackStack()
        }
    }
}