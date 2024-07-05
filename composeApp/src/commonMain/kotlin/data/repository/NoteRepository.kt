package data.repository

import domain.model.Note

interface NoteRepository {
    suspend fun getAllNotes(): List<Note>
    suspend fun createNote(note: Note)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: Long)
}