package adminfree.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase constante que contiene los DML Y DDL para el modulo de Archivo de Gestion
 *
 * @author Carlos Andres Diaz
 */
public class SQLArchivoGestion {

	/** SQL para obtener los tipos documentales parametrizados en el sistema*/
	public static final String GET_TIPOS_DOCUMENTALES = "SELECT ID_TIPO_DOC,NOMBRE FROM TIPOS_DOCUMENTALES ORDER BY NOMBRE";

	/** SQL para insertar un tipo documental*/
	public static final String INSERT_TIPO_DOCUMENTAL = "INSERT INTO TIPOS_DOCUMENTALES(NOMBRE)VALUES(?)";

	/** SQL para editar un tipo documental*/
	public static final String EDITAR_TIPO_DOCUMENTAL = "UPDATE TIPOS_DOCUMENTALES SET NOMBRE=? WHERE ID_TIPO_DOC=?";

	/** SQL para eliminar un tipo documental*/
	public static final String ELIMINAR_TIPO_DOCUMENTAL = "DELETE FROM TIPOS_DOCUMENTALES WHERE ID_TIPO_DOC=?";

	/** SQL para verificar si un tipo documental especifico tiene relacion con alguna serie documental*/
	public static final String EXISTS_SERIES_TIPO_DOCUMENTAL = "SELECT EXISTS(SELECT * FROM TIPOS_DOCUMENTALES_SERIES WHERE ID_TIPO_DOC=?)";

	/** SQL para verificar si un tipo documental especifico tiene relacion con alguna sub-serie documental*/
	public static final String EXISTS_SUBSERIES_TIPO_DOCUMENTAL = "SELECT EXISTS(SELECT * FROM TIPOS_DOCUMENTALES_SUBSERIES WHERE ID_TIPO_DOC=?)";

	/** SQL para insertar una serie documental*/
	public static final String INSERT_SERIE = "INSERT INTO SERIES_DOCUMENTALES(CLIENTE,CODIGO,NOMBRE,AG,AC,CT,M,S,E,PROCEDIMIENTO,FECHA_CREACION,USUARIO_CREACION)VALUES(?,?,?,?,?,?,?,?,?,?,CURDATE(),?)";

	/** SQL para editar una serie documental*/
	public static final String EDIT_SERIE = "UPDATE SERIES_DOCUMENTALES SET CODIGO=?,NOMBRE=?,AG=?,AC=?,CT=?,M=?,S=?,E=?,PROCEDIMIENTO=? WHERE ID_SERIE=?";

	/** SQL para obtener la cantidad de consecutivos asociados a una serie documental*/
	public static final String GET_CANT_CONSECUTIVOS_SERIE = "SELECT CANT_CONSECUTIVOS FROM SERIES_DOCUMENTALES WHERE ID_SERIE=?";

	/** SQL para verificar si la serie documental esta asociado en la TRD*/
	public static final String EXISTS_SERIE_TRD = "SELECT EXISTS(SELECT * FROM TRDS WHERE ID_SERIE=?)";

	/** SQL para verificar las sub-series que tiene esta serie*/
	public static final String EXISTS_SUBSERIES_SERIE = "SELECT EXISTS(SELECT * FROM SUBSERIES_DOCUMENTALES WHERE ID_SERIE=?)";

	/** SQL para insertar una subserie documental*/
	public static final String INSERT_SUBSERIE = "INSERT INTO SUBSERIES_DOCUMENTALES(ID_SERIE,CODIGO,NOMBRE,AG,AC,CT,M,S,E,PROCEDIMIENTO,FECHA_CREACION,USUARIO_CREACION)VALUES(?,?,?,?,?,?,?,?,?,?,CURDATE(),?)";

	/** SQL para editar una subserie documental*/
	public static final String EDIT_SUBSERIE = "UPDATE SUBSERIES_DOCUMENTALES SET ID_SERIE=?,CODIGO=?,NOMBRE=?,AG=?,AC=?,CT=?,M=?,S=?,E=?,PROCEDIMIENTO=? WHERE ID_SUBSERIE=?";

	/** SQL para obtener la cantidad de consecutivos asociados a una sub-serie documental*/
	public static final String GET_CANT_CONSECUTIVOS_SUBSERIE = "SELECT CANT_CONSECUTIVOS FROM SUBSERIES_DOCUMENTALES WHERE ID_SUBSERIE=?";

	/** SQL para verificar si la sub-serie documental esta asociado en la TRD*/
	public static final String EXISTS_SUBSERIE_TRD = "SELECT EXISTS(SELECT * FROM TRDS WHERE ID_SUBSERIE=?)";

	/**
	 * SQL para obtener las subseries que le pertenece a cada serie documental
	 */
	public static String getSQLSubseries(StringBuilder idsSerie) {
		StringBuilder sql = new StringBuilder("SELECT ID_SUBSERIE,ID_SERIE,CODIGO,LOWER(NOMBRE),AG,AC,CT,M,S,E,PROCEDIMIENTO FROM SUBSERIES_DOCUMENTALES WHERE ID_SERIE IN(");
		sql.append(idsSerie).append(")ORDER BY ID_SERIE ASC,NOMBRE ASC");
		return sql.toString();
	}

	/**
	 * SQL para obtener los tipos de documentales que le pertenece a cada serie documental
	 */
	public static String getSQLTiposDocSerie(StringBuilder idsSerie) {
		StringBuilder sql = new StringBuilder("SELECT TS.ID_SERIE,TS.ID_TIPO_DOC,TD.NOMBRE FROM TIPOS_DOCUMENTALES_SERIES TS JOIN TIPOS_DOCUMENTALES TD ON(TD.ID_TIPO_DOC=TS.ID_TIPO_DOC)WHERE TS.ID_SERIE IN(");
		sql.append(idsSerie).append(")ORDER BY TS.ID_SERIE ASC,TD.NOMBRE ASC");
		return sql.toString();
	}

	/**
	 * SQL para obtener los tipos de documentales que le pertenece a cada subserie documental
	 */
	public static String getSQLTiposDocSubSerie(StringBuilder idsSubSerie) {
		StringBuilder sql = new StringBuilder("SELECT TS.ID_SUBSERIE,TS.ID_TIPO_DOC,TD.NOMBRE FROM TIPOS_DOCUMENTALES_SUBSERIES TS JOIN TIPOS_DOCUMENTALES TD ON(TD.ID_TIPO_DOC=TS.ID_TIPO_DOC)WHERE TS.ID_SUBSERIE IN(");
		sql.append(idsSubSerie).append(")ORDER BY TS.ID_SUBSERIE ASC,TD.NOMBRE ASC");
		return sql.toString();
	}

	/**
	 * SQL para validar si existe un nombre de un tipo documental especifico
	 */
	public static String existsNombreTipoDocumental(Integer idTipoDocumental) {
		StringBuilder sql = new StringBuilder("SELECT EXISTS(SELECT * FROM TIPOS_DOCUMENTALES WHERE NOMBRE=?");
		if (idTipoDocumental != null) {
			sql.append(" AND ID_TIPO_DOC<>").append(idTipoDocumental);
		}
		sql.append(")");
		return sql.toString();
	}

	/**
	 * SQL para validar si existe el valor de un campo especifico en la serie documental
	 */
	public static String existsValorSerie(String campo, Integer idCliente, Long idSerie) {
		StringBuilder sql = new StringBuilder("SELECT EXISTS(SELECT * FROM SERIES_DOCUMENTALES WHERE ");
		sql.append(campo).append("=? AND CLIENTE=").append(idCliente);
		if (idSerie != null) {
			sql.append(" AND ID_SERIE<>").append(idSerie);
		}
		sql.append(")");
		return sql.toString();
	}

	/**
	 * SQL para construir el DELETE de una serie documental con sus tablas asociadas
	 */
	public static List<String> deleteSerieDocumental(Long idSerie) {
		List<String> deletes = new ArrayList<>();
		deletes.add("DELETE FROM TIPOS_DOCUMENTALES_SERIES WHERE ID_SERIE="+idSerie);
		deletes.add("DELETE FROM SERIES_DOCUMENTALES WHERE ID_SERIE="+idSerie);
		return deletes;
	}

	/**
	 * SQL para validar si existe el valor de un campo especifico en la sub-serie documental
	 */
	public static String existsValorSubSerie(String campo, Integer idCliente, Long idSubSerie) {
		StringBuilder sql = new StringBuilder("SELECT EXISTS(SELECT * FROM SUBSERIES_DOCUMENTALES SUB JOIN SERIES_DOCUMENTALES SE ON(SE.ID_SERIE=SUB.ID_SERIE)WHERE SUB.");
		sql.append(campo).append("=? AND SE.CLIENTE=").append(idCliente);
		if (idSubSerie != null) {
			sql.append(" AND SUB.ID_SUBSERIE<>").append(idSubSerie);
		}
		sql.append(")");
		return sql.toString();
	}

	/**
	 * SQL para construir el DELETE de una sub-serie documental con sus tablas asociadas
	 */
	public static List<String> deleteSubSerieDocumental(Long idSubSerie) {
		List<String> deletes = new ArrayList<>();
		deletes.add("DELETE FROM TIPOS_DOCUMENTALES_SUBSERIES WHERE ID_SUBSERIE="+idSubSerie);
		deletes.add("DELETE FROM SUBSERIES_DOCUMENTALES WHERE ID_SUBSERIE="+idSubSerie);
		return deletes;
	}
}
