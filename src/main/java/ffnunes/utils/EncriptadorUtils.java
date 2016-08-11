package ffnunes.utils;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public final class EncriptadorUtils {

	private static final String MD5 = "MD5";
	private static final String SHA_1 = "SHA-1";

	private EncriptadorUtils() {
	}

	public static String encriptarMD5(String senha) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(MD5);
		passwordEncryptor.setPlainDigest(true);
		return passwordEncryptor.encryptPassword(senha);
	}

	public static boolean checkPasswordMD5(String plainPass, String encryptPass) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(MD5);
		passwordEncryptor.setPlainDigest(true);
		return passwordEncryptor.checkPassword(plainPass, encryptPass);
	}

	public static String encriptarSHA_1(String senha) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(SHA_1);
		passwordEncryptor.setPlainDigest(true);
		return passwordEncryptor.encryptPassword(senha);
	}

	public static boolean checkPasswordSHA_1(String plainPass, String encryptPass) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm(SHA_1);
		passwordEncryptor.setPlainDigest(true);
		return passwordEncryptor.checkPassword(plainPass, encryptPass);
	}
}
