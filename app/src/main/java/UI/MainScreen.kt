package UI

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavbardemo.ui.BottomBarScreen

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val currentScreen by viewModel.currentScreen.observeAsState()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home) },
                    label = { Text("Home") },
                    selected = currentScreen == BottomBarScreen.Home,
                    onClick = { viewModel.navigateTo(BottomBarScreen.Home) }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person) },
                    label = { Text("Profile") },
                    selected = currentScreen == BottomBarScreen.Profile,
                    onClick = { viewModel.navigateTo(BottomBarScreen.Profile) }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Settings) },
                    label = { Text("Settings") },
                    selected = currentScreen == BottomBarScreen.Settings,
                    onClick = { viewModel.navigateTo(BottomBarScreen.Settings) }
                )
            }
        }
    ) {
        NavHost(navController = viewModel.navController, startDestination = BottomBarScreen.Home.route) {
            composable(route = BottomBarScreen.Home.route) {
                HomeScreen()
            }
            composable(route = BottomBarScreen.Profile.route) {
                ProfileScreen()
            }
            composable(route = BottomBarScreen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}
