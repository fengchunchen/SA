package bigwork;
/*class T
{
	int submittime=0;
	int wrongtime=0;
	int accesstime=0;
	public int getSubmittime() {
		return submittime;
	}
	public void setSubmittime(int submittime) {
		this.submittime = submittime;
	}
	public int getWrongtime() {
		return wrongtime;
	}
	public void setWrongtime(int wrongtime) {
		this.wrongtime = wrongtime;
	}
	public int getAccesstime() {
		return accesstime;
	}
	public void setAccesstime(int accesstime) {
		this.accesstime = accesstime;
	}
}*/
public class student {
	String USER;
	int actime=0;
	int wrtime=0;
	int a=0;
	int b=0;
	int c=0;
	int d=0;
	int e=0;
	int f=0;
	int g=0;
	double tt[]= {0,0,0,0,0,0,0,0};
	double t=0;
	
	public double[] getTt() {
		return tt;
	}
	public void setTt(double[] tt) {
		this.tt = tt;
	}
	public int getActime() {
		actime=a+b+c+d+e+f+g;
		return actime;
	}
	public student(String uSER) {
		super();
		USER = uSER;
	}
	public String getUSER() {
		return USER;
	}
	public void setUSER(String uSER) {
		USER = uSER;
	}
	public int getWrtime() {
		return wrtime;
	}
	public void setWrtime(int wrtime) {
		this.wrtime = wrtime;
	}
	
		
}

