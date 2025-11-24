import React, { useMemo, useState } from "react";
import { View, Text, TextInput } from "react-native";
import colors from "../theme/colors";

function parseNum(s: string): number | null {
  if (s.trim() === "") return null;
  const n = Number(s.replace(",", "."));
  return Number.isFinite(n) ? n : null;
}

export default function CalculateTotalScreen() {
  const [quantity, setQuantity] = useState("");
  const [unitPrice, setUnitPrice] = useState("");

  const total = useMemo(() => {
    const q = parseNum(quantity);
    const p = parseNum(unitPrice);
    if (q === null || p === null || q < 0 || p < 0) return "—";
    return (q * p).toFixed(2); // dos decimales
  }, [quantity, unitPrice]);

  const inputStyle = {
    color: colors.text,
    borderColor: "#30363d",
    borderWidth: 1,
    paddingHorizontal: 12,
    paddingVertical: 10,
    borderRadius: 10,
    backgroundColor: "#161b22",
    marginBottom: 10,
  } as const;

  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117", padding: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 22, marginBottom: 12 }}>Calcular valor total</Text>

      <TextInput
        keyboardType="decimal-pad"
        placeholder="Cantidad"
        placeholderTextColor="#8b949e"
        value={quantity}
        onChangeText={setQuantity}
        style={inputStyle}
      />

      <TextInput
        keyboardType="decimal-pad"
        placeholder="Precio unitario"
        placeholderTextColor="#8b949e"
        value={unitPrice}
        onChangeText={setUnitPrice}
        style={inputStyle}
      />

      <Text style={{ color: colors.text, fontSize: 18 }}>
        Total: <Text style={{ color: colors.primary, fontWeight: "bold" }}>{total}</Text>
      </Text>
    </View>
  );
}
