package com.wxw.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * 题意是要对一个字符串进行尽可能多的划分，并保证每个划分中的元素不在其他划分中出现。
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * @author 10187
 *
 */
public class PartitionLabel_763 {

	public static List<Integer> partitionLabels(String s){
		int[] lastIndexs = new int[26];
		//记录字符串中每一个字母在字符串中出现的最后的位置
		for (int i = 0; i < s.length(); i++) {
			lastIndexs[s.charAt(i) - 'a'] = i;
		}
	    List<Integer> ret = new ArrayList<>();
	    int firstIndex = 0;
	    while (firstIndex < s.length()) {
	        int lastIndex = firstIndex;
	        for (int i = firstIndex; i < s.length() && i <= lastIndex; i++) {
	            int index = lastIndexs[s.charAt(i) - 'a'];
	            if (index > lastIndex)
	                lastIndex = index;
	        }
	        ret.add(lastIndex - firstIndex + 1);
	        firstIndex = lastIndex + 1;
	    }
	    return ret;
	}
	
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		partitionLabels(s);
	}
}
