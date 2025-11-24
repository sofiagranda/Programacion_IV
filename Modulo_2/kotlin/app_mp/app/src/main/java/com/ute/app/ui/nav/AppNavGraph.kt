package com.ute.app.ui.nav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.ute.app.ui.components.AppTopBar
import com.ute.app.ui.screens.*

@Composable
fun AppNavGraph() {
    val nav = rememberNavController()
    val current by nav.currentBackStackEntryAsState()
    val currentRoute = current?.destination?.route ?: NavRoute.Home.route
    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarMsg by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(snackbarMsg) { snackbarMsg?.let { snackbarHostState.showSnackbar(it); snackbarMsg = null } }

    val colors = MaterialTheme.colorScheme

    Scaffold(
        topBar = {
            AppTopBar(
                title = when (currentRoute) {
                    NavRoute.Home.route -> "Inicio"
                    NavRoute.Posts.route -> "Posts"
                    NavRoute.Account.route -> "Mi cuenta"
                    NavRoute.Settings.route -> "Ajustes"
                    NavRoute.Gallery.route -> "Galería"
                    NavRoute.Video.route -> "Video"
                    else -> "Control Inventario"
                }
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = colors.surface,
                contentColor = colors.onSurface
            ) {
                NavRoute.bottomTabs.forEach { tab ->
                    NavigationBarItem(
                        selected = currentRoute.startsWith(tab.route),
                        onClick = {
                            nav.navigate(tab.route) {
                                popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Text(tab.emoji) },
                        label = { Text(tab.label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colors.primary,
                            selectedTextColor = colors.primary,
                            unselectedIconColor = colors.onSurfaceVariant,
                            unselectedTextColor = colors.onSurfaceVariant
                        )
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(snackbarHostState) { data ->
                Snackbar(
                    snackbarData = data,
                    containerColor = colors.secondaryContainer,
                    contentColor = colors.onSecondaryContainer
                )
            }
        }
    ) { inner ->
        NavHost(navController = nav, startDestination = NavRoute.Home.route, modifier = Modifier.padding(inner)) {
            composable(NavRoute.Home.route) {
                HomeScreen(
                    goTo = { route -> nav.navigate(route) },
                    goToDetail = { id -> nav.navigate(NavRoute.PostDetail.build(id)) }
                )
            }
            composable(NavRoute.Posts.route) { PostsListScreen(openDetail = { id -> nav.navigate(NavRoute.PostDetail.build(id)) }) }
            composable(NavRoute.Account.route) { AccountScreen(openSettings = { nav.navigate(NavRoute.Settings.route) }) }
            composable(NavRoute.Settings.route) { SettingsScreen() }
            composable(NavRoute.Gallery.route) { GalleryScreen() }
            composable(NavRoute.Video.route) { VideoScreen() }
            composable(
                route = NavRoute.PostDetail.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { back ->
                val id = back.arguments?.getInt("id") ?: -1
                PostDetailScreen(id = id)
            }
        }
    }
}
