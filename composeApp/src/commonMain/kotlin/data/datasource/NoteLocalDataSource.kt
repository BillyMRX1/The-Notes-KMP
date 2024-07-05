package data.datasource

import domain.model.Note

interface NoteLocalDataSource {
    suspend fun getAllNotes(): List<Note>
    suspend fun createNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun updateNote(note: Note)
}