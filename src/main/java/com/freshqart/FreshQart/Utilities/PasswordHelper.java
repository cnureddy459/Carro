package com.freshqart.FreshQart.Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/*
 * MD5 hash alone is not a safe way to encrypt the password.
 * We add extra layer of protection by generating a random salt (string)
 * and hash it along with the password.
 * We need to store this salt for each user so that this can used to encrypt the input password
 * to check the valid login.
 */
public class PasswordHelper {

	 public static void main(String[] args) {
		 byte[] salt = getSalt();
		 String saltStr = new String(salt);
		 String saltEncode = Base64.getEncoder().encodeToString(salt);
		 System.out.println(getMD5Hash("password", saltEncode.getBytes()));
		 System.out.println(getMD5("password", saltEncode));
		test(saltEncode);
	 }
	 
	 public static String getMD5(String password, String salt) {
		 return getMD5Hash(password, salt.getBytes());
	 }
	 
	 public static String getMD5Hash(String passwordInput, byte[] salt) {
		 StringBuilder md5Builder = new StringBuilder();
		 try {
			 MessageDigest md5 = MessageDigest.getInstance("MD5");
			 //update salt..
			 md5.update(salt);
			 //Add password bytes to digest
			 //md5.update(passwordInput.getBytes());
			 // get hash bytes
			 byte[] bytes = md5.digest(passwordInput.getBytes());
			 
			 for (int i=0; i < bytes.length; i++) {
				 md5Builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			 }			 
		 } catch (NoSuchAlgorithmException ex) {
			 // do nothing..
		 }
		 return md5Builder.toString();
	 }
	 
	 private static byte[] getSalt() {
	     //Always use a SecureRandom generator
		 byte[] salt = new byte[16];
		 try {
			 SecureRandom sr = new SecureRandom();
			 sr.nextBytes(salt);			 
		 } catch (Exception ex) {
			 // do nothing..
		 }
	     
	     return salt;
	 }
	 
	 private static void test(String s) {
		 System.out.println(s);
		 System.out.println(new String(s.getBytes()));
	 }
}
