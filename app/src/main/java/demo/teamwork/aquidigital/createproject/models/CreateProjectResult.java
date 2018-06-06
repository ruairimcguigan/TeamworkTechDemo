package demo.teamwork.aquidigital.createproject.models;

import com.google.gson.annotations.SerializedName;

public class CreateProjectResult{

	@SerializedName("STATUS")
	private String status;

	public void setStatus(String status){
		this.status = status;
	}

	public String getSTATUS(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"CreateProjectResult{" + 
			"sTATUS = '" + status + '\'' +
			"}";
		}
}