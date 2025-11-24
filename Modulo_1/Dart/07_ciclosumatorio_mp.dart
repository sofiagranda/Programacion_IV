void main(){
  int totalProductos = 10;
  double sumaStock = 0;

  for (int i = 1; i <= totalProductos; i++) {
    sumaStock += i;
  }

  print("La suma total del stock de los primeros $totalProductos productos es $sumaStock");
}
