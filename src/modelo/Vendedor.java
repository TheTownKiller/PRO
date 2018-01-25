package modelo;

import java.time.LocalDate;

public class Vendedor extends Persona {

	private String codigoVendedor;
	private float ganancias;
	
	public String getC�digoVendedor() {
		return codigoVendedor;
	}

	public void setC�digoVendedor(String c�digoVendedor) {
		this.codigoVendedor = c�digoVendedor;
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
