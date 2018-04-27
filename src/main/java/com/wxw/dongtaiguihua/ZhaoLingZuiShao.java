package com.wxw.dongtaiguihua;

import java.util.HashMap;
import java.util.Map;

/**
 * 最少硬币找零问题：给予不同面值的硬币若干种种（每种硬币个数无限多），用若干种硬币组合为某种面额的钱，使硬币的的个数最少。
 * 现存在一堆面值为 1,2,5,11,20,50 面值的硬币，问最少需要多少个硬币才能找出总值为 N个单位的零钱 
 * @author 王馨苇
 *
 */
public class ZhaoLingZuiShao {

	/**
	 * 这个问题，硬币的个数是没有限制的，每一个硬币的金额都是没有限制的
	 * 
	 * 动态规划算法思路： 
记d{n}={}表示兑换面值为n的最优解组合为{x1,x2,x3…} 
从子问题出发，取0元只有一种方法为{0}，即d(0)={0}，取1元（0+1)元，最优解为1元+0元，即d(0)+1={0,1}={1}; 
取2元有两种方式，即d(0)+2={2}或d(1)+1={1,1}，易知最化解为{2}…… 
以此累推，兑换面值为n的最优解为d(n)=max{d(n-i)+i}，其中(i<=n) 
	 * @param coins 硬币种类
	 * @param money 要找零的钱
	 * @return
	 */
	public static void makeChange(int[] coins, int money){
		int[] coinsUsed = new int[money+1];
		int valueKinds = coins.length;
		coinsUsed[0] = 0;//0元最优解
		Map<Integer,HashMap<Integer,Integer>> coinChangeMap = new HashMap<Integer,HashMap<Integer,Integer>>();
        //从1-money先求子问题的最优解
		for (int i = 1; i <= money; i++) {
			int minCount = i;
			//保存每个面值的具体找零方案
			HashMap<Integer,Integer> minCoinMap = new HashMap<Integer,Integer>();
			//遍历每一种面值的硬币，看看是否可以作为找零的其中一种
			for (int j = 0; j < valueKinds; j++) {
				//当前面值
				int coinVal = coins[j];
				//差值
				int oppCoinVal = i - coinVal;
				if(coinVal <= i){//当前面值的硬币小于等于i的时候
					int tempCount = coinsUsed[oppCoinVal] + 1;
					if(tempCount <= minCount){//只要用当前面值的时候，硬币个数小，继续，否则不继续
						/*子问题的最优解*/  
                        HashMap<Integer,Integer> subMap = coinChangeMap.get(oppCoinVal);    
                        HashMap<Integer,Integer> tmpMap = new HashMap<Integer,Integer>();  
                        if(subMap!=null) {
                            /*取到了子问题的最优解*/
                            tmpMap.putAll(subMap);
                        }
                        /*子问题的最优解+剩下面值 ->整个问题的最优解决*/
                        //更新结果，加入当前面值，或者是在之前的上面+！
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
			// 保存最小硬币数    
            coinsUsed[i] = minCount;   
            coinChangeMap.put(i, minCoinMap); 
            System.out.println("面值为 " + (i) + " 的最小硬币数 : " + minCount + ",货币为" + minCoinMap); 
		}
		
	}
	
	public static int zhaoling(int[] coint, int m){
		int[] count = new int[m+1];
		int[] trace = new int[m+1];
		for (int i = 0; i <= m; i++) {
			count[i] = Integer.MAX_VALUE;
		}
		count[0] = 0;//0元最优解
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
		// 硬币面值预先已经按降序排列    
        int[] coinValue = new int[] { 25, 21, 5, 2,1 };    
        // 需要找零的面值    
        int money = 63;    
        // 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1    
        System.out.println(zhaoling(coinValue,  money));  
        
	}
}
