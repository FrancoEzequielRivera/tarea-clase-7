import java.util.ArrayList;

public class Carrito {
    //private String prods[] = new String[3];
    //private Double precios[] = new Double[3];
    private ArrayList<Double> precios = new ArrayList<Double>();
    private int cont = 0;
    //private Descuento descuento;
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    public Carrito(){
    }

    public void agregarProducto(Producto producto, Descuento descuento){
        productos.add(producto);

        if (descuento.calcularElDescuento(productos.get(cont).darPrecio()) <= 0){
            throw new IllegalArgumentException("El descuento es un numero negativo");
        }
        precios.add(productos.get(cont).darPrecio() - descuento.calcularElDescuento(productos.get(cont).darPrecio()));
        cont = cont + 1;
    }
    public double precio(){

        Double precioTotal = 0.0;

        for(Double precioProducto : precios){
            precioTotal += precioProducto;
        }
        if (precioTotal == 0){
            throw new IllegalArgumentException("No se puede aplicar un descuento a un carrito de precio 0");
        }
        return precioTotal;
    }

}
