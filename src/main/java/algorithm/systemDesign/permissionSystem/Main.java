package algorithm.systemDesign.permissionSystem;

public class Main {
    public static void main(String[] args){
        //initialize permission system
        PermissionSystem system = new PermissionSystem(1,"demo system");
        //create users and add to system
        User user1 = new User(1,"James");
        User user2 = new User(2,"Kate");
        system.addUser(user1.getId(),PermissionType.NORMAL);
        system.addUser(user2.getId(),PermissionType.VIP);
        //get permission type
        System.out.println(system.getPermissionType(user1.getId()));
        System.out.println(system.getPermissionType(user2.getId()));
        //valid permission type
        System.out.println(system.validPermission(user1.getId(),PermissionType.VIP));
    }
}
