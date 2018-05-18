package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.gson.annotations.SerializedName;

public class MicrosoftConnectors{

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