import 'package:flutter/material.dart';

class CalcularPedidoPage extends StatefulWidget {
  @override
  _CalcularPedidoPageState createState() => _CalcularPedidoPageState();
}

class _CalcularPedidoPageState extends State<CalcularPedidoPage> {
  final _cantidadPlatoController = TextEditingController();
  final _cantidadBebidaController = TextEditingController();
  final _cantidadAcompanamientoController = TextEditingController();

  // Variables para almacenar el tipo seleccionado
  String _tipoPlato = 'Pollo';
  String _tipoBebida = 'Gaseosa';
  String _tipoAcompanamiento = 'Papas';

  // Precios fijos
  final Map<String, double> preciosPlatos = {'Pollo': 6, 'Carne': 7, 'Vegetariano': 5};
  final Map<String, double> preciosBebidas = {'Gaseosa': 2, 'Jugo': 3, 'Agua': 1};
  final Map<String, double> preciosAcompanamientos = {'Papas': 2, 'Ensalada': 2.5, 'Pan': 1.5};

  String _resultado = '';
  String _errorMessage = '';  // Variable para mostrar el mensaje de error

  // Función para calcular el total
  void _calcularTotal() {
    setState(() {
      _errorMessage = '';  // Limpiar el mensaje de error al intentar calcular
    });

    // Obtener las cantidades ingresadas
    int cantidadPlatos = int.tryParse(_cantidadPlatoController.text) ?? 0;
    int cantidadBebidas = int.tryParse(_cantidadBebidaController.text) ?? 0;
    int cantidadAcompanamientos = int.tryParse(_cantidadAcompanamientoController.text) ?? 0;

    if (cantidadPlatos <= 0 || cantidadBebidas <= 0 || cantidadAcompanamientos <= 0) {
      setState(() {
        _errorMessage = 'Las cantidades deben ser mayores que 0.';
      });
      return;  // No hacer nada si hay un error
    }

    double subtotalPlato = preciosPlatos[_tipoPlato]! * cantidadPlatos;
    double subtotalBebida = preciosBebidas[_tipoBebida]! * cantidadBebidas;
    double subtotalAcompanamiento = preciosAcompanamientos[_tipoAcompanamiento]! * cantidadAcompanamientos;

    double total = subtotalPlato + subtotalBebida + subtotalAcompanamiento;

    setState(() {
      _resultado = 'Subtotal:\n'
                   'Platos: \$${subtotalPlato.toStringAsFixed(2)}\n'
                   'Bebidas: \$${subtotalBebida.toStringAsFixed(2)}\n'
                   'Acompañamientos: \$${subtotalAcompanamiento.toStringAsFixed(2)}\n\n'
                   'Total: \$${total.toStringAsFixed(2)}';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Calcular Pedido'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            // Tipo de plato
            DropdownButton<String>(
              value: _tipoPlato,
              items: ['Pollo', 'Carne', 'Vegetariano']
                  .map((e) => DropdownMenuItem(
                        child: Text(e),
                        value: e,
                      ))
                  .toList(),
              onChanged: (value) {
                setState(() {
                  _tipoPlato = value!;
                });
              },
              isExpanded: true,
              hint: Text('Selecciona el tipo de plato'),
            ),
            SizedBox(height: 16),

            // Cantidad de platos
            TextField(
              controller: _cantidadPlatoController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Cantidad de Platos',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),

            // Tipo de bebida
            DropdownButton<String>(
              value: _tipoBebida,
              items: ['Gaseosa', 'Jugo', 'Agua']
                  .map((e) => DropdownMenuItem(
                        child: Text(e),
                        value: e,
                      ))
                  .toList(),
              onChanged: (value) {
                setState(() {
                  _tipoBebida = value!;
                });
              },
              isExpanded: true,
              hint: Text('Selecciona el tipo de bebida'),
            ),
            SizedBox(height: 16),

            // Cantidad de bebidas
            TextField(
              controller: _cantidadBebidaController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Cantidad de Bebidas',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),

            // Tipo de acompañamiento
            DropdownButton<String>(
              value: _tipoAcompanamiento,
              items: ['Papas', 'Ensalada', 'Pan']
                  .map((e) => DropdownMenuItem(
                        child: Text(e),
                        value: e,
                      ))
                  .toList(),
              onChanged: (value) {
                setState(() {
                  _tipoAcompanamiento = value!;
                });
              },
              isExpanded: true,
              hint: Text('Selecciona el tipo de acompañamiento'),
            ),
            SizedBox(height: 16),

            // Cantidad de acompañamientos
            TextField(
              controller: _cantidadAcompanamientoController,
              keyboardType: TextInputType.number,
              decoration: InputDecoration(
                labelText: 'Cantidad de Acompañamientos',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16),

            // Botón de calcular
            ElevatedButton(
              onPressed: _calcularTotal,
              child: Text('Calcular Total'),
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
          ],
        ),
      ),
    );
  }
}
