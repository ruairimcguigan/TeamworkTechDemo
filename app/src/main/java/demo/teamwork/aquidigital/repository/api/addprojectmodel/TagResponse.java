package demo.teamwork.aquidigital.repository.api.addprojectmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TagResponse {

	@SerializedName("tags")
	private List<TagsItem> tags;

	public void setTags(List<TagsItem> tags){
		this.tags = tags;
	}

	public List<TagsItem> getTags(){
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