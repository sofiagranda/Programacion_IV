
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

void main() => runApp(const VentasPage());

class VentasPage extends StatelessWidget {
  const VentasPage({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Resumen de Ventas Diarias',
      theme: ThemeData(
        useMaterial3: true,
        colorSchemeSeed: Colors.teal,
      ),
      home: const DailyIncomePage(),
    );
  }
}

class DailyIncomePage extends StatefulWidget {
  const DailyIncomePage({super.key});

  @override
  State<DailyIncomePage> createState() => _DailyIncomePageState();
}

class _DailyIncomePageState extends State<DailyIncomePage> {
  int servicios = 1;
  List<TextEditingController> montosCtrl = [];
  double total = 0.0;
  String categoria = '';

  @override
  void initState() {
    super.initState();
    _crearControladores(servicios);
  }

  void _crearControladores(int n) {
    for (final c in montosCtrl) {
      c.dispose();
    }
    montosCtrl = List.generate(n, (_) => TextEditingController());
  }

  void _calcularTotal() {
    double suma = 0.0;

    for (int i = 0; i < servicios; i++) {
      final value = double.tryParse(montosCtrl[i].text.trim());
      if (value == null || value < 0) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Monto inválido en servicio ${i + 1}')),
        );
        return;
      }
      suma += value;
    }

    setState(() {
      total = suma;
      categoria = _clasificarDia(total);
    });
  }

  String _clasificarDia(double t) {
    if (t < 200) return 'Día flojo';
    if (t <= 500) return 'Día aceptable';
    return 'Día excelente';
  }

  void _reiniciar() {
    setState(() {
      servicios = 1;
      _crearControladores(servicios);
      total = 0.0;
      categoria = '';
    });
  }

  @override
  void dispose() {
    for (final c in montosCtrl) {
      c.dispose();
    }
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('DailyIncomePage'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => context.go('/'),
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.restart_alt),
            tooltip: 'Reiniciar',
            onPressed: _reiniciar,
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            Row(
              children: [
                const Text(
                  'Servicios/Rentas del día:',
                  style: TextStyle(fontWeight: FontWeight.w600),
                ),
                const SizedBox(width: 12),
                DropdownButton<int>(
                  value: servicios,
                  items: List.generate(50, (i) => i + 1)
                      .map((e) => DropdownMenuItem(
                            value: e,
                            child: Text('$e'),
                          ))
                      .toList(),
                  onChanged: (v) {
                    if (v == null) return;
                    setState(() {
                      servicios = v;
                      _crearControladores(servicios);
                      total = 0.0;
                      categoria = '';
                    });
                  },
                ),
              ],
            ),
            const SizedBox(height: 12),

            Expanded(
              child: ListView.separated(
                itemCount: servicios,
                separatorBuilder: (_, __) => const SizedBox(height: 8),
                itemBuilder: (context, index) {
                  return TextField(
                    controller: montosCtrl[index],
                    keyboardType: const TextInputType.numberWithOptions(decimal: true),
                    decoration: InputDecoration(
                      labelText: 'Monto servicio ${index + 1}',
                      prefixText: '\$ ',
                      border: const OutlineInputBorder(),
                    ),
                  );
                },
              ),
            ),

            const SizedBox(height: 12),

            SizedBox(
              width: double.infinity,
              child: FilledButton.icon(
                icon: const Icon(Icons.calculate),
                label: const Text('Calcular total'),
                onPressed: _calcularTotal,
              ),
            ),

            const SizedBox(height: 12),

            if (categoria.isNotEmpty)
              Container(
                width: double.infinity,
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Theme.of(context).colorScheme.primaryContainer,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      'Total del día: \$${total.toStringAsFixed(2)}',
                      style: const TextStyle(
                          fontSize: 16, fontWeight: FontWeight.bold),
                    ),
                    const SizedBox(height: 6),
                    Row(
                      children: [
                        const Icon(Icons.assessment),
                        const SizedBox(width: 8),
                        Text(
                          categoria,
                          style: const TextStyle(fontSize: 16),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
          ],
        ),
      ),
    );
  }
}
