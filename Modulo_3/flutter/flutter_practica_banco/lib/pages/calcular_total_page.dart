import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class CalcularTotalPage extends StatefulWidget {
  @override
  _CalcularTotalPageState createState() => _CalcularTotalPageState();
}

class _CalcularTotalPageState extends State<CalcularTotalPage> {
  final _precioController = TextEditingController();
  final _cantidadController = TextEditingController();
  String _resultado = '';
  double _descuento = 0;

  void _calcularTotal() {
    double precio = double.tryParse(_precioController.text) ?? 0;
    int cantidad = int.tryParse(_cantidadController.text) ?? 0;
    double subtotal = precio * cantidad;

    double descuento = 0;
    if (_tipoCliente == 'Frecuente') {
      descuento = 0.08; // 8%
    } else if (_tipoCliente == 'Corporativo') {
      descuento = 0.12; // 12%
    }
    double totalConDescuento = subtotal - (subtotal * descuento);

    setState(() {
      _resultado = 'Subtotal: \$${subtotal.toStringAsFixed(2)}\n'
                   'Descuento: ${descuento * 100}%\n'
                   'Total: \$${totalConDescuento.toStringAsFixed(2)}';
    });
  }

  String _tipoCliente = 'Nuevo';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Calcular Total del Menú'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: _precioController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Precio Base del Menú',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),
            TextField(
              controller: _cantidadController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Cantidad de Menús',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),
            DropdownButton<String>(
              value: _tipoCliente,
              items: ['Nuevo', 'Frecuente', 'Corporativo']
                  .map((e) => DropdownMenuItem(
                        child: Text(e),
                        value: e,
                      ))
                  .toList(),
              onChanged: (value) {
                setState(() {
                  _tipoCliente = value!;
                });
              },
              isExpanded: true,
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: _calcularTotal,
              child: Text('Calcular Total'),
            ),
            SizedBox(height: 20),
            Text(
              _resultado,
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
    );
  }
}
