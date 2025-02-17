package com.example.final_application_2024.ui.create_transformer

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
import com.example.final_application_2024.databinding.FragmentCreateRobotBinding
import com.example.final_application_2024.ui.transformer.TransformersListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CreateRobotFragment : Fragment() {

    companion object {
        fun newInstance() = CreateRobotFragment()
    }

    private val viewModel: CreateRobotViewModel by viewModels()
    private lateinit var binding: FragmentCreateRobotBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateRobotBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val adapter = TransformersListAdapter()
        val rv = binding.createRobot
        rv.adapter = adapter*/
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect {
                    uiState -> when(uiState) {
                        is CreateRobotListUiState.Error -> {}
                        is CreateRobotListUiState.InitialState -> {}
                        is CreateRobotListUiState.Loading -> {}
                        is CreateRobotListUiState.Finished -> {
                            val action = CreateRobotFragmentDirections.actionCreateRobotFragmentToTransformerListFragment()
                            view.findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        binding.saveTransformer.setOnClickListener {
            viewModel.createRobot(
                binding.nameInput.text.toString(),
                binding.altModeInput.text.toString(),
                binding.genderSelection.toString()
            )
        }
    }

}