void main() {
  print("Listas y colecciones en Inventario");

  final productos = ["Laptop", "Mouse", "Teclado", "Teclado", "Monitor", "Monitor", "Monitor", "Impresora", "Impresora", "Parlantes", "Webcam", "Router"];
  
  print("Lista original de productos: $productos");
  print("Cantidad total de productos: ${productos.length}");
  print("Producto en posición 4: ${productos[4]}");
  print("Primer producto en lista: ${productos.first}");
  
  final productosInvertidos = productos.reversed;
  print("Lista invertida: $productosInvertidos");
  print("Lista invertida como List: ${productosInvertidos.toList()}");
  print("Lista invertida sin duplicados (Set): ${productosInvertidos.toSet()}");
}
