import 'package:flutter/material.dart';
import '../../core/theme/theme_controller.dart';
import 'package:go_router/go_router.dart';

class HomePage extends StatelessWidget {
  final ThemeController theme;

  const HomePage({super.key, required this.theme});

  @override
  Widget build(BuildContext context) {
    final items = List.generate(5, (i) => i + 1);

    return Scaffold(
      backgroundColor: const Color(0xFF0d1117),
      appBar: AppBar(
        backgroundColor: const Color(0xFF161b22),
        title: const Text('Productos', style: TextStyle(color: Colors.white)),
        actions: [
          IconButton(
            tooltip: 'Cambiar tema',
            onPressed: theme.toggle,
            icon: const Icon(Icons.brightness_6, color: Colors.white),
          ),
        ],
      ),
      body: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            colors: [Color(0xFF1b1f2a), Color(0xFF2c3142)],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ),
        child: ListView.separated(
          padding: const EdgeInsets.all(16),
          itemCount: items.length,
          separatorBuilder: (_, __) => const SizedBox(height: 12),
          itemBuilder: (_, i) {
            final id = items[i];
            return _GlassCard(
              child: ListTile(
                title: Text('Producto #$id', style: const TextStyle(color: Colors.white, fontWeight: FontWeight.w600)),
                subtitle: const Text('Toca para ver detalle', style: TextStyle(color: Colors.white70)),
                trailing: const Icon(Icons.chevron_right, color: Colors.white),
                onTap: () => context.go('/detail/$id'),
              ),
            );
          },
        ),
      ),
    );
  }
}

class _GlassCard extends StatelessWidget {
  final Widget child;
  const _GlassCard({required this.child});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white.withOpacity(0.06),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.white.withOpacity(0.15), width: 1),
      ),
      child: child,
    );
  }
}
