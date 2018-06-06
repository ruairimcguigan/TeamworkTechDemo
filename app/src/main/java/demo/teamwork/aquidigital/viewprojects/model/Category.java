package demo.teamwork.aquidigital.viewprojects.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category implements Serializable {

	@SerializedName("color")
	private String color;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
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
			"Category{" + 
			"color = '" + color + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}