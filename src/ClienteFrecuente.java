public class ClienteFrecuente extends Cliente {

    private int numeroCompras;

    public ClienteFrecuente(String nombre, int identificacion, double valorCompra, int numeroCompras) {
        super(nombre, identificacion, valorCompra);
        this.numeroCompras = numeroCompras;
    }

    @Override
    public double calcularTotalPagar() {

        double total;

        if (numeroCompras > 20) {
            total = descontar(0.30);
        } else if (numeroCompras > 10) {
            total = descontar(0.20);
        } else {
            total = descontar(0.10);
        }

        if (compraAlta()) {
            total = total - (total * 0.05);
        }

        return total;
    }
}