import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();

        while (true) {
            System.out.println("Escriba el número de la película de Star Wars que quiere consultar (o 'salir' para terminar): ");
            String entrada = input.nextLine();  // Leer la entrada del usuario

            // Comprobar si la entrada es "salir" (ignorando mayúsculas/minúsculas)
            if (entrada.equalsIgnoreCase("salir")) {
                System.out.println("Finalizó la aplicación");
                break;  // Salir del bucle
            }

            try {
                // Convertir la entrada a un número entero
                int numeroDePelicula = Integer.parseInt(entrada);

                // Consultar la película
                Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
                System.out.println(pelicula);
                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarGjson(pelicula);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("No se encontró la película especificada.");
            }
        }
    }
}
