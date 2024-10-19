import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la práctica de tiro de la Batalla Naval. Primero dime el tamaño del tablero que deseas (MAX 26).");
        int tamaño = pedirTamañoTablero(scanner);

        String [][] tablero = new String[tamaño+1][tamaño+1];
        generarTablero(tablero, tamaño);

        System.out.println("Muy bien cadete!!!, ahora que tenemos el tablero, vamos a comenzar la práctica.");

        disparo(tablero, tamaño, scanner);

        System.out.println("Buena práctica cadete!!!.");
    }
    public static int pedirTamañoTablero(Scanner scanner) {
        int tamaño;
        while (true) {
            tamaño = scanner.nextInt();
            if (tamaño > 0 && tamaño < 27) {
                return tamaño;
            } else {
                System.out.println("El tamaño del tablero debe ser un número mayor a 0 y menor a 27.");
            }
        }
    }
    public static void generarTablero(String[][] tablero, int tamaño) {
        int index = 65;
        tablero [0][0] = "   ";
        for (int j = 1; j < tamaño+1; j++) {
            tablero[0][j] = String.format(" %c ", (char) (index++));
        }
        for (int i = 1; i < tamaño+1; i++) {
            tablero[i][0] = String.format("%2d ", i);
            for (int j = 1; j < tamaño+1; j++) {
                tablero[i][j] = "[ ]";
            }
        }
        mostrarTablero(tablero, tamaño);
    }
    public static void mostrarTablero(String[][] tablero, int tamaño) {
        for (int i = 0; i < tamaño+1; i++) {
            for (int j = 0; j < tamaño+1; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void disparo(String[][] tablero, int tamaño, Scanner scanner){
        String letra;
        int numero;
        System.out.println("Elige la coordenada a donde quieres disparar y dime la letra.");
        while (true) {
            letra = scanner.next().toUpperCase();
            if (letra.length()==1 && letra.charAt(0)>='A' && letra.charAt(0)< 'A'+tamaño) {
                break;
            }
            else {
                System.out.println("La letra debe aparecer en el tablero.");
            }
        }
        System.out.println("Ahora dime el numero.");
        while (true) {
            numero = scanner.nextInt();
            if (numero>0 && numero<tamaño) {
                break;
            }
            else {
                System.out.println("El numero debe aparecer en el tablero.");
            }
        }

        tablero[numero][(int)letra.charAt(0)-64] = "[X]";
        mostrarTablero(tablero, tamaño);
    }
}