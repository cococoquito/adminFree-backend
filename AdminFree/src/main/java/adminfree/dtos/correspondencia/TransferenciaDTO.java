package adminfree.dtos.correspondencia;

import java.io.Serializable;

/**
 * DTO que contiene los atributos de una transferencia
 * de un consecutivo para otro usuario
 *
 * @author Carlos Andres Diaz
 */
public class TransferenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** Es el consecutivo en la cual se hizo la transferencia */
	private String consecutivo;

	/** Nomenclatura asociada al consecutivo */
	private String nomenclatura;

	/** Es el nombre del usuario quien era o es duenio del consecutivo */
	private String usuario;

	/** Es la fecha que se hizo la transferencia */
	private String fechaTransferido;

	/**
	 * Metodo que permite obtener el valor del atributo consecutivo
	 */
	public String getConsecutivo() {
		return consecutivo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nomenclatura
	 */
	public String getNomenclatura() {
		return nomenclatura;
	}

	/**
	 * Metodo que permite obtener el valor del atributo usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Metodo que permite obtener el valor del atributo fechaTransferido
	 */
	public String getFechaTransferido() {
		return fechaTransferido;
	}

	/**
	 * Metodo que permite configurar el nuevo valor 
	 * para el atributo @param consecutivo
	 */
	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	/**
	 * Metodo que permite configurar el nuevo valor 
	 * para el atributo @param nomenclatura
	 */
	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	/**
	 * Metodo que permite configurar el nuevo valor 
	 * para el atributo @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que permite configurar el nuevo valor 
	 * para el atributo @param fechaTransferido
	 */
	public void setFechaTransferido(String fechaTransferido) {
		this.fechaTransferido = fechaTransferido;
	}
}
