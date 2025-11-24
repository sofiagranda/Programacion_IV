import React from "react";
import { LinearGradient } from "expo-linear-gradient";
import { View, StyleSheet } from "react-native";
import { gradientBlue } from "../theme/gradients";
import InventoryWave from "./InventoryWave";

export default function InventoryGradientBg({ children }: { children: React.ReactNode }) {
  return (
    <View style={{ flex: 1, backgroundColor: "#0a0f1c" }}>
      <LinearGradient
        colors={gradientBlue.colors}
        start={gradientBlue.start}
        end={gradientBlue.end}
        style={StyleSheet.absoluteFillObject}
      />
      <InventoryWave opacity={0.3} />
      {children}
    </View>
  );
}
