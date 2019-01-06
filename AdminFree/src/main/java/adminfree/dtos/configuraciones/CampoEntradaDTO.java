package adminfree.dtos.configuraciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO que contiene los atributos para los campos de entrada de informacion
 * 
 * @author Carlos Andres Diaz
 *
 */
public class CampoEntradaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/** Es el identificador del campo de entrada */
	private Long id;

	/** Nombre del campo de entrada */
	private String nombre;

	/** Descripcion del campo de entrada */
	private String descripcion;

	/** Identifica el tipo de campo (input,list,check,date) */
	private Integer tipoCampo;

	/** Nombre del tipo de campo */
	private String tipoCampoNombre;

	/** Los campos de ingreso estan asociados a un cliente */
	private Long idCliente;

	/** Son las restricciones que contiene este campo */
	private List<RestriccionDTO> restricciones;

	/** Son los items para este campo, solo aplica para lista desplegable */
	private List<ItemDTO> items;

	/** indica si se debe consultar las restricciones */
	private boolean consultarRestricciones;

	/** Se utiliza al momento de crear la nomenclatura */
	private boolean aplica;

	/** Cuando nomenclatura tiene asociada consecutivos el campo no puede editar */
	private boolean soloLectura;

	/**
	 * Metodo que permite agregar una restriccion para este campo
	 */
	public void agregarRestriccion(RestriccionDTO restriccion) {
		if (this.restricciones == null) {
			this.restricciones = new ArrayList<>();
		}
		this.restricciones.add(restriccion);
	}

	/**
	 * Metodo que permite agregar un item para este campo
	 */
	public void agregarItem(ItemDTO item) {
		if (this.items == null) {
			this.items = new ArrayList<>();
		}
		this.items.add(item);
	}

	/**
	 * Metodo que permite obtener el valor del atributo id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo que permite obtener el valor del atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param
	 * descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tipoCampo
	 */
	public Integer getTipoCampo() {
		return tipoCampo;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param
	 * tipoCampo
	 */
	public void setTipoCampo(Integer tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	/**
	 * Metodo que permite obtener el valor del atributo tipoCampoNombre
	 */
	public String getTipoCampoNombre() {
		return tipoCampoNombre;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param
	 * tipoCampoNombre
	 */
	public void setTipoCampoNombre(String tipoCampoNombre) {
		this.tipoCampoNombre = tipoCampoNombre;
	}

	/**
	 * Metodo que permite obtener el valor del atributo idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param
	 * idCliente
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Metodo que permite obtener el valor del atributo restricciones
	 */
	public List<RestriccionDTO> getRestricciones() {
		return restricciones;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param
	 * restricciones
	 */
	public void setRestricciones(List<RestriccionDTO> restricciones) {
		this.restricciones = restricciones;
	}

	/**
	 * Metodo que permite obtener el valor del atributo items
	 */
	public List<ItemDTO> getItems() {
		return items;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param items
	 */
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	/**
	 * Metodo que permite obtener el valor del atributo consultarRestricciones
	 */
	public boolean isConsultarRestricciones() {
		return consultarRestricciones;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param
	 * consultarRestricciones
	 */
	public void setConsultarRestricciones(boolean consultarRestricciones) {
		this.consultarRestricciones = consultarRestricciones;
	}

	/**
	 * Metodo que permite obtener el valor del atributo aplica
	 */
	public boolean isAplica() {
		return aplica;
	}

	/**
	 * Metodo que permite configurar el nuevo valor para el atributo @param aplica
	 */
	public void setAplica(boolean aplica) {
		this.aplica = aplica;
	}

	/**
	 * Metodo que permite obtener el valor del atributo soloLectura
	 */
	public boolean isSoloLectura() {
		return soloLectura;
	}

	/**
	 * Metodo que permite configurar el nuevo valor 
	 * para el atributo @param soloLectura
	 */
	public void setSoloLectura(boolean soloLectura) {
		this.soloLectura = soloLectura;
	}
}
