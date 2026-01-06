// App.tsx principal - Punto de entrada
import React from 'react';
import { SafeAreaView, StatusBar } from 'react-native';
import TypeScriptDemo from './src/screens/TypeScriptDemo';
import { StyleSheet, Text, View } from "react-native";
import { AppTitle } from "@/components/common/AppTitle";
import AppButton from '@/components/AppButton';
import { ClockDemo } from '@/screens/ClockDemo';
import { UseEffectAsyncDemo } from '@/screens/UseEffectAsyncDemo';
import { AbortFetchDemo } from '@/screens/AbortFetchDemo';
import { ProductsDemo } from '@/screens/Productos';
import { Parte09Lab } from '@/screens/Parte09Lab';
import { Parte10Lab } from '@/screens/Parte10Lab';

function App(): React.JSX.Element {
  return (
    <View style={styles.container}>
        <Parte10Lab />
    </View>
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