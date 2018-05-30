package demo.teamwork.aquidigital.repository.api.projectsmodel;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.repository.Item;

public class ProjectItem implements Item, Serializable {

	@SerializedName("replyByEmailEnabled")
	private boolean replyByEmailEnabled;

	@SerializedName("endDate")
	private String endDate;

	@SerializedName("created-on")
	private String createdOn;

	@SerializedName("announcementHTML")
	private String announcementHTML;

	@SerializedName("description")
	private String description;

	@SerializedName("overview-start-page")
	private String overviewStartPage;

	@SerializedName("boardData")
	private BoardData boardData;

	@SerializedName("starred")
	private boolean starred;

	@SerializedName("logo")
	private String logo;

	@SerializedName("company")
	private Company company;

	@SerializedName("id")
	private String id;

	@SerializedName("announcement")
	private String announcement;

	@SerializedName("tasks-start-page")
	private String tasksStartPage;

	@SerializedName("start-page")
	private String startPage;

	@SerializedName("notifyeveryone")
	private boolean notifyeveryone;

	@SerializedName("filesAutoNewVersion")
	private boolean filesAutoNewVersion;

	@SerializedName("subStatus")
	private String subStatus;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("privacyEnabled")
	private boolean privacyEnabled;

	@SerializedName("isProjectAdmin")
	private boolean isProjectAdmin;

	@SerializedName("defaultPrivacy")
	private String defaultPrivacy;

	@SerializedName("last-changed-on")
	private String lastChangedOn;

	@SerializedName("defaults")
	private Defaults defaults;

	@SerializedName("name")
	private String name;

	@SerializedName("show-announcement")
	private boolean showAnnouncement;

	@SerializedName("harvest-timers-enabled")
	private boolean harvestTimersEnabled;

	@SerializedName("category")
	private Category category;

	@SerializedName("integrations")
	private Integrations integrations;

	@SerializedName("startDate")
	private String startDate;

	@SerializedName("status")
	private String status;

	public void setReplyByEmailEnabled(boolean replyByEmailEnabled){
		this.replyByEmailEnabled = replyByEmailEnabled;
	}

	public boolean isReplyByEmailEnabled(){
		return replyByEmailEnabled;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setCreatedOn(String createdOn){
		this.createdOn = createdOn;
	}

	public String getCreatedOn(){
		return createdOn;
	}

	public void setAnnouncementHTML(String announcementHTML){
		this.announcementHTML = announcementHTML;
	}

	public String getAnnouncementHTML(){
		return announcementHTML;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setOverviewStartPage(String overviewStartPage){
		this.overviewStartPage = overviewStartPage;
	}

	public String getOverviewStartPage(){
		return overviewStartPage;
	}

	public void setBoardData(BoardData boardData){
		this.boardData = boardData;
	}

	public BoardData getBoardData(){
		return boardData;
	}

	public void setStarred(boolean starred){
		this.starred = starred;
	}

	public boolean isStarred(){
		return starred;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setCompany(Company company){
		this.company = company;
	}

	public Company getCompany(){
		return company;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAnnouncement(String announcement){
		this.announcement = announcement;
	}

	public String getAnnouncement(){
		return announcement;
	}

	public void setTasksStartPage(String tasksStartPage){
		this.tasksStartPage = tasksStartPage;
	}

	public String getTasksStartPage(){
		return tasksStartPage;
	}

	public void setStartPage(String startPage){
		this.startPage = startPage;
	}

	public String getStartPage(){
		return startPage;
	}

	public void setNotifyeveryone(boolean notifyeveryone){
		this.notifyeveryone = notifyeveryone;
	}

	public boolean isNotifyeveryone(){
		return notifyeveryone;
	}

	public void setFilesAutoNewVersion(boolean filesAutoNewVersion){
		this.filesAutoNewVersion = filesAutoNewVersion;
	}

	public boolean isFilesAutoNewVersion(){
		return filesAutoNewVersion;
	}

	public void setSubStatus(String subStatus){
		this.subStatus = subStatus;
	}

	public String getSubStatus(){
		return subStatus;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setPrivacyEnabled(boolean privacyEnabled){
		this.privacyEnabled = privacyEnabled;
	}

	public boolean isPrivacyEnabled(){
		return privacyEnabled;
	}

	public void setIsProjectAdmin(boolean isProjectAdmin){
		this.isProjectAdmin = isProjectAdmin;
	}

	public boolean isIsProjectAdmin(){
		return isProjectAdmin;
	}

	public void setDefaultPrivacy(String defaultPrivacy){
		this.defaultPrivacy = defaultPrivacy;
	}

	public String getDefaultPrivacy(){
		return defaultPrivacy;
	}

	public void setLastChangedOn(String lastChangedOn){
		this.lastChangedOn = lastChangedOn;
	}

	public String getLastChangedOn(){
		return lastChangedOn;
	}

	public void setDefaults(Defaults defaults){
		this.defaults = defaults;
	}

	public Defaults getDefaults(){
		return defaults;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setShowAnnouncement(boolean showAnnouncement){
		this.showAnnouncement = showAnnouncement;
	}

	public boolean isShowAnnouncement(){
		return showAnnouncement;
	}

	public void setHarvestTimersEnabled(boolean harvestTimersEnabled){
		this.harvestTimersEnabled = harvestTimersEnabled;
	}

	public boolean isHarvestTimersEnabled(){
		return harvestTimersEnabled;
	}

	public void setCategory(Category category){
		this.category = category;
	}

	public Category getCategory(){
		return category;
	}

	public void setIntegrations(Integrations integrations){
		this.integrations = integrations;
	}

	public Integrations getIntegrations(){
		return integrations;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ProjectsItem{" + 
			"replyByEmailEnabled = '" + replyByEmailEnabled + '\'' + 
			",endDate = '" + endDate + '\'' + 
			",created-on = '" + createdOn + '\'' + 
			",announcementHTML = '" + announcementHTML + '\'' + 
			",description = '" + description + '\'' + 
			",overview-start-page = '" + overviewStartPage + '\'' + 
			",boardData = '" + boardData + '\'' + 
			",starred = '" + starred + '\'' + 
			",logo = '" + logo + '\'' + 
			",company = '" + company + '\'' + 
			",id = '" + id + '\'' + 
			",announcement = '" + announcement + '\'' + 
			",tasks-start-page = '" + tasksStartPage + '\'' + 
			",start-page = '" + startPage + '\'' + 
			",notifyeveryone = '" + notifyeveryone + '\'' + 
			",filesAutoNewVersion = '" + filesAutoNewVersion + '\'' + 
			",subStatus = '" + subStatus + '\'' + 
			",tags = '" + tags + '\'' + 
			",privacyEnabled = '" + privacyEnabled + '\'' + 
			",isProjectAdmin = '" + isProjectAdmin + '\'' + 
			",defaultPrivacy = '" + defaultPrivacy + '\'' + 
			",last-changed-on = '" + lastChangedOn + '\'' + 
			",defaults = '" + defaults + '\'' + 
			",name = '" + name + '\'' + 
			",show-announcement = '" + showAnnouncement + '\'' + 
			",harvest-timers-enabled = '" + harvestTimersEnabled + '\'' + 
			",category = '" + category + '\'' + 
			",integrations = '" + integrations + '\'' + 
			",startDate = '" + startDate + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}