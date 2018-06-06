package demo.teamwork.aquidigital.people.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PeopleResponse{

	@SerializedName("STATUS")
	private String status;

	@SerializedName("people")
	private List<PeopleItem> people;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setPeople(List<PeopleItem> people){
		this.people = people;
	}

	public List<PeopleItem> getPeople(){
		return people;
	}

	@Override
 	public String toString(){
		return 
			"PeopleResponse{" + 
			"sTATUS = '" + status + '\'' +
			",people = '" + people + '\'' + 
			"}";
		}
}