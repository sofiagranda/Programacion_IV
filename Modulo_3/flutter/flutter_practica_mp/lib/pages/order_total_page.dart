import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class InventarioTotalPage extends StatefulWidget {
  const InventarioTotalPage({super.key});

  @override
  State<InventarioTotalPage> createState() => _InventarioTotalPageState();
}

class _InventarioTotalPageState extends State<InventarioTotalPage> {
  String precioUnitarioText = '';
  String cantidadText = '';
  String resultText = '';

  void calculateTotal() {
    final precioUnitario = double.tryParse(precioUnitarioText.replaceAll(',', '.')) ?? 0.0;
    final cantidad = int.tryParse(cantidadText) ?? 0;

    if (precioUnitario <= 0 || cantidad <= 0) {
      setState(() {
        resultText = 'Ingrese precio y cantidad válidos';
      });
      return;
    }

    final totalProducto = precioUnitario * cantidad;

    setState(() {
      resultText =
        'Precio Unitario: \$${precioUnitario.toStringAsFixed(2)}\n'
        'Cantidad: $cantidad\n'
        'Total del Producto: \$${totalProducto.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Total por Producto'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            const Text(
              'Calcular total del producto en inventario',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Precio Unitario (\$)',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                precioUnitarioText = value;
              },
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Cantidad',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                cantidadText = value;
              },
            ),
            const SizedBox(height: 16),

            ElevatedButton(
              onPressed: calculateTotal,
              child: const Text('Calcular'),
            ),
            const SizedBox(height: 16),
            Text(resultText),
          ],
        ),
      ),
    );
  }
}
