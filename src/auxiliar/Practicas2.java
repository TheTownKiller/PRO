package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Practicas2 {
	int conteo = 0;

	public ArrayList<String> AsignaProvinciasALista(String url, int identificador){
		ArrayList<String>resultado = new ArrayList<String>();
		
		try {
			BufferedReader inFile = new BufferedReader(new FileReader(url));
			while (inFile.ready()) {
				String texto = inFile.readLine();
				String[] partes = texto.split("%");
				String provincia = partes[1];
				int id = Integer.parseInt(partes[2]);
				int habitantes = Integer.parseInt(partes[3]);
				if(id == identificador) {
					resultado.add(provincia);
					conteo += habitantes;
					
				}
			}inFile.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	public ArrayList<String> AsignaComunidadesALista(String url){
		ArrayList<String>comunidades = new ArrayList<String>();
		try {
			BufferedReader inFile = new BufferedReader(new FileReader(url));
			while (inFile.ready()) {
				String texto = inFile.readLine();
				String[] partes = texto.split("%");
				String comunidads = partes[1];
				comunidades.add(comunidads);
			}inFile.close();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comunidades;
	}
	
	public HashMap<String, ArrayList<String>> Asignador(){
		HashMap<String, ArrayList<String>>resultante = new HashMap<String, ArrayList<String>>();
		ArrayList<String> comunidades =AsignaComunidadesALista("ficheros/comunidades.txt");
		for(int i = 0; i<comunidades.size();i++) {
			resultante.put(comunidades.get(i),  AsignaProvinciasALista("ficheros/provincias.txt", i+1));
			System.out.println(comunidades.get(i) + " " +  AsignaProvinciasALista("ficheros/provincias.txt", i+1) + " " + (conteo/2));
			conteo = 0;
		}
		return resultante;
		
	}
}
