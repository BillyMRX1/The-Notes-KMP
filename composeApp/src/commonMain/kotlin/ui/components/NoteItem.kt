package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import util.extensions.toStringFormat
import domain.model.Note
import navigation.Screen
import util.Constant.EDIT_NOTES_ARGUMENT
import viewmodel.HomeViewModel

@Composable
fun NoteItem(
    note: Note,
    viewModel: HomeViewModel,
    navController: NavHostController,
) {
    if (viewModel.showDialog.value) {
        AlertDialog(
            onDismissRequest = { viewModel.dismissAlertDialog() },
            text = {
                Text(
                    "Are you sure you want to delete this note?",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.deleteNotes(viewModel.noteId.value)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(
                    onClick = { viewModel.dismissAlertDialog() }
                ) {
                    Text("Cancel")
                }
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    EDIT_NOTES_ARGUMENT,
                    note
                )
                navController.navigate(route = Screen.EditNotes.route)
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier.padding(16.dp).weight(1f)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = if (note.title.isEmpty().not()) note.title else note.content,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = if (note.content.isEmpty().not() && note.title.isEmpty()
                            .not()
                    ) note.content else "No text",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
                Text(
                    text = note.updatedAt.toStringFormat(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = {
                    viewModel.showAlertDialog(note.id)
                }
            ) {
                Icon(
                    Icons.Default.Delete,
                    "",
                )
            }
        }
    }
}
