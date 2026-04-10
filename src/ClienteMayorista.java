public class ClienteMayorista extends Cliente {

    private int cantidadProductos;

    public ClienteMayorista(String nombre, int identificacion, double valorCompra, int cantidadProductos) {
        super(nombre, identificacion, valorCompra);
        this.cantidadProductos = cantidadProductos;
    }

    @Override
    public double calcularTotalPagar() {

        double total;

        if (cantidadProductos > 50) {
            total = valorCompra * 0.50;
        } else if (cantidadProductos > 20) {
            total = valorCompra * 0.65;
        } else {
            total = valorCompra * 0.80;
        }

        if (total > 500000) {
            total = 500000;
        }

        return total;
    }
}