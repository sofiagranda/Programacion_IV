import 'package:flutter/material.dart';
import '../../core/theme/theme_controller.dart';

class SettingsPage extends StatelessWidget {
  final ThemeController theme;
  const SettingsPage({super.key, required this.theme});

  @override
  Widget build(BuildContext context) {
    final isDark = theme.mode == ThemeMode.dark;

    return Scaffold(
      backgroundColor: const Color(0xFF0d1117),
      appBar: AppBar(
        title: const Text('Ajustes'),
        backgroundColor: const Color(0xFF161b22),
      ),
      body: ListView(
        padding: const EdgeInsets.all(16),
        children: [
          _GlassCard(
            child: SwitchListTile(
              title: const Text('Tema oscuro', style: TextStyle(color: Colors.white)),
              value: isDark,
              onChanged: (_) => theme.toggle(),
              subtitle: const Text('Se guarda en shared_preferences', style: TextStyle(color: Colors.white70)),
            ),
          ),
        ],
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
        border: Border.all(color: Colors.white.withOpacity(0.15)),
      ),
      padding: const EdgeInsets.all(12),
      margin: const EdgeInsets.only(bottom: 12),
      child: child,
    );
  }
}
