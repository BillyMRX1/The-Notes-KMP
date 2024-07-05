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
import androidx.navigation.NavHostController
import navigation.Screen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import ui.components.HomeTopAppBar
import ui.components.NoteList
import viewmodel.HomeViewModel

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomePage(navController: NavHostController) {
    val viewModel: HomeViewModel = koinViewModel()

    viewModel.getAllNotes()

    Scaffold(
        topBar = {
            HomeTopAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(route = Screen.CreateNotes.route)
                },
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp),
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            NoteList(viewModel)
        }
    }
}