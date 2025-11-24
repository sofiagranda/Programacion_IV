import React, { useState } from "react";
import { View, Text, Button, StyleSheet } from "react-native";

export default function InventarioProducto() {
  const [cantidad, setCantidad] = useState(0);

  return (
    <View style={styles.container}>
      <Text style={styles.nombre}>Producto: Camiseta</Text>
      <Text style={styles.stock}>Stock: {cantidad}</Text>

      <View style={styles.buttons}>
        <Button title="Agregar" onPress={() => setCantidad(cantidad + 1)} />
        <Button
          title="Quitar"
          onPress={() => cantidad > 0 && setCantidad(cantidad - 1)}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    alignItems: "center",
    marginTop: 50,
    padding: 20,
    backgroundColor: "#1f6feb",
    borderRadius: 10,
  },
  nombre: {
    color: "white",
    fontSize: 22,
    fontWeight: "bold",
    marginBottom: 10,
  },
  stock: {
    color: "white",
    fontSize: 18,
    marginBottom: 20,
  },
  buttons: {
    flexDirection: "row",
    justifyContent: "space-between",
    width: "60%",
  },
});
