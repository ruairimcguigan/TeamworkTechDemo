package demo.teamwork.aquidigital.repository.api.projectsmodel;

import com.google.gson.annotations.SerializedName;

public class Xero{

	@SerializedName("connected")
	private String connected;

	@SerializedName("basecurrency")
	private String basecurrency;

	@SerializedName("countrycode")
	private String countrycode;

	@SerializedName("organisation")
	private String organisation;

	@SerializedName("enabled")
	private boolean enabled;

	public void setConnected(String connected){
		this.connected = connected;
	}

	public String getConnected(){
		return connected;
	}

	public void setBasecurrency(String basecurrency){
		this.basecurrency = basecurrency;
	}

	public String getBasecurrency(){
		return basecurrency;
	}

	public void setCountrycode(String countrycode){
		this.countrycode = countrycode;
	}

	public String getCountrycode(){
		return countrycode;
	}

	public void setOrganisation(String organisation){
		this.organisation = organisation;
	}

	public String getOrganisation(){
		return organisation;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	@Override
 	public String toString(){
		return 
			"Xero{" + 
			"connected = '" + connected + '\'' + 
			",basecurrency = '" + basecurrency + '\'' + 
			",countrycode = '" + countrycode + '\'' + 
			",organisation = '" + organisation + '\'' + 
			",enabled = '" + enabled + '\'' + 
			"}";
		}
}