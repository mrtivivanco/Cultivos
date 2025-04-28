package modelos;

import java.util.Date;
import java.util.Objects;

public class Actividad {
	private String accion;
	private Date fecha;

	public Actividad() {

	}

	public Actividad(String accion, Date fecha) {
		super();
		this.accion = accion;
		this.fecha = fecha;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accion, fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return Objects.equals(accion, other.accion) && Objects.equals(fecha, other.fecha);
	}

	@Override
	public String toString() {
		return "Actividad [accion=" + accion + ", fecha=" + fecha + "]";
	}

}
