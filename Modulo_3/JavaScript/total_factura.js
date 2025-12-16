// Dado un arreglo de facturas, donde cada factura tiene un id y un arreglo 
// de items con precio y cantidad, devuelve un nuevo arreglo con el id y el
// total calculado para cada factura

const facturas = [
  {
    id: 1,
    items: [
      { precio: 10, cantidad: 2 },
      { precio: 5, cantidad: 4 }
    ]
  },
  {
    id: 2,
    items: [
      { precio: 100, cantidad: 1 },
      { precio: 20, cantidad: 3 },
    ]
  }
];


function calcularTotalesFacturas(facturas) {
    const resultado = []

    for(let i = 0; i < facturas.length; i++){
        let total = 0;

        for (let j = 0; j < facturas[i].items.lenght;j++){
            const item = facturas[i].items[j];
            total += item.precio * item.cantidad;
        }
        resultado.push({
            id: facturas[i].id,
            total: total
        });
    }
    return resultado;
};

const totalesFacturas = calcularTotalesFacturas(facturas);
console.log(totalesFacturas);