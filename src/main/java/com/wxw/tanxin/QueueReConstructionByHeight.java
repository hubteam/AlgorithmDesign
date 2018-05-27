package com.wxw.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 * @author 10187
 *
 */
public class QueueReConstructionByHeight {

	public static int[][] reconstructQueue(int[][] people){
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

	    List<int[]> queue = new ArrayList<>();

	    for (int[] p : people)
	        queue.add(p[1], p);

	    return queue.toArray(new int[queue.size()][]);
	}
	
	public static void main(String[] args) {
		int[][] p = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		reconstructQueue(p);
		List<String> list = new ArrayList<>();
		list.add(0, "a");
		list.add(1, "c");
		list.add(1, "b");
	}
}
