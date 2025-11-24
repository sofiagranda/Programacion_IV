import React from "react";
import { ScrollView, Text, View } from "react-native";
import AvPlayer from "./AvPlayer";
import ImageGrid from "./ImageGrid";
import colors from "../theme/colors";

const productos = [
  {
    id: 1,
    nombre: "Mochila deportiva",
    imagenes: [
      "https://via.placeholder.com/150",
      "https://via.placeholder.com/151",
      "https://via.placeholder.com/152",
    ],
    video: "https://www.w3schools.com/html/mov_bbb.mp4",
    stock: 10,
  },
  {
    id: 2,
    nombre: "Zapatos de correr",
    imagenes: [
      "https://via.placeholder.com/153",
      "https://via.placeholder.com/154",
    ],
    video: "https://www.w3schools.com/html/movie.mp4",
    stock: 5,
  },
];

export default function InventarioMultimedia() {
  return (
    <ScrollView style={{ flex: 1, padding: 16, backgroundColor: "#0d1117" }}>
      {productos.map((prod) => (
        <View key={prod.id} style={{ marginBottom: 32 }}>
          <Text style={{ color: colors.primary, fontSize: 18, marginBottom: 8 }}>
            {prod.nombre} - Stock: {prod.stock}
          </Text>

          <ImageGrid uris={prod.imagenes} />

          <View style={{ marginTop: 12 }}>
            <AvPlayer source={{ uri: prod.video }} autoPlay={false} loop={false} />
          </View>
        </View>
      ))}
    </ScrollView>
  );
}
