package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.model.Notes

@Composable
fun NoteList() {
    val noteList: List<Notes> =
        listOf(Notes(id = 1, title = "Title Notes", body = "Body Notes", createdAt = 1719394322000))

    if (noteList.isNullOrEmpty().not()) {
        NoteListItems(noteList)
    } else {
        Box(modifier = Modifier.padding(bottom = 64.dp)) {
            EmptyState()
        }
    }
}