package demo.teamwork.aquidigital.repository.api.addprojectmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TagResponse {

	@SerializedName("tags")
	private List<TagItem> tags;

	public void setTags(List<TagItem> tags){
		this.tags = tags;
	}

	public List<TagItem> getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"Tag{" + 
			"tags = '" + tags + '\'' + 
			"}";
		}
}