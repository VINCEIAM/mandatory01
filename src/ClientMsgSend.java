import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.server.ExportException;
import java.util.Scanner;

public class ClientMsgSend  implements Runnable {
        Scanner scn = new Scanner(System.in);
        String name;
        InputStream input;
        OutputStream output;
        Socket socket;



        public ClientMsgSend (Socket socket, String name, InputStream input,
                              OutputStream output) {
            this.input = input;
            this.output = output;
            this.name = name;
            this.socket = socket;
        }


        @Override
        public void run() {
            String messageIN;


            while (true){
                try {
                    System.out.println("Reading username...");
                    byte[] dataIn = new byte[1024];
                    input.read(dataIn);
                    String msgIn = new String(dataIn);

                    System.out.println(msgIn);
                    String username_temp =  msgIn.substring(5);
                    System.out.println(username_temp);
                    int ipIndex = username_temp.indexOf(",");
                    username_temp = username_temp.substring(0,ipIndex);
                    System.out.println("\n"+username_temp);

                    if (users.contains(username_temp)) {
                        usernameAccept = true;
                        outToClient.writeBytes(usernameAccept+"\n");
                        System.out.println("username accepted. Connecting user...");
                        users.add(username_temp);
                        break;
                    }
                    outToClient.writeBytes(usernameAccept+"\n");
                    System.out.println("username in use...\n" +
                            "requesting new username...");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }



            while(true) {
                try {
                    byte[] dataIn = new byte[1024];
                    input.read(dataIn);
                    String msgIn = new String(dataIn);
                    msgIn = msgIn.trim();

                    if (msgIn.equals("QUIT"))    {
                        break;
                    }
                } catch (Exception e)  {
                    e.printStackTrace();
                }
            }
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
