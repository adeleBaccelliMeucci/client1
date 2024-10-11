package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaDaInviare;

        boolean exit = false;

        do {
            Scanner scan = new Scanner(System.in); //crela l' input
            System.out.println("inserisci la tua parola: ");  
            String stringaDigitata = scan.nextLine();

            if(stringaDigitata.equals("exit")){
                //out.writeBytes("!" + "\n"); //manda
                //break;
                stringaDaInviare = "!";
                exit = true;
            }else{
                stringaDaInviare = stringaDigitata;
            }

            out.writeBytes(stringaDaInviare + "\n"); //manda

            String stringaModificata = in.readLine(); //legge
            System.out.println("stringa modificata: " + stringaModificata);

        } while (!exit);
        
        //System.out.println("Hai inserito: " + stringaInviata);
        //scan.close();
        

        s.close();
    }
}