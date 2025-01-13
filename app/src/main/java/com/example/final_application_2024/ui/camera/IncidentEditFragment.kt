package com.example.final_application_2024.ui.camera

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.final_application_2024.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IncidentEditFragment : Fragment() {

    companion object {
        fun newInstance() = IncidentEditFragment()
    }

    private val viewModel: IncidentEditViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_incident_edit, container, false)
    }
}