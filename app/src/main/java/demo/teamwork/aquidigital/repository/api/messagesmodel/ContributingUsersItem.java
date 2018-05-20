package demo.teamwork.aquidigital.repository.api.messagesmodel;

import com.google.gson.annotations.SerializedName;

public class ContributingUsersItem{

	@SerializedName("avatarURL")
	private String avatarURL;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setAvatarURL(String avatarURL){
		this.avatarURL = avatarURL;
	}

	public String getAvatarURL(){
		return avatarURL;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ContributingUsersItem{" + 
			"avatarURL = '" + avatarURL + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}