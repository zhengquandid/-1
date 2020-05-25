/*
package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DemoTest1 {

    public static double normalPackage(int s, double[] w, double[] v, double p){
        double[][] vperw = new double[s][2];//[0]单位重量下的价值[1]编号
        for (int i = 0; i < s; i++) {
            vperw[i][0] = v[i] / w[i];
            vperw[i][1] = i;
        }
        //按照收益比排序
        Arrays.sort(vperw, new Comparator<double[]>() {
            @Override public int compare(double[] o1, double[] o2) {
                return o2[0]-o1[0]>0?1:-1;
            }
        });

//        //看排序是否正确
//        for (int i = 0; i < s; i++) {
//            System.out.print(vperw[i][0] + "   ");
//        }
//        System.out.println();

        double tmpW = 0;//临时重量
        double result = 0;//价值
        for (int i = 0; i < s; i++) {
            int b = (int) vperw[i][1];//当前物品的id
            double thisW = w[b];
            if (thisW < p-tmpW){//如果可以放下完整的物品
                result += v[b];
                tmpW += w[b];
                System.out.println("物品 " + b +" 放入比例 1 获得收益 " + v[b]);
            }else {
                double canW = p-tmpW;//可以放的重量
                result += vperw[i][0] * canW;
                System.out.println("物品 " + b +" 放入比例 "+ canW/thisW +" 获得收益 " + vperw[i][0] * canW);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("请输入背包的容量w和物品的个数n");
        Scanner reader = new Scanner(System.in);
        int w = reader.nextInt();//背包的容量
        int n = reader.nextInt();//物品的个数
        double[] p = new double[1000];
        double[] v = new double[1000];
        System.out.println("请依次输入各个物品的重量w");
        for (int i = 0; i < n; i++) {
            p[i] = reader.nextDouble();
        }
        System.out.println("请依次输入各个物品的价值v");
        for (int i = 0; i < n; i++) {
            v[i] = reader.nextDouble();
        }
        double result = normalPackage(n,p, v, w);
        System.out.println("获取最大收益为：" + result);

    }
}*/
