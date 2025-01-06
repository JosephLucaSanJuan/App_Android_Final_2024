package com.example.final_application_2024.ui.register

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
import androidx.navigation.fragment.findNavController
import com.example.final_application_2024.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val surname = binding.surnameInput.text.toString()
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            viewModel.onRegister(name, surname, email, password)
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    uiState -> when(uiState) {
                        is RegisterListUiState.InitialState -> {
                            /*hideError()
                            enableInput()*/
                        }
                        is RegisterListUiState.Error -> {
                            /*enableInput()
                            showError(uiState.message)*/
                        }
                        is RegisterListUiState.Loading -> {
                            disableInput()
                            hideError()
                        }
                        is RegisterListUiState.Registered -> {
                            hideError()
                            findNavController().popBackStack()
                            binding.registerButton.setOnClickListener {
                                val action = RegisterFragmentDirections.actionRegisterFragmentToFactionFragment()
                                view.findNavController().navigate(action)
                            }
                        }
                    }
                }
            }
        }
        binding.registerToLogin.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            view.findNavController().navigate(action)
        }
    }

    private fun disableInput() {
        binding.registerButton.isEnabled = false
        binding.nameInput.isEnabled = false
        binding.surnameInput.isEnabled = false
        binding.emailInput.isEnabled = false
        binding.passwordInput.isEnabled = false
        binding.confirmPassword.isEnabled = false
    }
    private fun enableInput() {
        binding.registerButton.isEnabled = true
        binding.nameInput.isEnabled = false
        binding.surnameInput.isEnabled = false
        binding.emailInput.isEnabled = true
        binding.passwordInput.isEnabled = true
        binding.confirmPassword.isEnabled = true
    }
    private fun showError(message:String) {
        binding.name.error = message
        binding.surname.error = message
        binding.email.error = message
        binding.password.error = message
    }
    private fun hideError() {
        binding.name.error = null
        binding.surname.error = null
        binding.email.error = null
        binding.password.error = null
    }

}