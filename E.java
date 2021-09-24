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
		// ���ļ�
		BufferedReader in1 = new BufferedReader(new FileReader("�ϻ����.csv"));
		String str;
		while ((str = in1.readLine()) != null) {
			String[] s = str.split(",");
			studentdata stu = new studentdata(s[0], s[1], s[2], s[3], s[7], 0);
			list1.add(stu);
		}
		BufferedReader in2 = new BufferedReader(new FileReader("ѧ������.csv"));
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
     * ���ຯ�����塣
     * ���һά double ���顣ָ��������Ŀ k��
     * �����ݾ۳� k �ࡣ
     */
    public static double cluster(double[] p, int k) {
        // ��ž���ɵľ�������
        double[] c = new double[k];
        // ����¼���ľ�������
        double[] nc = new double[k];
        // ��ŷŻؽ��
        double[][] g;
        // ��ʼ����������
        // ���䷽�������ѡȡ k ��
        // �����в���ǰ k ����Ϊ��������
        // �������ĵ�ѡȡ��Ӱ�����ս��
        for (int i = 0; i < k; i++)
            c[i] = p[i];
        // ѭ�����࣬���¾�������
        // ���������Ĳ���Ϊֹ
        while (true) {
            // ���ݾ������Ľ�Ԫ�ط���
            g = group(p, c);
            // ��������ľ�������
            for (int i = 0; i < g.length; i++) {
                nc[i] = center(g[i]);
            }
            // ����������Ĳ�ͬ
            if (!equal(nc, c)) {
                // Ϊ��һ�ξ���׼��
                c = nc;
                nc = new double[k];
            } else // �������
            {
            	//System.out.println(nc[0]);
                break;
            }
        }
        // ���ؾ�����
        return nc[0];
    }
    /*
     * �������ĺ���
     * �򵥵�һά���෵��������ƽ��ֵ
     * ����չ
     */
    public static double center(double[] p) {
        return sum(p) / p.length;
    }
    /*
     * ���� double ������ p �;������� c��
     * ���� c �� p ��Ԫ�ؾ��ࡣ���ض�ά���顣
     * ��Ÿ���Ԫ�ء�
     */
    public static double[][] group(double[] p, double[] c) {
        // �м����������������
        int[] gi = new int[p.length];
        // ����ÿһ��Ԫ�� pi ͬ�������� cj �ľ���
        // pi �� cj �ľ�����С���Ϊ j ��
        for (int i = 0; i < p.length; i++) {
            // ��ž���
            double[] d = new double[c.length];
            // ���㵽ÿ���������ĵľ���
            for (int j = 0; j < c.length; j++) {
                d[j] = distance(p[i], c[j]);
            }
            // �ҳ���С����
            int ci = min(d);
            // ���������һ��
            gi[i] = ci;
        }
        // ��ŷ�����
        double[][] g = new double[c.length][];
        // ����ÿ���������ģ�����
        for (int i = 0; i < c.length; i++) {
            // �м��������¼�����ÿһ��Ĵ�С
            int s = 0;
            // ����ÿһ��ĳ���
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i)
                    s++;
            // �洢ÿһ��ĳ�Ա
            g[i] = new double[s];
            s = 0;
            // ���ݷ����ǽ���Ԫ�ع�λ
            for (int j = 0; j < gi.length; j++)
                if (gi[j] == i) {
                    g[i][s] = p[j];
                    s++;
                }
        }
        // ���ط�����
        return g;
    }
 
    /*
     * ����������֮��ľ��룬 ���������򵥵�һάŷ�Ͼ��룬 ����չ��
     */
    public static double distance(double x, double y) {
        return Math.abs(x - y);
    }
 
    /*
     * ���ظ��� double �����Ԫ��֮�͡�
     */
    public static double sum(double[] p) {
        double sum = 0.0;
        for (int i = 0; i < p.length; i++)
            sum += p[i];
        return sum;
    }
 
    /*
     * ���� double �������飬������Сֵ���±ꡣ
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
     * �ж����� double �����Ƿ���ȡ� ����һ���Ҷ�Ӧλ��ֵ��ͬ�����档
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




