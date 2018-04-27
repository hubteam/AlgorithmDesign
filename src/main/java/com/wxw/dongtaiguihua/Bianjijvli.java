package com.wxw.dongtaiguihua;

/**
 * 两个字符串的编辑距离
 * 编辑距离：一个字符串可以有三种操作，修改一个字母或者删除一个，或者增加一个，将一个字符串变成另外一个，求最少的操作次数
 * 
 * 解题：两个字符串的编辑距离越小，则它们越相似。如果两个字符串相等，则它们的编辑距离为0
 *     两个字符串的编辑距离肯定不超过它们的最大长度（可以通过先把短串的每一位都修改成长串对应位置的字符，然后插入长串中的剩下字符）。
 * <p>Description: <／p>
 * <p>Company: HUST<／p> 
 * @author 王馨苇
 * @date 2018年4月27日
 */
public class Bianjijvli {

	public static int editDistance(char[] s1, char[] s2){
		int len1 = s1.length;
		int len2 = s2.length;		
		int[][] dp = new int[len1 + 1][len2 + 1];
		
		dp[0][0] = 0;
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
		//考虑A串的第i个字符和B串的第j个字符
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				
				int cost = (s1[i - 1] == s2[j - 1]) ? 0 : 1;  
				//删除A串的第i个字符，之后仅需要计算A[i+1...lenA]和B[j...lenB]的距离即可；
	            int deletion = dp[i - 1][j] + 1;  
	            //把B串的第j个字符插入到A串的第i个字符之前，之后仅需要计算A[i...lenA]和B[j+1...lenB]的距离即可
	            int insertion = dp[i][j - 1] + 1;  
	            //修改A串的第i个字符成B串的第j个字符，之后仅需要计算A[i+1...lenA]和B[j+1...lenB]的距离即可
	            //这里之所以不是+1.因为可能是i和j位置相同，也可能是改变i，让两者相同
	            int substitution = dp[i - 1][j - 1] + cost;  
	            
	            if(deletion <= insertion && deletion <= substitution){
	            	dp[i][j] = deletion;
	            }else if(insertion <= deletion && insertion <= substitution){
	            	dp[i][j] = insertion;
	            }else{
	            	dp[i][j] = substitution;
	            }
			}
		}
		
		return dp[len1][len2];
	}
	
	public static void main(String[] args) {
		String str1 = "cafe";
		String str2 = "coffee";
		System.out.println(editDistance(str1.toCharArray(), str2.toCharArray()));
	}
}
