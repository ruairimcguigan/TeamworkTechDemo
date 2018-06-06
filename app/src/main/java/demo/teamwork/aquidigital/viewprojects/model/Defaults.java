package demo.teamwork.aquidigital.viewprojects.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Defaults implements Serializable {

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