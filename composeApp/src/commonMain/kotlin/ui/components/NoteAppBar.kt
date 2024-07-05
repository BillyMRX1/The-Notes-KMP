package ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import viewmodel.CreateNoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteAppBar(navController: NavHostController, viewModel: CreateNoteViewModel) {
    TopAppBar(
        title = {
            Text(
                text = "The Notes",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    "",
                )
            }
        },
        actions = {
            if (viewModel.isNoteValid.value) {
                IconButton(
                    onClick = {
                        viewModel.saveNotes()
                    }
                ) {
                    Icon(
                        Icons.Filled.Check,
                        ""
                    )
                }
            }
        }
    )
}