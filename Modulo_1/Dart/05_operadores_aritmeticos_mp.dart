void main() {
  print("Operaciones básicas en Inventario");

  final double stockInicial = 12.5;
  final double productosVendidos = 5;

  print("Suma (Stock inicial + nuevos productos): $stockInicial + $productosVendidos = ${stockInicial + productosVendidos}");
  print("Resta (Stock inicial - productos vendidos): $stockInicial - $productosVendidos = ${stockInicial - productosVendidos}");
  print("Multiplicación (Stock por precio unitario): $stockInicial * $productosVendidos = ${stockInicial * productosVendidos}");
  print("División (Stock dividido en partes iguales): $stockInicial / $productosVendidos = ${stockInicial / productosVendidos}");
}
