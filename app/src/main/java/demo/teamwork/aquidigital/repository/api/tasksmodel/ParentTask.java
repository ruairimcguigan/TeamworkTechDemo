package demo.teamwork.aquidigital.repository.api.tasksmodel;

import com.google.gson.annotations.SerializedName;

public class ParentTask{

	@SerializedName("id")
	private String id;

	@SerializedName("content")
	private String content;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"ParentTask{" + 
			"id = '" + id + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}