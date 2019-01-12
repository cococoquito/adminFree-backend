package adminfree.business;

import java.sql.Connection;
import java.sql.Types;
import java.util.Calendar;
import java.util.List;

import adminfree.constants.CommonConstant;
import adminfree.constants.SQLConfiguraciones;
import adminfree.constants.SQLCorrespondencia;
import adminfree.dtos.configuraciones.ItemDTO;
import adminfree.dtos.correspondencia.CampoEntradaDetalleDTO;
import adminfree.dtos.correspondencia.NomenclaturaDetalleDTO;
import adminfree.enums.TipoCampo;
import adminfree.mappers.MapperConfiguraciones;
import adminfree.mappers.MapperCorrespondencia;
import adminfree.persistence.CommonDAO;
import adminfree.persistence.ValueSQL;

/**
 * Clase que contiene los procesos de negocio para el modulo de Correspondencia
 * 
 * @author Carlos Andres Diaz
 *
 */
public class CorrespondenciaBusiness extends CommonDAO {

	/**
	 * Metodo que permite obtener el detalle de una nomenclatura
	 * 
	 * @param idNomenclatura, identificador de la nomenclatura
	 * @return DTO con los datos de la nomenclatura
	 */
	public NomenclaturaDetalleDTO getDetalleNomenclatura(Long idNomenclatura, Connection connection) throws Exception {
		return (NomenclaturaDetalleDTO) find(connection,
				SQLCorrespondencia.GET_DTL_NOMENCLATURA.replace(
						CommonConstant.INTERROGACION_1,
						Calendar.getInstance().get(Calendar.YEAR) + ""),
				MapperCorrespondencia.get(MapperCorrespondencia.GET_DTL_NOMENCLATURA), 
				ValueSQL.get(idNomenclatura, Types.BIGINT));
	}

	/**
	 * Metodo que permite obtener los campos de la nomenclatura
	 * 
	 * @param idNomenclatura, identificador de la nomenclatura
	 * @return DTO con los campos de la nomenclatura
	 */
	@SuppressWarnings("unchecked")
	public List<CampoEntradaDetalleDTO> getCamposNomenclatura(Long idNomenclatura, Connection connection) throws Exception {

		// se obtiene los campos asociados a la nomenclatura
		List<CampoEntradaDetalleDTO> resultado = (List<CampoEntradaDetalleDTO>)
				find(connection,
						SQLCorrespondencia.GET_DTL_NOMENCLATURA_CAMPOS,
						MapperCorrespondencia.get(MapperCorrespondencia.GET_DTL_NOMENCLATURA_CAMPOS),
						ValueSQL.get(idNomenclatura, Types.BIGINT));

		// se recorre todos los campos en busqueda de los select-items
		if (resultado != null && !resultado.isEmpty()) {
			for (CampoEntradaDetalleDTO campo : resultado) {

				// se consulta los items para esta lista desplegable
				if (TipoCampo.LISTA_DESPLEGABLE.id.equals(campo.getTipoCampo())) {
					campo.setItems((List<ItemDTO>)
							find(connection,
									SQLConfiguraciones.GET_ITEMS,
									MapperConfiguraciones.get(MapperConfiguraciones.GET_ITEMS),
									ValueSQL.get(campo.getId(), Types.BIGINT)));
				}
			}
		}
		return resultado;
	}
}