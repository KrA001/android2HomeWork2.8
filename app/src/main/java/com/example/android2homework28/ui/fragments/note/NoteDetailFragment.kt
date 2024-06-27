package com.example.android2homework28.ui.fragments.note

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.android2homework22.extensions.setBackStackData
import com.example.android2homework28.App
import com.example.android2homework28.R
import com.example.android2homework28.data.models.NoteModels
import com.example.android2homework28.databinding.FragmentNoteDetailBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class NoteDetailFragment : Fragment() {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding: FragmentNoteDetailBinding get() = _binding!!

    private var noteId: Int = -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        update()
        setupListene()
        setupListener()
        setupListeners()
        setupListenerss()
    }

    private fun update() {
        arguments?.let {
            noteId = it.getInt("noteId", -1)
        }
        if (noteId != -1) {
            val argsNote = App().getInstance()?.noteDao()?.getNoteById(noteId)
            argsNote?.let {model ->
                binding.etTitle.setText(model.title)
                binding.etDescription.setText(model.description)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListene() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.tvStr.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            if (noteId != -1) {
                val updateNote = NoteModels(etTitle, etDescription, color = "#151515", data = data)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else{
                App().getInstance()?.noteDao()?.insertNote(
                    NoteModels(
                        title = etTitle,
                        description = etDescription,
                        color = "#151515",
                        data = data
                    )
                )
            }
            findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListener() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnOne.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            if (noteId != -1) {
                val updateNote = NoteModels(etTitle, etDescription, color = "#FF9800", data = data)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else{
                App().getInstance()?.noteDao()?.insertNote(
                    NoteModels(
                        title = etTitle,
                        description = etDescription,
                        color = "#FF9800",
                        data = data
                    )
                )
            }
            findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListeners() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnTwo.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            if (noteId != -1) {
                val updateNote = NoteModels(etTitle, etDescription, color = "#EBE4C9", data = data)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else{
                App().getInstance()?.noteDao()?.insertNote(
                    NoteModels(
                        title = etTitle,
                        description = etDescription,
                        color = "#EBE4C9",
                        data = data
                    )
                )
            }
            findNavController().navigateUp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupListenerss() {
        val localDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM \nHH:mm", Locale("ru"))
        val data = localDateTime.format(formatter)

        binding.btnThree.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            if (noteId != -1) {
                val updateNote = NoteModels(etTitle, etDescription, color = "#571818", data = data)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else{
                App().getInstance()?.noteDao()?.insertNote(
                    NoteModels(
                        title = etTitle,
                        description = etDescription,
                        color = "#571818",
                        data = data
                    )
                )
            }
            findNavController().navigateUp()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

