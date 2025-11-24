import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    const bg = Color(0xFF0d1117);
    const card = Color(0xFF161b22);
    const text = Color(0xFFc9d1d9);
    const primary = Color(0xFF58a6ff);
    const accent = Color(0xFF2ea043);
    const border = Color(0xFF30363d);

    final theme = ThemeData(
      useMaterial3: true,
      brightness: Brightness.dark,
      scaffoldBackgroundColor: bg,
      colorScheme: ColorScheme.fromSeed(
        seedColor: primary,
        brightness: Brightness.dark,
        primary: primary,
        secondary: accent,
        surface: card,
        outline: border,
      ),
      cardColor: card,
      textTheme: const TextTheme(bodyMedium: TextStyle(color: text)),
      appBarTheme: const AppBarTheme(
        backgroundColor: card,
        foregroundColor: primary,
        elevation: 0,
      ),
    );

    return MaterialApp(
      title: 'Control de Inventario',
      debugShowCheckedModeBanner: false,
      theme: theme,
      home: const InventoryPage(),
    );
  }
}

class InventoryPage extends StatefulWidget {
  const InventoryPage({super.key});

  @override
  State<InventoryPage> createState() => _InventoryPageState();
}

class _InventoryPageState extends State<InventoryPage> {
  int stock = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Control de Inventario')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            const Text('Stock actual:', style: TextStyle(fontSize: 18)),
            const SizedBox(height: 8),
            Text('$stock', style: const TextStyle(fontSize: 56, fontWeight: FontWeight.w800)),
            const SizedBox(height: 16),
            Card(
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 12),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    FilledButton.tonal(
                      onPressed: () => setState(() => stock = (stock - 1).clamp(0, 999999)),
                      child: const Text('-1'),
                    ),
                    const SizedBox(width: 12),
                    FilledButton(
                      onPressed: () => setState(() => stock++),
                      child: const Text('+1'),
                    ),
                    const SizedBox(width: 12),
                    OutlinedButton(
                      onPressed: () => setState(() => stock = 0),
                      child: const Text('Reset'),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
