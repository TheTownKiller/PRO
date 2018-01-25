package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Vendedor;
import modelo.Venta;

public class Practicas {
	// private static String[] diasSemana = { "lunes", "martes", "miercoles",
	// "jueves", "viernes", "sábado", "domingo" };

	public boolean esPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}

		return true;
	}
	
	public int[] numerosPrimos(int cuantos) {
		int[] primos = new int[cuantos];
		int i = 0;
		int j = 1;
		while (i < cuantos) {
			if (esPrimo(j))
				j = primos[i++];
			j++;
		}
		return primos;
	}


	public ArrayList<Integer> numerosPrimos2(int cuantos) {
		ArrayList<Integer> primos = new ArrayList<Integer>(cuantos);
		int i = 0;
		int j = 1;
		while (i < cuantos) {
			if (esPrimo(j))
				j = primos.get(i++);
			j++;
		}
		return primos;
	}

	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		int z;
		x = numeros[0];
		y = numeros[1];
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			z = numeros[i];
			x = y;
			y = z;
		}
		return numeros;
	}
	
	public ArrayList<Integer> numerosFibonacci2(int cuantos) {
		ArrayList<Integer> numeros = new ArrayList<Integer>(cuantos);
		int x = 0;
		int y = 1;
		int z;
		x = numeros.get(0);
		y = numeros.get(1);
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			z = numeros.get(i);
			x = y;
			y = z;
		}
		return numeros;
	}

	// LIGA: Obtener clasificación a partir de resultados
	public int[] obtenerClasificacion(String[][] goles) {
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = new String[goles.length];
		// recorrer la matriz de goles
		for (int i = 0; i < goles.length; i++)
			for (int j = 0; j < goles[i].length; j++)
				if (goles[i][j].indexOf('-') != -1) {
					String[] puntuacion = goles[i][j].split("-");
					String puntuacion1 = puntuacion[1];
					String puntuacion2 = puntuacion[2];
					resultado[0] =  puntuacion1;
					resultado[1] =  puntuacion2;
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					System.out.println(golesLocal + "   " + golesVisitante);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] = puntos[i] + 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] = puntos[j] + 3;
					else { // empate
						puntos[i] = puntos[i] + 1;
						puntos[j] = puntos[j] + 1;
					}
				}
		return puntos;
	}
	
	public ArrayList<Integer> obtenerClasificacion2(ArrayList<ArrayList<String>> goles) {
		ArrayList<Integer> puntos = new ArrayList<Integer>(5);
		int golesLocal;
		int golesVisitante;
		ArrayList<String> resultado = new ArrayList<String>();
		// recorrer la matriz de goles
		for (int i = 0; i < goles.size(); i++)
			for (int j = 0; j < goles.get(i).size(); j++)
				if (goles.get(i).get(j).indexOf('-') != -1) {
					String[] puntuacion = goles.get(i).get(j).split("-");
					String puntuacion1 = puntuacion[1];
					String puntuacion2 = puntuacion[2];
					resultado.set(0, puntuacion1);
					resultado.set(1, puntuacion2);
					golesLocal = Integer.parseInt(resultado.get(0));
					golesVisitante = Integer.parseInt(resultado.get(1));
					System.out.println(golesLocal + "   " + golesVisitante);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos.set(i, puntos.get(i) + 3);
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos.set(j, puntos.get(j) + 3);
					else { // empate
						puntos.set(i, puntos.get(i) + 1);
						puntos.set(j, puntos.get(j) + 1);
					}
				}
		return puntos;
	}

	public int[] obtenerClasificacion3(String[][] goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = new String[goles.length];
		// recorrer la matriz de goles
		for (int j = 0; j < goles[0].length; j++)
			for (int i = 0; i < goles.length; i++)
				if (goles[i][j].indexOf('-') != -1) {
					String[] puntuacion = goles[i][j].split("-");
					String puntuacion1 = puntuacion[1];
					String puntuacion2 = puntuacion[2];
					resultado[0] = puntuacion1;
					resultado[1] = puntuacion2;
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] = puntos[i] + 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] = puntos[j] + 3;
					else { // empate
						puntos[i] = puntos[i] + 1;
						puntos[j] = puntos[j] + 1;
					}
				}
		return puntos;
	}
	
	public ArrayList<Integer> obtenerClasificacion4(ArrayList<ArrayList<String>> goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		ArrayList<Integer> puntos = new ArrayList<Integer>(5);
		int golesLocal;
		int golesVisitante;
		ArrayList<String> resultado = new ArrayList<String>();
		// recorrer la matriz de goles
		for (int j = 0; j < goles.get(0).size(); j++)
			for (int i = 0; i < goles.size(); i++)
				if (goles.get(i).get(j).indexOf('-') != -1) {
					String[] puntuacion = goles.get(i).get(j).split("-");
					String puntuacion1 = puntuacion[1];
					String puntuacion2 = puntuacion[2];
					resultado.set(0, puntuacion1);
					resultado.set(1, puntuacion2);
					golesLocal = Integer.parseInt(resultado.get(0));
					golesVisitante = Integer.parseInt(resultado.get(1));
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos.set(i, puntos.get(i) + 3);
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos.set(j, puntos.get(j) + 3);
					else { // empate
						puntos.set(i, puntos.get(i) + 1);
						puntos.set(j, puntos.get(j) + 1);
					}
				}
		return puntos;
	}
	
	public Equipo[] obtenerClasificacion5(int[][] puntosJornadas) {
		Equipo[] clasificacion = new Equipo[5];
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas[0].length; j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.length; i++)
				e.setPuntos(e.getPuntos() + puntosJornadas[i][j]);
			e = clasificacion[j];
		}

		return clasificacion;
	}

	public ArrayList<Equipo> obtenerClasificacion6(ArrayList<ArrayList<Integer>> puntosJornadas) {
		ArrayList<Equipo> clasificacion = new ArrayList<Equipo>(5);
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas.get(0).size(); j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.size(); i++)
				e.setPuntos(e.getPuntos() + puntosJornadas.get(i).get(j));
			e = clasificacion.get(j);
		}

		return clasificacion;
	}

	public boolean validarNif(String nif) {
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nif.length() != 9)
			return false;
		String numeros = nif.substring(0, 8);
		// System.out.println(numeros);
		int numerosOK;
		try {
			numerosOK = Integer.parseInt(numeros);
		} catch (NumberFormatException e) {
			return false;
		}
		int resto = numerosOK % 23;
		if (letrasValidas[resto] != nif.charAt(8))
			return false;
		return true;
	}

	// ORDENACION
	public void ordenaEnteros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] > numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
	}
	
	public void ordenaEnteros2(ArrayList<Integer> numeros) {
		for (int i = 0; i < numeros.size() - 1; i++)
			for (int j = i + 1; j < numeros.size(); j++)
				if (numeros.get(i) > numeros.get(j)) {
					int aux = numeros.get(i);
					numeros.set(i, numeros.get(j));
					numeros.set(j, aux);
				}
	}

	public void ordenaClasificacion(int[] numeros,String[] equipos) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] < numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
					String aux2 = equipos[i];
					equipos[i] = equipos[j];
					equipos[j] = aux2;
				}
	}
	
	public void ordenaClasificacion2(ArrayList<Integer> numeros, ArrayList<String> equipos) {
		for (int i = 0; i < numeros.size() - 1; i++)
			for (int j = i + 1; j < numeros.size(); j++)
				if (numeros.get(i) < numeros.get(j)) {
					int aux = numeros.get(i);
					numeros.set(i, numeros.get(j));
					numeros.set(j, aux);
					String aux2 = equipos.get(i);
					equipos.set(i, equipos.get(j));
					equipos.set(j, aux2);
				}
	}
	// mezcla dos arrays ordenados

	public int[] mezclaArrays(int[] l1, int[] l2) {
		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j])
				resultado[k] = l1[i++];
			else
				resultado[k] = l1[j++];
			k++;

			if (i == l1.length)
				l1[--i] = Integer.MAX_VALUE;

			if (j == l2.length)
				l2[--j] = Integer.MAX_VALUE;
		}
		return resultado;
	}
	
	public ArrayList<Integer> mezclaArrays2(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int i = 0, j = 0, k = 0;
		ArrayList<Integer> resultado = new ArrayList<Integer>(l1.size() + l2.size());

		while (l1.get(i) != Integer.MAX_VALUE || l2.get(j) != Integer.MAX_VALUE) {
			if (l1.get(i) < l2.get(j))
				resultado.set(k, l1.get(i++));
			else
				resultado.set(k, l2.get(j++));
			k++;

			if (i == l1.size())
				l1.set(--i, Integer.MAX_VALUE);

			if (j == l2.size())
				l2.set(--j, Integer.MAX_VALUE);
		}
		return resultado;
	}

	public void ordenaCadenas(String[] cadenas) {
		for (int i = 0; i < cadenas.length - 1; i++)
			for (int j = i + 1; j < cadenas.length; j++)
				if (cadenas[i].compareTo(cadenas[j]) > 0) {
					String aux = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = aux;
				}

	}
	
	public void ordenaCadenas2(ArrayList<String> cadenas) {
		for (int i = 0; i < cadenas.size() - 1; i++)
			for (int j = i + 1; j < cadenas.size(); j++)
				if (cadenas.get(i).compareTo(cadenas.get(j)) > 0) {
					String aux = cadenas.get(i);
					cadenas.set(i, cadenas.get(j));
					cadenas.set(j, aux);
				}

	}

	public void ordenaEstudiantes(Estudiante[] estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.length - 1; i++)
			for (int j = i + 1; j < estudiantes.length; j++)
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					Estudiante aux = estudiantes[j];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
	}
	
	public void ordenaEstudiantes2(ArrayList<Estudiante> estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.size() - 1; i++)
			for (int j = i + 1; j < estudiantes.size(); j++)
				if (estudiantes.get(i).compareTo(estudiantes.get(j)) > 0) {
					Estudiante aux = estudiantes.get(j);
					estudiantes.set(i, estudiantes.get(j));
					estudiantes.set(j, aux);
				}
	}

	public float calculaSaldo(float saldoInicial, float[] movimientos) {
		Float saldoFinal = saldoInicial;
		for (Float bucle : movimientos)
			saldoFinal += bucle;
		return saldoFinal;
	}
	
	public float calculaSaldo2(float saldoInicial, ArrayList<Float> movimientos) {
		Float saldoFinal = saldoInicial;
		for (Float bucle : movimientos)
			saldoFinal += bucle;
		return saldoFinal;
	}

	public int[] convierteCadenasANumeros(String[] cadenas) {
		int[] resultado = new int[cadenas.length];
		for (int i = 0; i<cadenas.length; i++) {
			try {
				resultado[i] = Integer.parseInt(cadenas[i]);
			} catch (NumberFormatException e) {
				resultado[i] = -1;
			}
		}
		return resultado;
	}	
	
	public ArrayList<Integer> convierteCadenasANumeros2(ArrayList<String> cadenas) {
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for (String bucle : cadenas) {
			try {
				resultado.add(Integer.parseInt(bucle));
			} catch (NumberFormatException e) {
				resultado.add(-1);
			}
		}
		return resultado;
	}

	public void muestraNumeros() {

		int x = 0;
		while (x <= 1000) {
			System.out.println("x: " + x);
			x++;
		}
	}

	public void muestraNumeros(int min, int max) {

		if (min <= max) {
			int x = min;
			while (x <= max) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros2(int min, int max) {

		if (min <= max) {
			int x = min;
			do {
				System.out.println("x: " + x);
				x++;
			} while (x <= max);
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros3(int min, int max) {
		int x = min;
		if (min <= max) {
			// for (int x = min; x < max; x++) {
			// for (;;) {
			while (true) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void generaAleatorios(int cuantos, int inferior, int superior) // max 30, min 10
	{

		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + (int) (Math.random() * (superior - inferior + 1)));

	}

	public void generaAleatorios2(int cuantos, int inferior, int superior) // max 30, min 10
	{

		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
	}

	
	public int[] generaAleatorios3(int cuantos, int inferior, int superior) // max 30, min 10
	{
		int[] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);
		return resultado;
	}

	public ArrayList<Integer> generaAleatorios4(int cuantos, int inferior, int superior) // max 30, min 10
	{
		ArrayList<Integer> resultado = new ArrayList<Integer>(cuantos);
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado.set(i, inferior + rnd.nextInt(superior - inferior + 1));
		return resultado;
	}
	
	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatorios3(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}
	
	public ArrayList<Integer> frecuenciaAparicion2(int cuantos, int inferior, int superior) {
		ArrayList<Integer> resultado = new ArrayList<Integer>(superior - inferior + 1);
		ArrayList<Integer> lanzamientos = this.generaAleatorios4(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.size(); i++) {
			resultado.set(lanzamientos.get(i) - 1, (lanzamientos.get(i++) - 1));
		}
		return resultado;

	}

	public void estadisticaCadena(String cadena) {
		int contadorVocales = 0;
		int contadorMayusculas = 0;
		int contadorEspeciales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
					|| cadena.charAt(i) == 'u' || cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E'
					|| cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U')
				contadorVocales++;
			if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z')
				contadorMayusculas++;
			int caracterAscii = cadena.charAt(i);
			if ((caracterAscii >= 0 && caracterAscii <= 47) || (caracterAscii >= 58 && caracterAscii <= 64) ||

					(caracterAscii >= 91) && (caracterAscii <= 96))

				contadorEspeciales++;
		}
		// System.out.println("Hay " + contadorVocales + " vocales en " + cadena);
		System.out.println("Hay " + contadorEspeciales + " caracteres especiales en " + cadena);

	}

	public void listaDiasSemana() {
		Datos datos = new Datos();
		// String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes",
		// "sábado", "domingo" };
		// for (int i = 0; i < datos.getDiasSemana().length; i++)
		for (String dia : datos.getDiasSemana())
			// System.out.println(datos.getDiasSemana()[i]);
			System.out.println(dia);
	}

	public void listaEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public int visitantesIslaYear(int isla, int[][] v) {
		int acu = 0;
		for (int j = 0; j < v[0].length; j++)
			acu += v[isla][j];
		return acu;
	}

	public int visitantesMesYear(int mes, int[][] v) {
		int acu = 0;
		for (int i = 0; i < v.length; i++)
			acu += v[i][mes];
		return acu;
	}

	public void recorrerMatrizIrregularPorColumnas(int[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}

			}
		}
	}

	public void recorrerMatrizIrregularPorColumnas2(Integer[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j].byteValue());
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				} catch (NullPointerException e) {
					continue;
				}

			}
		}
	}

	// SEGUNDA EVALUACIÓN

	public ArrayList<Estudiante> introListas() {
		ArrayList<Estudiante> listaE;
		listaE = new ArrayList<Estudiante>();
		Estudiante est1 = new Estudiante(123);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		int tam = listaE.size();
		Estudiante est2 = new Estudiante(321);
		listaE.add(0, est2);
		listaE.remove(listaE.size() - 1);
		// listaE.set(0, est1);
		for (int i = 0; i < listaE.size(); i++) {
			System.out.println(listaE.get(i).getNombre());

		}
		return listaE;
	}

	public void listaEstudiantes(ArrayList<Estudiante> lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public ArrayList<ArrayList<Integer>> transformarArrayEnArrayList(int[][] visitantesYear) {
		ArrayList<ArrayList<Integer>> arrayResultante = new ArrayList<ArrayList<Integer>>();
		for (int[] fila : visitantesYear) {
			ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
			for (int numero : fila) {
				arrayResultante.add(arrayInteger);
				arrayInteger.add(numero);

			}
		}
		System.out.println(arrayResultante);
		return arrayResultante;
	}

	public ArrayList<ArrayList<Integer>> transformarArrayEnArrayList2(int[][] visitantesYear) {
		ArrayList<ArrayList<Integer>> arrayResultante = new ArrayList<ArrayList<Integer>>();
		for (int j = 0; j < visitantesYear.length; j++) {
			ArrayList<Integer> arrayInteger = new ArrayList<Integer>();
			for (int i = 0; i < visitantesYear[j].length; i++) {
				arrayResultante.add(arrayInteger);
				arrayInteger.add(visitantesYear[j][i]);

			}
		}
		System.out.println(arrayResultante);
		return arrayResultante;
	}

	public HashMap<String, Estudiante> introMapas() {
		// La clave representa el nif del estudiante
		HashMap<String, Estudiante> resultado = new HashMap<String, Estudiante>();
		Estudiante est = new Estudiante(123, "1231233F", "paco", 'M', null, 180, null, null);
		resultado.put(est.getNif(), est);
		Estudiante estudiante = resultado.get(est.getNif());
		resultado.put("1231233F", new Estudiante(0));
		return resultado;

	}

	public void bufferFile() throws IOException {
		try {
			BufferedReader inFile = new BufferedReader(new FileReader("src/ficheros/personas.txt"));
			while (inFile.ready()) {
				String texto = inFile.readLine();
				String[] partes = texto.split("-");
				LocalDate fechaNac = LocalDate.of(Integer.parseInt(partes[2].substring(0, 2)),
						Integer.parseInt(partes[2].substring(2, 4)), Integer.parseInt(partes[2].substring(4, 8)));
				String nif = partes[0];
				String nombre = partes[1];
				Character genero = partes[3].charAt(0);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public String ageCalculation(String fechaNac) {

		String[] ahora = LocalDate.now().toString().split("-");
		int dia = Integer.parseInt(ahora[2]);
		int mes = Integer.parseInt(ahora[1]);
		int año = Integer.parseInt(ahora[0]);

		String[] nac = fechaNac.split("-");
		int diaNac = Integer.parseInt(nac[0]);
		int mesNac = Integer.parseInt(nac[1]);
		int añoNac = Integer.parseInt(nac[2]);

		int resultado = ((año * 365) + (mes * 30) + dia) - ((añoNac * 365) + (mesNac * 30) + diaNac);
		int resulMeses = (resultado % 365);
		System.out.println(resultado / 365 + " Años " + ((resulMeses) / 30) + " meses " + resulMeses % 30 + " dias.");
		String resultado1 = resultado / 365 + " Años " + ((resulMeses) / 30) + " meses " + resulMeses % 30 + " dias.";
		return resultado1;
	}

	public HashMap<Vendedor, Venta> ficheroVendedor() {

		ArrayList<Venta> venta = new ArrayList<Venta>();
		HashMap<Vendedor, Venta> ventasDeVendedores = new HashMap<Vendedor, Venta>();
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

		try {
			BufferedReader fb = new BufferedReader(new FileReader("ficheros/ventasDeptoAlmacen.txt"));
			String line;
			while ((line = fb.readLine()) != null) {
				String[] split = line.split("%");
				String fechaVentaString = split[0];
				LocalDate fechaVenta = LocalDate.of(Integer.parseInt(fechaVentaString.substring(4, 8)),
						Integer.parseInt(fechaVentaString.substring(2, 4)),
						Integer.parseInt(fechaVentaString.substring(0, 2)));
				String códigoVendedor = split[1];
				Float ganancias = Float.parseFloat(split[2]);
				Vendedor vendedor = new Vendedor(códigoVendedor, ganancias);
				Venta ventaVendedor = new Venta(fechaVenta, ganancias);
				if (ventasDeVendedores.containsKey(vendedor)) {
					vendedor.setGanancias(vendedor.getGanancias() + ganancias);
					venta.add(ventaVendedor);
				} else {
					venta.add(ventaVendedor);
					vendedores.add(vendedor);
				}
				ventasDeVendedores.put(vendedor, ventaVendedor);

				// bufferedReader
			}

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no Encontrado");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return ventasDeVendedores;

	}

	public HashMap<String, Float> devuelveVentas(HashMap<String, ArrayList<Float>> ventas) {
		HashMap<String, Float> Resultado = new HashMap<String, Float>();
		float acumulador = 0;
		
		Set<String> claves = ventas.keySet();
		for (String clave : claves) {
			ArrayList<Float> importe = ventas.get(clave);
			for (float numero : importe) {
				acumulador += numero;
				Resultado.put(clave, acumulador);
			}
		}
		return Resultado;

	}

	public Integer edadMedia() throws NumberFormatException, IOException {

		Integer acumulado = 0;
		int numeroFilas = 0;
		try {
			BufferedReader inFile = new BufferedReader(new FileReader("ficheros/personas.txt"));
			while (inFile.ready()) {
				String texto = inFile.readLine();
				String[] partes = texto.split("-");
				String[] ahora = LocalDate.now().toString().split("-");
				int año = Integer.parseInt(ahora[0]);
				int añoNac = Integer.parseInt(partes[2].substring(4, 8));
				int edad = año - añoNac;
				acumulado += edad;
				numeroFilas = numeroFilas + 1;

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(acumulado / numeroFilas);
		return (acumulado / numeroFilas);

	}

}