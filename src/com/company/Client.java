
package com.company;

import java.io.*;
import java.net.*;

public class Client {
        public static void main(String[] args) throws IOException {
            String sentence ;
            String modifiedSentence;
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));


            while(true){
                Socket clientSocket = new Socket("localhost", 8080);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                sentence = userInput.readLine();
                if(sentence.equalsIgnoreCase("end")){
                    System.out.println("Thank you for using this amazing program");
                    clientSocket.close();
                    break;
                }

                outToServer.writeBytes(sentence + '\n');
                modifiedSentence = inFromServer.readLine();
                System.out.println(modifiedSentence);

            }


        }
}
