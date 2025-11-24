import React from "react";
import { ScrollView, Text, View } from "react-native";
import AvPlayer from "./AvPlayer";
import colors from "../theme/colors";

const productos = [
  {
    id: 1,
    nombre: "Mochila deportiva",
    video: "https://www.w3schools.com/html/mov_bbb.mp4",
  },
  {
    id: 2,
    nombre: "Zapatos de correr",
    video: "https://www.w3schools.com/html/movie.mp4",
  },
];

export default function InventarioMultimedia() {
  return (
    <ScrollView style={{ flex: 1, padding: 16, backgroundColor: "#0d1117" }}>
      {productos.map((prod) => (
        <View key={prod.id} style={{ marginBottom: 24 }}>
          <Text style={{ color: colors.primary, fontSize: 18, marginBottom: 8 }}>
            {prod.nombre}
          </Text>
          <AvPlayer source={{ uri: prod.video }} autoPlay={false} loop={false} />
        </View>
      ))}
    </ScrollView>
  );
}
