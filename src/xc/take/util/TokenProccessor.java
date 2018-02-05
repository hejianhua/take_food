package xc.take.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenProccessor {
	
	//单例设计模式,保证类的对象在内存中只有一个
	private TokenProccessor(){
		
	}
	private static final TokenProccessor instance= new TokenProccessor();
	
	//返回类的对象
	public static TokenProccessor getInstance(){
			
			return instance;
	}
	
	public String makeToken(){
		
		String token=(System.currentTimeMillis()+ new Random().nextInt(999999999))+"";
		
		
		try {
			MessageDigest  md= MessageDigest.getInstance("md5");
			byte md5 [] = md.digest(token.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5); 
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
