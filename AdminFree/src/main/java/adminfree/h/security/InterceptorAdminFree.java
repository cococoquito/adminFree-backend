package adminfree.h.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor que aplica para las peticiones http de toda la aplicacion excepto
 * el paquete de autenticacion
 * 
 * @author Carlos Andres Diaz
 *
 */
@Component
public class InterceptorAdminFree implements HandlerInterceptor {

	/**
	 * Metodo que se ejecuta antes de procesar la peticion HTTP de cualquier modulo
	 * excepto seguridad
	 * 
	 * @return true si la peticion es valida, de lo contrario false
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("InterceptorAdminFree fue invocado");
		return true;
	}
}
