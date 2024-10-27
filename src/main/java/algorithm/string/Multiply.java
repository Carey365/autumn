package algorithm.string;

public class Multiply {
    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length()+num2.length()+1];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int scale1 = num1.length()-i-1;
                int scale2 = num2.length()-j-1;
                int scale = scale1+scale2;
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';
                int cur = (a*b)%10;
                int next = (a*b)/10 + (nums[scale]+cur)/10;
                nums[scale] = (nums[scale]+cur)%10;
                while(next!=0){
                    scale++;
                    int temp = (nums[scale]+ next)/10;
                    nums[scale] = (nums[scale]+ next)%10;
                    next = temp;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==0 && ans.length()==0){
                continue;
            }
            ans.append(String.valueOf(nums[i]));
        }
        if(ans.length()==0){
            return "0";
        }
        return ans.toString();
    }
}
