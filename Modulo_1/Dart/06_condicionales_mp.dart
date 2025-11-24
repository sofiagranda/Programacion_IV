void main() {
  int stock = 2;

  if (stock > 5) {
    print('Stock alto: más de 5 unidades');
  }
  if (stock < 5) {
    print('Stock bajo: menos de 5 unidades');
  }
  if (stock == 2) {
    print('Stock igual a 2 unidades');
  } else {
    print('Stock diferente de 2 unidades');
  }

  int pedido = 2;
  if (pedido > stock) {
    print('Pedido mayor al stock disponible');
  } else if (pedido < stock) {
    print('Pedido menor al stock disponible');
  } else {
    print('Pedido igual al stock disponible');
  }

  int edadProducto = 18;
  String estadoProducto = edadProducto >= 12 ? 'Producto en inventario activo' : 'Producto nuevo en inventario';
  print(estadoProducto);
}
