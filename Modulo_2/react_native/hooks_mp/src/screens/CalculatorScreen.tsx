import React, { useMemo, useState } from "react";
import { View, Text, TextInput, Pressable } from "react-native";
import colors from "../theme/colors";

function toNumber(s: string): number | null {
  if (s.trim() === "") return null;
  const n = Number(s.replace(",", "."));
  return Number.isFinite(n) ? n : null;
}

export default function InventarioScreen() {
  const [stock, setStock] = useState("");
  const [cantidad, setCantidad] = useState("");
  const [op, setOp] = useState<"+" | "-">("+");

  const nuevoStock = useMemo(() => {
    const s = toNumber(stock);
    const c = toNumber(cantidad);
    if (s === null || c === null) return "—";
    switch (op) {
      case "+": return (s + c).toString();
      case "-": return (s - c).toString();
      default: return "—";
    }
  }, [stock, cantidad, op]);

  const Input = (props: any) => (
    <TextInput
      keyboardType="decimal-pad"
      placeholder={props.placeholder}
      placeholderTextColor="#8b949e"
      value={props.value}
      onChangeText={props.onChangeText}
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
  );

  const OpBtn = ({ value }: { value: typeof op }) => (
    <Pressable
      onPress={() => setOp(value)}
      style={({ pressed }) => ({
        paddingVertical: 10,
        paddingHorizontal: 16,
        borderRadius: 10,
        borderWidth: 1,
        borderColor: op === value ? colors.primary : "#30363d",
        backgroundColor: pressed ? "#1f2937" : "#161b22",
        marginRight: 8,
      })}
    >
      <Text style={{ color: op === value ? colors.primary : colors.text, fontWeight: "bold" }}>{value}</Text>
    </Pressable>
  );

  return (
    <View style={{ flex: 1, backgroundColor: "#0d1117", padding: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 22, marginBottom: 12 }}>Control de Inventario</Text>

      <Input placeholder="Stock actual" value={stock} onChangeText={setStock} />
      <Input placeholder="Cantidad a agregar/quitar" value={cantidad} onChangeText={setCantidad} />

      <View style={{ flexDirection: "row", marginVertical: 8 }}>
        <OpBtn value="+" />
        <OpBtn value="-" />
      </View>

      <Text style={{ color: colors.text, fontSize: 18, marginTop: 12 }}>
        Nuevo stock: <Text style={{ color: colors.primary, fontWeight: "bold" }}>{nuevoStock}</Text>
      </Text>
    </View>
  );
}
