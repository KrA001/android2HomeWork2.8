package com.example.android2homework28.interfaces

import com.example.android2homework28.data.models.NoteModels

interface OnClickItem {

    fun onLongClick(noteModels: NoteModels)

    fun onClick(noteModels: NoteModels)
}