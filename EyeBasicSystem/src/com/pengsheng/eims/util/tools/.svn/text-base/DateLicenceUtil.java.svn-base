package com.pengsheng.eims.util.tools;

import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DateLicenceUtil {
	
	private static final String PASSWORD_CRYPT_KEY = "%^&*RG*D";
	private final static String DES = "DES";

	/**
	 * 加密
	 */
	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {	
		SecureRandom sr = new SecureRandom();	
		DESKeySpec dks = new DESKeySpec(key);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		
		Cipher cipher = Cipher.getInstance(DES);	
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 */
	public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
	
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(key);
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		 
		Cipher cipher = Cipher.getInstance(DES);
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		
		return cipher.doFinal(src);
	}

	public final static String decrypt(String data) {
		try {
			return new String(decrypt(hex2byte(data.getBytes()),PASSWORD_CRYPT_KEY.getBytes()));
		} catch (Exception e) {
		}
		return null;
	}

	public final static String encrypt(String password) {
		try {
			return byte2hex(encrypt(password.getBytes(), PASSWORD_CRYPT_KEY.getBytes()));
		} catch (Exception e) {
		}
		return null;
	}

	private static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
		    stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			}
		return hs.toUpperCase();
	}
	
	private static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
			byte[] b2 = new byte[b.length / 2];
			for (int n = 0; n < b.length; n += 2) {
				String item = new String(b, n, 2);
				b2[n / 2] = (byte) Integer.parseInt(item, 16);
			}
		return b2;
	}
	
	public static void main(String[] args) {
		System.out.println("md5加密后的字符串是 "	+ new DateLicenceUtil().encrypt("2013-07-12"));
		System.out.println("md5解密后的字符串是 "	+ new DateLicenceUtil().decrypt("3002C0F2596A66D4266D7EECCBE71D5A"));
	}
}
