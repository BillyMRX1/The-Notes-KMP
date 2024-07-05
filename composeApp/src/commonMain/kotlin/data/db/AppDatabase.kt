package data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import domain.model.Note
import org.koin.core.component.KoinComponent

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase(), DB {
    abstract fun getDao(): NoteDao
    override fun clearAllTables(): Unit {}
}

interface DB {
    fun clearAllTables(): Unit {}
}
