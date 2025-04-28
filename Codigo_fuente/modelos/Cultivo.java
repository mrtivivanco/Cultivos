package modelos;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cultivo {
	private String nombre;
	private String variedad;
	private float superficie;
	private Date fechaSiembra;
	private Estado estado;
	private List<Actividad> listaActividades;
	private Parcela parcela;
	
	public Cultivo() {
	}

	public Cultivo(String nombre, String variedad, float superficie, Date fechaSiembra, Estado estado,
			List<Actividad> listaActividades, Parcela parcela) {
		super();
		this.nombre = nombre;
		this.variedad = variedad;
		this.superficie = superficie;
		this.fechaSiembra = fechaSiembra;
		this.estado = estado;
		this.listaActividades = listaActividades;
		this.parcela = parcela;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getVariedad() {
		return variedad;
	}

	public void setVariedad(String variedad) {
		this.variedad = variedad;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	public Date getFechaSiembra() {
		return fechaSiembra;
	}

	public void setFechaSiembra(Date fechaSiembra) {
		this.fechaSiembra = fechaSiembra;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Actividad> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, fechaSiembra, listaActividades, nombre, superficie, variedad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cultivo other = (Cultivo) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(fechaSiembra, other.fechaSiembra)
				&& Objects.equals(listaActividades, other.listaActividades) && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(superficie) == Float.floatToIntBits(other.superficie)
				&& Objects.equals(variedad, other.variedad);
	}

	@Override
	public String toString() {
		return "Cultivo [nombre=" + nombre + ", variedad=" + variedad + ", superficie=" + superficie + ", fechaSiembra="
				+ fechaSiembra + ", estado=" + estado + ", listaActividades=" + listaActividades + "]";
	}

}
