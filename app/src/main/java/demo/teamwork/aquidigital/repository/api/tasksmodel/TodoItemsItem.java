package demo.teamwork.aquidigital.repository.api.tasksmodel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import demo.teamwork.aquidigital.repository.Item;

public class TodoItemsItem implements Serializable, Item{

	@SerializedName("project-name")
	private String projectName;

	@SerializedName("responsible-party-lastname")
	private String responsiblePartyLastname;

	@SerializedName("predecessors")
	private List<PredecessorsItem> predecessors;

	@SerializedName("creator-firstname")
	private String creatorFirstname;

	@SerializedName("timeIsLogged")
	private String timeIsLogged;

	@SerializedName("parent-task")
	private ParentTask parentTask;

	@SerializedName("responsible-party-names")
	private String responsiblePartyNames;

	@SerializedName("responsible-party-summary")
	private String responsiblePartySummary;

	@SerializedName("company-id")
	private int companyId;

	@SerializedName("due-date-base")
	private String dueDateBase;

	@SerializedName("creator-lastname")
	private String creatorLastname;

	@SerializedName("userFollowingChanges")
	private boolean userFollowingChanges;

	@SerializedName("commentFollowerIds")
	private String commentFollowerIds;

	@SerializedName("id")
	private int id;

	@SerializedName("harvest-enabled")
	private boolean harvestEnabled;

	@SerializedName("order")
	private int order;

	@SerializedName("todo-list-name")
	private String todoListName;

	@SerializedName("company-name")
	private String companyName;

	@SerializedName("estimated-minutes")
	private int estimatedMinutes;

	@SerializedName("hasTickets")
	private boolean hasTickets;

	@SerializedName("changeFollowerSummary")
	private String changeFollowerSummary;

	@SerializedName("lockdownId")
	private String lockdownId;

	@SerializedName("comments-count")
	private int commentsCount;

	@SerializedName("completed")
	private boolean completed;

	@SerializedName("priority")
	private String priority;

	@SerializedName("responsible-party-firstname")
	private String responsiblePartyFirstname;

	@SerializedName("last-changed-on")
	private String lastChangedOn;

	@SerializedName("responsible-party-id")
	private String responsiblePartyId;

	@SerializedName("position")
	private int position;

	@SerializedName("has-reminders")
	private boolean hasReminders;

	@SerializedName("status")
	private String status;

	@SerializedName("private")
	private int jsonMemberPrivate;

	@SerializedName("userFollowingComments")
	private boolean userFollowingComments;

	@SerializedName("DLM")
	private int dLM;

	@SerializedName("created-on")
	private String createdOn;

	@SerializedName("parentTaskId")
	private String parentTaskId;

	@SerializedName("canEdit")
	private boolean canEdit;

	@SerializedName("description")
	private String description;

	@SerializedName("start-date")
	private String startDate;

	@SerializedName("has-predecessors")
	private int hasPredecessors;

	@SerializedName("responsible-party-type")
	private String responsiblePartyType;

	@SerializedName("content")
	private String content;

	@SerializedName("todo-list-id")
	private int todoListId;

	@SerializedName("responsible-party-ids")
	private String responsiblePartyIds;

	@SerializedName("due-date")
	private String dueDate;

	@SerializedName("attachments-count")
	private int attachmentsCount;

	@SerializedName("project-id")
	private int projectId;

	@SerializedName("commentFollowerSummary")
	private String commentFollowerSummary;

	@SerializedName("tasklist-isTemplate")
	private boolean tasklistIsTemplate;

	@SerializedName("canComplete")
	private boolean canComplete;

	@SerializedName("creator-id")
	private int creatorId;

	@SerializedName("has-dependencies")
	private int hasDependencies;

	@SerializedName("canLogTime")
	private boolean canLogTime;

	@SerializedName("tasklist-private")
	private boolean tasklistPrivate;

	@SerializedName("changeFollowerIds")
	private String changeFollowerIds;

	@SerializedName("has-unread-comments")
	private boolean hasUnreadComments;

	@SerializedName("tasklist-lockdownId")
	private String tasklistLockdownId;

	@SerializedName("viewEstimatedTime")
	private boolean viewEstimatedTime;

	@SerializedName("boardColumn")
	private BoardColumn boardColumn;

	@SerializedName("progress")
	private int progress;

	@SerializedName("creator-avatar-url")
	private String creatorAvatarUrl;

	public void setProjectName(String projectName){
		this.projectName = projectName;
	}

	public String getProjectName(){
		return projectName;
	}

	public void setResponsiblePartyLastname(String responsiblePartyLastname){
		this.responsiblePartyLastname = responsiblePartyLastname;
	}

	public String getResponsiblePartyLastname(){
		return responsiblePartyLastname;
	}

	public void setPredecessors(List<PredecessorsItem> predecessors){
		this.predecessors = predecessors;
	}

	public List<PredecessorsItem> getPredecessors(){
		return predecessors;
	}

	public void setCreatorFirstname(String creatorFirstname){
		this.creatorFirstname = creatorFirstname;
	}

	public String getCreatorFirstname(){
		return creatorFirstname;
	}

	public void setTimeIsLogged(String timeIsLogged){
		this.timeIsLogged = timeIsLogged;
	}

	public String getTimeIsLogged(){
		return timeIsLogged;
	}

	public void setParentTask(ParentTask parentTask){
		this.parentTask = parentTask;
	}

	public ParentTask getParentTask(){
		return parentTask;
	}

	public void setResponsiblePartyNames(String responsiblePartyNames){
		this.responsiblePartyNames = responsiblePartyNames;
	}

	public String getResponsiblePartyNames(){
		return responsiblePartyNames;
	}

	public void setResponsiblePartySummary(String responsiblePartySummary){
		this.responsiblePartySummary = responsiblePartySummary;
	}

	public String getResponsiblePartySummary(){
		return responsiblePartySummary;
	}

	public void setCompanyId(int companyId){
		this.companyId = companyId;
	}

	public int getCompanyId(){
		return companyId;
	}

	public void setDueDateBase(String dueDateBase){
		this.dueDateBase = dueDateBase;
	}

	public String getDueDateBase(){
		return dueDateBase;
	}

	public void setCreatorLastname(String creatorLastname){
		this.creatorLastname = creatorLastname;
	}

	public String getCreatorLastname(){
		return creatorLastname;
	}

	public void setUserFollowingChanges(boolean userFollowingChanges){
		this.userFollowingChanges = userFollowingChanges;
	}

	public boolean isUserFollowingChanges(){
		return userFollowingChanges;
	}

	public void setCommentFollowerIds(String commentFollowerIds){
		this.commentFollowerIds = commentFollowerIds;
	}

	public String getCommentFollowerIds(){
		return commentFollowerIds;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setHarvestEnabled(boolean harvestEnabled){
		this.harvestEnabled = harvestEnabled;
	}

	public boolean isHarvestEnabled(){
		return harvestEnabled;
	}

	public void setOrder(int order){
		this.order = order;
	}

	public int getOrder(){
		return order;
	}

	public void setTodoListName(String todoListName){
		this.todoListName = todoListName;
	}

	public String getTodoListName(){
		return todoListName;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setEstimatedMinutes(int estimatedMinutes){
		this.estimatedMinutes = estimatedMinutes;
	}

	public int getEstimatedMinutes(){
		return estimatedMinutes;
	}

	public void setHasTickets(boolean hasTickets){
		this.hasTickets = hasTickets;
	}

	public boolean isHasTickets(){
		return hasTickets;
	}

	public void setChangeFollowerSummary(String changeFollowerSummary){
		this.changeFollowerSummary = changeFollowerSummary;
	}

	public String getChangeFollowerSummary(){
		return changeFollowerSummary;
	}

	public void setLockdownId(String lockdownId){
		this.lockdownId = lockdownId;
	}

	public String getLockdownId(){
		return lockdownId;
	}

	public void setCommentsCount(int commentsCount){
		this.commentsCount = commentsCount;
	}

	public int getCommentsCount(){
		return commentsCount;
	}

	public void setCompleted(boolean completed){
		this.completed = completed;
	}

	public boolean isCompleted(){
		return completed;
	}

	public void setPriority(String priority){
		this.priority = priority;
	}

	public String getPriority(){
		return priority;
	}

	public void setResponsiblePartyFirstname(String responsiblePartyFirstname){
		this.responsiblePartyFirstname = responsiblePartyFirstname;
	}

	public String getResponsiblePartyFirstname(){
		return responsiblePartyFirstname;
	}

	public void setLastChangedOn(String lastChangedOn){
		this.lastChangedOn = lastChangedOn;
	}

	public String getLastChangedOn(){
		return lastChangedOn;
	}

	public void setResponsiblePartyId(String responsiblePartyId){
		this.responsiblePartyId = responsiblePartyId;
	}

	public String getResponsiblePartyId(){
		return responsiblePartyId;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public int getPosition(){
		return position;
	}

	public void setHasReminders(boolean hasReminders){
		this.hasReminders = hasReminders;
	}

	public boolean isHasReminders(){
		return hasReminders;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setJsonMemberPrivate(int jsonMemberPrivate){
		this.jsonMemberPrivate = jsonMemberPrivate;
	}

	public int getJsonMemberPrivate(){
		return jsonMemberPrivate;
	}

	public void setUserFollowingComments(boolean userFollowingComments){
		this.userFollowingComments = userFollowingComments;
	}

	public boolean isUserFollowingComments(){
		return userFollowingComments;
	}

	public void setDLM(int dLM){
		this.dLM = dLM;
	}

	public int getDLM(){
		return dLM;
	}

	public void setCreatedOn(String createdOn){
		this.createdOn = createdOn;
	}

	public String getCreatedOn(){
		return createdOn;
	}

	public void setParentTaskId(String parentTaskId){
		this.parentTaskId = parentTaskId;
	}

	public String getParentTaskId(){
		return parentTaskId;
	}

	public void setCanEdit(boolean canEdit){
		this.canEdit = canEdit;
	}

	public boolean isCanEdit(){
		return canEdit;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setHasPredecessors(int hasPredecessors){
		this.hasPredecessors = hasPredecessors;
	}

	public int getHasPredecessors(){
		return hasPredecessors;
	}

	public void setResponsiblePartyType(String responsiblePartyType){
		this.responsiblePartyType = responsiblePartyType;
	}

	public String getResponsiblePartyType(){
		return responsiblePartyType;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	public void setTodoListId(int todoListId){
		this.todoListId = todoListId;
	}

	public int getTodoListId(){
		return todoListId;
	}

	public void setResponsiblePartyIds(String responsiblePartyIds){
		this.responsiblePartyIds = responsiblePartyIds;
	}

	public String getResponsiblePartyIds(){
		return responsiblePartyIds;
	}

	public void setDueDate(String dueDate){
		this.dueDate = dueDate;
	}

	public String getDueDate(){
		return dueDate;
	}

	public void setAttachmentsCount(int attachmentsCount){
		this.attachmentsCount = attachmentsCount;
	}

	public int getAttachmentsCount(){
		return attachmentsCount;
	}

	public void setProjectId(int projectId){
		this.projectId = projectId;
	}

	public int getProjectId(){
		return projectId;
	}

	public void setCommentFollowerSummary(String commentFollowerSummary){
		this.commentFollowerSummary = commentFollowerSummary;
	}

	public String getCommentFollowerSummary(){
		return commentFollowerSummary;
	}

	public void setTasklistIsTemplate(boolean tasklistIsTemplate){
		this.tasklistIsTemplate = tasklistIsTemplate;
	}

	public boolean isTasklistIsTemplate(){
		return tasklistIsTemplate;
	}

	public void setCanComplete(boolean canComplete){
		this.canComplete = canComplete;
	}

	public boolean isCanComplete(){
		return canComplete;
	}

	public void setCreatorId(int creatorId){
		this.creatorId = creatorId;
	}

	public int getCreatorId(){
		return creatorId;
	}

	public void setHasDependencies(int hasDependencies){
		this.hasDependencies = hasDependencies;
	}

	public int getHasDependencies(){
		return hasDependencies;
	}

	public void setCanLogTime(boolean canLogTime){
		this.canLogTime = canLogTime;
	}

	public boolean isCanLogTime(){
		return canLogTime;
	}

	public void setTasklistPrivate(boolean tasklistPrivate){
		this.tasklistPrivate = tasklistPrivate;
	}

	public boolean isTasklistPrivate(){
		return tasklistPrivate;
	}

	public void setChangeFollowerIds(String changeFollowerIds){
		this.changeFollowerIds = changeFollowerIds;
	}

	public String getChangeFollowerIds(){
		return changeFollowerIds;
	}

	public void setHasUnreadComments(boolean hasUnreadComments){
		this.hasUnreadComments = hasUnreadComments;
	}

	public boolean isHasUnreadComments(){
		return hasUnreadComments;
	}

	public void setTasklistLockdownId(String tasklistLockdownId){
		this.tasklistLockdownId = tasklistLockdownId;
	}

	public String getTasklistLockdownId(){
		return tasklistLockdownId;
	}

	public void setViewEstimatedTime(boolean viewEstimatedTime){
		this.viewEstimatedTime = viewEstimatedTime;
	}

	public boolean isViewEstimatedTime(){
		return viewEstimatedTime;
	}

	public void setBoardColumn(BoardColumn boardColumn){
		this.boardColumn = boardColumn;
	}

	public BoardColumn getBoardColumn(){
		return boardColumn;
	}

	public void setProgress(int progress){
		this.progress = progress;
	}

	public int getProgress(){
		return progress;
	}

	public void setCreatorAvatarUrl(String creatorAvatarUrl){
		this.creatorAvatarUrl = creatorAvatarUrl;
	}

	public String getCreatorAvatarUrl(){
		return creatorAvatarUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TodoItemsItem)) return false;
		TodoItemsItem that = (TodoItemsItem) o;
		return companyId == that.companyId &&
				userFollowingChanges == that.userFollowingChanges &&
				id == that.id &&
				harvestEnabled == that.harvestEnabled &&
				order == that.order &&
				estimatedMinutes == that.estimatedMinutes &&
				hasTickets == that.hasTickets &&
				commentsCount == that.commentsCount &&
				completed == that.completed &&
				position == that.position &&
				hasReminders == that.hasReminders &&
				jsonMemberPrivate == that.jsonMemberPrivate &&
				userFollowingComments == that.userFollowingComments &&
				dLM == that.dLM &&
				canEdit == that.canEdit &&
				hasPredecessors == that.hasPredecessors &&
				todoListId == that.todoListId &&
				attachmentsCount == that.attachmentsCount &&
				projectId == that.projectId &&
				tasklistIsTemplate == that.tasklistIsTemplate &&
				canComplete == that.canComplete &&
				creatorId == that.creatorId &&
				hasDependencies == that.hasDependencies &&
				canLogTime == that.canLogTime &&
				tasklistPrivate == that.tasklistPrivate &&
				hasUnreadComments == that.hasUnreadComments &&
				viewEstimatedTime == that.viewEstimatedTime &&
				progress == that.progress &&
				Objects.equals(projectName, that.projectName) &&
				Objects.equals(responsiblePartyLastname, that.responsiblePartyLastname) &&
				Objects.equals(predecessors, that.predecessors) &&
				Objects.equals(creatorFirstname, that.creatorFirstname) &&
				Objects.equals(timeIsLogged, that.timeIsLogged) &&
				Objects.equals(parentTask, that.parentTask) &&
				Objects.equals(responsiblePartyNames, that.responsiblePartyNames) &&
				Objects.equals(responsiblePartySummary, that.responsiblePartySummary) &&
				Objects.equals(dueDateBase, that.dueDateBase) &&
				Objects.equals(creatorLastname, that.creatorLastname) &&
				Objects.equals(commentFollowerIds, that.commentFollowerIds) &&
				Objects.equals(todoListName, that.todoListName) &&
				Objects.equals(companyName, that.companyName) &&
				Objects.equals(changeFollowerSummary, that.changeFollowerSummary) &&
				Objects.equals(lockdownId, that.lockdownId) &&
				Objects.equals(priority, that.priority) &&
				Objects.equals(responsiblePartyFirstname, that.responsiblePartyFirstname) &&
				Objects.equals(lastChangedOn, that.lastChangedOn) &&
				Objects.equals(responsiblePartyId, that.responsiblePartyId) &&
				Objects.equals(status, that.status) &&
				Objects.equals(createdOn, that.createdOn) &&
				Objects.equals(parentTaskId, that.parentTaskId) &&
				Objects.equals(description, that.description) &&
				Objects.equals(startDate, that.startDate) &&
				Objects.equals(responsiblePartyType, that.responsiblePartyType) &&
				Objects.equals(content, that.content) &&
				Objects.equals(responsiblePartyIds, that.responsiblePartyIds) &&
				Objects.equals(dueDate, that.dueDate) &&
				Objects.equals(commentFollowerSummary, that.commentFollowerSummary) &&
				Objects.equals(changeFollowerIds, that.changeFollowerIds) &&
				Objects.equals(tasklistLockdownId, that.tasklistLockdownId) &&
				Objects.equals(boardColumn, that.boardColumn) &&
				Objects.equals(creatorAvatarUrl, that.creatorAvatarUrl);
	}

	@Override
	public int hashCode() {	
		return Objects.hash(projectName, responsiblePartyLastname, predecessors, creatorFirstname, timeIsLogged, parentTask, responsiblePartyNames, responsiblePartySummary, companyId, dueDateBase, creatorLastname, userFollowingChanges, commentFollowerIds, id, harvestEnabled, order, todoListName, companyName, estimatedMinutes, hasTickets, changeFollowerSummary, lockdownId, commentsCount, completed, priority, responsiblePartyFirstname, lastChangedOn, responsiblePartyId, position, hasReminders, status, jsonMemberPrivate, userFollowingComments, dLM, createdOn, parentTaskId, canEdit, description, startDate, hasPredecessors, responsiblePartyType, content, todoListId, responsiblePartyIds, dueDate, attachmentsCount, projectId, commentFollowerSummary, tasklistIsTemplate, canComplete, creatorId, hasDependencies, canLogTime, tasklistPrivate, changeFollowerIds, hasUnreadComments, tasklistLockdownId, viewEstimatedTime, boardColumn, progress, creatorAvatarUrl);
	}

	@Override
 	public String toString(){
		return 
			"TodoItemsItem{" + 
			"project-name = '" + projectName + '\'' + 
			",responsible-party-lastname = '" + responsiblePartyLastname + '\'' + 
			",predecessors = '" + predecessors + '\'' + 
			",creator-firstname = '" + creatorFirstname + '\'' + 
			",timeIsLogged = '" + timeIsLogged + '\'' + 
			",parent-task = '" + parentTask + '\'' + 
			",responsible-party-names = '" + responsiblePartyNames + '\'' + 
			",responsible-party-summary = '" + responsiblePartySummary + '\'' + 
			",company-id = '" + companyId + '\'' + 
			",due-date-base = '" + dueDateBase + '\'' + 
			",creator-lastname = '" + creatorLastname + '\'' + 
			",userFollowingChanges = '" + userFollowingChanges + '\'' + 
			",commentFollowerIds = '" + commentFollowerIds + '\'' + 
			",id = '" + id + '\'' + 
			",harvest-enabled = '" + harvestEnabled + '\'' + 
			",order = '" + order + '\'' + 
			",todo-list-name = '" + todoListName + '\'' + 
			",company-name = '" + companyName + '\'' + 
			",estimated-minutes = '" + estimatedMinutes + '\'' + 
			",hasTickets = '" + hasTickets + '\'' + 
			",changeFollowerSummary = '" + changeFollowerSummary + '\'' + 
			",lockdownId = '" + lockdownId + '\'' + 
			",comments-count = '" + commentsCount + '\'' + 
			",completed = '" + completed + '\'' + 
			",priority = '" + priority + '\'' + 
			",responsible-party-firstname = '" + responsiblePartyFirstname + '\'' + 
			",last-changed-on = '" + lastChangedOn + '\'' + 
			",responsible-party-id = '" + responsiblePartyId + '\'' + 
			",position = '" + position + '\'' + 
			",has-reminders = '" + hasReminders + '\'' + 
			",status = '" + status + '\'' + 
			",private = '" + jsonMemberPrivate + '\'' + 
			",userFollowingComments = '" + userFollowingComments + '\'' + 
			",dLM = '" + dLM + '\'' + 
			",created-on = '" + createdOn + '\'' + 
			",parentTaskId = '" + parentTaskId + '\'' + 
			",canEdit = '" + canEdit + '\'' + 
			",description = '" + description + '\'' + 
			",start-date = '" + startDate + '\'' + 
			",has-predecessors = '" + hasPredecessors + '\'' + 
			",responsible-party-type = '" + responsiblePartyType + '\'' + 
			",content = '" + content + '\'' + 
			",todo-list-id = '" + todoListId + '\'' + 
			",responsible-party-ids = '" + responsiblePartyIds + '\'' + 
			",due-date = '" + dueDate + '\'' + 
			",attachments-count = '" + attachmentsCount + '\'' + 
			",project-id = '" + projectId + '\'' + 
			",commentFollowerSummary = '" + commentFollowerSummary + '\'' + 
			",tasklist-isTemplate = '" + tasklistIsTemplate + '\'' + 
			",canComplete = '" + canComplete + '\'' + 
			",creator-id = '" + creatorId + '\'' + 
			",has-dependencies = '" + hasDependencies + '\'' + 
			",canLogTime = '" + canLogTime + '\'' + 
			",tasklist-private = '" + tasklistPrivate + '\'' + 
			",changeFollowerIds = '" + changeFollowerIds + '\'' + 
			",has-unread-comments = '" + hasUnreadComments + '\'' + 
			",tasklist-lockdownId = '" + tasklistLockdownId + '\'' + 
			",viewEstimatedTime = '" + viewEstimatedTime + '\'' + 
			",boardColumn = '" + boardColumn + '\'' + 
			",progress = '" + progress + '\'' + 
			",creator-avatar-url = '" + creatorAvatarUrl + '\'' + 
			"}";
		}
}