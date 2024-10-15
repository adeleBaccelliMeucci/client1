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

        //String stringaDaInviare;
        //String stringScelta;

        boolean exit = false; /*
        false = non esce
        true = vuole uscire */


        do {
            Scanner scan = new Scanner(System.in); //crela l' input

            //System.out.println("inserisci cosa vuoi fare: ");  
            

            System.out.println("# # # digitare # # #");
            System.out.println("'exit' per uscire ");
            System.out.println("1) Trasformare stringa in maiuscolo");
            System.out.println("2) Trasformare stringa in minuscolo");
            System.out.println("3) Ribaltare i caratteri della stringa");
            System.out.println("4) Contare il numero di caratteri");
            System.out.println("# # # # # #");
            System.out.print("scelta: ");
            String stringScelta = scan.nextLine();

            
            if (stringScelta.equals("exit")) {
                exit = true; //esce dal do while
                stringScelta = "!"; //per il server //protocollo

            }

            out.writeBytes(stringScelta + "\n"); //manda operazione

            if (!exit) {
                System.out.println("inserisci la tua parola: ");  
                String stringaDigitata = scan.nextLine(); //PAROLA
                out.writeBytes(stringaDigitata + "\n");
            }
            
            if (!exit) {
                //RISULTATO
                String stringaModificata = in.readLine(); //legge
                System.out.println("stringa modificata: " + stringaModificata);
            }


            /*
            if(stringaDigitata.equals("exit")){
                //out.writeBytes("!" + "\n"); //manda
                //break;
                stringaDaInviare = "!";
                exit = true;
            }else{
                stringaDaInviare = stringaDigitata;
            }*/

            /*
            if(stringScelta.equals("exit")){
                //out.writeBytes("!" + "\n"); //manda
                //break;
                stringScelta = "!";
                exit = true;
            }else{
                //stringaDaInviare = stringaDigitata;
            } */ //non va

            /*
            //out.writeBytes(stringaDaInviare + "\n"); //manda
            out.writeBytes(scan.nextLine() + "\n"); //stringaDaInviare*/ //non va

        } while (!exit);
        
        //System.out.println("Hai inserito: " + stringaInviata);
        //scan.close();
        

        s.close();
    }
}