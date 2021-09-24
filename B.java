package bigwork;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class B {
	public static void main(String args[]) throws Exception {
		ArrayList<studentdata> list1 = new ArrayList<studentdata>();
		ArrayList<student> list2=new ArrayList<student>();
		Scanner cin = new Scanner(System.in);
		try {
			// 读文件
			BufferedReader in1 = new BufferedReader(new FileReader("上机情况.csv"));
			String str;
			while ((str = in1.readLine()) != null) {
				String[] s = str.split(",");
				studentdata stu=new studentdata(s[0], s[1], s[2], s[3], s[7], 0);
				list1.add(stu);
			}
			BufferedReader in2 = new BufferedReader(new FileReader("学生名单.csv"));
			while ((str = in2.readLine()) != null) {
			    student st=new student(str);
				list2.add(st);
			}
			int n = list1.size();
			int m=list2.size();
			int i;
			int j;
			for(i=1;i<n;i++)
			{
				for(j=1;j<m;j++)
				{
					if(list1.get(i).getUSER().equals(list2.get(j).getUSER()))
					{
						list1.get(i).setTrueID(j);
						String s1=list1.get(i).getRESULT().substring(0, 3);
						if(list1.get(i).getPROBLEM().equals("A"))
						{
							if(s1.equals("Acc"))
								list2.get(j).a=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						if(list1.get(i).getPROBLEM().equals("B"))
						{
							if(s1.equals("Acc"))
								list2.get(j).b=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						if(list1.get(i).getPROBLEM().equals("C"))
						{
							if(s1.equals("Acc"))
								list2.get(j).c=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						if(list1.get(i).getPROBLEM().equals("D"))
						{
							if(s1.equals("Acc"))
								list2.get(j).d=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						if(list1.get(i).getPROBLEM().equals("E"))
						{
							if(s1.equals("Acc"))
								list2.get(j).e=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						if(list1.get(i).getPROBLEM().equals("F"))
						{
							if(s1.equals("Acc"))
								list2.get(j).f=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						if(list1.get(i).getPROBLEM().equals("G"))
						{
							if(s1.equals("Acc"))
								list2.get(j).g=1;
							if(s1.equals("Run")||s1.equals("Tim")||s1.equals("Wro")||s1.equals("Com")||s1.equals("*Ac"))
							{
								list2.get(j).wrtime++;
							}
						}
						break;
					}
				}
			}
			for (i = 0; i < 8; i++) {
				int count = 0;
				student wrmin=new student("aa");
				wrmin.setWrtime(100);
				for (j = 1; j < m; j++) {
					int ac = list2.get(j).getActime();
					if (ac == i) {
						count++;
						if(list2.get(j).wrtime<wrmin.getWrtime())
							wrmin=list2.get(j);
					}
				}
				System.out.println("AC了" + i + "道题目的人数：" + count);
				System.out.println("错误最少的同学是：" + wrmin.getUSER());
			}
		} catch (IOException e) {
		}
		}
}
