import React from "react";
import { View, Text, Pressable } from "react-native";
import colors from "../theme/colors";

function Item({ label, onPress }: { label: string; onPress: () => void }) {
  return (
    <Pressable
      onPress={onPress}
      style={({ pressed }) => ({
        backgroundColor: pressed ? "#1f2937" : "#161b22",
        padding: 16,
        borderRadius: 12,
        borderWidth: 1,
        borderColor: "#30363d",
        marginBottom: 12,
      })}
    >
      <Text style={{ color: colors.primary, fontWeight: "bold" }}>{label}</Text>
    </Pressable>
  );
}

export default function InventoryMenuScreen({ navigation }: any) {
  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117", padding: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 22, marginBottom: 16 }}>Inventario</Text>

      <Item label="Registrar producto" onPress={() => navigation.navigate("RegisterProduct")} />
      <Item label="Ver inventario" onPress={() => navigation.navigate("ViewInventory")} />
      <Item label="Actualizar stock" onPress={() => navigation.navigate("UpdateStock")} />
      <Item label="Calcular valor total" onPress={() => navigation.navigate("CalculateTotal")} />
    </View>
  );
}
