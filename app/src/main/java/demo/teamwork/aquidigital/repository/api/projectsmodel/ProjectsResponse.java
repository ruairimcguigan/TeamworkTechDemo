package demo.teamwork.aquidigital.repository.api.projectsmodel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProjectsResponse implements Serializable{

	@SerializedName("STATUS")
	private String status;

	@SerializedName("projects")
	private List<ProjectItem> projectItems;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setProjectItems(List<ProjectItem> projectItems){
		this.projectItems = projectItems;
	}

	public List<ProjectItem> getProjects(){
		return projectItems;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"status = '" + status + '\'' +
			",projects = '" + projectItems + '\'' +
			"}";
		}
}