import 'package:flutter/material.dart';

void main() {
  int stock = 0;

  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: const Text('Control de Inventario')),
        body: StatefulBuilder(
          builder: (context, setState) {
            return Center(
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Text('Stock actual: $stock', style: const TextStyle(fontSize: 28)),
                  const SizedBox(height: 16),
                  ElevatedButton(
                    onPressed: () => setState(() => stock++),
                    child: const Text('Agregar unidad'),
                  ),
                  const SizedBox(height: 8),
                  ElevatedButton(
                    onPressed: () => setState(() => stock > 0 ? stock-- : 0),
                    child: const Text('Quitar unidad'),
                  ),
                ],
              ),
            );
          },
        ),
      ),
    ),
  );
}
