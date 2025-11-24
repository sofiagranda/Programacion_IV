import React, { useMemo, useState } from "react";
import { View, Text, TextInput } from "react-native";
import colors from "../theme/colors";

function parseNumber(s: string): number | null {
  if (!s.trim()) return null;
  const v = Number(s.replace(",", "."));
  return Number.isFinite(v) ? v : null;
}

export default function InventarioScreen() {
  const [cantidad, setCantidad] = useState("");
  const [precioUnitario, setPrecioUnitario] = useState("");

  const total = useMemo(() => {
    const c = parseNumber(cantidad);
    const p = parseNumber(precioUnitario);
    if (c === null || p === null || c < 0 || p < 0) return "—";
    return (c * p).toFixed(2);
  }, [cantidad, precioUnitario]);

  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117", padding: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 22, marginBottom: 12 }}>
        Control de Inventario
      </Text>

      <TextInput
        keyboardType="decimal-pad"
        placeholder="Cantidad"
        placeholderTextColor="#8b949e"
        value={cantidad}
        onChangeText={setCantidad}
        style={{
          color: colors.text,
          borderColor: "#30363d",
          borderWidth: 1,
          paddingHorizontal: 12,
          paddingVertical: 10,
          borderRadius: 10,
          backgroundColor: "#161b22",
          marginBottom: 10,
        }}
      />

      <TextInput
        keyboardType="decimal-pad"
        placeholder="Precio unitario"
        placeholderTextColor="#8b949e"
        value={precioUnitario}
        onChangeText={setPrecioUnitario}
        style={{
          color: colors.text,
          borderColor: "#30363d",
          borderWidth: 1,
          paddingHorizontal: 12,
          paddingVertical: 10,
          borderRadius: 10,
          backgroundColor: "#161b22",
          marginBottom: 10,
        }}
      />

      <Text style={{ color: colors.text, fontSize: 18 }}>
        Valor total: <Text style={{ color: colors.primary, fontWeight: "bold" }}>{total}</Text>
      </Text>
    </View>
  );
}
