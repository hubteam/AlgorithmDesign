package com.wxw.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * ����Ӳ���������⣺���費ͬ��ֵ��Ӳ���������֣�ÿ��Ӳ�Ҹ������޶ࣩ����������Ӳ�����Ϊĳ������Ǯ��ʹӲ�ҵĵĸ������١�
 * �ִ���һ����ֵΪ 1,2,5,11,20,50 ��ֵ��Ӳ�ң���������Ҫ���ٸ�Ӳ�Ҳ����ҳ���ֵΪ N����λ����Ǯ 
 * @author ��ܰέ
 *
 */
public class ZhaoLingZuiShao {

	/**
	 * ������⣬Ӳ�ҵĸ�����û�����Ƶģ�ÿһ��Ӳ�ҵĽ���û�����Ƶ�
	 * 
	 * ��̬�滮�㷨˼·�� 
��d{n}={}��ʾ�һ���ֵΪn�����Ž����Ϊ{x1,x2,x3��} 
�������������ȡ0Ԫֻ��һ�ַ���Ϊ{0}����d(0)={0}��ȡ1Ԫ��0+1)Ԫ�����Ž�Ϊ1Ԫ+0Ԫ����d(0)+1={0,1}={1}; 
ȡ2Ԫ�����ַ�ʽ����d(0)+2={2}��d(1)+1={1,1}����֪���Ϊ{2}���� 
�Դ����ƣ��һ���ֵΪn�����Ž�Ϊd(n)=max{d(n-i)+i}������(i<=n) 
	 * @param coins Ӳ������
	 * @param money Ҫ�����Ǯ
	 * @return
	 */
	public static void makeChange(int[] coins, int money){
		int[] coinsUsed = new int[money+1];
		int valueKinds = coins.length;
		coinsUsed[0] = 0;//0Ԫ���Ž�
		Map<Integer,HashMap<Integer,Integer>> coinChangeMap = new HashMap<Integer,HashMap<Integer,Integer>>();
        //��1-money��������������Ž�
		for (int i = 1; i <= money; i++) {
			int minCount = i;
			//����ÿ����ֵ�ľ������㷽��
			HashMap<Integer,Integer> minCoinMap = new HashMap<Integer,Integer>();
			//����ÿһ����ֵ��Ӳ�ң������Ƿ������Ϊ���������һ��
			for (int j = 0; j < valueKinds; j++) {
				//��ǰ��ֵ
				int coinVal = coins[j];
				//��ֵ
				int oppCoinVal = i - coinVal;
				if(coinVal <= i){//��ǰ��ֵ��Ӳ��С�ڵ���i��ʱ��
					int tempCount = coinsUsed[oppCoinVal] + 1;
					if(tempCount <= minCount){//ֻҪ�õ�ǰ��ֵ��ʱ��Ӳ�Ҹ���С�����������򲻼���
						/*����������Ž�*/  
                        HashMap<Integer,Integer> subMap = coinChangeMap.get(oppCoinVal);    
                        HashMap<Integer,Integer> tmpMap = new HashMap<Integer,Integer>();  
                        if(subMap!=null) {
                            /*ȡ��������������Ž�*/
                            tmpMap.putAll(subMap);
                        }
                        /*����������Ž�+ʣ����ֵ ->������������Ž��*/
                        //���½�������뵱ǰ��ֵ����������֮ǰ������+��
                        if(tmpMap.containsKey(coinVal)) {
                            tmpMap.put(coinVal, subMap.get(coinVal)+1);  
                        }else {
                            tmpMap.put(coinVal, 1);
                        }
                        minCount = tempCount;
                        minCoinMap = tmpMap;
					}
				}
			}
			// ������СӲ����    
            coinsUsed[i] = minCount;   
            coinChangeMap.put(i, minCoinMap); 
            System.out.println("��ֵΪ " + (i) + " ����СӲ���� : " + minCount + ",����Ϊ" + minCoinMap); 
		}
		
	}
	
	public static int zhaoling(int[] coint, int m){
		int[] count = new int[m+1];
		int[] trace = new int[m+1];
		for (int i = 0; i <= m; i++) {
			count[i] = Integer.MAX_VALUE;
		}
		count[0] = 0;//0Ԫ���Ž�
//		count[1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < coint.length; j++) {
				if(coint[j] <= i && count[i-coint[j]]+1 < count[i]){
					count[i] = count[i-coint[j]] + 1;
					trace[i] = coint[j];
				}
			}
		}
		return count[m];
	}
	
	public static void main(String[] args) {
		// Ӳ����ֵԤ���Ѿ�����������    
        int[] coinValue = new int[] { 25, 21, 5, 2,1 };    
        // ��Ҫ�������ֵ    
        int money = 63;    
        // ����ÿһ����ֵ�����������СӲ������0�ŵ�Ԫ�������ã�����Ҫ���1    
        System.out.println(zhaoling(coinValue,  money));  
        
	}
}
