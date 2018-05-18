package demo.teamwork.aquidigital.repository.api.apimodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("STATUS")
	private String sTATUS;

	@SerializedName("projects")
	private List<Project> projects;

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
	}

	public void setProjects(List<Project> projects){
		this.projects = projects;
	}

	public List<Project> getProjects(){
		return projects;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"sTATUS = '" + sTATUS + '\'' + 
			",projects = '" + projects + '\'' + 
			"}";
		}
}