import React from "react";
import { View, ViewStyle } from "react-native";
import colors from "../theme/colors";

export default function InventoryCard({ children, style }: { children: React.ReactNode; style?: ViewStyle }) {
  return (
    <View
      style={[
        {
          backgroundColor: "rgba(255,255,255,0.05)",
          borderWidth: 1,
          borderColor: "rgba(255,255,255,0.1)",
          padding: 16,
          borderRadius: 12,
          shadowColor: "#000",
          shadowOffset: { width: 0, height: 2 },
          shadowOpacity: 0.1,
          shadowRadius: 4,
          elevation: 2
        },
        style
      ]}
    >
      {children}
    </View>
  );
}