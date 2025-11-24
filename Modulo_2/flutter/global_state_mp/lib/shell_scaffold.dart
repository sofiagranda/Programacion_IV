import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'core/state/app_state.dart';
import 'core/theme/theme_controller.dart';

class ShellScaffold extends StatelessWidget {
  final Widget child;
  final AppState app;
  final ThemeController theme;
  final String location;
  const ShellScaffold({
    super.key,
    required this.child,
    required this.app,
    required this.theme,
    required this.location,
  });

  int _indexFromLocation(String loc) {
    if (loc.startsWith('/settings')) return 1;
    if (loc.startsWith('/profile')) return 2;
    return 0;
  }

  @override
  Widget build(BuildContext context) {
    final currentIndex = _indexFromLocation(location);

    return Scaffold(
      appBar: AppBar(
        title: const Text('Control de Inventario'),
        actions: [
          Center(
            child: Padding(
              padding: const EdgeInsets.only(right: 12.0),
              child: Text('Items: ${app.count}', style: const TextStyle(fontWeight: FontWeight.w600)),
            ),
          ),
          IconButton(
            tooltip: 'Cambiar tema',
            onPressed: theme.toggle,
            icon: const Icon(Icons.brightness_6),
          ),
        ],
      ),
      body: child,
      bottomNavigationBar: NavigationBar(
        selectedIndex: currentIndex,
        onDestinationSelected: (i) {
          switch (i) {
            case 0: context.go('/home'); break;
            case 1: context.go('/settings'); break;
            case 2: context.go('/profile'); break;
          }
        },
        destinations: const [
          NavigationDestination(icon: Icon(Icons.inventory_2_outlined), selectedIcon: Icon(Icons.inventory_2), label: 'Inventario'),
          NavigationDestination(icon: Icon(Icons.settings_outlined), selectedIcon: Icon(Icons.settings), label: 'Ajustes'),
          NavigationDestination(icon: Icon(Icons.person_outline), selectedIcon: Icon(Icons.person), label: 'Perfil'),
        ],
      ),
    );
  }
}
