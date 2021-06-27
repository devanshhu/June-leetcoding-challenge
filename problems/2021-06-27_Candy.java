/*
----------------------------------------PROBLEM--------------------------------
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

    Input: ratings = [1,0,2]
    Output: 5
    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:

    Input: ratings = [1,2,2]
    Output: 4
    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
    The third child gets 1 candy because it satisfies the above two conditions.

---------------------------------SOLUTION-------------------------------------

We just need to traverse each child first left-to-right & then check if an element has rating greater than previous, we increment candy to current child by ( previous child candy count + 1 ).
Next, traverse each child right-to-left & check if current child has rating greater than previous child, & If our current child already has greater no. of candies than our previous(right neighbour),then we skip else increase the candy count to ( previous child candy count + 1);   

-------------------------------------------------------------------------------
*/
class Solution {
    public int candy(int[] ratings) {
        int arr[] = new int[ratings.length];
        Arrays.fill(arr, 1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1] )
                arr[i] = arr[i-1]+1;
        }
        for(int i=ratings.length-2;i >=0 ;i--){
            if(ratings[i] > ratings[i+1] && arr[i] <= arr[i+1])
                arr[i] = arr[i+1]+1;
        }
        return Arrays.stream(arr).reduce(0,(a,b) -> a+b);
    }
}