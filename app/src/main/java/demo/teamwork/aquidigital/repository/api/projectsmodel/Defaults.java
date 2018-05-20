package demo.teamwork.aquidigital.repository.api.projectsmodel;

import com.google.gson.annotations.SerializedName;

public class Defaults{

	@SerializedName("privacy")
	private String privacy;

	public void setPrivacy(String privacy){
		this.privacy = privacy;
	}

	public String getPrivacy(){
		return privacy;
	}

	@Override
 	public String toString(){
		return 
			"Defaults{" + 
			"privacy = '" + privacy + '\'' + 
			"}";
		}
}