package bigwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class make{
	String name;
	int copytime=0;
	int givetime=0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public make(String name, int copytime, int givetime) {
		super();
		this.name = name;
		this.copytime = copytime;
		this.givetime = givetime;
	}
	public make(String name) {
		super();
		this.name = name;
	}
	public int getCopytime() {
		return copytime;
	}
	public void addCopytime() {
		this.copytime ++;
	}
	public int getGivetime() {
		return givetime;
	}
	public void addGivetime() {
		this.givetime ++;
	}
	
}
public class D {
	public static void main(String args[]) throws Exception {
		ArrayList<studentdata> list1 = new ArrayList<studentdata>();
		ArrayList<student> list2 = new ArrayList<student>();
		ArrayList<friends> friend = new ArrayList<friends>();
		ArrayList<make> maker = new ArrayList<make>();
		Scanner cin = new Scanner(System.in);
		try {
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
			int a[] = { 0, 0, 0, 0, 0, 0, 0 };
			for (i = 1; i < n; i++) {
				for (j = 1; j < m; j++) {
					if (list1.get(i).getUSER().equals(list2.get(j).getUSER())) {
						list1.get(i).setTrueID(j);
					}
				}

				String s1 = list1.get(i).getRESULT().substring(0, 3);
				if (s1.equals("*Ac")) {
					String s2 = list1.get(i).getRESULT().substring(9, 13);
					for (int k = 1; k < n; k++) {
						if (list1.get(k).getID().equals(s2)) {
							friends f = new friends(list1.get(k).getUSER(), list1.get(i).getUSER(),
									list1.get(i).getPROBLEM());
							friend.add(f);
						}
					}
				}
			}
			for (i = 0; i < friend.size(); i++) {
				if (friend.get(i).getT().equals("A")) {
					a[0]++;
				}
				if (friend.get(i).getT().equals("B")) {
					a[1]++;
				}
				if (friend.get(i).getT().equals("C")) {
					a[2]++;
				}
				if (friend.get(i).getT().equals("D")) {
					a[3]++;
				}
				if (friend.get(i).getT().equals("E")) {
					a[4]++;
				}
				if (friend.get(i).getT().equals("F")) {
					a[5]++;
				}
				if (friend.get(i).getT().equals("G")) {
					a[6]++;
				}
				//System.out.println(friend.get(i).getCopyer()+"抄袭了"+friend.get(i).getFrom()+"的"+friend.get(i).getT()+"题");
				//System.out.println("{source : '"+friend.get(i).getFrom().substring(0, 4)+"', target : '"+friend.get(i).getCopyer().substring(0, 4)+"', weight : 10},");
				System.out.println("{source: '"+friend.get(i).getFrom().substring(0, 4)+"',target: '"+friend.get(i).getCopyer().substring(0, 4)+"',lineStyle: {normal: {width: 5,curveness: 0.2} }},");
			}
			int k=0;
			for (i = 0; i < friend.size(); i++) {
                int aa=0;
                int bb=0;
				for( k=0;k<maker.size();k++)
				{
					if(friend.get(i).getFrom().equals(maker.get(k).getName()))
					{
						aa=1;
					    maker.get(k).addGivetime();
					}
					if(friend.get(i).getCopyer().equals(maker.get(k).getName()))
					{
						bb=1;
						maker.get(k).addCopytime();
					}
				}
				if(aa==0)
				{
					make aaa=new make(friend.get(i).getFrom());
					maker.add(aaa);
					maker.get(maker.size()-1).addGivetime();
				}
				if(bb==0)
				{
					make bbb=new make(friend.get(i).getCopyer());
					maker.add(bbb);
					maker.get(maker.size()-1).addCopytime();
				}
				
			}
			int jj=0;
			int kk=0;
			for(i=0;i<maker.size();i++)
			{
				int jieguo = 0;
				String jie="";
				if(maker.get(i).getGivetime()>0&&maker.get(i).getCopytime()>0)
				{
					jieguo=0;
					jie="被别人抄袭也抄袭别人";
				}
				if(maker.get(i).getGivetime()>0&&maker.get(i).getCopytime()==0)
				{
					jieguo=1;
					jie="只被别人抄袭";
				}if(maker.get(i).getGivetime()==0&&maker.get(i).getCopytime()>0)
				{
					jieguo=2;
					jie="只抄袭别人";
					
				}
				System.out.println("{name: '"+maker.get(i).getName().substring(0, 4)+"',x: "+jj+",y: "+kk+"},");
				jj++;
				if(jj>7)
				{
					kk++;
					jj=0;
				}
				//System.out.println("{category:"+jieguo+", name: '"+maker.get(i).getName().substring(0, 4)+"',value :"+(maker.get(i).getCopytime()+maker.get(i).getGivetime())+" },");
				//System.out.println("学号："+maker.get(i).getName().substring(0, 4)+"   交易次数："+(maker.get(i).getCopytime()+maker.get(i).getGivetime())+"   抄袭类型："+jie);
			}
			for (i = 0; i < 7; i++)
				System.out.println(a[i]);
		} catch (IOException e) {
		}
	}
}
