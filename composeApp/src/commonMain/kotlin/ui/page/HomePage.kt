package ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.HomeTopAppBar
import ui.components.NoteList

@Composable
fun HomePage() {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp),
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NoteList()
        }
    }
}