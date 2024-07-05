package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import viewmodel.HomeViewModel

@Composable
fun NoteList(viewModel: HomeViewModel) {
    if (viewModel.allNotes.value.isEmpty().not()) {
        NoteListItems(viewModel)
    } else {
        Box(modifier = Modifier.padding(bottom = 64.dp)) {
            EmptyState()
        }
    }
}