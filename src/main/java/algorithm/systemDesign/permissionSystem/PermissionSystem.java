package algorithm.systemDesign.permissionSystem;

import java.util.HashMap;
import java.util.Map;

public class PermissionSystem {
    Integer systemId;
    String systemName;
    Map<Integer,PermissionType> userMap;

    PermissionSystem(Integer systemId,String systemName){
        this.systemId = systemId;
        this.systemName = systemName;
        userMap = new HashMap<>();
    }

    public void addUser(Integer userId,PermissionType type){
        userMap.put(userId,type);
    }

    public PermissionType getPermissionType(Integer userId){
        return userMap.get(userId);
    }

    public Boolean validPermission(Integer userId,PermissionType type){
        PermissionType permissionType = userMap.get(userId);
        if(permissionType.equals(type)){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}
