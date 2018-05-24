
package com.company;

import java.io.*;
import java.net.*;

public class Client {
        public static void main(String[] args) throws IOException {
            String sentence;
            String modifiedSentence;
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            Socket clientSocket = new Socket("localhost", 8080);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            sentence = userInput.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println(modifiedSentence);
            clientSocket.close();
        }
}
