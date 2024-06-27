package data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val title: String,
    val body: String,
    val createdAt: Long?
)