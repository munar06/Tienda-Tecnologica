public class Cliente {

    protected String nombre;
    protected int identificacion;
    protected double valorCompra;

    public Cliente(String nombre, int identificacion, double valorCompra) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.valorCompra = valorCompra;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public double calcularTotalPagar() {
        return valorCompra;
    }

    public double descontar(double porcentaje) {
        return valorCompra - (valorCompra * porcentaje);
    }

    public double aumentar(double porcentaje) {
        return valorCompra + (valorCompra * porcentaje);
    }

    public boolean compraAlta() {
        return valorCompra > 300000;
    }

    public void imprimirResumen(double total) {
        System.out.println("\nCliente:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Valor compra: " + valorCompra);
        System.out.println("Total a pagar: " + total);
    }
}