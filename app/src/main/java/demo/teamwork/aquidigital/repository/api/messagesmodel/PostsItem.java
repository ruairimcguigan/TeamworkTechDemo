package demo.teamwork.aquidigital.repository.api.messagesmodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PostsItem{

	@SerializedName("private")
	private String jsonMemberPrivate;

	@SerializedName("project-name")
	private String projectName;

	@SerializedName("posted-on")
	private String postedOn;

	@SerializedName("contributingUsers")
	private List<ContributingUsersItem> contributingUsers;

	@SerializedName("post-id")
	private String postId;

	@SerializedName("followerIds")
	private String followerIds;

	@SerializedName("isRead")
	private String isRead;

	@SerializedName("user-display-posted-date")
	private String userDisplayPostedDate;

	@SerializedName("body")
	private String body;

	@SerializedName("title")
	private String title;

	@SerializedName("milestone-id")
	private String milestoneId;

	@SerializedName("html-body")
	private String htmlBody;

	@SerializedName("category-name")
	private String categoryName;

	@SerializedName("last-comment-date")
	private String lastCommentDate;

	@SerializedName("author-first-name")
	private String authorFirstName;

	@SerializedName("content-type")
	private String contentType;

	@SerializedName("id")
	private String id;

	@SerializedName("attachments-count")
	private String attachmentsCount;

	@SerializedName("project-id")
	private String projectId;

	@SerializedName("company-name")
	private String companyName;

	@SerializedName("user-display-posted-time")
	private String userDisplayPostedTime;

	@SerializedName("comments-count")
	private String commentsCount;

	@SerializedName("author-last-name")
	private String authorLastName;

	@SerializedName("category-id")
	private String categoryId;

	@SerializedName("author-avatar-url")
	private String authorAvatarUrl;

	@SerializedName("author-id")
	private String authorId;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("isOriginal")
	private String isOriginal;

	@SerializedName("category-color")
	private String categoryColor;

	@SerializedName("userFollowing")
	private boolean userFollowing;

	@SerializedName("last-changed-on")
	private String lastChangedOn;

	public void setJsonMemberPrivate(String jsonMemberPrivate){
		this.jsonMemberPrivate = jsonMemberPrivate;
	}

	public String getJsonMemberPrivate(){
		return jsonMemberPrivate;
	}

	public void setProjectName(String projectName){
		this.projectName = projectName;
	}

	public String getProjectName(){
		return projectName;
	}

	public void setPostedOn(String postedOn){
		this.postedOn = postedOn;
	}

	public String getPostedOn(){
		return postedOn;
	}

	public void setContributingUsers(List<ContributingUsersItem> contributingUsers){
		this.contributingUsers = contributingUsers;
	}

	public List<ContributingUsersItem> getContributingUsers(){
		return contributingUsers;
	}

	public void setPostId(String postId){
		this.postId = postId;
	}

	public String getPostId(){
		return postId;
	}

	public void setFollowerIds(String followerIds){
		this.followerIds = followerIds;
	}

	public String getFollowerIds(){
		return followerIds;
	}

	public void setIsRead(String isRead){
		this.isRead = isRead;
	}

	public String getIsRead(){
		return isRead;
	}

	public void setUserDisplayPostedDate(String userDisplayPostedDate){
		this.userDisplayPostedDate = userDisplayPostedDate;
	}

	public String getUserDisplayPostedDate(){
		return userDisplayPostedDate;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setMilestoneId(String milestoneId){
		this.milestoneId = milestoneId;
	}

	public String getMilestoneId(){
		return milestoneId;
	}

	public void setHtmlBody(String htmlBody){
		this.htmlBody = htmlBody;
	}

	public String getHtmlBody(){
		return htmlBody;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return categoryName;
	}

	public void setLastCommentDate(String lastCommentDate){
		this.lastCommentDate = lastCommentDate;
	}

	public String getLastCommentDate(){
		return lastCommentDate;
	}

	public void setAuthorFirstName(String authorFirstName){
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorFirstName(){
		return authorFirstName;
	}

	public void setContentType(String contentType){
		this.contentType = contentType;
	}

	public String getContentType(){
		return contentType;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAttachmentsCount(String attachmentsCount){
		this.attachmentsCount = attachmentsCount;
	}

	public String getAttachmentsCount(){
		return attachmentsCount;
	}

	public void setProjectId(String projectId){
		this.projectId = projectId;
	}

	public String getProjectId(){
		return projectId;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setUserDisplayPostedTime(String userDisplayPostedTime){
		this.userDisplayPostedTime = userDisplayPostedTime;
	}

	public String getUserDisplayPostedTime(){
		return userDisplayPostedTime;
	}

	public void setCommentsCount(String commentsCount){
		this.commentsCount = commentsCount;
	}

	public String getCommentsCount(){
		return commentsCount;
	}

	public void setAuthorLastName(String authorLastName){
		this.authorLastName = authorLastName;
	}

	public String getAuthorLastName(){
		return authorLastName;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setAuthorAvatarUrl(String authorAvatarUrl){
		this.authorAvatarUrl = authorAvatarUrl;
	}

	public String getAuthorAvatarUrl(){
		return authorAvatarUrl;
	}

	public void setAuthorId(String authorId){
		this.authorId = authorId;
	}

	public String getAuthorId(){
		return authorId;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setIsOriginal(String isOriginal){
		this.isOriginal = isOriginal;
	}

	public String getIsOriginal(){
		return isOriginal;
	}

	public void setCategoryColor(String categoryColor){
		this.categoryColor = categoryColor;
	}

	public String getCategoryColor(){
		return categoryColor;
	}

	public void setUserFollowing(boolean userFollowing){
		this.userFollowing = userFollowing;
	}

	public boolean isUserFollowing(){
		return userFollowing;
	}

	public void setLastChangedOn(String lastChangedOn){
		this.lastChangedOn = lastChangedOn;
	}

	public String getLastChangedOn(){
		return lastChangedOn;
	}

	@Override
 	public String toString(){
		return 
			"PostsItem{" + 
			"private = '" + jsonMemberPrivate + '\'' + 
			",project-name = '" + projectName + '\'' + 
			",posted-on = '" + postedOn + '\'' + 
			",contributingUsers = '" + contributingUsers + '\'' + 
			",post-id = '" + postId + '\'' + 
			",followerIds = '" + followerIds + '\'' + 
			",isRead = '" + isRead + '\'' + 
			",user-display-posted-date = '" + userDisplayPostedDate + '\'' + 
			",body = '" + body + '\'' + 
			",title = '" + title + '\'' + 
			",milestone-id = '" + milestoneId + '\'' + 
			",html-body = '" + htmlBody + '\'' + 
			",category-name = '" + categoryName + '\'' + 
			",last-comment-date = '" + lastCommentDate + '\'' + 
			",author-first-name = '" + authorFirstName + '\'' + 
			",content-type = '" + contentType + '\'' + 
			",id = '" + id + '\'' + 
			",attachments-count = '" + attachmentsCount + '\'' + 
			",project-id = '" + projectId + '\'' + 
			",company-name = '" + companyName + '\'' + 
			",user-display-posted-time = '" + userDisplayPostedTime + '\'' + 
			",comments-count = '" + commentsCount + '\'' + 
			",author-last-name = '" + authorLastName + '\'' + 
			",category-id = '" + categoryId + '\'' + 
			",author-avatar-url = '" + authorAvatarUrl + '\'' + 
			",author-id = '" + authorId + '\'' + 
			",tags = '" + tags + '\'' + 
			",isOriginal = '" + isOriginal + '\'' + 
			",category-color = '" + categoryColor + '\'' + 
			",userFollowing = '" + userFollowing + '\'' + 
			",last-changed-on = '" + lastChangedOn + '\'' + 
			"}";
		}
}