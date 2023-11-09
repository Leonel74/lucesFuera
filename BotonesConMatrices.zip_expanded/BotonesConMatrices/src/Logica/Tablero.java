package Logica;

import java.util.Random;

public class Tablero {
	private boolean[][] tablero;
	private int celdaSeleccionada;
	private Random random = new Random();
	/* Constructor */
	public Tablero(int tamanio) {
		this.verificarTablero(tamanio);
		this.celdaSeleccionada = 0;
		this.tablero = new boolean[tamanio][tamanio];
		this.llenarTablero();
	}

	// llena del tablero de booleans randoms
	private void llenarTablero() {
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {
				tablero[fila][columna] = this.random.nextBoolean();
			}
		}
	}

	public void restartTablero() {
		this.llenarTablero();
	}

// verifica si el juego esta resuelto
	public boolean estaResuelto() {
		return todoEnFalse();
	}

	private boolean todoEnFalse() {
		boolean ret = true;
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {
				ret = ret && !tablero[fila][columna];
			}
		}
		return ret;
	}

	// cambiar el estado de la celda pasada por parametro(f, c) y sus vecinas
	public void cambiarEstado(int fila, int columna) {
		// verificamos que los datos sean correctos
		verificarFilaYcolumna(fila);
		verificarFilaYcolumna(columna);

		// modificamos el tablero
		cambiarEstadoCelda(fila, columna);
		cambiarEstadoColumna(columna);
		cambiarEstadoFila(fila);
		incrementarIntentosDeSeleccion();

	}

	private void cambiarEstadoFila(int fila) {
		for (int col = 0; col < tablero[0].length; col++) {
			tablero[fila][col] = !tablero[fila][col];
		}
	}

	private void cambiarEstadoColumna(int col) {
		for (int fila = 0; fila < tablero.length; fila++) {
			tablero[fila][col] = !tablero[fila][col];
		}
	}

	// cambiar el estado de la celda pasada por parametro
	private void cambiarEstadoCelda(int fila, int columna) {
		tablero[fila][columna] = !tablero[fila][columna];
	}

	private void verificarFilaYcolumna(int i) {
		if (i < 0)
			throw new IllegalArgumentException("El numero no puede ser negativo: " + i);

		if (i >= tablero.length)
			throw new IllegalArgumentException("El numero " + i + " deben estar entre 0 y " + (tablero.length - 1));
	}

	private void verificarTablero(int tamanio) {
		if (!(tamanio >= 3))
			throw new IllegalArgumentException("El tamanio del tablero debe ser >= 4 no, " + tamanio);
	}

	/* utilizo para determinar el color del tablero en la vista */
	public boolean celdaEstaEncendida(int fila, int columna) {
		return this.tablero[fila][columna];
	}

	public boolean[][] informarTablero() {
		return this.tablero;
	}

	public int tamanio() {
		return this.tablero.length;
	}

	private void incrementarIntentosDeSeleccion() {
		++celdaSeleccionada;
	}

	public int cantIntentos() {
		return celdaSeleccionada;
	}

}
