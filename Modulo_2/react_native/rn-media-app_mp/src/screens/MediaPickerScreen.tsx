import React, { useState } from "react";
import { ScrollView, View, Text, Pressable, ActivityIndicator } from "react-native";
import * as ImagePicker from "expo-image-picker";
import { Audio, Video, ResizeMode } from "expo-av";
import ImageGrid from "../components/ImageGrid";
import colors from "../theme/colors";

export default function MultimediaScreen({ navigation }: any) {
  const [images, setImages] = useState<string[]>([]);
  const [localVideoUri, setLocalVideoUri] = useState<string | null>(null);
  const [remoteVideoUri] = useState("https://www.w3schools.com/html/mov_bbb.mp4");
  const [audioUri, setAudioUri] = useState<string | null>(null);
  const [loadingVideo, setLoadingVideo] = useState(false);

  const pickImages = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== "granted") return;
    const res = await ImagePicker.launchImageLibraryAsync({
      allowsMultipleSelection: true,
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      quality: 0.9,
    });
    if (!res.canceled) setImages(res.assets.map(a => a.uri));
  };

  const pickLocalVideo = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== "granted") return;
    const res = await ImagePicker.launchImageLibraryAsync({ mediaTypes: ImagePicker.MediaTypeOptions.Videos });
    if (!res.canceled && res.assets[0]?.uri) setLocalVideoUri(res.assets[0].uri);
  };

  const pickAudio = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== "granted") return;
    const res = await ImagePicker.launchImageLibraryAsync({ mediaTypes: ImagePicker.MediaTypeOptions.Audio });
    if (!res.canceled && res.assets[0]?.uri) setAudioUri(res.assets[0].uri);
  };

  return (
    <ScrollView style={{ flex: 1, backgroundColor: colors.bg }} contentContainerStyle={{ padding: 16, gap: 16 }}>
      <Text style={{ color: colors.primary, fontSize: 20 }}>Imágenes</Text>
      <Pressable
        onPress={pickImages}
        style={{ borderColor: colors.primary, borderWidth: 1, borderRadius: 8, padding: 10, alignSelf: "flex-start" }}
      >
        <Text style={{ color: colors.primary }}>Seleccionar imágenes</Text>
      </Pressable>
      <ImageGrid uris={images} />

      <Text style={{ color: colors.primary, fontSize: 20 }}>Video Local</Text>
      <Pressable
        onPress={pickLocalVideo}
        style={{ borderColor: colors.primary, borderWidth: 1, borderRadius: 8, padding: 10, alignSelf: "flex-start" }}
      >
        <Text style={{ color: colors.primary }}>Seleccionar video</Text>
      </Pressable>
      {localVideoUri ? (
        <Video
          source={{ uri: localVideoUri }}
          style={{ width: "100%", aspectRatio: 16 / 9, borderRadius: 12, backgroundColor: "#000" }}
          useNativeControls
          resizeMode={ResizeMode.CONTAIN}
          onLoadStart={() => setLoadingVideo(true)}
          onLoad={() => setLoadingVideo(false)}
        />
      ) : (
        <Text style={{ color: colors.subtle }}>No hay video seleccionado.</Text>
      )}
      {loadingVideo && <ActivityIndicator color={colors.primary} />}

      <Text style={{ color: colors.primary, fontSize: 20 }}>Video Remoto</Text>
      <Video
        source={{ uri: remoteVideoUri }}
        style={{ width: "100%", aspectRatio: 16 / 9, borderRadius: 12, backgroundColor: "#000" }}
        useNativeControls
        resizeMode={ResizeMode.CONTAIN}
      />

      <Text style={{ color: colors.primary, fontSize: 20 }}>Audio</Text>
      <Pressable
        onPress={pickAudio}
        style={{ borderColor: colors.primary, borderWidth: 1, borderRadius: 8, padding: 10, alignSelf: "flex-start" }}
      >
        <Text style={{ color: colors.primary }}>Seleccionar audio</Text>
      </Pressable>
      <Text style={{ color: colors.subtle }}>{audioUri ? audioUri : "No hay audio seleccionado."}</Text>

      <Text style={{ color: colors.primary, fontSize: 20 }}>YouTube</Text>
      <Pressable
        onPress={() => navigation.navigate("YouTube")}
        style={{ borderColor: colors.primary, borderWidth: 1, borderRadius: 8, padding: 10 }}
      >
        <Text style={{ color: colors.primary }}>Abrir YouTube</Text>
      </Pressable>
    </ScrollView>
  );
}
