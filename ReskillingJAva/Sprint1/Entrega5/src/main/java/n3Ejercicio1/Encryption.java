package n3Ejercicio1;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import auxiliar.Utils;

public class Encryption {
    static String key = "z_nesUfre*e!EyiG5sihacri-it$e-Hl";
    static String salt = "_itHUmA?RlSwo*l4u676Us#TAT=9spEj";
    static Path path = Utils.selectPath("encryptedfiles");
    
    public static void init(String option, String[] args) {
        switch (option) {
            case "-enc" -> initEnc(args);
            case "-dec" -> initDec(args);
        }
    }
    
    private static void initEnc(String[] args) {
        File file=null;
        if (args.length < 1) {
            Path p = Utils.inputPath("");
            if (Files.exists(p)) file = Utils.inputFile(p, "");
        } else {
            file = new File(Utils.argsToString(args));
        }
        if (file!=null&&file.exists()) {
            encrypt(file);
        } else {
            System.out.println("File not found.");
        }
    }
    
    private static void initDec(String[] args) {
        
        File file;
        if (args.length < 1) {
            file = Utils.inputFile(path, "");
        } else {
            file = new File(path + "/" + Utils.argsToString(args));
        }
        if (file.exists()) {
            decrypt(file);
        } else {
            System.out.println("File not found.");
        }
        
    }
    
    private static SecretKeySpec createKey() {
        SecretKeyFactory secretKeyFactory;
        KeySpec keySpec;
        SecretKey secretKeyTemp;
        try {
            secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
            secretKeyTemp = secretKeyFactory.generateSecret(keySpec);
            return new SecretKeySpec(secretKeyTemp.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    private static void encrypt(File file) {
        byte[] iv = new byte[16];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKeySpec = createKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            if (file.exists()) {
                String fileContent = getFileContent(file);
                byte[] chain = fileContent.getBytes(StandardCharsets.UTF_8);
                byte[] encrypted = cipher.doFinal(chain);
                saveFileContent(file, encrypted);
                System.out.println("File Encrypted in encryptedfiles directory");
            } else {
                System.out.println("File not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void decrypt(File file) {
        String result = "";
        byte[] iv = new byte[16];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKeySpec = createKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            if (file.exists()) {
                String fileContent = getFileContent(file);
                byte[] chain = Base64.getDecoder().decode(fileContent);
                byte[] decryption = cipher.doFinal(chain);
                result = new String(decryption);
                System.out.println(result);
            } else {
                System.out.println("File not found.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void saveFileContent(File file, byte[] encriptada) throws IOException {
        File output=new File(path.toString(), "enc"+file.getName());
        FileOutputStream fos = new FileOutputStream(output);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(Base64.getEncoder().encode(encriptada));
        bos.flush();
        bos.close();
    }
    
    private static String getFileContent(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[(int) file.length()];
        bis.read(bytes);
        String fileContent = new String(bytes, StandardCharsets.UTF_8);
        bis.close();
        return fileContent;
    }
}


