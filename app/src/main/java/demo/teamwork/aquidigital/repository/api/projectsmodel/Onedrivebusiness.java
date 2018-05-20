package demo.teamwork.aquidigital.repository.api.projectsmodel;

import com.google.gson.annotations.SerializedName;

public class Onedrivebusiness{

	@SerializedName("folder")
	private String folder;

	@SerializedName("foldername")
	private String foldername;

	@SerializedName("enabled")
	private boolean enabled;

	@SerializedName("account")
	private String account;

	public void setFolder(String folder){
		this.folder = folder;
	}

	public String getFolder(){
		return folder;
	}

	public void setFoldername(String foldername){
		this.foldername = foldername;
	}

	public String getFoldername(){
		return foldername;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setAccount(String account){
		this.account = account;
	}

	public String getAccount(){
		return account;
	}

	@Override
 	public String toString(){
		return 
			"Onedrivebusiness{" + 
			"folder = '" + folder + '\'' + 
			",foldername = '" + foldername + '\'' + 
			",enabled = '" + enabled + '\'' + 
			",account = '" + account + '\'' + 
			"}";
		}
}