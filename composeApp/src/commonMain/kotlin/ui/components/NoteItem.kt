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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.extensions.toStringFormat
import data.model.Notes

@Composable
fun NoteItem(
    note: Notes,
) {
//    if (showDialog == true) {
//        AlertDialog(
//            onDismissRequest = { viewModel.dismissAlertDialog() },
//            text = {
//                Text(
//                    stringResource(R.string.title_alert_dialog_delete_notes),
//                    style = MaterialTheme.typography.titleMedium
//                )
//            },
//            confirmButton = {
//                Button(
//                    onClick = {
//                        viewModel.dismissAlertDialog()
//                        viewModel.deleteNotes(viewModel.noteId.value.getValueOrZero())
//                    }
//                ) {
//                    Text("OK")
//                }
//            },
//            dismissButton = {
//                Button(
//                    onClick = { viewModel.dismissAlertDialog() }
//                ) {
//                    Text("Cancel")
//                }
//            }
//        )
//    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp))
            .clickable { }
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
                    text = if (note.title.isEmpty().not()) note.title else note.body,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    maxLines = 1
                )
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = if (note.body.isEmpty().not() && note.title.isEmpty()
                            .not()
                    ) note.body else "No text",
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
                Text(
                    text = note.createdAt.toStringFormat(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = {

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
