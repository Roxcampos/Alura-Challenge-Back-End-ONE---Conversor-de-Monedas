import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el código de la moneda de origen: ");
        String codigoOrigen = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese el código de la moneda de destino: ");
        String codigoDestino = scanner.nextLine().toUpperCase();
        System.out.println("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try {
            String json = ConsultaMoneda.consultar("https://v6.exchangerate-api.com/v6/005eb7055a72ed5cc078ed4f/latest/USD");
            double tasaOrigen = FiltroMonedas.obtenerTasa(json, codigoOrigen);
            double tasaDestino = FiltroMonedas.obtenerTasa(json, codigoDestino);
            double resultado = cantidad * (tasaDestino / tasaOrigen);
            System.out.println("El resultado de la conversión es: " + resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}