import 'package:flutter/material.dart';

class InventarioPedidoPage extends StatefulWidget {
  @override
  _InventarioPedidoPageState createState() => _InventarioPedidoPageState();
}

class _InventarioPedidoPageState extends State<InventarioPedidoPage> {
  final _nombreProductoController = TextEditingController();
  final _precioController = TextEditingController();
  final _cantidadController = TextEditingController();

  String _resultado = '';
  String _errorMessage = '';
  List<Map<String, dynamic>> _productos = [];

  void _agregarProducto() {
    String nombre = _nombreProductoController.text;
    double precio = double.tryParse(_precioController.text) ?? 0;
    int cantidad = int.tryParse(_cantidadController.text) ?? 0;

    if (nombre.isEmpty || precio <= 0 || cantidad <= 0) {
      setState(() {
        _errorMessage = 'Por favor ingresa datos válidos';
        _resultado = '';
      });
      return;
    }

    _productos.add({
      'nombre': nombre,
      'precio': precio,
      'cantidad': cantidad,
      'total': precio * cantidad,
    });

    double totalInventario = _productos.fold(
        0, (sum, item) => sum + (item['precio'] * item['cantidad']));

    setState(() {
      _resultado =
          'Producto agregado: $nombre\nTotal inventario: \$${totalInventario.toStringAsFixed(2)}';
      _errorMessage = '';
      _nombreProductoController.clear();
      _precioController.clear();
      _cantidadController.clear();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Control de Inventario de Pedidos'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: _nombreProductoController,
              decoration: InputDecoration(
                labelText: 'Nombre del Producto',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),
            TextField(
              controller: _precioController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Precio Unitario',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),
            TextField(
              controller: _cantidadController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Cantidad',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),
            ElevatedButton(
              onPressed: _agregarProducto,
              child: Text('Agregar al Inventario'),
            ),
            SizedBox(height: 20),
            if (_errorMessage.isNotEmpty)
              Text(
                _errorMessage,
                style: TextStyle(color: Colors.red, fontSize: 16),
              ),
            if (_resultado.isNotEmpty)
              Text(
                _resultado,
                style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
            SizedBox(height: 20),
            Expanded(
              child: ListView.builder(
                itemCount: _productos.length,
                itemBuilder: (context, index) {
                  final producto = _productos[index];
                  return ListTile(
                    title: Text(producto['nombre']),
                    subtitle: Text(
                        'Precio: \$${producto['precio']} x Cantidad: ${producto['cantidad']} = \$${producto['total']}'),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
