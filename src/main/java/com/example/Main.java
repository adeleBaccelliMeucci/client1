package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaInviata = "sdkfahfkg";
        out.writeBytes(stringaInviata + "\n"); //manda

        String stringaModificata = in.readLine(); //legge
        System.out.println("stringa modificata: " + stringaModificata);

        s.close();
    }
}