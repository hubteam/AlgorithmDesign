package com.wxw.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ������һ�����䲻�ص�����Ҫ�Ƴ������������
 * ��ÿ��ѡ���У�����Ľ�β��Ϊ��Ҫ��ѡ��������βԽС���������������Ŀռ�Խ����ô�����ܹ�ѡ����������Ҳ��Խ��
������Ľ�β��������ÿ��ѡ���β��С�����Һ�ǰһ�����䲻�ص������䡣
 * @author 10187
 *
 */
public class NonOverlappingIntervals_435 {

	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals.length == 0) {
			return 0;
		}
//		Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
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
