import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda(); // Nuestra nueva herramienta
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("**********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar =>> Peso argentino\n" +
                    "2) Peso argentino =>> Dólar\n" +
                    "3) Dólar =>> Real brasileño\n" +
                    "4) Real brasileño =>> Dólar\n" +
                    "5) Dólar =>> Peso colombiano\n" +
                    "6) Peso colombiano =>> Dólar\n" +
                    "7) Salir");
            System.out.println("Elija una opción válida:");

            try {
                opcion = Integer.parseInt(lectura.nextLine());
                if (opcion == 7) break;

                String base = "", destino = "";
                switch (opcion) {
                    case 1 -> { base = "USD"; destino = "ARS"; }
                    case 2 -> { base = "ARS"; destino = "USD"; }
                    case 3 -> { base = "USD"; destino = "BRL"; }
                    case 4 -> { base = "BRL"; destino = "USD"; }
                    case 5 -> { base = "USD"; destino = "COP"; }
                    case 6 -> { base = "COP"; destino = "USD"; }
                }

                System.out.println("Ingrese el valor que desea convertir:");
                double valor = Double.parseDouble(lectura.nextLine());

                // Usamos la clase de consulta
                MonedaExchange moneda = consulta.buscarMoneda(base);
                double tasa = moneda.conversion_rates().get(destino);
                double resultado = valor * tasa;

                System.out.println("El valor " + valor + " [" + base + "] corresponde al valor final de =>>> "
                        + String.format("%.2f", resultado) + " [" + destino + "]");

            } catch (Exception e) {
                System.out.println("Error: Ingrese una opción o valor válido.");
            }
        }
        System.out.println("Programa finalizado.");
    }
}