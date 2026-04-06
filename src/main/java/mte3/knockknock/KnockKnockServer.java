// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockServer.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockServer {
    public static int PORT = 54322;

    public static void receiveAndSend(Scanner scanner,String message,PrintWriter writer,boolean concat) throws IOException {
        ServerSocket server = new ServerSocket(8081);
        Socket client = server.accept();

        scanner = new Scanner(client.getInputStream());
        message = scanner.nextLine();
        System.out.println(message);

        PrintWriter out = new PrintWriter(client.getOutputStream());
        out.println(message);
        out.flush();

        scanner.close();
        server.close();
        client.close();


    } // receiveAndSend() method closed
    
    public static void main(String args[]) throws IOException {
        KnockKnockServer kks = new KnockKnockServer();
        Scanner scanner = new Scanner();
        PrintWriter pw = new PrintWriter();
        kks.receiveAndSend(scanner, "hello", pw, true);
    
    } // main() method closed
}