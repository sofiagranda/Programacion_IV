import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class SplitInventoryPage extends StatefulWidget {
  const SplitInventoryPage({super.key});

  @override
  State<SplitInventoryPage> createState() => _SplitInventoryPageState();
}

class _SplitInventoryPageState extends State<SplitInventoryPage> {
  String totalStockText = '';
  String boxesText = '';
  String resultText = '';

  void calculateSplit() {
    final totalStock = int.tryParse(totalStockText) ?? 0;
    final boxes = int.tryParse(boxesText) ?? 0;

    if (totalStock <= 0 || boxes <= 0) {
      setState(() {
        resultText = 'Ingrese valores válidos';
      });
      return;
    }

    final perBox = totalStock / boxes;

    setState(() {
      resultText =
        'Stock total: $totalStock\n'
        'Número de cajas: $boxes\n'
        'Cantidad por caja: ${perBox.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Distribuir inventario'),
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
              'Distribuir stock entre cajas',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Stock total',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                totalStockText = value;
              },
            ),
            const SizedBox(height: 16),

            TextField(
              decoration: const InputDecoration(
                labelText: 'Número de cajas',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                boxesText = value;
              },
            ),
            const SizedBox(height: 16),

            ElevatedButton(
              onPressed: calculateSplit,
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
