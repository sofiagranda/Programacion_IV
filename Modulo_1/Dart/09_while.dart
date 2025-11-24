void main() {
  int n = 10;
  double tabla = 3;
  int i = 0;
  while (i <= n) {
    print("$i * $tabla = ${i * tabla}");
    i++;
  }
  i = 1;
  do {
    print("$i * $tabla = ${i * tabla}");
    i++;
  } while (i < n); 
}
