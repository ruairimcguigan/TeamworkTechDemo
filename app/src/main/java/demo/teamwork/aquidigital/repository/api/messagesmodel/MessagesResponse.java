package demo.teamwork.aquidigital.repository.api.messagesmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MessagesResponse{

	@SerializedName("STATUS")
	private String sTATUS;

	@SerializedName("posts")
	private List<PostsItem> posts;

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
	}

	public void setPosts(List<PostsItem> posts){
		this.posts = posts;
	}

	public List<PostsItem> getPosts(){
		return posts;
	}

	@Override
 	public String toString(){
		return 
			"MessagesResponse{" + 
			"sTATUS = '" + sTATUS + '\'' + 
			",posts = '" + posts + '\'' + 
			"}";
		}
}