package data.repository

import data.datasource.NoteLocalDataSource
import domain.model.Note
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NoteRepositoryImpl : NoteRepository,
    KoinComponent {
    private val repository: NoteLocalDataSource by inject()

    override suspend fun getAllNotes(): List<Note> = repository.getAllNotes()

    override suspend fun createNote(note: Note) = repository.createNote(note)

    override suspend fun updateNote(note: Note) = repository.updateNote(note)

    override suspend fun deleteNote(id: Long) = repository.deleteNote(id)

    override suspend fun getNote(id: Long): Note? = repository.getNote(id)
}