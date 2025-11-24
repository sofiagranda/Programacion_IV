void main() {
  print("Registro de producto en inventario");

  final Map<String, dynamic> producto = {
    'nombre': 'Laptop HP Pavilion',
    'stock': '25',
    'disponible': true,
    'caracteristicas': <String>['Intel i5', '8GB RAM', '256GB SSD'],
    'imagenes': {
      1: 'img/laptop1.jpg',
      2: 'img/laptop2.jpg'
    }
  };

  print(producto);
  print(producto['nombre']);
  print(producto['imagenes']);
  print(producto['disponible']);
}
