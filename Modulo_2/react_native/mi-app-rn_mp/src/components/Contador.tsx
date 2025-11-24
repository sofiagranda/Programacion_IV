import React, { useState } from "react";
import { View, Text, Button, StyleSheet } from "react-native";

type Props = {
  nombre: string;
  precio: number;
};

export default function InventarioItem({ nombre, precio }: Props) {
  const [cantidad, setCantidad] = useState(0);

  return (
    <View style={styles.container}>
      <Text style={styles.nombre}>{nombre}</Text>
      <Text style={styles.precio}>Precio: ${precio.toFixed(2)}</Text>
      <Text style={styles.cantidad}>Cantidad: {cantidad}</Text>

      <View style={styles.buttons}>
        <Button title="+" onPress={() => setCantidad(cantidad + 1)} />
        <Button title="−" onPress={() => cantidad > 0 && setCantidad(cantidad - 1)} />
      </View>

      <Text style={styles.total}>Total: ${(cantidad * precio).toFixed(2)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: "#1f6feb",
    padding: 16,
    borderRadius: 10,
    margin: 10,
    alignItems: "center",
  },
  nombre: {
    color: "white",
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 4,
  },
  precio: {
    color: "white",
    marginBottom: 4,
  },
  cantidad: {
    color: "white",
    marginBottom: 8,
  },
  buttons: {
    flexDirection: "row",
    width: "50%",
    justifyContent: "space-between",
    marginBottom: 8,
  },
  total: {
    color: "white",
    fontWeight: "bold",
  },
});
