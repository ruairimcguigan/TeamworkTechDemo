package demo.teamwork.aquidigital.viewprojects.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Company implements Serializable {

	@SerializedName("is-owner")
	private String isOwner;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setIsOwner(String isOwner){
		this.isOwner = isOwner;
	}

	public String getIsOwner(){
		return isOwner;
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
			"Company{" + 
			"is-owner = '" + isOwner + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}