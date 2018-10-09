package adminfree.g.persistence;

import java.sql.ResultSet;

import adminfree.e.utilities.ConstantNumeros;

/**
 * 
 * Clase que contiene los metodos MAPPER para las consultas JDBC
 * 
 * @author Carlos Andres Diaz
 *
 */
public class MapperJDBC {

	/** Constantes para los identificadores de los MAPPERS */
	public static final int MAPPER_GET_CLIENTES = 1;
	public static final int MAPPER_COUNT = 2;

	/** Es el tipo de MAPPER a ejecutar */
	private Integer tipoMapper;

	/**
	 * Constructor del Mapper donde recibe el tipo de mapper a ejecutar
	 */
	public MapperJDBC(Integer tipoMapper) {
		this.tipoMapper = tipoMapper;
	}

	/**
	 * Metodo que es ejecutado para MAPPER los datos de acuerdo a un ResultSet
	 * 
	 * @param res, resultado de acuerdo a la consulta
	 * @return objecto con sus datos configurado de acuerdo al Mapper
	 */
	public Object execute(ResultSet res) throws Exception {
		// encapsula el resultado con sus atributo configurados
		Object result = null;
		
		// se ejecuta el metodo de acuerdo al tipo de MAPPER
		switch (this.tipoMapper) {
			case MAPPER_GET_CLIENTES:
				result = getClientes(res);
				break;
	
			case MAPPER_COUNT:
				result = getCount(res);
				break;
		}
		return result;
	}

	/**
	 * Mapper para configurar los atributos de los clientes
	 */
	private Object getClientes(ResultSet res) throws Exception {
		return null;
	}

	/**
	 * Mapper para configurar el COUNT de un SELECT
	 */	
	private Object getCount(ResultSet res) throws Exception {
		if (res.next()) {
            return res.getLong(ConstantNumeros.UNO);
        }
		return ConstantNumeros.ZERO.longValue();
	}
}
