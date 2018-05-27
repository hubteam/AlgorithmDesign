package com.wxw.tanxin;

/**
 * ����֮��������Ҫһ����λ�ļ��������Ƿ������� n �仨
 * ���磺flowerbed = [1,0,0,0,1], n = 1
 * @author 10187
 *
 */
public class PlaceFlower_605 {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
	    int len = flowerbed.length;
	    int cnt = 0;
	    for (int i = 0; i < len; i++) {
	        if (flowerbed[i] == 1)
	            continue;
	        int pre = i == 0 ? 0 : flowerbed[i - 1];
	        int next = i == len - 1 ? 0 : flowerbed[i + 1];
	        if (pre == 0 && next == 0) {
	            cnt++;
	            flowerbed[i] = 1;
	        }
	    }
	    return cnt >= n;
	}
}
