import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] agrs) throws IOException {
    String localhost = "netology.homework";
    int port = 8080;
    try (Socket clientSocket = new Socket(localhost, port);
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
    /*out.println("GET / HTTP/1.1\n"+
            "Host: localhost\n"+
            "Port: 8080\n");*/
      System.out.println(in.readLine());
      out.println("Petya");
      System.out.println(in.readLine());
      out.println("no");
      System.out.println(in.readLine());
    }
  }
}
