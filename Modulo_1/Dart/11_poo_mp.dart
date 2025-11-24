void main() {
  final Producto laptop = Producto(nombre: 'Laptop Dell', descripcion: 'Portátil con i7 y 16GB RAM');
  
  print(laptop);
  print(laptop.nombre);
  print(laptop.descripcion);
}

class Producto {
  String nombre = "";
  String descripcion = "";
  
  Producto({required this.nombre, this.descripcion = "Sin descripción"});

  @override
  String toString() {
    return "$nombre - $descripcion";
  }
}
