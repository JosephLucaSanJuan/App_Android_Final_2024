package com.example.final_application_2024.ui.home

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.final_application_2024.R
import com.example.final_application_2024.databinding.FragmentHomeBinding
import com.example.final_application_2024.ui.NavigationSharedViewModel
import com.example.final_application_2024.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeBinding
    private val naViewModel: NavigationSharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.topAppBar.setOnMenuItemClickListener { mi ->
            when(mi.itemId) {
                R.id.logout -> {
                    viewModel.onLogOut()
                    true
                }
                else -> false
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect{ uiState ->
                    when(uiState) {
                        is HomeUiState.Loading -> {}
                        is HomeUiState.Error -> {}
                        is HomeUiState.LoggedIn -> {
                            //binding.factionCount.text = resources.getQuantityString(uiState.factions, uiState.factions)
                            //binding.transformerCount.text = resources.getQuantityString(uiState.transformers,uiState.transformers)
                        }
                        is HomeUiState.LoggedOut -> {
                            val intent = Intent(requireContext(),LoginActivity::class.java)
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            startActivity(intent)
                        }
                    }
                }
            }
        }/**/
    }
}