import React from "react";
import { ActivityIndicator, Text, View } from "react-native";
import { useFetch } from "../hooks/useFetch";
import type { Producto } from "../types/api";
import colors from "../theme/colors";
import spacing from "../theme/spacing";

type Props = {
  route: { params: { id: number } };
};

export default function ProductoDetailScreen({ route }: Props) {
  const { id } = route.params;
  const { data, loading, error, retry } = useFetch<Producto>(
    `https://miapi.com/productos/${id}`,
    { deps: [id] }
  );

  if (loading) {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center", backgroundColor: "#0d1117" }}>
        <ActivityIndicator size="large" color={colors.primary} />
      </View>
    );
  }

  if (error || !data) {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center", padding: spacing.lg, backgroundColor: "#0d1117" }}>
        <Text style={{ color: colors.danger, marginBottom: spacing.md }}>Error: {error ?? "Producto no encontrado"}</Text>
        <Text onPress={retry} style={{ color: colors.primary, textDecorationLine: "underline" }}>Reintentar</Text>
      </View>
    );
  }

  return (
    <View style={{ flex: 1, padding: spacing.xl, backgroundColor: "#0d1117" }}>
      <Text style={{ color: colors.primary, fontSize: 22, marginBottom: spacing.md }}>{data.nombre}</Text>
      <Text style={{ color: colors.text }}>ID: {data.id}</Text>
      <Text style={{ color: colors.text }}>Cantidad en stock: {data.cantidad}</Text>
      <Text style={{ color: colors.text }}>Descripción: {data.descripcion}</Text>
    </View>
  );
}
