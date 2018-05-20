package demo.teamwork.aquidigital.repository.api.projectsmodel;

import com.google.gson.annotations.SerializedName;

public class Integrations{

	@SerializedName("xero")
	private Xero xero;

	@SerializedName("onedrivebusiness")
	private Onedrivebusiness onedrivebusiness;

	@SerializedName("microsoftConnectors")
	private MicrosoftConnectors microsoftConnectors;

	public void setXero(Xero xero){
		this.xero = xero;
	}

	public Xero getXero(){
		return xero;
	}

	public void setOnedrivebusiness(Onedrivebusiness onedrivebusiness){
		this.onedrivebusiness = onedrivebusiness;
	}

	public Onedrivebusiness getOnedrivebusiness(){
		return onedrivebusiness;
	}

	public void setMicrosoftConnectors(MicrosoftConnectors microsoftConnectors){
		this.microsoftConnectors = microsoftConnectors;
	}

	public MicrosoftConnectors getMicrosoftConnectors(){
		return microsoftConnectors;
	}

	@Override
 	public String toString(){
		return 
			"Integrations{" + 
			"xero = '" + xero + '\'' + 
			",onedrivebusiness = '" + onedrivebusiness + '\'' + 
			",microsoftConnectors = '" + microsoftConnectors + '\'' + 
			"}";
		}
}