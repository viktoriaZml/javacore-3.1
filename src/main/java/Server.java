import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] agrs) throws IOException {

    int port = 8080;
    try (ServerSocket serverSocket = new ServerSocket(port);
         Socket clientSocket = serverSocket.accept();
         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
      System.out.println("New connection accepted");
      //final String name = in.readLine();
      //out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
      out.println("Write your name");
      final String user = in.readLine();
      System.out.println("Username = " + user);
      out.println("Are you child? (yes/no)");
      final String isChild = in.readLine();
      System.out.println("Child = " + isChild);
      if (isChild.equals("yes"))
        out.println(String.format("Welcome to the kids area, %s! Let's play!", user));
      else
        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", user));

    }
  }
}
