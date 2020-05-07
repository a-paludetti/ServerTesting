package SingleServerExample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectToServer {
    public static void connectToServer() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket connectionSocket = serverSocket.accept();

            InputStream inputStream = connectionSocket.getInputStream();
            OutputStream outputStream = connectionSocket.getOutputStream();

            Scanner scanner = new Scanner(inputStream, "UTF-8");
            PrintWriter serverPrint = new PrintWriter(
                    new OutputStreamWriter(outputStream, "UTF-8"), true);

            serverPrint.println("Exit to exit.");

            boolean done = false;
            while (!done && scanner.hasNextLine()) {
                String line = scanner.nextLine();
                serverPrint.println("repeating: " + line);
                if (line.toLowerCase().trim().equals("exit")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}