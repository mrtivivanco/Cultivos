package modelos;

import java.util.Objects;

public class Parcela {
	private String codigoParcela;

	public Parcela() {
	}

	public Parcela(String codigoParcela) {
		super();
		this.codigoParcela = codigoParcela;
	}

	public String getCodigoParcela() {
		return codigoParcela;
	}

	public void setCodigoParcela(String codigoParcela) {
		this.codigoParcela = codigoParcela;
	}

	public int hashCode() {
		return Objects.hash(codigoParcela);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcela other = (Parcela) obj;
		return Objects.equals(codigoParcela, other.codigoParcela);
	}

	@Override
	public String toString() {
		return "Parcela [codigoParcela=" + codigoParcela + "]";
	}

}
