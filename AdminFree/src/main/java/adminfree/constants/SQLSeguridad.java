package adminfree.constants;

/**
 * 
 * Clase constante que contiene los DML Y DDL para el modulo de seguridad
 * 
 * @author Carlos Andres Diaz
 *
 */
public class SQLSeguridad {

	/** SQL para obtener los datos del USUARIO cuando inicia sesion */
	public static final String INICIAR_SESION_USER = "SELECT US.ID_USUARIO AS ID_USUARIO, US.NOMBRE AS NOMBRE_USUARIO, CL.ID_CLIENTE AS ID_CLIENTE, CL.NOMBRE AS NOMBRE_CLIENTE, USER_MODULO.TOKEN_MODULO AS TOKEN_MODULO FROM USUARIOS US JOIN CLIENTES CL ON(CL.ID_CLIENTE = US.CLIENTE) JOIN USUARIOS_MODULOS USER_MODULO ON(USER_MODULO.ID_USUARIO = US.ID_USUARIO) WHERE US.USUARIO_INGRESO = ? AND US.CLAVE_INGRESO = ? AND US.ESTADO = ? AND CL.ESTADO = ? ORDER BY USER_MODULO.TOKEN_MODULO";
	
	/** SQL para obtener los datos del ADMINISTRADOR cuando inicia sesion */
	public static final String INICIAR_SESION_ADMIN = "SELECT CL.ID_CLIENTE, CL.NOMBRE FROM CLIENTES CL WHERE CL.TOKEN = ? AND CL.USUARIO = ? AND CL.ESTADO = ?";
}
