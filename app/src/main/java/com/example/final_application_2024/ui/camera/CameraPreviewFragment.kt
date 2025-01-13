package com.example.final_application_2024.ui.camera

import android.content.ContentValues
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCapture.OnImageSavedCallback
import androidx.camera.core.ImageCapture.OutputFileOptions
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.LifecycleCameraController
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.final_application_2024.R
import com.example.final_application_2024.databinding.FragmentCameraPreviewBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.Executors

@AndroidEntryPoint
class CameraPreviewFragment : Fragment() {

    private lateinit var binding: FragmentCameraPreviewBinding
    private lateinit var cameraController: LifecycleCameraController
    private val viewModel: IncidentEditViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraPreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preview = binding
        cameraController = LifecycleCameraController(requireContext())
        cameraController.bindToLifecycle(this)
        cameraController.cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        //preview.controller = cameraController
    }

    private fun captureImageToDisk() {
        val name = SimpleDateFormat(FILENAME_PATTERN, Locale.getDefault())
            .format(System.currentTimeMillis())

        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        }

        val outputOptions = OutputFileOptions.Builder(
            requireContext().contentResolver,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            contentValues
        ).build()

        cameraController.takePicture(
            outputOptions,
            Executors.newSingleThreadExecutor(),
            object: OnImageSavedCallback {
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                    viewModel.onImageCaptured(outputFileResults.savedUri)
                    findNavController().popBackStack()
                }

                override fun onError(exception: ImageCaptureException) {
                    exception.message?.let {
                        Toast.makeText(
                            requireContext(),
                            exception.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        )
    }

    companion object {
        private const val FILENAME_PATTERN = "yyyy-MM-dd HH-mm-ss"
    }
}