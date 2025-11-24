import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class DetailPage extends StatelessWidget {
  final String id;
  const DetailPage({super.key, required this.id});

  @override
  Widget build(BuildContext context) {
    final colors = _InventoryColors();

    return Scaffold(
      backgroundColor: colors.bg,
      appBar: AppBar(
        title: Text('Detalle $id', style: GoogleFonts.poppins(color: colors.text)),
        backgroundColor: colors.appBar,
        elevation: 0,
      ),
      body: Container(
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: colors.gradient,
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ),
        width: double.infinity,
        height: double.infinity,
        child: Center(
          child: _GlassCard(
            child: Padding(
              padding: const EdgeInsets.all(24),
              child: Text(
                'Mostrando detalle del producto #$id',
                style: GoogleFonts.poppins(
                  fontSize: 18,
                  color: colors.text,
                  fontWeight: FontWeight.w500,
                ),
                textAlign: TextAlign.center,
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class _GlassCard extends StatelessWidget {
  final Widget child;
  const _GlassCard({required this.child});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white.withOpacity(0.06),
        borderRadius: BorderRadius.circular(16),
        border: Border.all(color: Colors.white.withOpacity(0.15), width: 1),
      ),
      child: child,
    );
  }
}

class _InventoryColors {
  final Color bg = const Color(0xFF0d1117); // Fondo oscuro
  final Color text = const Color(0xFFFFFFFF); // Texto principal
  final Color appBar = const Color(0xFF161b22); // Barra superior
  final List<Color> gradient = [
    const Color(0xFF1b1f2a),
    const Color(0xFF2c3142),
  ]; // Gradiente suave de inventario
}
