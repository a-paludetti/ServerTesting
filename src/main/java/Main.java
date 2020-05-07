import HTTPWebServer.ExampleServlet;
import HTTPWebServer.Httpserver;
import org.apache.catalina.LifecycleException;

public class Main {
    public static void main(String[] args) {
//        new ConnectToServer().connectToServer();
        try {
            new Httpserver().httpServer();
            new ExampleServlet();
        } catch (InterruptedException | LifecycleException e) {
            e.printStackTrace();
        }
    }
}