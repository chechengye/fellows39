package com.weichuang.day03Demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ProgrmExample {

    @Test
    public void testFn(){
        int[] arrs = {7,5,6,3,10 };
        int[] arrs2 = {7,5,6,3,10};
        //注意：只能对已经排好序的数组
        int index = Arrays.binarySearch(arrs, 5);
        System.out.println(index);
        //Arrays.toString 转成数组字符串
        System.out.println(Arrays.toString(arrs));
        //帮我们讲数组排好序，并赋值回该数组
        //Arrays.sort(arrs);
        System.out.println(Arrays.toString(arrs));
        //扩容,扩容的大小，就是原数组的长度的2倍 & 原数组长度的 1/2 + 1
        arrs = Arrays.copyOf(arrs, arrs.length * 2);
        for(int x : arrs){
            System.out.print(x + " ");
        }
        System.out.println(Arrays.equals(arrs, arrs2));
        Arrays.fill(arrs2 , 0 , 2 , 3);
        System.out.println(Arrays.toString(arrs2));

    }

    /**
     * 双色球模拟综合案例
     */
    @Test
    public void testFn1(){
        String[] pool = getPool();
        System.out.println(Arrays.toString(pool));
        //机器抽取6红球-随机操作
        String[] sysRedBalls = getRedBalls(pool);
        System.out.println(Arrays.toString(sysRedBalls));
        //机器随机抽取1个篮球
        Random r = new Random();
        final int blueBound = 16;
        String sysBlueBall = pool[r.nextInt(blueBound)];
        System.out.println(sysBlueBall);
        //用户来了，让你机器随机抽取号码
        String[] userRedBalls = getRedBalls(pool);
        String userBlueBall = pool[r.nextInt(blueBound)];
        System.out.println(Arrays.toString(userRedBalls));
        System.out.println(userBlueBall);
        System.out.println(getReward(sysRedBalls, sysBlueBall, userRedBalls, userBlueBall));
    }

    /**
     * 初始化双色球池子
     */
    private String[] getPool(){
        String[] pool = new String[33];
        int len =  pool.length;
        for(int i = 1 ; i <= len ; i++){
            if(i < 10) pool[i - 1] = "0" + i;
            else pool[i - 1] = i + "";
        }
        return pool;
    }

    /**
     * 随机获取6个红球
     */
    private String[] getRedBalls(String[] pool){
        String[] redBalls = new String[6];
        //获取随机数的对象
        Random r = new Random();
        int count = 0 ;
        boolean[] isUsed = new boolean[pool.length];
        while (true){
            int index = r.nextInt(pool.length);//此方法随机获取bound -1 ~ 0
            if(isUsed[index]) continue; //判断是否已经取过红球
            isUsed[index] = true; //讲取过的索引，加标志位
            redBalls[count ++] = pool[index];
            if(count == redBalls.length) break;
        }
        return redBalls;
    }

    /**
     * 获得了几等奖
     */
    private String getReward(String[] sysRedBalls , String sysBlueBall , String[] userRedBalls , String userBlueBall){
        int redCount = 0;
        for(String sysRed : sysRedBalls){
            for(String userRed : userRedBalls){
                if(sysRed == userRed) redCount ++;
            }
        }
        int blueCount = 0;
        if(sysBlueBall == userBlueBall) blueCount ++;
        if(blueCount == 1 && redCount < 3)
            return "六等奖";
        else if((blueCount + redCount) == 4)
            return "五等奖";
        else if((blueCount + redCount) == 5)
            return "四等奖";
        else if(redCount == 5 && blueCount == 1)
            return "三等奖";
        else if(redCount == 6 && blueCount == 0)
            return "二等奖";
        else if((redCount + blueCount) == 7)
            return "一等奖";
        else return "未中奖";
    }
}
