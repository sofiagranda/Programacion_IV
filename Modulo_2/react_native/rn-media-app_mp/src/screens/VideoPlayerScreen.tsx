import React, { useState } from "react";
import { ScrollView, Text, TextInput, View } from "react-native";
import { WebView } from "react-native-webview";
import colors from "../theme/colors";

const DEFAULT_URL = "https://www.youtube.com/embed/dQw4w9WgXcQ";

export default function YouTubeScreen() {
  const [url, setUrl] = useState(DEFAULT_URL);

  return (
    <ScrollView style={{ flex: 1, backgroundColor: colors.bg }} contentContainerStyle={{ padding: 16, gap: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 20 }}>YouTube</Text>

      <Text style={{ color: colors.text }}>Pega la URL del video (modo embed, ejemplo: https://www.youtube.com/embed/VIDEO_ID):</Text>
      <TextInput
        value={url}
        onChangeText={setUrl}
        autoCapitalize="none"
        autoCorrect={false}
        placeholder="https://www.youtube.com/embed/..."
        placeholderTextColor={colors.subtle}
        style={{
          color: colors.text,
          borderColor: colors.border,
          borderWidth: 1,
          borderRadius: 10,
          paddingHorizontal: 12,
          paddingVertical: 10,
          backgroundColor: colors.card,
        }}
      />

      <View style={{ height: 220, borderRadius: 12, overflow: "hidden", marginTop: 16 }}>
        <WebView
          source={{ uri: url }}
          style={{ flex: 1, backgroundColor: "#000" }}
          javaScriptEnabled
          domStorageEnabled
        />
      </View>

      <View>
        <Text style={{ color: colors.subtle, marginTop: 8 }}>
          Tip: asegúrate de usar la URL en formato embed para que funcione dentro de la app.
        </Text>
      </View>
    </ScrollView>
  );
}
