import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient_test
{
    public static void main(String args []) throws Exception    {
        System.out.println("___TCPClient___");
        String sentence;
        String username;
        Scanner joinInput = new Scanner(System.in);

        final String IP_PORT ="127.0.0.1:5656";


        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);


        System.out.println("trying to connect");
        Socket socket = new Socket("127.0.0.1", 5656);
        System.out.println("we are connected");


//        InputStream input = socket.getInputStream();
//        OutputStream output = socket.getOutputStream();
        DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        do  {
            System.out.println("type in your username for this session:");
            username = joinInput.next();
            outToServer.writeBytes("JOIN "+ username + ", 127.0.0.1:5656" + '\n');
            sentence = inFromServer.readLine();
            if (sentence.contains("false"))  {
                System.out.println("Username "+username+" is already in use. Please use a different one.");
                continue;
            }
            break;
        }while (true);

        System.out.println("Connected to server with username "+username);



        while (true)    {
            System.out.print("Please type your text: ");
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            if(sentence.equals("!quit"))    {
                System.out.println("quitting");
                break;
            }
        }

        sentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + sentence);

        socket.close();

    }

}
