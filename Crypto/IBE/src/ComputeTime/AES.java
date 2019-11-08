package ComputeTime;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	public static void crypto(int mode, InputStream is, OutputStream os, Element e){
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKey secKey = generateSecretKeyFromElement(e);
			cipher.init(mode, secKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			byte[] block = new byte[8];
			int i;
			while ((i = is.read(block)) != -1) {
				cos.write(block, 0, i);
			}
			cos.close();
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (NoSuchPaddingException e1) {
			e1.printStackTrace();
		} catch (InvalidKeyException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static SecretKey generateSecretKeyFromElement(Element e) {
		//System.out.println("e:" + e);
		byte[] b = e.toBytes();
		b = Arrays.copyOf(b, 16);
		return new SecretKeySpec(b, "AES");
	}
}
/*

byte[] bys=e.toBytes();//通过默认编码转换成数组
FileOutputStream fos = null;
try {
	fos = new FileOutputStream("aes.txt");
} catch (FileNotFoundException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
try {
	fos.write(bys);
	fos.close();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}*/