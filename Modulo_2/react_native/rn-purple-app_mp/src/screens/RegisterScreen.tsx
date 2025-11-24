import React, { useState } from "react";
import { View, Text, Alert } from "react-native";
import InventoryGradientBg from "../components/InventoryGradientBg";
import GlassCard from "../components/GlassCard";
import AppInput from "../components/AppInput";
import AppButton from "../components/AppButton";
import { register } from "../services/auth.service";

export default function RegisterScreen({ navigation }: any) {
  const [email, setEmail] = useState("nuevo.usuario@inventario.com");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);

  const onRegister = async () => {
    try {
      setLoading(true);
      await register(email, password);
      Alert.alert("OK", "Cuenta creada. Ahora puedes iniciar sesión.");
      navigation.replace("Login");
    } catch (e: any) {
      Alert.alert("Error", e?.response?.data?.error ?? e.message ?? "No se pudo registrar");
    } finally {
      setLoading(false);
    }
  };

  return (
    <InventoryGradientBg>
      <View style={{ flex: 1, justifyContent: "center", padding: 24 }}>
        <GlassCard>
          <Text style={{ color: "#fff", fontSize: 22, fontWeight: "700", marginBottom: 12 }}>
            Crear cuenta de Inventario
          </Text>
          <AppInput 
            label="Email corporativo" 
            keyboardType="email-address" 
            autoCapitalize="none" 
            value={email} 
            onChangeText={setEmail} 
          />
          <AppInput 
            label="Contraseña" 
            secureTextEntry 
            value={password} 
            onChangeText={setPassword} 
          />
          <AppButton 
            label={loading ? "Creando..." : "Crear cuenta"} 
            onPress={onRegister} 
          />
        </GlassCard>
      </View>
    </InventoryGradientBg>
  );
}
