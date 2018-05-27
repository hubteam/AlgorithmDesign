package com.wxw.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 计算让一组区间不重叠所需要移除的区间个数。
 * 在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，那么后面能够选择的区间个数也就越大。
按区间的结尾进行排序，每次选择结尾最小，并且和前一个区间不重叠的区间。
 * @author 10187
 *
 */
public class NonOverlappingIntervals_435 {

	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
		int cnt = 1;
		int end = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < end) {
				continue;
			}
			end = intervals[i].end;
			cnt++;
		}
		return intervals.length - cnt;
	}
	
}

class Interval {
	int start;
	int end;
}
