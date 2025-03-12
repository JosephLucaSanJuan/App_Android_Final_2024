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
import androidx.navigation.fragment.findNavController
import com.example.final_application_2024.R
import com.example.final_application_2024.databinding.FragmentTransformerListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TransformerListFragment : Fragment() {
    private val viewModel: TransformerViewModel by viewModels()
    private lateinit var binding: FragmentTransformerListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTransformerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.transformersList
        recyclerView.adapter = TransformersListAdapter(::toTransformer)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    uiState -> when(uiState){
                        is TransformersListUiState.Error -> {}
                        is TransformersListUiState.Loading -> {}
                        is TransformersListUiState.Success -> {
                            (recyclerView.adapter as TransformersListAdapter).submitList(viewModel.read())
                        }
                    }
                }
            }
        }
        binding.createRobotFab.setOnClickListener {
            val action = TransformerListFragmentDirections.actionTransformerListFragmentToCreateRobotFragment()
            view.findNavController().navigate(action)
        }
    }

    private fun toTransformer(id:Int) {
        val action = TransformerListFragmentDirections.actionTransformerListFragmentToTransformerEditFragment(id)
        findNavController().navigate(action)
    }
}