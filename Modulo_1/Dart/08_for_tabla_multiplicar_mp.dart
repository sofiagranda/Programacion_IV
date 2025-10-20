void main(){
  int totalDias = 10;
  double productosVendidosPorDia = 5;

  for (int dia = 1; dia <= totalDias; dia++) {
    print("Día $dia: Se vendieron ${dia * productosVendidosPorDia} productos");
  }
}
