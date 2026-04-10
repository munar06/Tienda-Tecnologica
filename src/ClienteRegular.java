public class ClienteRegular extends Cliente {

    public ClienteRegular(String nombre, int identificacion, double valorCompra) {
        super(nombre, identificacion, valorCompra);
    }

    @Override
    public double calcularTotalPagar() {

        if (valorCompra > 300000) {
            return descontar(0.08);
        } else if (valorCompra > 150000) {
            return descontar(0.05);
        } else if (valorCompra < 60000) {
            return aumentar(0.06);
        }

        return valorCompra;
    }
}