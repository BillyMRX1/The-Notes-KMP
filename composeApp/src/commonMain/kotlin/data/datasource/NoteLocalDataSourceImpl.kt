package data.datasource

import data.db.AppDatabase
import domain.model.Note
import org.koin.core.component.KoinComponent

class NoteLocalDataSourceImpl(private val appDatabase: AppDatabase) : NoteLocalDataSource {
    override suspend fun getAllNotes(): List<Note> = appDatabase.getDao().getAllNotes()

    override suspend fun createNote(note: Note) = appDatabase.getDao().createNote(note)

    override suspend fun deleteNote(id: Long) = appDatabase.getDao().deleteNoteById(id)

    override suspend fun updateNote(note: Note) = appDatabase.getDao().updateNote(note)

    override suspend fun getNote(id: Long) = appDatabase.getDao().getNoteById(id)
}