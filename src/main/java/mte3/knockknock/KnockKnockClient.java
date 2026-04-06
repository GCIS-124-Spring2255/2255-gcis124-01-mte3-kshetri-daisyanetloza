// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 2
// Filename: KnockKnockClient.java (inside knockknock package)

package mte3.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import mte3.knockknock2.Joke;

public class KnockKnockClient {
    public static int PORT = 54322;
    public static String SERVER = "localhost";

    public static void sendAndReceive(PrintWriter writer, String message, Scanner scanner) {
        writer.println(message);
        writer.flush();
        System.out.println("Sent: " + message);

        scanner.nextLine();
        System.out.println("Received: " + message);

    } // sendAndReceive() method closed
    

    public static void joke(String who,String punchLine) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        Socket client = server.accept();

        Scanner scanner = new Scanner(client.getInputStream());
        String message = scanner.nextLine();
        System.out.println(message);

        PrintWriter out = new PrintWriter(client.getOutputStream());
        out.println(message);
        out.flush();

        scanner.close();
        server.close();
        client.close();

    } // joke() method closed

    public static void main(String[] args) throws IOException {

        String[][] jokes = {{"Tank","You're welcome!"},
                            {"Nobel","Nobel...that's why I knocked!"},
                            {"Says","Says me!"},
                            {"Hawaii","I'm good. Hawaii you?"},
                            {"Lettuce","Lettuce in, it's cold out here!"},
                            {"Cow says","No, a cow says moooooo!"},
                            {"Otto","Otto know. I forgot."}
                        };
        int i = new Random().nextInt(jokes.length);
        joke(jokes[i][0],jokes[i][1]);

    } // main() method closed

    // hint: please run KnockKnockServer first and then run KnockKnockClient

} // KnockKnockClient { } class closed