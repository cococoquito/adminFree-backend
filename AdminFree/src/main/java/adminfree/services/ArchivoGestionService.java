package adminfree.services;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adminfree.business.ArchivoGestionBusiness;
import adminfree.dtos.archivogestion.SerieDocumentalDTO;
import adminfree.dtos.archivogestion.SubSerieDocumentalDTO;
import adminfree.dtos.archivogestion.TipoDocumentalDTO;
import adminfree.utilities.CerrarRecursos;

/**
 * Clase que contiene todos los servicios para el modulo de Archivo de Gestión
 *
 * @author Carlos Andres Diaz
 *
 */
@Service
public class ArchivoGestionService {

	/** DataSource para las conexiones de la BD de AdminFree */
	@Autowired
	private DataSource adminFreeDS;

	/**
	 * Servicio que permite administrar los tipos documentales
	 *
	 * @param tipo, contiene los datos del tipo documental a procesar
	 * @return Objeto con el resultado solicitado
	 */
	public Object administrarTiposDocumentales(TipoDocumentalDTO tipo) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procesa la solicitud
			return new ArchivoGestionBusiness().administrarTiposDocumentales(tipo, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite administrar la entidad de series documentales
	 *
	 * @param serie, DTO con los datos de la serie documental
	 * @return Objeto con el resultado solicitado
	 */
	public Object administrarSerieDocumental(SerieDocumentalDTO serie) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procesa la solicitud
			return new ArchivoGestionBusiness().administrarSerieDocumental(serie, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite administrar la entidad de sub-serie documental
	 *
	 * @param subserie, DTO con los datos de la sub-serie documental
	 * @return Objeto con el resultado solicitado
	 */
	public Object administrarSubSerieDocumental(SubSerieDocumentalDTO subserie) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procesa la solicitud
			return new ArchivoGestionBusiness().administrarSubSerieDocumental(subserie, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}
}
