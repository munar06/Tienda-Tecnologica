import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> lista = new ArrayList<>();
        int opc;

        do {
            System.out.println("""
                MENU
                1. Registrar cliente regular
                2. Registrar cliente frecuente
                3. Registrar cliente mayorista
                4. Buscar cliente
                5. Mostrar todos
                6. Filtrar por tipo
                7. Calcular compra
                8. Mostrar compras altas
                9. Cliente que más pagó
                10. Salir
            """);

            opc = sc.nextInt();

            switch (opc) {

                case 1 -> {
                    System.out.print("Nombre: ");
                    String n = sc.next();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Compra: ");
                    double v = sc.nextDouble();

                    lista.add(new ClienteRegular(n, id, v));
                }

                case 2 -> {
                    System.out.print("Nombre: ");
                    String n = sc.next();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Compra: ");
                    double v = sc.nextDouble();
                    System.out.print("Número compras: ");
                    int nc = sc.nextInt();

                    lista.add(new ClienteFrecuente(n, id, v, nc));
                }

                case 3 -> {
                    System.out.print("Nombre: ");
                    String n = sc.next();
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Compra: ");
                    double v = sc.nextDouble();
                    System.out.print("Cantidad productos: ");
                    int cp = sc.nextInt();

                    lista.add(new ClienteMayorista(n, id, v, cp));
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    for (Cliente c : lista) {
                        if (c.getIdentificacion() == id) {
                            c.imprimirResumen(c.calcularTotalPagar());
                            break;
                        }
                    }
                }

                case 5 -> {
                    for (Cliente c : lista) {
                        c.imprimirResumen(c.calcularTotalPagar());
                    }
                }

                case 6 -> {
                    System.out.println("1.Regular 2.Frecuente 3.Mayorista");
                    int tipo = sc.nextInt();

                    for (Cliente c : lista) {
                        if (tipo == 1 && c instanceof ClienteRegular ||
                                tipo == 2 && c instanceof ClienteFrecuente ||
                                tipo == 3 && c instanceof ClienteMayorista) {

                            c.imprimirResumen(c.calcularTotalPagar());
                        }
                    }
                }

                case 7 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    for (Cliente c : lista) {
                        if (c.getIdentificacion() == id) {
                            System.out.println("Total: " + c.calcularTotalPagar());
                        }
                    }
                }

                case 8 -> {
                    for (Cliente c : lista) {
                        if (c.compraAlta()) {
                            c.imprimirResumen(c.calcularTotalPagar());
                        }
                    }
                }

                case 9 -> {
                    Cliente mayor = null;
                    double max = 0;

                    for (Cliente c : lista) {
                        double t = c.calcularTotalPagar();
                        if (t > max) {
                            max = t;
                            mayor = c;
                        }
                    }

                    if (mayor != null) {
                        System.out.println("\nCliente que más pagó:");
                        mayor.imprimirResumen(max);
                    }
                }

                case 10 -> System.out.println("Saliendo...");
            }

        } while (opc != 10);
    }
}