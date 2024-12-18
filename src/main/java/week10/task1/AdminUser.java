package week10.task1;

@UserPermission("admin")
public class AdminUser extends User{

    public AdminUser(String username){
        super(username);
    }

    @Override
    String getPermissionLevel(){
        return "admin";
    }
}
