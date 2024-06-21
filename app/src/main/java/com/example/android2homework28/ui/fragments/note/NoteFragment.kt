package com.example.android2homework28.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2homework22.extensions.getBackStackData
import com.example.android2homework28.R
import com.example.android2homework28.data.models.NoteModels
import com.example.android2homework28.databinding.FragmentNoteBinding
import com.example.android2homework28.ui.adapters.NoteAdapter
import com.example.android2homework28.utils.PreferenceHelper

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding get() = _binding!!

    private val noteAdapter = NoteAdapter()
    private val list : ArrayList<NoteModels> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        getData()
    }

    private fun initialize() {
        binding.rvNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setupListeners() = with(binding) {
//        val preferenceHelper = PreferenceHelper()
//        preferenceHelper.unit(requireContext())
//        btnSave.setOnClickListener {
//            val et = edText.text.toString()
//            preferenceHelper.text =et
//            txtSave.text = et
//        }
//        txtSave.text = preferenceHelper.text
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }
    }

    private fun getData() {
        getBackStackData<String>("key"){ data->
            val noteModels = NoteModels(data)
            list.add(noteModels)
            noteAdapter.submitList(list)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}