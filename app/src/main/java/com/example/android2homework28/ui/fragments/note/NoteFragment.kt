package com.example.android2homework28.ui.fragments.note

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2homework28.App
import com.example.android2homework28.R
import com.example.android2homework28.data.models.NoteModels
import com.example.android2homework28.databinding.FragmentNoteBinding
import com.example.android2homework28.interfaces.OnClickItem
import com.example.android2homework28.ui.adapters.NoteAdapter

class NoteFragment : Fragment(), OnClickItem {

    private var _binding: FragmentNoteBinding? = null
    private val binding: FragmentNoteBinding get() = _binding!!

    private val noteAdapter = NoteAdapter(this, this)
    private var isLinearLayout = true


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
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }
        ivCubes.setOnClickListener {
            toggleLayout()
        }
    }

    private fun toggleLayout() {
            if (isLinearLayout) {
                binding.rvNote.layoutManager = GridLayoutManager(requireContext(), 2)
            } else {
                binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            }
            isLinearLayout = !isLinearLayout
    }

    private fun getData() {
        App().getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }
    }

    override fun onLongClick(noteModels: NoteModels) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder) {
            setTitle("Вы точно хотите удалить")
            setPositiveButton("Да"){dialog, which ->
                App().getInstance()?.noteDao()?.deleteNote(noteModels)
                //App.appDatabase?.noteDao()?.deleteNote(noteModels)
            }
            setNegativeButton("Нет"){deialog, which ->
                deialog.cancel()
            }
            show()
        }
        builder.create()
    }

    override fun onClick(noteModels: NoteModels) {
        val action = NoteFragmentDirections.actionNoteFragmentToNoteDetailFragment(noteModels.id)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}