package com.wxw.dongtaiguihua;

public class PaLouTi {

	public static int calLoop(int n){
		//处理前两项
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			int a = 0;
			int b = 1;
			int c = 0;
			for (int i = 2; i <= n; i++) {
				c = a + b;
				a = b;
				b = c;
			}
			return c;
		}
	}
}
