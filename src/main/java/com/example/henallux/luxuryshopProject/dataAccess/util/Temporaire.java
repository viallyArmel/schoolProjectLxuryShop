package com.example.henallux.luxuryshopProject.dataAccess.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temporaire {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String mdp1 = "Jesuis123";
        String mdpPO = "PO_manil";
        String mdpIdrl = "tego2000!";


        String pwdEncode = bCryptPasswordEncoder.encode("lala12");
        System.out.println(pwdEncode);

    }
}
