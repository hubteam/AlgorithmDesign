package com.wxw.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * һ��ѧ������������ (h, k) ������h ��ʾ��ߣ�k ��ʾ����ǰ����� k ��ѧ������߱����߻��ߺ���һ���ߡ�
 * @author 10187
 *
 */
public class QueueReConstructionByHeight {

	public static int[][] reconstructQueue(int[][] people){
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
//		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

	    List<int[]> queue = new ArrayList<int[]>();

	    for (int[] p : people)
	        queue.add(p[1], p);

	    return queue.toArray(new int[queue.size()][]);
	}
	
	public static void main(String[] args) {
		int[][] p = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		reconstructQueue(p);
		List<String> list = new ArrayList<String>();
		list.add(0, "a");
		list.add(1, "c");
		list.add(1, "b");
	}
}
