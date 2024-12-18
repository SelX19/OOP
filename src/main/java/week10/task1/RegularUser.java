package week10.task1;

@UserPermission("regular")
public class RegularUser extends User {

    public RegularUser(String username){
        super(username);
    }

    @Override
    public String getPermissionLevel(){
        //get permissionLevel = getUsername
        return "regular";
    }
}
