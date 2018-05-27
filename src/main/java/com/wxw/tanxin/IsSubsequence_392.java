package com.wxw.tanxin;

/**
 * ÅÐ¶ÏÊÇ·ñÎª×Ó´®
 * @author 10187
 *
 */
public class IsSubsequence_392 {

	/**
	 * s = "abc", t = "ahbgdc"
	 * Return true.
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isSubsequence(String s, String t) {
		int index = -1;
		for (char c: s.toCharArray()) {
			index = t.indexOf(c, index + 1);
			if (index == -1) {
				return false;
			}
		}
		return true;
	}
}
