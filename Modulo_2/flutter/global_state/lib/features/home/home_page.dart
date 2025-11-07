import 'package:flutter/material.dart';
import '../../core/theme/theme_controller.dart';  // Importa ThemeController
import 'package:go_router/go_router.dart';  // Importación de go_router

class HomePage extends StatelessWidget {
  final ThemeController theme;

  const HomePage({super.key, required this.theme});

  @override
  Widget build(BuildContext context) {
    final items = List.generate(5, (i) => i + 1);  // Genera una lista de elementos

    return Scaffold(
      appBar: AppBar(
        title: const Text('Inicio'),
        actions: [
          IconButton(
            tooltip: 'Cambiar tema',
            onPressed: theme.toggle,  // Cambiar tema al presionar el ícono
            icon: const Icon(Icons.brightness_6),
          ),
        ],
      ),
      body: ListView.separated(
        padding: const EdgeInsets.all(16),
        itemCount: items.length,
        separatorBuilder: (_, __) => const SizedBox(height: 8),
        itemBuilder: (_, i) {
          final id = items[i];
          return Card(
            child: ListTile(
              title: Text('Elemento #$id'),
              subtitle: const Text('Toca para ver detalle'),
              trailing: const Icon(Icons.chevron_right),
              onTap: () => context.go('/detail/$id'),  // Navegación a la página de detalle
            ),
          );
        },
      ),
    );
  }
}
