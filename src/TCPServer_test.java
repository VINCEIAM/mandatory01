import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;




public class TCPServer_test     {
    public static ArrayList<String> users = new ArrayList<>();

    static Vector<ClientMsgSend> Clients = new Vector<>();
    public static void main(String args []) throws Exception    {
        System.out.println("___TCPServer___");
        String sentence;
        String userText;
        String joinCommand;

//
//


//        final ServerSocket serverSocketf = new ServerSocket(5656);
//        Socket serverSocket;
//        while(true) {
//            serverSocket = serverSocketf.accept();
//            System.out.println("New Client Connected");
//
//            InputStream input = serverSocket.getInputStream();
//            OutputStream output = serverSocket.getOutputStream();
//            ClientHandler ch = new ClientHandler(s, "client" + i, input, output);
//
//
//        }

//
//
        int i = 1;
        users.add(i, "vince");
        boolean usernameAccept = false;
        ServerSocket serverSocket = new ServerSocket(5656);
        System.out.println("we have a socket");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("waiting for a connection");
        Socket connectionSocket = serverSocket.accept();
        System.out.println("we have a connection");

        InputStream msgIn = connectionSocket.getInputStream();
        OutputStream msgOut = connectionSocket.getOutputStream();

        while(true) {
            sentence = inFromClient.readLine();
            System.out.println(sentence);
            if (sentence.equals("!quit"))   {
                System.out.println("Quitting!");
                break;
            }
        }
        connectionSocket.close();
        serverSocket.close();
    }
}