package modelo;

import java.time.LocalDate;

public class Vendedor extends Persona {

	private String codigoVendedor;
	private float ganancias;
	
	public String getCódigoVendedor() {
		return codigoVendedor;
	}

	public void setCódigoVendedor(String códigoVendedor) {
		this.codigoVendedor = códigoVendedor;
	}

	public float getGanancias() {
		return ganancias;
	}

	public void setGanancias(float ganancias) {
		this.ganancias = ganancias;
	}

	public Vendedor(String codigoVendedor, float ganancias) {
		this.codigoVendedor = codigoVendedor;
		this.ganancias = ganancias;
	}
}
