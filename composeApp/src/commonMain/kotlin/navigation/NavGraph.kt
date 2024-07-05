package navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ui.page.CreateNotePage
import ui.page.HomePage

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomePage(navController)
        }
        composable(
            route = Screen.CreateNotes.route,
        ) {
            CreateNotePage(navController)
        }
//        composable(
//            route = Screen.EditNotes.route
//        ) {
//            val notes = navController.previousBackStackEntry?.savedStateHandle?.get<Notes>(EDIT_NOTES_ARGUMENT)
//            CreateNotesScreen(
//                navController,
//                isEditNote = true,
//                notes = notes
//            )
//        }
    }
}