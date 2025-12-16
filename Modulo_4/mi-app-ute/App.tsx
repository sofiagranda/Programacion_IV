// App.tsx principal - Punto de entrada
import React from 'react';
import { SafeAreaView, StatusBar } from 'react-native';
import TypeScriptDemo from './src/screens/TypeScriptDemo';
import { StyleSheet, Text, View } from "react-native";
import { AppTitle } from "@/components/common/AppTitle";
import AppButton from '@/components/AppButton';

function App(): React.JSX.Element {
  return (
    <>
      {/* Primer elemento: Contiene TypeScriptDemo */}
      <SafeAreaView style={{ flex: 1, backgroundColor: '#0d1117' }}>
        {/* Usando el componente StatusBar de react-native */}
        <StatusBar barStyle="light-content" backgroundColor="#0d1117" />
        <TypeScriptDemo />
      </SafeAreaView>

      {/* Segundo elemento: El View adicional */}
      <View style={styles.container}>
        {/* <AppTitle value="Estructura lista" /> */}
        <Text style={{ color: 'white' }}>Imports limpios con alias ✅</Text>
        {/* <StatusBar style="light" /> */}
      </View>

      <View style={styles.section}>
        <Text style={styles.sectionTitle}>4. Componente con Props Tipadas</Text>

        <AppButton
          title="Presionar aquí"
          onPress={() => console.log('Botón presionado!')}
          variant="primary"
        />

        <View style={{ height: 10 }} />

        <AppButton
          title="Cargando..."
          onPress={() => { }}
          loading={true}
          variant="secondary"
        />

        <View style={{ height: 10 }} />

        <AppButton
          title="Deshabilitado"
          onPress={() => { }}
          disabled={true}
          variant="outline"
        />
      </View>

    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#0d1117",
    alignItems: "center",
    justifyContent: "center",
    padding: 16,
  },
  section: {
    marginBottom: 30,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: '600',
    color: '#c9d1d9',
    marginBottom: 10,
    borderLeftWidth: 3,
    borderLeftColor: '#58a6ff',
    paddingLeft: 10,
  },
  card: {
    backgroundColor: '#161b22',
    borderWidth: 1,
    borderColor: '#30363d',
    borderRadius: 8,
    padding: 16,
  },
  label: {
    color: '#8b949e',
    fontSize: 14,
    marginTop: 8,
  },
  value: {
    color: '#c9d1d9',
    fontSize: 16,
    fontWeight: '500',
  },
  success: {
    color: '#3fb950',
  },
  error: {
    color: '#f85149',
  },
  codeComment: {
    color: '#8b949e',
    fontStyle: 'italic',
    fontSize: 12,
    marginTop: 8,
  },
});

export default App;