import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class InventarioHomePage extends StatelessWidget {
  const InventarioHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Control de Inventario')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text(
              'Seleccione una opción:',
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 24),

            ElevatedButton(
              onPressed: () => context.go('/inventario-total'),
              child: const Text('Calcular total por producto'),
            ),
            const SizedBox(height: 12),

            ElevatedButton(
              onPressed: () => context.go('/inventario-agregar'),
              child: const Text('Agregar producto al inventario'),
            ),
            const SizedBox(height: 12),

            ElevatedButton(
              onPressed: () => context.go('/inventario-lista'),
              child: const Text('Ver lista de productos'),
            ),
          ],
        ),
      ),
    );
  }
}
