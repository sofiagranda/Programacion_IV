void main() {
  print("Variables Inventario");

  final String producto = "Laptop Dell XPS";
  print(producto);

  String encargado = "Sofia";
  encargado = "Carlos";
  print(encargado);

  const String categoria = "Electrónica";
  print("Categoría: $categoria");

  bool disponible = false;
  disponible = false;
  print("Disponible: $disponible");

  int stock = 100;
  print("Cantidad en stock: $stock");

  List<String> caracteristicas = ["i7", "16GB RAM", "512GB SSD"];
  print("Características: $caracteristicas");

  final imagenes = <String>[
    "img/laptop1.jpg",
    "img/laptop2.jpg"
  ];
  print("Imágenes del producto: $imagenes");

  print("Resumen del producto:");
  print("""
  Producto: $producto
  Stock: $stock unidades
  Imágenes: $imagenes
  Características: $caracteristicas
  """);
}
