package data.datasource

import data.db.AppDatabase
import domain.model.Note
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NoteLocalDataSourceImpl : NoteLocalDataSource, KoinComponent {
    private val appDatabase: AppDatabase by inject()

    override suspend fun getAllNotes(): List<Note> = appDatabase.getDao().getAllNotes()

    override suspend fun createNote(note: Note) = appDatabase.getDao().createNote(note)

    override suspend fun deleteNote(id: Long) = appDatabase.getDao().deleteNoteById(id)

    override suspend fun updateNote(note: Note) = appDatabase.getDao().updateNote(note)
}