package demo.teamwork.aquidigital.repository.api.projectsmodel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProjectsResponse implements Serializable{

	@SerializedName("STATUS")
	private String status;

	@SerializedName("projects")
	private List<Project> projects;

	public void setStatus(String status){
		this.status = status;
	}

	public String getSTATUS(){
		return status;
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
			"status = '" + status + '\'' +
			",projects = '" + projects + '\'' + 
			"}";
		}
}