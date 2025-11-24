import 'package:flutter/material.dart';
import 'core/theme/app_theme.dart' as app_theme;
import 'core/theme/theme_controller.dart';
import 'core/state/app_state.dart' as app_state;
import 'router.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  final theme = ThemeController();
  await theme.load();

  final app = app_state.AppState();

  final router = buildRouter(app: app, theme: theme);

  runApp(MyApp(theme: theme, app: app, routerConfig: router));
}

class MyApp extends StatelessWidget {
  final ThemeController theme;
  final app_state.AppState app;
  final RouterConfig<Object> routerConfig;

  const MyApp({
    super.key,
    required this.theme,
    required this.app,
    required this.routerConfig,
  });

  @override
  Widget build(BuildContext context) {
    return AnimatedBuilder(
      animation: Listenable.merge([theme, app]),
      builder: (context, _) {
        return MaterialApp.router(
          title: 'Control de Inventario',
          debugShowCheckedModeBanner: false,
          theme: app_theme.AppTheme.light(),
          darkTheme: app_theme.AppTheme.dark(),
          themeMode: theme.mode,
          routerConfig: routerConfig,
        );
      },
    );
  }
}
