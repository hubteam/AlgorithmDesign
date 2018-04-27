package com.wxw.dongtaiguihua;

/**
 * �����ַ����ı༭����
 * �༭���룺һ���ַ������������ֲ������޸�һ����ĸ����ɾ��һ������������һ������һ���ַ����������һ���������ٵĲ�������
 * 
 * ���⣺�����ַ����ı༭����ԽС��������Խ���ơ���������ַ�����ȣ������ǵı༭����Ϊ0
 *     �����ַ����ı༭����϶����������ǵ���󳤶ȣ�����ͨ���ȰѶ̴���ÿһλ���޸ĳɳ�����Ӧλ�õ��ַ���Ȼ����볤���е�ʣ���ַ�����
 * <p>Description: <��p>
 * <p>Company: HUST<��p> 
 * @author ��ܰέ
 * @date 2018��4��27��
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
		//����A���ĵ�i���ַ���B���ĵ�j���ַ�
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				
				int cost = (s1[i - 1] == s2[j - 1]) ? 0 : 1;  
				//ɾ��A���ĵ�i���ַ���֮�����Ҫ����A[i+1...lenA]��B[j...lenB]�ľ��뼴�ɣ�
	            int deletion = dp[i - 1][j] + 1;  
	            //��B���ĵ�j���ַ����뵽A���ĵ�i���ַ�֮ǰ��֮�����Ҫ����A[i...lenA]��B[j+1...lenB]�ľ��뼴��
	            int insertion = dp[i][j - 1] + 1;  
	            //�޸�A���ĵ�i���ַ���B���ĵ�j���ַ���֮�����Ҫ����A[i+1...lenA]��B[j+1...lenB]�ľ��뼴��
	            //����֮���Բ���+1.��Ϊ������i��jλ����ͬ��Ҳ�����Ǹı�i����������ͬ
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
