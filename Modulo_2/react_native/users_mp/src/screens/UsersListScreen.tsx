import React from "react";
import { ActivityIndicator, Alert, FlatList, Pressable, Text, View } from "react-native";
import { useProducts } from "../hooks/useProducts";
import colors from "../theme/colors";

export default function ProductsListScreen({ navigation }: any) {
  const { products, loading, error, reload, remove } = useProducts();

  if (loading) {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center", backgroundColor: "#0d1117" }}>
        <ActivityIndicator size="large" color={colors.primary} />
        <Text style={{ color: colors.text, marginTop: 10 }}>Cargando productos...</Text>
      </View>
    );
  }

  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117" }}>
      {error && (
        <View style={{ backgroundColor: "#331b1b", padding: 10 }}>
          <Text style={{ color: "#f85149" }}>{error}</Text>
          <Text onPress={reload} style={{ color: colors.primary, textDecorationLine: "underline" }}>Reintentar</Text>
        </View>
      )}

      <View style={{ padding: 16, flexDirection: "row", justifyContent: "space-between", alignItems: "center" }}>
        <Text style={{ color: colors.primary, fontSize: 20 }}>Productos</Text>
        <Pressable
          onPress={() => navigation.navigate("ProductForm")}
          style={({ pressed }) => ({
            borderWidth: 1,
            borderColor: colors.primary,
            paddingHorizontal: 12,
            paddingVertical: 8,
            borderRadius: 8,
            backgroundColor: pressed ? "#0b3d91" : "transparent",
          })}
        >
          <Text style={{ color: colors.primary }}>+ Nuevo</Text>
        </Pressable>
      </View>

      <FlatList
        contentContainerStyle={{ padding: 16 }}
        data={products}
        keyExtractor={(item) => String(item.id)}
        renderItem={({ item }) => (
          <View
            style={{
              backgroundColor: "#161b22",
              padding: 16,
              borderRadius: 12,
              borderWidth: 1,
              borderColor: "#30363d",
              marginBottom: 10,
            }}
          >
            <Text style={{ color: colors.primary, fontWeight: "bold" }}>{item.name}</Text>
            <Text style={{ color: colors.text }}>Precio: ${item.price}</Text>
            <Text style={{ color: colors.subtle }}>{item.description}</Text>

            <View style={{ flexDirection: "row", gap: 8, marginTop: 10 }}>
              <Pressable
                onPress={() => navigation.navigate("ProductForm", { id: item.id })}
                style={({ pressed }) => ({
                  borderWidth: 1,
                  borderColor: colors.primary,
                  paddingHorizontal: 10,
                  paddingVertical: 6,
                  borderRadius: 8,
                  marginRight: 8,
                  backgroundColor: pressed ? "#0b3d91" : "transparent",
                })}
              >
                <Text style={{ color: colors.primary }}>Editar</Text>
              </Pressable>

              <Pressable
                onPress={() => {
                  Alert.alert("Eliminar", `¿Eliminar ${item.name}?`, [
                    { text: "Cancelar", style: "cancel" },
                    {
                      text: "Eliminar",
                      style: "destructive",
                      onPress: async () => {
                        try {
                          await remove(item.id!);
                        } catch {}
                      },
                    },
                  ]);
                }}
                style={({ pressed }) => ({
                  borderWidth: 1,
                  borderColor: "#f85149",
                  paddingHorizontal: 10,
                  paddingVertical: 6,
                  borderRadius: 8,
                  backgroundColor: pressed ? "#3a0b0b" : "transparent",
                })}
              >
                <Text style={{ color: "#f85149" }}>Eliminar</Text>
              </Pressable>
            </View>
          </View>
        )}
      />
    </View>
  );
}
