import java.util.*;

class ChatApplication {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);              // Replace with file to take inputs from a file.
	String []userAlias = s.nextLine().split(" ");    // Take user aliases logged into the chatroom
        ChatRoom cr = new ChatRoom(userAlias);
        while(s.hasNext()) {
            String what = s.next();
            if (what.equals("Q")) {                     // Print user's sent/received messages
                String user = s.next();
                User queryUser = cr.getUserReference(user);
                System.out.println(user+"'s sent messages:");
                queryUser.printSentMessages();
                System.out.println(user+"'s received messages:");
                queryUser.printReceivedMessages();
                System.out.println();
            }
            else if (what.equals("C")) {              // A user is sending a message to another user
                String from = s.next();
                String to = s.next().split(":")[0];
                String message = s.nextLine();
                User fromUser = cr.getUserReference(from);
                User toUser = cr.getUserReference(to);
                fromUser.writeMessage(message, toUser);
            }
        }
    }
}
