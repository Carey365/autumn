package algorithm.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] floders = readFolders(path);
        StringBuilder str = new StringBuilder();
        LinkedList<String> list = new LinkedList<>();
        for(int i=0;i<floders.length;i++){
            if(floders[i].equals(".")){
                continue;
            }
            else if(floders[i].equals("..")){
                if(!list.isEmpty()){
                    list.removeLast();
                }
            }
            else{
                list.add(floders[i]);
            }
        }
        str.append("/");
        for(int i=0;i<list.size();i++){
            str.append(list.get(i));
            if(i<list.size()-1){
                str.append("/");
            }
        }
        return str.toString();
    }
    public String[] readFolders(String path){
        int index = 0;
        List<String> list = new ArrayList<>();
        while(index<path.length()){
            if(path.charAt(index)=='/'){
                index++;
                continue;
            }
            StringBuilder str = new StringBuilder();
            while(index<path.length() && path.charAt(index)!='/'){
                str.append(path.charAt(index));
                index++;
            }
            if(str.length()>0){
                list.add(str.toString());
            }
        }
        String[] res = new String[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }
}
