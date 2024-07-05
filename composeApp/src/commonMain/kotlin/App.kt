import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import navigation.NavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.AppTheme

@Composable
@Preview
fun App() {
    val navController: NavHostController = rememberNavController()
    AppTheme {
        NavGraph(navController = navController)
    }
}