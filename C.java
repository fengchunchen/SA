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

public class C {
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
			int j=0;
			ArrayList<Integer> time = new ArrayList<Integer>();
			time.add(0);
			ArrayList<Integer> actime = new ArrayList<Integer>();
			actime.add(0);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d H:m");
			Date date = dateFormat.parse(list1.get(n-1).getSUBMITTIME());
			for (i = n-1 ; i >=1; ) {
				Calendar calendar = Calendar.getInstance();
				Date date1 = dateFormat.parse(list1.get(i).getSUBMITTIME());
				long jiange=date1.getTime()-date.getTime();
				//System.out.println(jiange);
				
				if(jiange>3600000)
				{
					date.setHours(date.getHours()+1);
					j++;
					time.add(0);
					actime.add(0);
					continue;
				}
				String s1=list1.get(i).getRESULT().substring(0, 3);
				if(s1.equals("Acc")||s1.equals("*Ac"))
				{
					actime.set(j, actime.get(j)+1);
				}
				time.set(j, time.get(j)+1);
				i--;
			}
			for(i=0;i<time.size();i++)
			{
				//System.out.println("第"+(i+1)+"个小时："+time.get(i)+"   "+"次");
				System.out.println(time.get(i)+" "+actime.get(i));
			}
		} catch (IOException e) {
		}
	}
}
