import java.util.Scanner;

public class Sudoku {

	public static final int DIMENSION_TABLERO = 9;
	public static final int DIMENSION_CAJA = 3;

	public static void main(String[] args) {
		Sudoku.ejecutar();
	}

	public static void ejecutar() {
		int[][] celdas = new int[DIMENSION_TABLERO][DIMENSION_TABLERO];
		int ocupacion = 0;
		ocupacion = Sudoku.iniciar(celdas);
		Sudoku.jugar(celdas, ocupacion);
	}

	public static int iniciar(int[][] celdas) {
		int ocupacion = 0;
		for (int fila = 0; fila < DIMENSION_TABLERO; fila++) {
			for (int columna = 0; columna < DIMENSION_TABLERO; columna++) {
				celdas[fila][columna] = 0;
			}
		}

		celdas[0][0] = 5;
		ocupacion++;
		celdas[0][1] = 3;
		ocupacion++;
		celdas[0][4] = 7;
		ocupacion++;
		celdas[1][0] = 6;
		ocupacion++;
		celdas[1][3] = 1;
		ocupacion++;
		celdas[1][4] = 9;
		ocupacion++;
		celdas[1][5] = 5;
		ocupacion++;
		celdas[2][1] = 9;
		ocupacion++;
		celdas[2][2] = 8;
		ocupacion++;
		celdas[2][7] = 6;
		ocupacion++;
		celdas[3][0] = 8;
		ocupacion++;
		celdas[3][4] = 6;
		ocupacion++;
		celdas[3][8] = 3;
		ocupacion++;
		celdas[4][0] = 4;
		ocupacion++;
		celdas[4][3] = 8;
		ocupacion++;
		celdas[4][5] = 3;
		ocupacion++;
		celdas[4][8] = 1;
		ocupacion++;
		celdas[5][0] = 7;
		ocupacion++;
		celdas[5][4] = 2;
		ocupacion++;
		celdas[5][8] = 6;
		ocupacion++;
		celdas[6][1] = 6;
		ocupacion++;
		celdas[6][6] = 2;
		ocupacion++;
		celdas[6][7] = 8;
		ocupacion++;
		celdas[7][3] = 4;
		ocupacion++;
		celdas[7][4] = 1;
		ocupacion++;
		celdas[7][5] = 9;
		ocupacion++;
		celdas[7][8] = 5;
		ocupacion++;
		celdas[8][4] = 8;
		ocupacion++;
		celdas[8][7] = 7;
		ocupacion++;
		celdas[8][8] = 9;
		ocupacion++;

		return ocupacion;
	}


	public static void jugar(int[][] celdas, int ocupacion) {
		Sudoku.mostrar(celdas);
		while (ocupacion != DIMENSION_TABLERO * DIMENSION_TABLERO) {
			System.out.print("Introduzca una fila [1.." + DIMENSION_TABLERO + "]: ");
			int fila = Sudoku.leerEntero(1, DIMENSION_TABLERO);
			System.out.print("Introduzca una columna [1.." + DIMENSION_TABLERO + "]: ");
			int columna = Sudoku.leerEntero(1, DIMENSION_TABLERO);
			System.out.print("Introduzca un numero [1.." + DIMENSION_TABLERO + "]: ");
			int numero = Sudoku.leerEntero(1, DIMENSION_TABLERO);
			if (Sudoku.estaOcupada(celdas, fila, columna)) {
				System.out.println("ERROR: La celda [" + fila + "][" + columna + "] esta ocupada");
			} else if (Sudoku.estaEnFila(celdas, fila, numero)) {
				System.out.println("ERROR: El numero " + numero + " ya esta en la fila " + fila);
			} else if (Sudoku.estaEnColumna(celdas, columna, numero)) {
				System.out.println("ERROR: El numero " + numero + " ya esta en la columna " + columna);
			} else if (Sudoku.estaEnCaja(celdas, fila, columna, numero)) {
				System.out.println("ERROR: El numero " + numero + " ya esta en la caja "
						+ "de la celda [" + fila + "][" + columna + "]");
			} else {
				celdas[fila - 1][columna - 1] = numero;
				ocupacion++;
			}
			Sudoku.mostrar(celdas);
		}
		System.out.println("SUDOKU RESUELTO - ENHORABUENA");
	}

	public static int leerEntero(int minimo, int maximo) {
		Scanner scanner = new Scanner(System.in);
		int entero;
		do {
			entero = scanner.nextInt();
			scanner.nextLine();
		} while (entero < minimo || entero > maximo);
		return entero;
	}

	public static void mostrarLinea() {
		final int CAJAS = DIMENSION_TABLERO / DIMENSION_CAJA;
		final int GUIONES = 1 + 2 * (DIMENSION_CAJA + 1) * CAJAS;
		for (int i = 0; i < GUIONES; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	// TODO 1 ------------------------------------------------------------------------------------------
	public static void mostrar(int[][] celdas) {
		int r = 0;
		for(int i = 0; i <= 2; ++i) {
			mostrarLinea();
			if (i == 0) {
				r = 0;
			}
			else if (i == 1){
				r = 3;
			}
			else if (i == 2){
				r = 6;
			}
			for (int f = r; f <= r+2; ++f) {

				for (int j = 0; j <= (celdas.length - 1); ++j) {
					if (j == 0 || j == 3 || j == 6) {
						System.out.print("| ");
					}
					if (celdas[j][f] == 0) {
						System.out.print("- ");
					} else {
						System.out.print(celdas[j][f] + " ");
					}
				}
				System.out.print("|\n");
			}

		}
		mostrarLinea();
		// SE PIDE escribir el codigo de esta funcion
	}

	// TODO 2 ------------------------------------------------------------------------------------------
	public static boolean estaOcupada(int[][] celdas, int fila, int columna) {
		// SE PIDE escribir el codigo de esta funcion
		return true;
	}

	// TODO 3 ------------------------------------------------------------------------------------------
	public static boolean estaEnFila(int[][] celdas, int fila, int numero) {
		// SE PIDE escribir el codigo de esta funcion
		return true;
	}

	// TODO 4 ------------------------------------------------------------------------------------------
	public static boolean estaEnColumna(int[][] celdas, int columna, int numero) {
		// SE PIDE escribir el codigo de esta funcion
		return true;
	}

	// TODO 5 ------------------------------------------------------------------------------------------
	public static boolean estaEnCaja(int[][] celdas, int fila, int columna, int numero) {
		// SE PIDE escribir el codigo de esta funcion
		return true;
	}
}