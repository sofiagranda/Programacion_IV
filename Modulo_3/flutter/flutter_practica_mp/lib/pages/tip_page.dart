import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class InventarioAjustePage extends StatefulWidget {
  const InventarioAjustePage({super.key});

  @override
  State<InventarioAjustePage> createState() => _InventarioAjustePageState();
}

class _InventarioAjustePageState extends State<InventarioAjustePage> {
  String adjustmentType = 'Agregar';
  String quantityText = '';
  String resultText = '';

  void adjustInventory() {
    final quantity = int.tryParse(quantityText) ?? 0;

    if (quantity <= 0) {
      setState(() {
        resultText = 'Ingrese una cantidad válida';
      });
      return;
    }

    int adjustedQuantity = adjustmentType == 'Agregar' ? quantity : -quantity;

    setState(() {
      resultText =
        'Tipo de ajuste: $adjustmentType\n'
        'Cantidad ajustada: $adjustedQuantity';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Ajustar inventario'),
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
              'Ajuste de inventario',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 16),

            DropdownButton<String>(
              value: adjustmentType,
              isExpanded: true,
              items: const [
                DropdownMenuItem(
                  value: 'Agregar',
                  child: Text('Agregar stock'),
                ),
                DropdownMenuItem(
                  value: 'Quitar',
                  child: Text('Quitar stock'),
                ),
              ],
              onChanged: (value) {
                if (value == null) return;
                setState(() {
                  adjustmentType = value;
                });
              },
            ),

            const SizedBox(height: 16),
            TextField(
              decoration: const InputDecoration(
                labelText: 'Cantidad a ajustar',
                border: OutlineInputBorder(),
              ),
              keyboardType: TextInputType.number,
              onChanged: (value) {
                quantityText = value;
              },
            ),

            const SizedBox(height: 16),
            ElevatedButton(
              onPressed: adjustInventory,
              child: const Text('Aplicar ajuste'),
            ),

            const SizedBox(height: 16),
            Text(resultText),
          ],
        ),
      ),
    );
  }
}
