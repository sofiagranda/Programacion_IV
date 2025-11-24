import React from "react";
import { View, Text } from "react-native";
import InventoryGradientBg from "../components/InventoryGradientBg";
import GlassCard from "../components/GlassCard";
import AppButton from "../components/AppButton";

export default function WelcomeScreen({ navigation }: any) {
  return (
    <InventoryGradientBg>
      <View style={{ flex: 1, justifyContent: "center", padding: 24 }}>
        <GlassCard style={{ padding: 24, marginBottom: 16 }}>
          <Text style={{ color: "#fff", fontSize: 28, fontWeight: "700", marginBottom: 6 }}>
            ¡Bienvenido!
          </Text>
          <Text style={{ color: "#ddd" }}>
            Bienvenido a InventoryManager: inicia sesión para gestionar productos, controlar stock y revisar métricas.
          </Text>
        </GlassCard>
        <View style={{ flexDirection: "row", gap: 12 }}>
          <View style={{ flex: 1 }}>
            <AppButton label="Iniciar sesión" onPress={() => navigation.navigate("Login")} />
          </View>
          <View style={{ flex: 1 }}>
            <AppButton label="Crear cuenta" outline onPress={() => navigation.navigate("Register")} />
          </View>
        </View>
      </View>
    </InventoryGradientBg>
  );
}
