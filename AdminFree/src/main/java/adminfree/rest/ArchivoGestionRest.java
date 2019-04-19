package adminfree.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import adminfree.constants.ApiRest;
import adminfree.dtos.archivogestion.SerieDocumentalDTO;
import adminfree.dtos.archivogestion.SubSerieDocumentalDTO;
import adminfree.dtos.archivogestion.TipoDocumentalDTO;
import adminfree.services.ArchivoGestionService;
import adminfree.utilities.BusinessException;
import adminfree.utilities.Util;

/**
 * 
 * Clase que contiene todos los servicios REST para el modulo de Archivo de Gestión
 * localhost:puerto/Constants.ARCHIVO_GESTION_API/
 *
 * @author Carlos Andres Diaz
 *
 */
@RestController
@RequestMapping(ApiRest.ARCHIVO_GESTION_API)
public class ArchivoGestionRest {

	/** Objecto que contiene los servicios relacionados modulo archivo gestion */
	@Autowired
	private ArchivoGestionService archivoGestionService;

	/**
	 * Servicio que permite administrar los tipos documentales
	 *
	 * @param tipo, contiene los datos del tipo documental a procesar
	 * @return Objeto con el resultado solicitado
	 */
	@RequestMapping(
			value = ApiRest.ADMIN_TIPOS_DOCUMENTAL,
			method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
			consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Object> administrarTiposDocumentales(@RequestBody TipoDocumentalDTO tipo) {
		try {
			return Util.getResponseSuccessful(this.archivoGestionService.administrarTiposDocumentales(tipo));
		} catch (BusinessException e) {
			return Util.getResponseBadRequest(e.getMessage());
		} catch (Exception e) {
			return Util.getResponseError(ArchivoGestionRest.class.getSimpleName() + ".administrarTiposDocumentales ", e.getMessage());
		}
	}

	/**
	 * Servicio que permite administrar la entidad de series documentales
	 *
	 * @param serie, DTO con los datos de la serie documental
	 * @return Objeto con el resultado solicitado
	 */
	@RequestMapping(
			value = ApiRest.ADMIN_SERIES,
			method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
			consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Object> administrarSerieDocumental(@RequestBody SerieDocumentalDTO serie) {
		try {
			return Util.getResponseSuccessful(this.archivoGestionService.administrarSerieDocumental(serie));
		} catch (BusinessException e) {
			return Util.getResponseBadRequest(e.getMessage());
		} catch (Exception e) {
			return Util.getResponseError(ArchivoGestionRest.class.getSimpleName() + ".administrarSerieDocumental ", e.getMessage());
		}
	}

	/**
	 * Servicio que permite administrar la entidad de sub-serie documental
	 *
	 * @param subserie, DTO con los datos de la sub-serie documental
	 * @return Objeto con el resultado solicitado
	 */
	@RequestMapping(
			value = ApiRest.ADMIN_SUBSERIES,
			method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE },
			consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<Object> administrarSubSerieDocumental(@RequestBody SubSerieDocumentalDTO subserie) {
		try {
			return Util.getResponseSuccessful(this.archivoGestionService.administrarSubSerieDocumental(subserie));
		} catch (BusinessException e) {
			return Util.getResponseBadRequest(e.getMessage());
		} catch (Exception e) {
			return Util.getResponseError(ArchivoGestionRest.class.getSimpleName() + ".administrarSubSerieDocumental ", e.getMessage());
		}
	}
}
