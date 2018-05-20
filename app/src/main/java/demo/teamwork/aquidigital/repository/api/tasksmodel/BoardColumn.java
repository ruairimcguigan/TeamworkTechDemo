package demo.teamwork.aquidigital.repository.api.tasksmodel;

import com.google.gson.annotations.SerializedName;

public class BoardColumn{

	@SerializedName("color")
	private String color;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"BoardColumn{" + 
			"color = '" + color + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}