import React from "react";
import { ScrollView, Text, Pressable, View } from "react-native";
import colors from "../theme/colors";

export default function MultimediaHubScreen({ navigation }: any) {
  const Item = ({ label, screen }: { label: string; screen: string }) => (
    <Pressable
      onPress={() => navigation.navigate(screen)}
      style={({ pressed }) => ({
        backgroundColor: pressed ? "#1f2937" : "#161b22",
        padding: 16,
        borderRadius: 12,
        borderWidth: 1,
        borderColor: "#30363d",
        marginBottom: 12,
      })}
    >
      <Text style={{ color: colors.primary, fontWeight: "bold" }}>{label}</Text>
    </Pressable>
  );

  return (
    <ScrollView style={{ flex: 1, backgroundColor: colors.bg }} contentContainerStyle={{ padding: 16, gap: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 22, marginBottom: 16 }}>Multimedia Hub</Text>

      <Item label="Seleccionar imágenes" screen="MediaPicker" />
      <Item label="Seleccionar video local" screen="MediaPicker" />
      <Item label="Video remoto" screen="VideoPlayer" />
      <Item label="YouTube" screen="YouTube" />
    </ScrollView>
  );
}
