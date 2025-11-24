import 'package:go_router/go_router.dart';

import 'pages/restaurant_home_page.dart';
import 'pages/order_total_page.dart';
import 'pages/tip_page.dart';
import 'pages/split_bill_page.dart';
import 'pages/calcular_total_page.dart';
import 'pages/combos_page.dart';

final GoRouter appRouter = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (_, __) => const InventarioHomePage(),
    ),
    GoRoute(
      path: '/inventario-total',
      builder: (_, __) => const InventarioTotalPage(),
    ),
    GoRoute(
      path: '/inventario-agregar',
      builder: (_, __) => InventarioPedidoPage(),
    ),
    GoRoute(
      path: '/inventario-lista',
      builder: (_, __) => InventarioPedidoPage(), // Puedes reemplazar por página de lista si la creas
    ),
    GoRoute(
      path: '/split-inventory',
      builder: (_, __) => const SplitInventoryPage(),
    ),
    GoRoute(
      path: '/ajuste-inventario',
      builder: (_, __) => const InventarioAjustePage(),
    ),
  ],
);
