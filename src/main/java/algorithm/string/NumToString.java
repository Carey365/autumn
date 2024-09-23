package algorithm.string;

import java.util.*;

public class NumToString {
    String[] maps1 = new String[]{"" ,"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] maps2 = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        StringBuilder ans = new StringBuilder();
        List<String> list = new ArrayList<>();
        String str = String.valueOf(num);
        int index = str.length();
        //divide
        while(index > 0){
            String sub = str.substring(Math.max(0,index-3),index);
            list.add(sub);
            index = index -3;
        }
        //convert and merge
        String[] tails = new String[]{"","Thousand","Million","Billion","Trillion"};
        for(int i=0;i<list.size();i++){
            String convertStr = convertHelper(list.get(i));
            String cur = " " + convertStr + " " + tails[i];
            if(convertStr.equals("Zero") && list.size()>1){
                continue;
            }
            ans.insert(0,cur);
        }

        return ans.toString().trim();

    }
    public String convertHelper(String str){
        str = String.valueOf(Integer.parseInt(str));
        Integer num = Integer.parseInt(str);
        if(num==0){
            return "Zero";
        }
        if(num<=19){
            return maps1[num];
        }
        if(num<100){
            int tens = str.charAt(0)-'0';
            int ones = str.charAt(1)-'0';
            StringBuilder ans = new StringBuilder();
            ans.append(maps2[tens]);
            if(ones>0){
                ans.append(" ");
                ans.append(maps1[ones]);
            }
            return ans.toString();
        }
        //deal with nums larger than 100
        int hundreds = str.charAt(0)-'0';
        StringBuilder ans = new StringBuilder();
        ans.append(maps1[hundreds]);
        ans.append(" ");
        ans.append("Hundred");
        int rest = Integer.parseInt(str.substring(1,3));
        if(rest>0){
            ans.append(" ");
            ans.append(convertHelper(str.substring(1,3)));
        }
        return ans.toString();
    }
}
