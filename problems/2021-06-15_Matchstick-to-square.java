// Using backtracking to checkout whether any combination is possible or not
class Solution {
    public boolean makesquare(int[] m) {
        int sum = 0;
        // less than 4 matchsticks can't form a square
        if(m.length  < 4)
            return false;
        sum = (Arrays.stream(m).reduce(0,(a,b)-> a+b));
        // if not divisible by 4, we cant form a square
        if(sum % 4 != 0)
            return false;
        int side = (sum/4);
        // creating array for better handling 
        int[] sides = new int[]{side, side,side, side};
        return helper(m, 0, sides);
        
    }
        // created helper method for better abstraction
    boolean helper(int nums[],int i,int[] sides){
        // if we've exhausted all our matchsticks 
        if(i == nums.length){       
            if(sides[0] == 0 && sides[1] ==0 && sides[2]== 0 && sides[3] == 0)
                return true;
            else
                return false;
        }
        // reduce length of current stick from each side & recur for every side 
        for(int j=0;j<4;j++){
            // if current matchstick is greated than our side then skip 
            if(nums[i] > sides[j]) continue;
            // substract current match length & check further combinations
            sides[j] -= nums[i];
            // call helper to check if any child combination is possible
            if(helper(nums, i+1, sides)) return true;
            // adding that side again to include that in our current match & use the value for next match combination
            sides[j] += nums[i];
        }
        // We've reached here if no combination is possible
        return false;
    }
}