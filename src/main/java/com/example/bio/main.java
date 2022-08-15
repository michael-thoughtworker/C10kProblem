package com.example.bio;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class main {

    static  HttpClient client = HttpClient.newHttpClient();
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        int port = 8092;
        final ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("server is listing on " + port);

        while (true) {
            final Socket socket = serverSocket.accept(); // Blocking until someone connects
            handle(socket);
        }
    }

    private static void handle(final Socket socket) throws IOException, InterruptedException, URISyntaxException {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        byte[] buffer = new byte[250];
        inputStream.read(buffer);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.coindesk.com/v1/bpi/currentprice.json"))
                .GET()
                .build();
        String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
         final String TEAPOT_HTTP_RESP_STR =
                "HTTP/1.0 200 OK\r\n" +
                        "Content-Length: "+response.length()+"\r\n" +
                        "Content-Type: application/json\r\n" +
                        "Server: java-nio\r\n\r\n" +
                        response;
        outputStream.write(TEAPOT_HTTP_RESP_STR.getBytes(StandardCharsets.UTF_8));
        outputStream.close();

        inputStream.close();
        socket.close();
    }

}