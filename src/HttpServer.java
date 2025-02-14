import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class HttpServer {
    public static void main(String[] args) {
        // hello 
        int port = 8080; // Server Port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started at http://localhost:" + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                OutputStream out = clientSocket.getOutputStream()) {

            String requestLine = in.readLine();
            System.out.println("Received: " + requestLine);

            if (requestLine == null)
                return;

            // Serve index.html instead of hardcoded response
            File file = new File("public/index.html");
            if (file.exists()) {
                sendResponse(out, file);
            } else {
                send404Response(out);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(OutputStream out, File file) throws IOException {
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Connection: close\r\n\r\n";
        out.write(response.getBytes());
        out.write(fileBytes);
        out.flush();
    }

    private static void send404Response(OutputStream out) throws IOException {
        String response = "HTTP/1.1 404 Not Found\r\n" +
                "Content-Type: text/html\r\n" +
                "Connection: close\r\n\r\n" +
                "<h1>404 - Page Not Found</h1>";
        out.write(response.getBytes());
        out.flush();
    }
}
