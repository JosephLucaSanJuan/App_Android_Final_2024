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
import com.example.final_application_2024.databinding.FragmentFactionBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FactionFragment : Fragment() {

    companion object {
        fun newInstance() = FactionFragment()
    }

    private val viewModel: FactionViewModel by viewModels()
    private lateinit var binding: FragmentFactionBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.factionList
        recyclerView.adapter = FactionListAdapter()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    uiState -> when(uiState) {
                        is FactionListUiState.Error -> {}
                        is FactionListUiState.Loading -> {}
                        is FactionListUiState.Success -> {
                            (recyclerView.adapter as FactionListAdapter).submitList(viewModel.read())
                        }
                    }
                }
            }
        }
        binding.createFaction.setOnClickListener {
            val action = FactionFragmentDirections.actionFactionFragmentToCreateFactionFragment()
            view.findNavController().navigate(action)
        }
    }

}