package adminfree.services;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import adminfree.business.ConfiguracionesBusiness;
import adminfree.constants.PropertyKey;
import adminfree.dtos.configuraciones.CambioClaveDTO;
import adminfree.dtos.configuraciones.CampoEntradaDTO;
import adminfree.dtos.configuraciones.ClienteDTO;
import adminfree.dtos.configuraciones.RestriccionDTO;
import adminfree.dtos.seguridad.CredencialesDTO;
import adminfree.dtos.seguridad.UsuarioDTO;
import adminfree.utilities.CerrarRecursos;

/**
 *
 * Clase que contiene todos los servicios para el modulo de Configuraciones
 *
 * @author Carlos Andres Diaz
 *
 */
@Service
public class ConfiguracionesService {

	/** DataSource para las conexiones de la BD de AdminFree */
	@Autowired
	private DataSource adminFreeDS;

	/** Contiene el postPass para la encriptacion de claves */
	@Value(PropertyKey.SECURITY_POST_PASS)
	private String securityPostPass;	

	/**
	 * Servicio que permite crear un cliente en el sistema
	 *
	 * @param cliente, DTO con los datos del cliente a crear
	 * @return el nuevo cliente con el token, id y demas atributos
	 */
	public ClienteDTO crearCliente(ClienteDTO cliente) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a crear el cliente en BD
			return new ConfiguracionesBusiness().crearCliente(cliente, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio para actualizar los datos del CLIENTE
	 *
	 * @param clienteUpdate, datos del cliente ACTUALIZAR
	 */
	public void actualizarCliente(ClienteDTO clienteUpdate) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede actualizar los datos del CLIENTE
			new ConfiguracionesBusiness().actualizarCliente(clienteUpdate, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}
	
	/**
	 * Servicio que permite ACTIVAR un cliente
	 *
	 * @return cliente con los nuevos datos de la ACTIVACION
	 * @param cliente, contiene el identificador del cliente
	 */
	public ClienteDTO activarCliente(ClienteDTO cliente) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede activar el CLIENTE
			return new ConfiguracionesBusiness().activarCliente(cliente, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite INACTIVAR un cliente
	 *
	 * @return cliente con los nuevos datos de la INACTIVACION
	 * @param cliente, contiene el identificador del cliente
	 */
	public ClienteDTO inactivarCliente(ClienteDTO cliente) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede inactivar el CLIENTE
			return new ConfiguracionesBusiness().inactivarCliente(cliente, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite ELIMINAR un cliente del sistema
	 *
	 * @param cliente, DTO que contiene el identificador del cliente ELIMINAR
	 * @return OK, de lo contrario el mensaje de error de MYSQL
	 */
	public String eliminarCliente(ClienteDTO cliente) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede ELIMINAR el CLIENTE
			return new ConfiguracionesBusiness().eliminarCliente(cliente, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite consultar los usuarios con estados (ACTIVO/INACTIVO)
	 * asociados a un cliente especifico
	 *
	 * @param filtro, contiene los datos del filtro de busqueda
	 * @return lista de Usuarios asociados a un cliente
	 */	
	public List<UsuarioDTO> getUsuariosCliente(ClienteDTO filtro) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a consultar los usuarios asociados a un cliente
			return new ConfiguracionesBusiness().getUsuariosCliente(filtro, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite crear el usuario con sus privilegios en el sistema
	 *
	 * @param usuario, DTO que contiene los datos del usuarios
	 * @return DTO con los datos del usuario creado
	 */
	public UsuarioDTO crearUsuario(UsuarioDTO usuario) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a crear el usuario con sus privilegios
			return new ConfiguracionesBusiness().crearUsuario(usuario, this.securityPostPass, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite cambiar el estado de un usuario
	 *
	 * @param usuario, DTO que contiene los datos del usuario a modificar
	 */
	public void modificarEstadoUsuario(UsuarioDTO usuario) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a modificar el estado del usuario
			new ConfiguracionesBusiness().modificarEstadoUsuario(usuario, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite modificar los privilegios de un Usuario
	 *
	 * @param usuario, DTO que contiene el identificador y los privilegios a modificar
	 */
	public void modificarPrivilegiosUsuario(UsuarioDTO usuario) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a modificar los privilegios del usuario
			new ConfiguracionesBusiness().modificarPrivilegiosUsuario(usuario, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite generar una nueva clave de ingreso
	 * para el usuario que llega por parametro
	 *
	 * @param usuario, DTO con el identificador del usuario
	 * @return DTO con la clave de ingreso generada
	 */
	public CredencialesDTO generarClaveIngreso(UsuarioDTO usuario) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a generar una nueva clave de ingreso para el usuario
			return new ConfiguracionesBusiness().generarClaveIngreso(usuario, this.securityPostPass, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite actualizar los datos de la cuenta
	 * del usuario, solamente aplica (Nombre, Usuario Ingreso)
	 *
	 * @param usuario, DTO 	que contiene los datos del usuario
	 */
	public void modificarDatosCuenta(UsuarioDTO usuario) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a modificar los datos de la cuenta user
			new ConfiguracionesBusiness().modificarDatosCuenta(usuario, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite soportar el proceso de modificar la clave de ingreso
	 *
	 * @param datos, DTO que contiene los datos para el proceso de la modificacion
	 */
	public void modificarClaveIngreso(CambioClaveDTO datos) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a modificar la clave de ingreso del usuario
			new ConfiguracionesBusiness().modificarClaveIngreso(datos, this.securityPostPass, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite obtener las restricciones asociados a un tipo de campo
	 *
	 * @param tipoCampo, es el valor del tipo de campo asociado a las restricciones
	 * @return Lista de restricciones parametrizadas en la BD
	 */
	public List<RestriccionDTO> getRestriciones(Integer tipoCampo) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a obtener las restricciones asociada al tipo de campo
			return new ConfiguracionesBusiness().getRestriciones(tipoCampo, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Metodo que permite validar si el campo de entrada existe para el tipo, nombre y cliente
	 *
	 * @param campo, DTO que contiene los datos del nuevo campo de entrada
	 */
	public void validarCampoEntradaExistente(CampoEntradaDTO campo) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a ejecutar la validacion
			new ConfiguracionesBusiness().validarCampoEntradaExistente(campo, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite soportar el proceso de negocio para
	 * la creacion del campo de entrada de informacion
	 *
	 * @param campo, DTO que contiene los datos del nuevo campo de entrada
	 * @return DTO con los datos del nuevo campo de entrada
	 */
	public CampoEntradaDTO crearCampoEntrada(CampoEntradaDTO campo) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a crear el campo de entrada de informacion
			return new ConfiguracionesBusiness().crearCampoEntrada(campo, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}

	/**
	 * Servicio que permite obtener los campos de entrada de informacion asociado a un cliente
	 *
	 * @param idCliente, identificador del cliente que le pertenece los campos de entrada
	 * @return lista DTO con la informacion de los campos de entrada
	 */
	public List<CampoEntradaDTO> getCamposEntrada(Long idCliente) throws Exception {
		Connection connection = null;
		try {
			// se solicita una conexion de la BD de AdminFree
			connection = this.adminFreeDS.getConnection();

			// se procede a consultar los campos de entrada asociado al cliente
			return new ConfiguracionesBusiness().getCamposEntrada(idCliente, connection);
		} finally {
			CerrarRecursos.closeConnection(connection);
		}
	}
}
