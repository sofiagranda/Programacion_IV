package com.ute.app.ui.nav

sealed class NavRoute(val route: String, val label: String, val emoji: String) {
    object Home : NavRoute("home", "Inicio", "🏠")
    object Posts : NavRoute("posts", "Posts", "📝")
    object Account : NavRoute("account", "Cuenta", "👤")
    object PostDetail : NavRoute("post-detail/{id}", "Detalle", "ℹ️") {
        fun build(id: Int) = "post-detail/$id"
    }
    object Settings : NavRoute("settings", "Ajustes", "⚙️")
    object Gallery : NavRoute("gallery", "Galería", "🖼️")
    object Video : NavRoute("video", "Video", "🎬")

    companion object {
        val bottomTabs = listOf(Home, Posts, Account)
    }
}
