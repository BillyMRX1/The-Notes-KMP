package ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import viewmodel.HomeViewModel

@Composable
fun NoteList(viewModel: HomeViewModel, navController: NavHostController) {
    if (viewModel.allNotes.value.isEmpty().not()) {
        NoteListItems(viewModel, navController)
    } else {
        Box(modifier = Modifier.padding(bottom = 64.dp)) {
            EmptyState()
        }
    }
}