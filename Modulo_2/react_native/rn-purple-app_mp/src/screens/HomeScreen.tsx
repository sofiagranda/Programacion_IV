import React, { useState } from "react";
import { View, Text, Alert } from "react-native";
import InventoryGradientBg from "../components/InventoryGradientBg";
import GlassCard from "../components/GlassCard";
import AppInput from "../components/AppInput";
import AppButton from "../components/AppButton";
import { login } from "../services/auth.service";
import colors from "../theme/colors";

export default function LoginScreen({ navigation }: any) {
  const [email, setEmail] = useState("admin@inventario.com");
  const [password, setPassword] = useState("admin123");
  const [loading, setLoading] = useState(false);

  const onLogin = async () => {
    try {
      setLoading(true);
      await login(email, password);
      navigation.replace("App"); 
    } catch (e: any) {
      Alert.alert("Error", e?.response?.data?.error ?? e.message ?? "No se pudo iniciar sesión");
    } finally { 
      setLoading(false); 
    }
  };

  return (
    <InventoryGradientBg>
      <View style={{ flex: 1, justifyContent: "center", padding: 24 }}>
        <GlassCard>
          <Text style={{ color: "#fff", fontSize: 22, fontWeight: "700", marginBottom: 12 }}>Inicio de sesión - Inventario</Text>
          <AppInput label="Email" keyboardType="email-address" autoCapitalize="none" value={email} onChangeText={setEmail} />
          <AppInput label="Contraseña" secureTextEntry value={password} onChangeText={setPassword} />
          <AppButton label={loading ? "Ingresando..." : "Acceder"} onPress={onLogin} />
          <Text style={{ color: colors.subtle, marginTop: 10 }} onPress={() => navigation.navigate("Register")}>
            ¿No tienes cuenta? Regístrate
          </Text>
        </GlassCard>
      </View>
    </InventoryGradientBg>
  );
}
