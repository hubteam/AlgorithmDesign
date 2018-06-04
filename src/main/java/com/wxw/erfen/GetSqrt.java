package com.wxw.erfen;

/**
 * @author xinweiwang
 * @date 2018/6/4 13:18
 */
public class GetSqrt {

    public int getSqrt(int key){
        int l = 1, h = key;
        while (l <= h){
            int m = (l + (h - 1)) / 2;
            int sqrt = key / m;
            if (sqrt == m){
                return m;
            } else if (sqrt > m){
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }
}
