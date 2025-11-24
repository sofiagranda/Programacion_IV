import React from "react";
import { ActivityIndicator, KeyboardAvoidingView, Platform, Pressable, ScrollView, Text, TextInput, View } from "react-native";
import { useProductForm } from "../hooks/useProductForm";
import colors from "../theme/colors";

type Props = {
  route: { params?: { id?: number } };
  navigation: any;
};

export default function ProductFormScreen({ route, navigation }: Props) {
  const id = route?.params?.id;
  const { values, onChange, loading, saving, error, submit } = useProductForm(id);

  if (loading) {
    return (
      <View style={{ flex: 1, alignItems: "center", justifyContent: "center", backgroundColor: "#0d1117" }}>
        <ActivityIndicator size="large" color={colors.primary} />
      </View>
    );
  }

  const Input = ({
    label,
    value,
    onChangeText,
    keyboardType = "default",
  }: {
    label: string;
    value: string;
    onChangeText: (t: string) => void;
    keyboardType?: "default" | "decimal-pad";
  }) => (
    <View style={{ marginBottom: 12 }}>
      <Text style={{ color: colors.text, marginBottom: 6 }}>{label}</Text>
      <TextInput
        value={value}
        onChangeText={onChangeText}
        keyboardType={keyboardType}
        placeholderTextColor="#8b949e"
        style={{
          color: colors.text,
          borderColor: "#30363d",
          borderWidth: 1,
          borderRadius: 10,
          paddingHorizontal: 12,
          paddingVertical: 10,
          backgroundColor: "#161b22",
        }}
      />
    </View>
  );

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === "ios" ? "padding" : undefined}
      style={{ flex: 1, backgroundColor: "#0d1117" }}
    >
      {error && (
        <View style={{ backgroundColor: "#331b1b", padding: 10 }}>
          <Text style={{ color: "#f85149" }}>{error}</Text>
        </View>
      )}

      <ScrollView contentContainerStyle={{ padding: 16 }}>
        <Text style={{ color: colors.primary, fontSize: 20, marginBottom: 12 }}>
          {id ? "Editar producto" : "Nuevo producto"}
        </Text>

        <Input label="Nombre del producto" value={values.name} onChangeText={(t) => onChange("name", t)} />
        <Input label="Precio" value={values.price} onChangeText={(t) => onChange("price", t)} keyboardType="decimal-pad" />
        <Input label="Descripción" value={values.description} onChangeText={(t) => onChange("description", t)} />

        <Pressable
          onPress={async () => {
            try {
              await submit();
              navigation.goBack();
            } catch {}
          }}
          disabled={saving}
          style={({ pressed }) => ({
            borderWidth: 1,
            borderColor: colors.primary,
            paddingHorizontal: 14,
            paddingVertical: 10,
            borderRadius: 10,
            backgroundColor: pressed ? "#0b3d91" : "transparent",
            alignSelf: "flex-start",
            opacity: saving ? 0.6 : 1,
          })}
        >
          <Text style={{ color: colors.primary, fontWeight: "bold" }}>{saving ? "Guardando..." : "Guardar"}</Text>
        </Pressable>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}
