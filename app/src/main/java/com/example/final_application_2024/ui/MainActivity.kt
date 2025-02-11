package com.example.final_application_2024.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.final_application_2024.R
import com.example.final_application_2024.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var naViewModel: NavigationSharedViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.main_navigation_host) as NavHostFragment
        val navController = navHostFragment.navController/***/
        binding.mainBottomNav.setupWithNavController(navController)

        naViewModel = ViewModelProvider(this)[NavigationSharedViewModel::class.java]
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                naViewModel.navigationEvents.collect { event ->
                    when(event) {
                        is NavigationEvent.toTransformers -> {
                            navController.navigate(
                                R.id.transformers,
                                null,
                                NavOptions.Builder().setPopUpTo(R.id.homeFragment, false).build()
                            )
                        }
                        is NavigationEvent.toFactions -> {
                            navController.navigate(
                                R.id.faction,
                                null,
                                NavOptions.Builder().setPopUpTo(R.id.homeFragment, false).build()
                            )
                        }
                        is NavigationEvent.ToHome -> {}
                    }
                }
            }
        }

        navController.addOnDestinationChangedListener { _,destination,_ ->
            val hideNavbar = destination.arguments["hideNavbar"]
            binding.mainBottomNav.isVisible = true
            hideNavbar?.let {
                binding.mainBottomNav.isVisible = false
            }
        }
    }
}