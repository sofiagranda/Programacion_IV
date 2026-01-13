export type Product = {
    id: string;
    name: string;
    price: number;
    detail: string
  };
  
  export const PRODUCTS: Product[] = [
    { id: "p1", name: "Mouse", price: 12, detail: "Detalle" },
    { id: "p2", name: "Keyboard", price: 25, detail: "Detalle" },
    { id: "p3", name: "Monitor", price: 180, detail: "Detalle" },
    { id: "p4", name: "Laptop Stand", price: 30, detail: "Detalle" },
    { id: "p5", name: "Headset", price: 45, detail: "Detalle" },
  ];