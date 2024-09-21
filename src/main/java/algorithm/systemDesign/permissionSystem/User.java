package algorithm.systemDesign.permissionSystem;


public class User {
    Integer userId;
    String userName;

    User(Integer userId,String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public Integer getId(){
        return this.userId;
    }

}
