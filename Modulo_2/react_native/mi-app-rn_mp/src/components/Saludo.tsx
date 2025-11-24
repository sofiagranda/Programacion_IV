import React, { useState } from "react";
import { View, Text, Button, StyleSheet } from "react-native";

export default function InventarioConSaludo() {
  const [stock, setStock] = useState(5);

  return (
    <View style={styles.container}>
      <Text style={styles.saludo}>¡Hola! Bienvenido al inventario</Text>

      <Text style={styles.producto}>Producto: Mochila</Text>
      <Text style={styles.stock}>Stock actual: {stock}</Text>

      <View style={styles.buttons}>
        <Button title="Agregar" onPress={() => setStock(stock + 1)} />
        <Button
          title="Quitar"
          onPress={() => stock > 0 && setStock(stock - 1)}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 20,
    marginTop: 50,
    alignItems: "center",
    backgroundColor: "#1f6feb",
    borderRadius: 10,
  },
  saludo: {
    fontSize: 20,
    color: "white",
    marginBottom: 20,
    fontWeight: "bold",
  },
  producto: {
    fontSize: 18,
    color: "white",
    marginBottom: 10,
  },
  stock: {
    fontSize: 16,
    color: "white",
    marginBottom: 20,
  },
  buttons: {
    flexDirection: "row",
    justifyContent: "space-between",
    width: "60%",
  },
});
