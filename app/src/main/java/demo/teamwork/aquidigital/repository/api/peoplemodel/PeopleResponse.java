package demo.teamwork.aquidigital.repository.api.peoplemodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PeopleResponse{

	@SerializedName("STATUS")
	private String sTATUS;

	@SerializedName("people")
	private List<PeopleItem> people;

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
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
			"sTATUS = '" + sTATUS + '\'' + 
			",people = '" + people + '\'' + 
			"}";
		}
}