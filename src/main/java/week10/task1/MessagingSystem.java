package week10.task1;

import java.lang.reflect.Method;

public class MessagingSystem {

    @CanSendMessage
    @RequiresPermission("admin")
    public void sendMessage(User user) throws Exception{
       Class<?> userClass = user.getClass(); //reflection
       if(userClass.isAnnotationPresent(UserPermission.class)){ //is annotation "UserPermission" present on the classes
           //if so, get the value(parameter) of the annotation - is it admin/user, and save it as String to userPermission variable
           String userPermission = userClass.getAnnotation(UserPermission.class).value();
           String requiredPermission = "admin";

           if(userPermission.equals(requiredPermission)){
               System.out.println(user.getUsername()+" ("+userPermission+")"+" sent a message."); //admin sent a message
           }
           else{
               System.out.println("User "+ user.getUsername()+" is restricted from sending message.");
           }

       }
       else{//if no annotation UserPermission - referring to the class - is present
           System.out.println("User class does not have permission annotations");

       }
    }

    public static void main(String[] args)throws Exception{

        MessagingSystem msgSystem = new MessagingSystem();

        //users
        RegularUser regularUser = new RegularUser("Ilhana Selimovic");
        AdminUser adminUser = new AdminUser("Selma Djozic");

        //Testing sendMessage with reflection to check annotations
        Method sendMessageMethod = MessagingSystem.class.getMethod("sendMessage", User.class);

        if (sendMessageMethod.isAnnotationPresent(CanSendMessage.class)){
            System.out.println("@CanSendMessage annotation is present.");
        }
        if (sendMessageMethod.isAnnotationPresent(RequiresPermission.class)) {
            RequiresPermission permission = sendMessageMethod.getAnnotation(RequiresPermission.class);
            System.out.println("@RequiresPermission annotation is present with value: " + permission.value());
        }

        //Demonstrating sending of messages
        msgSystem.sendMessage(regularUser);
        msgSystem.sendMessage(adminUser);
    }
}
