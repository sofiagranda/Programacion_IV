import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'core/state/app_state.dart';
import 'core/theme/theme_controller.dart';
import 'features/home/home_page.dart';
import 'features/home/detail_page.dart';
import 'features/settings/settings_page.dart';
import 'features/profile/profile_page.dart';
import 'shell_scaffold.dart';

GoRouter buildRouter({
  required AppState app,
  required ThemeController theme,
}) {
  return GoRouter(
    initialLocation: '/home',  // Ruta inicial de la aplicación
    refreshListenable: Listenable.merge([theme, app]),  // Escucha los cambios en el tema y el estado
    routes: [
      // Definimos el ShellRoute que actúa como contenedor principal para las rutas secundarias
      ShellRoute(
        builder: (context, state, child) {
          // Usamos 'ShellScaffold' para envolver las páginas
          return ShellScaffold(
            child: child,
            app: app,    // Pasamos 'app' al Scaffold
            theme: theme,  // Pasamos 'theme' al Scaffold
            location: state.uri.toString(),  // Pasamos la ubicación actual
          );
        },
        routes: [
          // Ruta principal /home
          GoRoute(
            path: '/home',
            builder: (context, state) {
              return HomePage(app: app, theme: theme);  // Pasamos 'app' y 'theme' a HomePage
            },
            routes: [
              // Ruta secundaria dentro de /home para los detalles
              GoRoute(
                path: 'detail/:id',  // Ruta dinámica para los detalles
                builder: (context, state) {
                  final id = state.pathParameters['id'] ?? '—';
                  return DetailPage(id: id);  // Pasamos el 'id' a la página de detalles
                },
              ),
            ],
          ),
          // Ruta de configuración /settings
          GoRoute(
            path: '/settings',
            builder: (context, state) {
              return SettingsPage(theme: theme);  // Pasamos 'theme' a SettingsPage
            },
          ),
          // Ruta de perfil /profile
          GoRoute(
            path: '/profile',
            builder: (context, state) {
              return ProfilePage(app: app);  // Pasamos 'app' a ProfilePage
            },
          ),
        ],
      ),
    ],
  );
}
