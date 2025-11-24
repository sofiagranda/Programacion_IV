import React from "react";
import { TextInput, View, Text, TextInputProps } from "react-native";
import colors from "../theme/colors";

type Props = {
  label: string;
  error?: string;
} & TextInputProps;

export default function InventoryInput({ label, error, ...props }: Props) {
  return (
    <View style={{ marginBottom: 14 }}>
      <Text style={{ color: colors.primary, marginBottom: 6, fontWeight: "500" }}>{label}</Text>
      <TextInput
        placeholderTextColor="rgba(255,255,255,0.5)"
        style={{
          backgroundColor: "rgba(0,0,0,0.06)",
          borderWidth: 1,
          borderColor: "rgba(0,0,0,0.2)",
          color: colors.text,
          borderRadius: 12,
          paddingHorizontal: 12,
          paddingVertical: 10
        }}
        {...props}
      />
      {!!error && <Text style={{ color: colors.danger, marginTop: 4 }}>{error}</Text>}
    </View>
  );
}
