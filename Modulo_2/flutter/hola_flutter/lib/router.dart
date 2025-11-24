import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'core/theme/theme_controller.dart';
import 'features/home/home_page.dart';
import 'features/detail/detail_page.dart';

void main() {
  final themeController = ThemeController(); // Crea una instancia de ThemeController
  
  runApp(MyApp(themeController: themeController));
}

class MyApp extends StatelessWidget {
  final ThemeController themeController;

  MyApp({required this.themeController});

  @override
  Widget build(BuildContext context) {
    // Configura el GoRouter y lo pasa al MaterialApp.router
    final router = buildRouter(themeController);

    return MaterialApp.router(
      routerConfig: router, // Conectar GoRouter con MaterialApp
      title: 'Flutter App',
      theme: ThemeData.light(), // Tema por defecto, se puede cambiar con ThemeController
    );
  }
}

// Configuración de GoRouter
GoRouter buildRouter(ThemeController theme) {
  return GoRouter(
    refreshListenable: theme,  // Escucha los cambios en el tema
    routes: [
      GoRoute(
        path: '/',
        builder: (context, state) => HomePage(theme: theme),
      ),
      GoRoute(
        path: '/detail/:id',
        builder: (context, state) {
          final id = state.pathParameters['id'] ?? '—';
          return DetailPage(id: id);
        },
      ),
    ],
  );
}
