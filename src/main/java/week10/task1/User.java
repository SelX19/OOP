package week10.task1;

abstract class User {
    private String username;

    public User(String username){
        this.username=username;
    }

    public String getUsername(){
        return this.username;
    }

    abstract String getPermissionLevel();
}
