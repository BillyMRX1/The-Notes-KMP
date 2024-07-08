package db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.db.AppDatabase
import data.db.instantiateImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): AppDatabase {
    val dbFile = "${NSHomeDirectory()}/mrx_note.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}