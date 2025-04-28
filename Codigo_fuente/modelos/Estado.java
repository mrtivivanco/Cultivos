package modelos;

import java.util.Objects;

public class Estado {
	private String estado;
	
	public Estado() {
	}

	public Estado(String estado) {
		super();
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(estado, other.estado);
	}

	@Override
	public String toString() {
		return "Estado [estado=" + estado + "]";
	}
	
	
	
}
