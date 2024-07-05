package navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_page")
    object CreateNotes : Screen("create_note")
    object EditNotes : Screen("edit_note")
}