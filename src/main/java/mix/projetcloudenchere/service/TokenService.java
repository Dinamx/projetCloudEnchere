package mix.projetcloudenchere.service;


import mix.projetcloudenchere.model.Admin;
import mix.projetcloudenchere.model.Tokenadmin;

import java.security.MessageDigest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Formatter;

public class TokenService {
    private static String encrypt1(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public String encryptage(String st) throws Exception {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(st.getBytes("UTF-8"));
        return encrypt1(crypt.digest());
    }
    public String generateToken(String mess) throws Exception
    {
        String token = "";
        Date timest = Date.valueOf(LocalDate.now());
        String timestamp = String.valueOf(timest);
        String plus = "aeroflow";
        token = encryptage(timestamp + plus + mess);
        return token;

    }
    public Tokenadmin createToken(Admin admin) throws Exception {
        System.out.println("admin id " + admin.getId());
        int idadmin = Integer.valueOf(admin.getId());
        String token = generateToken(String.valueOf(admin.getId()));
        LocalDate creation = LocalDate.now();
        System.out.println("creation = " + creation);

        LocalDate expiration = LocalDate.now().plusDays(1);
        System.out.println("creation = " + expiration);


        return new Tokenadmin(admin,token,creation,expiration);
    }

    public Tokenadmin updateToken(Tokenadmin tokenadmin) throws Exception {
        LocalDate creation = LocalDate.now();
        System.out.println("creation = " + creation);

        LocalDate expiration = LocalDate.now().plusDays(1);
        System.out.println("creation = " + expiration);
        return new Tokenadmin(tokenadmin.getIdadmin(),tokenadmin.getToken(),creation,expiration);
    }
}
