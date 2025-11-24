void main() {
  print("Maps Iterables");
  final numbers = [1,2,3,3,5,5,5,7,7,8,9,10];
  print("Lista Original $numbers");
  print ("tamaño ${numbers.length}");
  print("Indice 4 ${numbers[4]}");
  print("primer elemento ${numbers.first}");
  final reversedNumbers = numbers.reversed;
  print("reverso de numbers ${reversedNumbers}");
  print("List : ${reversedNumbers.toList()}");
  print("Set : ${reversedNumbers.toSet()}");
  
}