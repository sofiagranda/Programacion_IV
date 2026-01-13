import { createNativeStackNavigator } from "@react-navigation/native-stack";
import type { RootStackParamList } from "@/navigation/types";
import { HomeScreen } from "@/screens/HomeScreen";
import { DetailsScreen } from "@/screens/DetailsScreen";
import { SettingsScreen } from "@/screens/SettingsScreen";
import { ClockDemo } from "@/screens/ClockDemo";
import { LoginFormScreen } from "@/screens/LoginFormScreen";
import { TrapezoidAreaScreen } from "@/screens/TrapecioScreen";
import { ProductsListScreen } from "@/screens/ProductsListScreen";
import { ProfileScreen } from "@/screens/ProfileScreen";

const Stack = createNativeStackNavigator<RootStackParamList>();

export function AppNavigator() {
  return (
    <Stack.Navigator
      screenOptions={{
        headerStyle: { backgroundColor: "#0d1117" },
        headerTintColor: "#58a6ff",
        headerTitleStyle: { fontWeight: "900" },
        contentStyle: { backgroundColor: "#0d1117" },
      }}
    >
      <Stack.Screen name="Home" component={HomeScreen} options={{ title: "Inicio" }} />
      <Stack.Screen name="Details" component={DetailsScreen} options={{ title: "Detalles" }} />
      <Stack.Screen name="Demo" component={ClockDemo} options={{ title: "Demo" }} />
      <Stack.Screen name="LoginForm" component={LoginFormScreen} options={{ title: "Login Form" }} />
      <Stack.Screen name="Trapecio" component={TrapezoidAreaScreen} options={{ title: "Trapecio" }} />
      <Stack.Screen name="Products" component={ProductsListScreen} options={{ title: "Productos" }} />
      <Stack.Screen
        name="Profile"
        component={ProfileScreen}
        options={{ title: "Perfil" }}
      />
      <Stack.Screen
        name="Settings"
        component={SettingsScreen}
        options={{ title: "Settings" }}
      />
    </Stack.Navigator>
  );
}