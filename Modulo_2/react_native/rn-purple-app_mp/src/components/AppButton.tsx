import React from "react";
import { Pressable, Text } from "react-native";
import colors from "../theme/colors";

type Props = {
  label: string;
  onPress: () => void;
  outline?: boolean;
};

export default function InventoryButton({ label, onPress, outline = false }: Props) {
  return (
    <Pressable
      onPress={onPress}
      style={({ pressed }) => ({
        borderWidth: 1,
        borderColor: outline ? colors.primary : "transparent",
        backgroundColor: outline ? "transparent" : colors.primary,
        opacity: pressed ? 0.7 : 1,
        paddingVertical: 12,
        paddingHorizontal: 18,
        borderRadius: 12,
        alignItems: "center",
        marginVertical: 4
      })}
    >
      <Text style={{ color: outline ? colors.primary : "#fff", fontWeight: "600", fontSize: 16 }}>
        {label}
      </Text>
    </Pressable>
  );
}
