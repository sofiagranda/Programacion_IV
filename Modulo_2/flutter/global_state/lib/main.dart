import 'package:flutter/material.dart';
import 'core/theme/app_theme.dart' as app_theme;  // Alias para app_theme
import 'core/theme/theme_controller.dart';
import 'core/state/app_state.dart' as app_state;  // Alias para app_state
import 'router.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  final theme = ThemeController();
  await theme.load();

  final app = app_state.AppState();  // Usamos el alias 'app_state' para acceder a AppState

  final router = buildRouter(app: app, theme: theme);

  runApp(MyApp(theme: theme, app: app, routerConfig: router));
}

class MyApp extends StatelessWidget {
  final ThemeController theme;
  final app_state.AppState app;  // Usa el alias 'app_state' aquí
  final RouterConfig<Object> routerConfig;

  const MyApp({
    super.key,
    required this.theme,
    required this.app,
    required this.routerConfig,
  });

  @override
  Widget build(BuildContext context) {
    // Redibuja cuando el tema o el estado de la app cambien
    return AnimatedBuilder(
      animation: Listenable.merge([theme, app]),
      builder: (context, _) {
        return MaterialApp.router(
          title: 'Flutter — Shell + BottomNav',
          debugShowCheckedModeBanner: false,
          theme: app_theme.AppTheme.light(),  // Usa el alias 'app_theme' aquí
          darkTheme: app_theme.AppTheme.dark(),  // Usa el alias 'app_theme' aquí
          themeMode: theme.mode,
          routerConfig: routerConfig,
        );
      },
    );
  }
}
