/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author checchia.simone
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String resp = null;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                Socket clientSocket = new Socket("192.168.56.1", 5000);

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                resp = sc.nextLine();
                out.println(resp);
                in.close();
                out.close();
                clientSocket.close();

            } catch (IOException ex) {

            }
        } while (!resp.equals("fine"));
    }

}
