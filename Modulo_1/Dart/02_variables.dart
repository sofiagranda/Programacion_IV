void main() {
  print("Tipos de Variables en Dart");
  
  final String pokemon = "Ditto";
  print(pokemon);
  
  String myName = "Fernando";
  myName = "Llulluna";
  print(myName);
  
  const String elemento = "Fuego";
  print("elemento:$elemento");
  
  bool active = false;
  active = false;
  
  print("Es activo :$active");
  
  int hp = 1000;
  print("Caballos de fuerza $hp");
  
  List<String> abilities = ["impostor","correlon"];
  print("habilidades $abilities");
  
  final sprites = <String>["src/image1.jpg","image2"];
  print("imagenes $sprites");
  
  print("Impresion en variias lineas");
  print("""
  $pokemon
  $hp
  $sprites
  $abilities
  """);
  
  }