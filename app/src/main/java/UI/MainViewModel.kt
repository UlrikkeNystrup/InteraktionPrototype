package UI

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class MainViewModel : ViewModel() {
    private val _currentScreen: MutableState<BottomBarScreen> = mutableStateOf(BottomBarScreen.Home)
    val currentScreen: MutableState<BottomBarScreen> = _currentScreen

    private val navController: NavController = rememberNavController()

    fun onBackPressed(): Boolean {
        return navController.popBackStack()
    }

    fun navigateTo(screen: BottomBarScreen) {
        if (currentScreen.value != screen) {
            navController.navigate(screen.route)
            _currentScreen.value = screen
        }
    }
}