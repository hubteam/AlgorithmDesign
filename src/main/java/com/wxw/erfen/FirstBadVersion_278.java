package com.wxw.erfen;

/**
 * 第一个错误版本
 * @author xinweiwang
 * @date 2018/6/5 10:38
 */
public class FirstBadVersion_278 {

    public static int findFirstBadVersion(int n){
        int l = 1, h = n;
        while (l <= h){
            int m = l + (h - l) / 2;
            if (isBadVersion(m)){
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static boolean isBadVersion(int x){
        return false;
    }
}
