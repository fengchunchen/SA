package bigwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;

public class E {


	public static void main(String args[]) throws Exception {

		ArrayList<studentdata> list1 = new ArrayList<studentdata>();
		ArrayList<student> list2 = new ArrayList<student>();
		Scanner cin = new Scanner(System.in);
		// 读文件
		BufferedReader in1 = new BufferedReader(new FileReader("上机情况.csv"));
		String str;
		while ((str = in1.readLine()) != null) {
			String[] s = str.split(",");
			studentdata stu = new studentdata(s[0], s[1], s[2], s[3], s[7], 0);
			list1.add(stu);
		}
		BufferedReader in2 = new BufferedReader(new FileReader("学生名单.csv"));
		while ((str = in2.readLine()) != null) {
			student st = new student(str);
			list2.add(st);
		}
		int n = list1.size();
		int m = list2.size();
		int i;
		int j;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d H:m");
		Date date = dateFormat.parse(list1.get(n - 1).getSUBMITTIME());
		for (i = 1; i < n; i++) {
			for (j = 1; j < m; j++) {
				if (list1.get(i).getUSER().equals(list2.get(j).getUSER())) {
					list1.get(i).setTrueID(j);
					Calendar calendar = Calendar.getInstance();
					Date date1 = dateFormat.parse(list1.get(i).getSUBMITTIME());
					long jiange = date1.getTime() - date.getTime();
					String s1 = list1.get(i).getRESULT().substring(0, 3);
					if (list1.get(i).getPROBLEM().equals("A")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[0] = jiange;
						}
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					if (list1.get(i).getPROBLEM().equals("B")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[1] = jiange;
						}
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					if (list1.get(i).getPROBLEM().equals("C")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[2] = jiange;
						}
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					if (list1.get(i).getPROBLEM().equals("D")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[3] = jiange;
						}
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					if (list1.get(i).getPROBLEM().equals("E")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[4] = jiange;
						}
						;
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					if (list1.get(i).getPROBLEM().equals("F")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[5] = jiange;
						}
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					if (list1.get(i).getPROBLEM().equals("G")) {
						if (s1.equals("Acc")) {
							jiange = date1.getTime() - date.getTime();
							list2.get(j).tt[6] = jiange;
						}
						if (s1.equals("Run") || s1.equals("Tim") || s1.equals("Wro") || s1.equals("Com")
								|| s1.equals("*Ac")) {
							list2.get(j).wrtime++;
						}
					}
					break;
				}

			}
		}

		System.out.println("0");
		for (int o = 0; o < list2.size(); o++) {
			double[] p = list2.get(o).tt;
	        int k = 1;
	        double  g =  cluster(p, k);
	        list2.get(o).t=g;
	        //System.out.println(g);
	     }
		System.out.println("******");
		for (int o = 0; o < list2.size(); o++) {
	        if(list2.get(o).t==0)
	        System.out.println(list2.get(o).getUSER());
	     }
		System.out.println("******");
		Date date1 = dateFormat.parse(list1.get(1).getSUBMITTIME());
		double jiange1 = date1.getTime() - date.getTime();
		for (int o = 0; o < list2.size(); o++) {
	        if(list2.get(o).t>0&&list2.get(o).t<1.7931E8)
	        System.out.println(list2.get(o).getUSER());
	     }
		System.out.println("******");
		for (int o = 0; o < list2.size(); o++) {
	        if(list2.get(o).t>1.7931E8)
	        System.out.println(list2.get(o).getUSER());
	     }
		
	}
		/* double[] p = { 1, 2, 3, 5, 6, 7, 9, 10, 11, 100, 150, 200, 1000 };
	        int k = 5;
	        double[][] g;
	        g = cluster(p, k);
	        for ( i = 0; i < g.length; i++) {
	            for ( j = 0; j < g[i].length; j++) {
	                System.out.print(g[i][j]);
	                System.out.print("\t");
	            }
	            System.out.println();
	        }
	        
	}*/
	
	 /*
     * 聚类函数主体。
     * 针对一维 double 数组。指定聚类数目 k。
     * 将数据聚成 k 类。
     */
    public static double cluster(double[] p, int k) {
        // 存放聚类旧的聚类中心
        double[] c = new double[k];
        // 存放新计算的聚类中心
        double[] nc = new double[k];
        // 存放放回结果
        double[][] g;
        // 初始化聚类中心
        // 经典方法是随机选取 k 个
        // 本例中采用前 k 个作为聚类中心
        // 聚类中心的选取不影响最终结果
        for (int i = 0; i < k; i++)
            c[i] = p[i];
        // 循环聚类，更新聚类中心
        // 到聚类中心不变为止
        while (true) {
            // 根据聚类中心将元素分类
            g = group(p, c);
            // 计算分类后的聚类中心
            for (int i = 0; i < g.length; i++) {
                nc[i] = center(g[i]);
            }
            // 如果聚类中心不同
            if (!equal(nc, c)) {
                // 为下一次聚类准备
                c = nc;
                nc = new double[k];
            } else // 聚类结束
            {
            	//System.out.println(nc[0]);
                break;
            }
        }
        // 返回聚类结果
        return nc[0];
    }
    /*
     * 聚类中心函数
     * 简单的一维聚类返回其算数平均值
     * 可扩展
     */
    public static double center(double[] p) {
        return sum(p) / p.length;
    }
    /*
     * 给定 double 型数组 p 和聚类中心 c。
     * 根据 c 将 p 中元素聚类。返回二维数组。
     * 存放各组元素。
     */
    public static double[][] group(double[] p, double[] c) {
        // 中间变量，用来分组标记
        int[] gi = new int[p.length];
        // 考察每一个元素 pi 同聚类中心 cj 的距离
        // pi 与 cj 的距离最小则归为 j 类
        for (int i = 0; i < p.length; i++) {
            // 存放距离
            double[] d = new double[c.length];
            // 计算到每个聚类中心的距离
            for (int j = 0; j < c.length; j++) {
                d[j] = distance(p[i], c[j]);
            }
            // 找出最小距离
            int ci = min(d);
            // 标记属于哪一组
            gi[i] = ci;
        }
        // 存放分组结果
        double[][] g = new double[c.length][];
        // 遍历每个聚类中心，分组
        for (int i = 0; i < c.length; i++) {
            // 中间变量，记录聚类后每一组的大小
            int s = 0;
            // 计算每一组的长度
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i)
                    s++;
            // 存储每一组的成员
            g[i] = new double[s];
            s = 0;
            // 根据分组标记将各元素归位
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i) {
                    g[i][s] = p[j];
                    s++;
                }
        }
        // 返回分组结果
        return g;
    }
 
    /*
     * 计算两个点之间的距离， 这里采用最简单得一维欧氏距离， 可扩展。
     */
    public static double distance(double x, double y) {
        return Math.abs(x - y);
    }
 
    /*
     * 返回给定 double 数组各元素之和。
     */
    public static double sum(double[] p) {
        double sum = 0.0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }
 
    /*
     * 给定 double 类型数组，返回最小值得下标。
     */
    public static int min(double[] p) {
        int i = 0;
        double m = p[0];
        for (int j = 1; j < p.length; j++) {
            if (p[j] < m) {
                i = j;
                m = p[j];
            }
        }
        return i;
    }
 
    /*
     * 判断两个 double 数组是否相等。 长度一样且对应位置值相同返回真。
     */
    public static boolean equal(double[] a, double[] b) {
        if (a.length != b.length)
            return false;
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i])
                    return false;
            }
        }
        return true;
    }
}




