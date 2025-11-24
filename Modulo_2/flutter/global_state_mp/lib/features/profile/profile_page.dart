import 'package:flutter/material.dart';
import '../../../core/state/app_state.dart';

class ProfilePage extends StatelessWidget {
  final AppState app;
  const ProfilePage({super.key, required this.app});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFF0d1117),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            _GlassCard(
              child: Column(
                children: [
                  const CircleAvatar(
                    radius: 50,
                    backgroundImage: NetworkImage('https://i.pravatar.cc/150'),
                  ),
                  const SizedBox(height: 12),
                  const Text(
                    'John Smith',
                    style: TextStyle(color: Colors.white, fontSize: 22, fontWeight: FontWeight.w700),
                  ),
                  Text(
                    'user@example.com',
                    style: TextStyle(color: Colors.white70),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 16),
            _GlassCard(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const Text('Métricas', style: TextStyle(color: Colors.white, fontWeight: FontWeight.w600)),
                  const SizedBox(height: 6),
                  Text('Productos: 42 — Pedidos: 17 — Puntos: 5978',
                      style: TextStyle(color: Colors.white70)),
                ],
              ),
            ),
            const SizedBox(height: 24),
            ElevatedButton(
              onPressed: () {},
              style: ElevatedButton.styleFrom(
                backgroundColor: const Color(0xFFff2fd8),
                padding: const EdgeInsets.symmetric(vertical: 14, horizontal: 24),
                shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
              ),
              child: const Text('Cerrar sesión', style: TextStyle(fontWeight: FontWeight.bold)),
            )
          ],
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
      padding: const EdgeInsets.all(16),
      child: child,
    );
  }
}
