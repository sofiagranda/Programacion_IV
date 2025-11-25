
import 'package:flutter/material.dart';

void main() {
  runApp(PropinasApp());
}

class PropinasApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Calculadora de Propinas',
      home: PropinasScreen(),
    );
  }
}

class PropinasScreen extends StatefulWidget {
  @override
  _PropinasScreenState createState() => _PropinasScreenState();
}

class _PropinasScreenState extends State<PropinasScreen> {
  int mesas = 1;
  List<TextEditingController> consumos = [];
  double porcentajePropina = 0.10;
  List<double> propinasPorMesa = [];
  double totalGeneral = 0;

  @override
  void initState() {
    super.initState();
    _crearControladores();
  }

  void _crearControladores() {
    consumos = List.generate(mesas, (_) => TextEditingController());
  }

  void _calcularPropinas() {
    propinasPorMesa.clear();
    totalGeneral = 0;

    for (int i = 0; i < mesas; i++) {
      double consumo = double.tryParse(consumos[i].text) ?? 0;
      double propina = consumo * porcentajePropina;
      propinasPorMesa.add(propina);
      totalGeneral += propina;
    }

    setState(() {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Calculadora de Propinas')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text('Número de mesas:'),
                DropdownButton<int>(
                  value: mesas,
                  items: List.generate(10, (index) => index + 1)
                      .map((e) => DropdownMenuItem<int>(
                            value: e,
                            child: Text('$e'),
                          ))
                      .toList(),
                  onChanged: (value) {
                    setState(() {
                      mesas = value!;
                      _crearControladores();
                    });
                  },
                ),
              ],
            ),
            SizedBox(height: 16),

            Expanded(
              child: ListView.builder(
                itemCount: mesas,
                itemBuilder: (context, index) {
                  return TextField(
                    controller: consumos[index],
                    keyboardType: TextInputType.number,
                    decoration: InputDecoration(
                      labelText: 'Consumo Mesa ${index + 1}',
                    ),
                  );
                },
              ),
            ),

            SizedBox(height: 16),

            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text('Porcentaje de propina:'),
                DropdownButton<double>(
                  value: porcentajePropina,
                  items: [
                    DropdownMenuItem(value: 0.10, child: Text('10%')),
                    DropdownMenuItem(value: 0.12, child: Text('12%')),
                    DropdownMenuItem(value: 0.15, child: Text('15%')),
                  ],
                  onChanged: (value) {
                    setState(() {
                      porcentajePropina = value!;
                    });
                  },
                ),
              ],
            ),

            SizedBox(height: 16),

            ElevatedButton(
              onPressed: _calcularPropinas,
              child: Text('Calcular'),
            ),

            SizedBox(height: 16),
            if (propinasPorMesa.isNotEmpty)
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('Propinas por mesa:'),
                  ...propinasPorMesa
                      .asMap()
                      .entries
                      .map((e) => Text(
                          'Mesa ${e.key + 1}: \$${e.value.toStringAsFixed(2)}')),
                  SizedBox(height: 8),
                  Text('Total general: \$${totalGeneral.toStringAsFixed(2)}',
                      style: TextStyle(fontWeight: FontWeight.bold)),
                ],
              ),
          ],
        ),
      ),
    );
  }
}
