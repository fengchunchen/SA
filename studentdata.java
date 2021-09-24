package bigwork;

import java.util.Date;

public class studentdata {
	String ID;
	String USER;
	String PROBLEM;
	String RESULT;
	String SUBMITTIME;
	int trueID=0;
	public studentdata(String iD, String uSER, String pROBLEM, String rESULT, String sUBMITTIME, int trueID) {
		super();
		ID = iD;
		USER = uSER;
		PROBLEM = pROBLEM;
		RESULT = rESULT;
		SUBMITTIME = sUBMITTIME;
		this.trueID = trueID;
	}
	public void set(String id,String user,String problem,String result,String submittime)
	{
		ID=id;
		USER=user;
		PROBLEM=problem;
		RESULT=result;
		SUBMITTIME=submittime;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUSER() {
		return USER;
	}
	public void setUSER(String uSER) {
		USER = uSER;
	}
	public String getPROBLEM() {
		return PROBLEM;
	}
	public void setPROBLEM(String pROBLEM) {
		PROBLEM = pROBLEM;
	}
	public String getRESULT() {
		return RESULT;
	}
	public void setRESULT(String rESULT) {
		RESULT = rESULT;
	}
	public String getSUBMITTIME() {
		return SUBMITTIME;
	}
	public void setSUBMITTIME(String sUBMITTIME) {
		SUBMITTIME = sUBMITTIME;
	}
	public int getTrueID() {
		return trueID;
	}
	public void setTrueID(int trueID) {
		this.trueID = trueID;
	}
}
