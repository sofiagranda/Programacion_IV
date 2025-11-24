import React, { useEffect, useState } from "react";
import { View, Alert } from "react-native";
import InventoryGradientBg from "../components/InventoryGradientBg";
import GlassCard from "../components/GlassCard";
import AppInput from "../components/AppInput";
import AppButton from "../components/AppButton";
import { createProduct, getProduct, updateProduct } from "../services/products.service";

export default function ProductFormScreen({ route, navigation }: any) {
  const id = route?.params?.id as number | undefined;
  const [name, setName] = useState("");
  const [quantity, setQuantity] = useState("0");
  const [description, setDescription] = useState("");

  useEffect(() => {
    if (!id) return;
    getProduct(id).then(p => {
      setName(p.title); 
      setQuantity(String(p.quantity ?? 0)); 
      setDescription(p.description);
    });
  }, [id]);

  const submit = async () => {
    try {
      const payload = { 
        title: name, 
        quantity: Number(quantity), 
        description, 
        image: "https://i.pravatar.cc", 
        category: "inventario" 
      };
      if (id) await updateProduct(id, payload);
      else await createProduct(payload);
      Alert.alert("OK", "Producto guardado"); 
      navigation.goBack();
    } catch (e: any) { 
      Alert.alert("Error", e.message ?? "No se pudo guardar"); 
    }
  };

  return (
    <InventoryGradientBg>
      <View style={{ flex:1, padding: 16 }}>
        <GlassCard>
          <AppInput label="Nombre del producto" value={name} onChangeText={setName} />
          <AppInput label="Cantidad" value={quantity} onChangeText={setQuantity} keyboardType="decimal-pad" />
          <AppInput label="Descripción" value={description} onChangeText={setDescription} multiline />
          <AppButton label="Guardar producto" onPress={submit} />
        </GlassCard>
      </View>
    </InventoryGradientBg>
  );
}
