# Chat-Application
The chat application support private messages among users. Take inputs from a standard stream (stdin). The first line of the input should contain handles of the users separated by spaces. The next lines can have either of the following two formats:

User1 User2: <message text>    // User1 sends the <message text> to User2

User2                          // Print the chat history of User2

##Input

Input:

Ed Edd Eddy

Eddy Ed: Oh Lumpenstein!

Eddy Ed: You'll never believe what I got!

Edd Eddy: Hey! See?

Eddy

##Output

Eddy’s sent messages:-

Ed: Oh Lumpenstein!

Ed: You’ll never believe what I got!

---

Eddy’s received messages:-

Edd: Hey! See?
