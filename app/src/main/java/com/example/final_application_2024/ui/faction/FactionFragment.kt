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
import com.example.final_application_2024.databinding.FragmentFactionBinding
import kotlinx.coroutines.launch

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.factionList
        recyclerView.adapter = FactionListAdapter()
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    uiState -> when(uiState) {
                        is FactionListUiState.Error -> TODO()
                        is FactionListUiState.Loading -> TODO()
                        is FactionListUiState.Success -> {
                            (recyclerView.adapter as FactionListAdapter).submitList(viewModel.read())
                        }
                    }
                }
            }
        }
    }

}