/*
-----------------------------------PROBLEM-------------------------------
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:

	Input: s = "abbaca"
	Output: "ca"
	Explanation: 
	For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:

	Input: s = "azxxzy"
	Output: "ay"

----------------------------SOLUTION---------------------------------------
The idea is to use LIFO algo.Below are 2 approaches:

	Create a stack & for each character, check if current character is on top of Stack, we remove the top element. at last, pop all the remaining item from the stack & reverse it to get the answer.

	Create a StringBuilder & check if at the last index we have same character as our current character.
		If yes, remove the last character & continue.
		If no, add the character to the last index of StringBuilder. 

---------------------------------------------------------------------------
*/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(Character.toString(stack.pop()));
        }
        return sb.reverse().toString();
    }
}