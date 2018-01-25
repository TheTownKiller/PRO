package modelo;

import java.time.LocalDate;

public class Venta {
	private Float importe;
	private LocalDate fechaVenta;

	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public Venta(LocalDate fechaVenta, Float importe) {
		this.fechaVenta = fechaVenta;
		this.importe = importe;
	}

}
