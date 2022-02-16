/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.*;
import java.io.*;

/**
 *
 * @author checchia.simone
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    private static int port = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            do {
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = in.readLine();
                if ("fine".equals(message)) {
                    break;
                } else {
                    System.out.println(message.toUpperCase());
                }
            } while (true);
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException ex) {
        }
    }

}
