package com.example.final_application_2024.ui.login

import android.content.Intent
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
import com.example.final_application_2024.databinding.FragmentLoginBinding
import com.example.final_application_2024.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

//import com.example.final_application_2024.ui.login.R

@AndroidEntryPoint
class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }/**/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    uiState -> when(uiState) {
                        is LoginListUiState.InitialState -> {}
                        is LoginListUiState.Error -> {}
                        is LoginListUiState.LoggingIn -> {}
                        is LoginListUiState.LoggedIn -> {
                            /*val action = LoginFragmentDirections.actionLoginFragmentToFactionFragment()
                            view.findNavController().navigate(action)*/
                            toMain()
                            requireActivity().finish()
                        }
                    }
                }
            }
        }/**/
        binding.loginToRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            view.findNavController().navigate(action)
        }
        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            viewModel.onLogin(email, password)
        }
    }

    private fun toMain() = startActivity(Intent(requireContext(), MainActivity::class.java))
    /*private fun setProgress(isVisible:Boolean) {
        binding.loginProgressIndicator.isVisible = isVisible
    }
    private fun hideProgress() = setProgress(false)
    private fun showProgress() = setProgress(true)
    private fun setInputState(enable:Boolean) {
        binding.emailInput.isEnabled = enable
        binding.passwordInput.isEnabled = enable
        binding.loginButton.isEnabled = enable
    }
    private fun disableInput() = setInputState(false)
    private fun enableInput() = setInputState(true)
    private fun setError(message:String?=null) {
        binding.userPassword.error = message
        binding.userEmail.error = message
    }
    private fun showError(message:String) = setError(message)

    private fun hideError() = setError()*/

}