void main() {
  int totalDias = 10;
  double productosPorDia = 3;
  int dia = 0;

  print("Ventas usando while:");
  while (dia <= totalDias) {
    print("Día $dia: Se registraron ${dia * productosPorDia} productos vendidos");
    dia++;
  }

  dia = 1;
  print("\nVentas usando do-while:");
  do {
    print("Día $dia: Se registraron ${dia * productosPorDia} productos vendidos");
    dia++;
  } while (dia < totalDias);
}
