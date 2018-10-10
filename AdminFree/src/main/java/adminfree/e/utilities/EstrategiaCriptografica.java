package adminfree.e.utilities;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

/**
 * Clase para generacion de TOKEN del sistema
 * 
 * @author Carlos Andres Diaz
 *
 */
public class EstrategiaCriptografica {

	/** constante que representa la encriptacion por MD5* */
	private static String ENCRIPTACION_MD5 = "MD5";

	/**
	 * Metodo que permite generar un TOKEN
	 */
	public String generarToken() throws Exception {
		return encriptarMD5(generateUUID());
	}

	/**
	 * Metodo que permite la encriptacion una cadena
	 * 
	 * @param entrada, es la cadena a encriptar
	 * @return cadena encriptada por MD5
	 */
	private String encriptarMD5(String entrada) throws Exception {
		MessageDigest md = MessageDigest.getInstance(ENCRIPTACION_MD5);
		byte[] messageDigest = md.digest(entrada.getBytes());
		BigInteger number = new BigInteger(1, messageDigest);
		String hashtext = number.toString(16);
		while (hashtext.length() < 32) {
			hashtext = ConstantNumeros.ZERO.toString() + hashtext;
		}
		return hashtext;
	}

	/**
	 * Metodo que permite generar UUID
	 */
	private String generateUUID() {
		return UUID.randomUUID().toString();
	}
}