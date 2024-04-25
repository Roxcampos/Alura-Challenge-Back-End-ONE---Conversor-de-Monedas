import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        System.out.println("Escriba la moneda que desea buscar:");
        try{
            var numeroDeMoneda = Integer.valueOf(lectura.nextLine());
            Moneda moneda = consulta.buscaMoneda(numeroDeMoneda);
            System.out.println(moneda);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(moneda);
        } catch (NumberFormatException e){
            System.out.println("Número no encontrado "+e.getMessage());
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
