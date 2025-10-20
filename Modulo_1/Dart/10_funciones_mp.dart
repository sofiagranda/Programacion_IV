void main() {
  print(saludoGeneral());
  print(sumarStock(3, 4));
  print(sumarStockOpcional(6, 8));
  print(sumarStockOpcional(8));
  print(saludoPersonalizado(name: "Sofía", message: "Inventario actualizado"));
}

String saludoGeneral() => "¡Bienvenidos al sistema de inventario!";

int sumarStock(int a, int b) => a + b;

int sumarStockOpcional(int a, [int b = 0]) {
  return a + b;
}

String saludoPersonalizado({required String name, String message = "Hola"}) {
  return '$message, $name';
}
