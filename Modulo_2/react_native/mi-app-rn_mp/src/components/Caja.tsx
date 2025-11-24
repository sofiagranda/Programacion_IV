import React from "react";
import { StyleSheet, View, Text } from "react-native";

type Props = {
  nombre: string;
  cantidad: number;
  precio: number;
};

export default function Caja({ nombre, cantidad, precio }: Props) {
  return (
    <View style={styles.box}>
      <Text style={styles.text}>{nombre}</Text>
      <Text style={styles.text}>Cantidad: {cantidad}</Text>
      <Text style={styles.text}>Precio: ${precio.toFixed(2)}</Text>
      <Text style={styles.text}>Total: ${(cantidad * precio).toFixed(2)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  box: {
    backgroundColor: "#1f6feb",
    padding: 20,
    borderRadius: 10,
    margin: 10,
  },
  text: {
    color: "white",
    fontWeight: "bold",
    textAlign: "center",
    marginBottom: 4,
  },
});
