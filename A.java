package bigwork;

import java.util.*;
import java.io.*;

public class A {
	public static void main(String args[]) throws Exception {
		ArrayList<studentdata> list1 = new ArrayList<studentdata>();
		ArrayList<student> list2=new ArrayList<student>();
		ArrayList<String> xiaohao=new ArrayList<String>();
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
						break;
					}
				}
			}
			for(i=1;i<n;i++)
			{
				if(list1.get(i).getTrueID()==0)
				{
					for(j=0;j<xiaohao.size();j++)
					{
					     if(xiaohao.get(j).equals(list1.get(i).getUSER()))
					    	 break;
					}
					if(j==xiaohao.size())
						xiaohao.add(list1.get(i).getUSER());
				}
			}
			for(i=0;i<xiaohao.size();i++)
			{
				System.out.println(xiaohao.get(i));
			}
		} catch (IOException e) {
		}

	}
}

