package practice.collections.codes;

public class SmallerNumbersThanCurrent {
	// Approach (Brute Force) 
	// We can simply run a loop for every element, 
	// starting from left to right. For each element, we will find the 
	// count of the elements which are lesser than the current number.
	// So basically, we run one outer loop for each element and in inner 
	// loop, we will traverse the whole array to count every element less 
	// than current value.
	
	 public static int[] smallerNumbersThanCurrent(int[] nums) 
	    {
	        int[]ans=new int[nums.length];
	        for(int i=0;i<nums.length;i++)
	        {
	            int count=0;
	            for(int j=0;j<nums.length;j++)
	            {
	                if(nums[i]>nums[j])   count++;
	            }
	            ans[i]=count;
	        }
	        return ans;
	    }
	    
	
	 
	    public static void main(String args[])
	    {
	       int[]nums={8,1,2,2,3};  
	       int[]ans=smallerNumbersThanCurrent(nums);
	        
	       for(int num : ans)  
	       {
	           System.out.print(num+" ");
	       }
}
}