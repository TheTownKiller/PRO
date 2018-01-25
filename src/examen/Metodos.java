package examen;

import modelo.Libro;

public class Metodos {

	// ejercicio 1
	
	public char metodo1(int numero) {

		String numeroString = Integer.toString(numero);

		if (numeroString.length() != 8) {
			return '1';
		} else {

			char[] equivalencia = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
					'V', 'H', 'L', 'C', 'K', 'E' };

			int resultado = numero % 23;
			return equivalencia[resultado];
		}
	}

	// ejercicio 2
	
	public Libro[] metodo(String[] libros) {

		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		Libro libro3 = new Libro();
		Libro libro4 = new Libro();
		Libro[] arrayLibros = { libro1, libro2, libro3, libro4 };

		for (int i = 0; i < libros.length; i++) {

			String[] arrayAuxiliar = libros[i].split("#");

			try {
				int id = Integer.parseInt(arrayAuxiliar[0]);
				arrayLibros[i].setId(id);

				String titulo = arrayAuxiliar[1];
				arrayLibros[i].setTitulo(titulo);

				float precio = Float.parseFloat(arrayAuxiliar[2]);
				arrayLibros[i].setPrecio(precio);

			} catch (NumberFormatException e) {
				arrayLibros[i] = null;
			}
		}

		return arrayLibros;

	}

	// ejercicio 3

	public int[][] metodo3(int jugadores, int partidas) {

		int[][] resultado = new int[partidas][jugadores];

		for (int j = 0; j < partidas; j++) {
			for (int i = 0; i < jugadores; i++) {
				resultado[j][i] = (int) (Math.random() * 7);
				if(resultado[j][i] == 0) {
					resultado[j][i] = 1;
				}
			}
		}
		return resultado;

	}

}
