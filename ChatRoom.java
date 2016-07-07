/**
 * The chatroom maintains the users logged into it.
 */
class ChatRoom {
    User users[];

    public ChatRoom(String[] userAlias) {
        users = new User[userAlias.length];
        for (int i = 0; i < userAlias.length; i++)
            this.users[i] = new User(userAlias[i], this);
    }
   
    public void transferMessage(String message, User to) {
        to.receiveMessage(message);
    }

    public User getUserReference(String alias) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getAlias().equals(alias)) {
                return users[i];
            }
        }
        return null;
    }
}
