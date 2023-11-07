import java.util.Scanner;

public class detectorDeMutantes {

    public static boolean esMutante(String[] ADN) {
        int fila = ADN.length;
        int columna = ADN[0].length();
        int contadorDeSecuencias = 0;

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {

                // Revisa la secuencia horizontalmente
                if (j + 3 < columna) {
                    if (ADN[i].charAt(j) == ADN[i].charAt(j + 1) &&
                            ADN[i].charAt(j) == ADN[i].charAt(j + 2) &&
                            ADN[i].charAt(j) == ADN[i].charAt(j + 3)) {
                        contadorDeSecuencias++;
                    }
                }

                // Revisa la secuencia verticalmente
                if (i + 3 < fila) {
                    if (ADN[i].charAt(j) == ADN[i + 1].charAt(j) &&
                            ADN[i].charAt(j) == ADN[i + 2].charAt(j) &&
                            ADN[i].charAt(j) == ADN[i + 3].charAt(j)) {
                        contadorDeSecuencias++;
                    }
                }

                // Revisa la secuencia diagonal en ambas direcciones
                if (i + 3 < fila && j + 3 < columna) {
                    if (ADN[i].charAt(j) == ADN[i + 1].charAt(j + 1) &&
                            ADN[i].charAt(j) == ADN[i + 2].charAt(j + 2) &&
                            ADN[i].charAt(j) == ADN[i + 3].charAt(j + 3)) {
                        contadorDeSecuencias++;
                    }
                }
                if (i + 3 < fila && j - 3 >= 0) {
                    if (ADN[i].charAt(j) == ADN[i + 1].charAt(j - 1) &&
                            ADN[i].charAt(j) == ADN[i + 2].charAt(j - 2) &&
                            ADN[i].charAt(j) == ADN[i + 3].charAt(j - 3)) {
                        contadorDeSecuencias++;
                    }
                }
            }
        }

        return contadorDeSecuencias > 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ADN = new String[6];

        System.out.println("Ingrese las filas de la matriz de ADN (6 filas, cada una con 6 letras A, T, C o G):");

        for (int i = 0; i < 6; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            ADN[i] = scanner.next();
        }

        // Si se carga
        //Fila 1: ATGCGA
        //Fila 2: CAGTGC
        //Fila 3: TTATGT
        //Fila 4: AGAAGG
        //Fila 5: CCCCTA
        //Fila 6: TCACTG
        // Respondera que es un muntante

        boolean resultado = esMutante(ADN);

        if (resultado) {
            System.out.println("Es un mutante.");
        } else {
            System.out.println("No es un mutante.");
        }
    }
}
