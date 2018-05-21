package demo.teamwork.aquidigital.repository.api.projectsmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MicrosoftConnectors implements Serializable {

	@SerializedName("enabled")
	private boolean enabled;

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	@Override
 	public String toString(){
		return 
			"MicrosoftConnectors{" + 
			"enabled = '" + enabled + '\'' + 
			"}";
		}
}