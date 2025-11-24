void main() {
  final Inventario inventario = Inventario(cantidadEntrada: 7, cantidadSalida: 8);

  print("Total productos en inventario (entrada + salida): ${inventario.suma()}");
  print("Diferencia productos (entrada - salida): ${inventario.resta()}");
  print("Producto multiplicado por factor (entrada * salida): ${inventario.multiplicacion()}");
  print("Ratio de entrada sobre salida (entrada / salida): ${inventario.division()}");
}

class Inventario {
  double cantidadEntrada = 0.0;
  double cantidadSalida = 0.0;

  Inventario({required this.cantidadEntrada, required this.cantidadSalida});

  double suma() {
    return this.cantidadEntrada + this.cantidadSalida;
  }

  double resta() {
    return this.cantidadEntrada - this.cantidadSalida;
  }

  double multiplicacion() {
    return this.cantidadEntrada * this.cantidadSalida;
  }

  double division() {
    return this.cantidadEntrada / this.cantidadSalida;
  }
}
