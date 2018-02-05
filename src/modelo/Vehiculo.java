package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Vehiculo {

	private int id;
	private String matricula;
	private String marcaModelo;
	private LocalDate fechaMatricula;
	private Float precio;
	
	public Vehiculo(int id, String matricula, String marcaModelo, LocalDate fechaMatricula, Float precio) {
		this.id = id;
		this.matricula = matricula;
		this.marcaModelo = marcaModelo;
		this.fechaMatricula = fechaMatricula;
		this.precio = precio;
	}
	
	public Vehiculo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	public ArrayList<Vehiculo> ficheroVehiculo() {

		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		try {
			BufferedReader fb = new BufferedReader(new FileReader("ficheros/vehiculos.txt"));
			String line;
			while ((line = fb.readLine()) != null) {
				String[] split = line.split("-");
				int id = Integer.parseInt(split[0]);
				String Matrícula = split[1];
				String marcaModelo = split[2];
				String fechaMatriculaString = split[3];
				LocalDate fechaMatricula = LocalDate.of(Integer.parseInt(fechaMatriculaString.substring(4, 8)),
						Integer.parseInt(fechaMatriculaString.substring(2, 4)),
						Integer.parseInt(fechaMatriculaString.substring(0, 2)));
				Float precio = Float.parseFloat(split[4]);
				Vehiculo vehiculo = new Vehiculo(id, Matrícula, marcaModelo, fechaMatricula, precio);
					lista.add(vehiculo);
					System.out.println(id + " " + Matrícula + " " +  marcaModelo + " " +  fechaMatricula + " " +  precio);
				}
			fb.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no Encontrado");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return lista;

	}
}
