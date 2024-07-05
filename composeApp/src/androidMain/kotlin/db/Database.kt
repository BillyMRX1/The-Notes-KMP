package db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.db.AppDatabase
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(ctx: Context): AppDatabase {
    val dbFile = ctx.getDatabasePath("mrx_note.db")
    return Room.databaseBuilder<AppDatabase>(ctx, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
//    val appContext = ctx.applicationContext
//    val dbFile = appContext.getDatabasePath("mrx_note.db")
//    return Room.databaseBuilder<AppDatabase>(
//        context = appContext,
//        name = dbFile.absolutePath
//    )
}