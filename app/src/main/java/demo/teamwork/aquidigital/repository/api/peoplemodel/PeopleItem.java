package demo.teamwork.aquidigital.repository.api.peoplemodel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PeopleItem{

	@SerializedName("user-type")
	private String userType;

	@SerializedName("address-line-1")
	private String addressLine1;

	@SerializedName("phone-number-office")
	private String phoneNumberOffice;

	@SerializedName("notes")
	private String notes;

	@SerializedName("address-line-2")
	private String addressLine2;

	@SerializedName("address-state")
	private String addressState;

	@SerializedName("pid")
	private String pid;

	@SerializedName("address-country")
	private String addressCountry;

	@SerializedName("twitter")
	private String twitter;

	@SerializedName("company-id")
	private String companyId;

	@SerializedName("permissions")
	private Permissions permissions;

	@SerializedName("im-service")
	private String imService;

	@SerializedName("created-at")
	private String createdAt;

	@SerializedName("userUUID")
	private String userUUID;

	@SerializedName("id")
	private String id;

	@SerializedName("phone-number-fax")
	private String phoneNumberFax;

	@SerializedName("im-handle")
	private String imHandle;

	@SerializedName("avatar-url")
	private String avatarUrl;

	@SerializedName("address-zip")
	private String addressZip;

	@SerializedName("last-active")
	private String lastActive;

	@SerializedName("email-alt-2")
	private String emailAlt2;

	@SerializedName("last-login")
	private String lastLogin;

	@SerializedName("email-alt-1")
	private String emailAlt1;

	@SerializedName("company-name")
	private String companyName;

	@SerializedName("email-alt-3")
	private String emailAlt3;

	@SerializedName("site-owner")
	private boolean siteOwner;

	@SerializedName("profile")
	private String profile;

	@SerializedName("phone-number-home")
	private String phoneNumberHome;

	@SerializedName("first-name")
	private String firstName;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("user-invited-status")
	private String userInvitedStatus;

	@SerializedName("user-invited")
	private String userInvited;

	@SerializedName("phone-number-mobile")
	private String phoneNumberMobile;

	@SerializedName("has-access-to-new-projects")
	private boolean hasAccessToNewProjects;

	@SerializedName("last-changed-on")
	private String lastChangedOn;

	@SerializedName("user-name")
	private String userName;

	@SerializedName("lengthOfDay")
	private String lengthOfDay;

	@SerializedName("user-invited-date")
	private String userInvitedDate;

	@SerializedName("login-count")
	private String loginCount;

	@SerializedName("openId")
	private String openId;

	@SerializedName("title")
	private String title;

	@SerializedName("administrator")
	private boolean administrator;

	@SerializedName("in-owner-company")
	private boolean inOwnerCompany;

	@SerializedName("useShorthandDurations")
	private boolean useShorthandDurations;

	@SerializedName("address-city")
	private String addressCity;

	@SerializedName("last-name")
	private String lastName;

	@SerializedName("phone-number-office-ext")
	private String phoneNumberOfficeExt;

	@SerializedName("profile-text")
	private String profileText;

	@SerializedName("address")
	private Address address;

	@SerializedName("email-address")
	private String emailAddress;

	@SerializedName("textFormat")
	private String textFormat;

	@SerializedName("deleted")
	private boolean deleted;

	@SerializedName("phone-number-mobile-parts")
	private PhoneNumberMobileParts phoneNumberMobileParts;

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setAddressLine1(String addressLine1){
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine1(){
		return addressLine1;
	}

	public void setPhoneNumberOffice(String phoneNumberOffice){
		this.phoneNumberOffice = phoneNumberOffice;
	}

	public String getPhoneNumberOffice(){
		return phoneNumberOffice;
	}

	public void setNotes(String notes){
		this.notes = notes;
	}

	public String getNotes(){
		return notes;
	}

	public void setAddressLine2(String addressLine2){
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine2(){
		return addressLine2;
	}

	public void setAddressState(String addressState){
		this.addressState = addressState;
	}

	public String getAddressState(){
		return addressState;
	}

	public void setPid(String pid){
		this.pid = pid;
	}

	public String getPid(){
		return pid;
	}

	public void setAddressCountry(String addressCountry){
		this.addressCountry = addressCountry;
	}

	public String getAddressCountry(){
		return addressCountry;
	}

	public void setTwitter(String twitter){
		this.twitter = twitter;
	}

	public String getTwitter(){
		return twitter;
	}

	public void setPermissions(Permissions permissions){
		this.permissions = permissions;
	}

	public Permissions getPermissions(){
		return permissions;
	}

	public void setImService(String imService){
		this.imService = imService;
	}

	public String getImService(){
		return imService;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUserUUID(String userUUID){
		this.userUUID = userUUID;
	}

	public String getUserUUID(){
		return userUUID;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setPhoneNumberFax(String phoneNumberFax){
		this.phoneNumberFax = phoneNumberFax;
	}

	public String getPhoneNumberFax(){
		return phoneNumberFax;
	}

	public void setImHandle(String imHandle){
		this.imHandle = imHandle;
	}

	public String getImHandle(){
		return imHandle;
	}

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setAddressZip(String addressZip){
		this.addressZip = addressZip;
	}

	public String getAddressZip(){
		return addressZip;
	}

	public void setLastActive(String lastActive){
		this.lastActive = lastActive;
	}

	public String getLastActive(){
		return lastActive;
	}

	public void setEmailAlt2(String emailAlt2){
		this.emailAlt2 = emailAlt2;
	}

	public String getEmailAlt2(){
		return emailAlt2;
	}

	public void setLastLogin(String lastLogin){
		this.lastLogin = lastLogin;
	}

	public String getLastLogin(){
		return lastLogin;
	}

	public void setEmailAlt1(String emailAlt1){
		this.emailAlt1 = emailAlt1;
	}

	public String getEmailAlt1(){
		return emailAlt1;
	}

	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return companyName;
	}

	public void setEmailAlt3(String emailAlt3){
		this.emailAlt3 = emailAlt3;
	}

	public String getEmailAlt3(){
		return emailAlt3;
	}

	public void setSiteOwner(boolean siteOwner){
		this.siteOwner = siteOwner;
	}

	public boolean isSiteOwner(){
		return siteOwner;
	}

	public void setProfile(String profile){
		this.profile = profile;
	}

	public String getProfile(){
		return profile;
	}

	public void setPhoneNumberHome(String phoneNumberHome){
		this.phoneNumberHome = phoneNumberHome;
	}

	public String getPhoneNumberHome(){
		return phoneNumberHome;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setUserInvitedStatus(String userInvitedStatus){
		this.userInvitedStatus = userInvitedStatus;
	}

	public String getUserInvitedStatus(){
		return userInvitedStatus;
	}

	public void setUserInvited(String userInvited){
		this.userInvited = userInvited;
	}

	public String getUserInvited(){
		return userInvited;
	}

	public void setCompanyId(String companyId){
		this.companyId = companyId;
	}

	public String getCompanyId(){
		return companyId;
	}

	public void setPhoneNumberMobile(String phoneNumberMobile){
		this.phoneNumberMobile = phoneNumberMobile;
	}

	public String getPhoneNumberMobile(){
		return phoneNumberMobile;
	}

	public void setHasAccessToNewProjects(boolean hasAccessToNewProjects){
		this.hasAccessToNewProjects = hasAccessToNewProjects;
	}

	public boolean isHasAccessToNewProjects(){
		return hasAccessToNewProjects;
	}

	public void setLastChangedOn(String lastChangedOn){
		this.lastChangedOn = lastChangedOn;
	}

	public String getLastChangedOn(){
		return lastChangedOn;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setLengthOfDay(String lengthOfDay){
		this.lengthOfDay = lengthOfDay;
	}

	public String getLengthOfDay(){
		return lengthOfDay;
	}

	public void setUserInvitedDate(String userInvitedDate){
		this.userInvitedDate = userInvitedDate;
	}

	public String getUserInvitedDate(){
		return userInvitedDate;
	}

	public void setLoginCount(String loginCount){
		this.loginCount = loginCount;
	}

	public String getLoginCount(){
		return loginCount;
	}

	public void setOpenId(String openId){
		this.openId = openId;
	}

	public String getOpenId(){
		return openId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setAdministrator(boolean administrator){
		this.administrator = administrator;
	}

	public boolean isAdministrator(){
		return administrator;
	}

	public void setInOwnerCompany(boolean inOwnerCompany){
		this.inOwnerCompany = inOwnerCompany;
	}

	public boolean isInOwnerCompany(){
		return inOwnerCompany;
	}

	public void setUseShorthandDurations(boolean useShorthandDurations){
		this.useShorthandDurations = useShorthandDurations;
	}

	public boolean isUseShorthandDurations(){
		return useShorthandDurations;
	}

	public void setAddressCity(String addressCity){
		this.addressCity = addressCity;
	}

	public String getAddressCity(){
		return addressCity;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setPhoneNumberOfficeExt(String phoneNumberOfficeExt){
		this.phoneNumberOfficeExt = phoneNumberOfficeExt;
	}

	public String getPhoneNumberOfficeExt(){
		return phoneNumberOfficeExt;
	}

	public void setProfileText(String profileText){
		this.profileText = profileText;
	}

	public String getProfileText(){
		return profileText;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress(){
		return emailAddress;
	}

	public void setTextFormat(String textFormat){
		this.textFormat = textFormat;
	}

	public String getTextFormat(){
		return textFormat;
	}

	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}

	public boolean isDeleted(){
		return deleted;
	}

	public void setPhoneNumberMobileParts(PhoneNumberMobileParts phoneNumberMobileParts){
		this.phoneNumberMobileParts = phoneNumberMobileParts;
	}

	public PhoneNumberMobileParts getPhoneNumberMobileParts(){
		return phoneNumberMobileParts;
	}

	@Override
 	public String toString(){
		return 
			"PeopleItem{" + 
			"user-type = '" + userType + '\'' + 
			",address-line-1 = '" + addressLine1 + '\'' + 
			",phone-number-office = '" + phoneNumberOffice + '\'' + 
			",notes = '" + notes + '\'' + 
			",address-line-2 = '" + addressLine2 + '\'' + 
			",address-state = '" + addressState + '\'' + 
			",pid = '" + pid + '\'' + 
			",address-country = '" + addressCountry + '\'' + 
			",twitter = '" + twitter + '\'' + 
			",company-id = '" + companyId + '\'' + 
			",permissions = '" + permissions + '\'' + 
			",im-service = '" + imService + '\'' + 
			",created-at = '" + createdAt + '\'' + 
			",userUUID = '" + userUUID + '\'' + 
			",id = '" + id + '\'' + 
			",phone-number-fax = '" + phoneNumberFax + '\'' + 
			",im-handle = '" + imHandle + '\'' + 
			",avatar-url = '" + avatarUrl + '\'' + 
			",address-zip = '" + addressZip + '\'' + 
			",last-active = '" + lastActive + '\'' + 
			",email-alt-2 = '" + emailAlt2 + '\'' + 
			",last-login = '" + lastLogin + '\'' + 
			",email-alt-1 = '" + emailAlt1 + '\'' + 
			",company-name = '" + companyName + '\'' + 
			",email-alt-3 = '" + emailAlt3 + '\'' + 
			",site-owner = '" + siteOwner + '\'' + 
			",profile = '" + profile + '\'' + 
			",phone-number-home = '" + phoneNumberHome + '\'' + 
			",first-name = '" + firstName + '\'' + 
			",tags = '" + tags + '\'' + 
			",user-invited-status = '" + userInvitedStatus + '\'' + 
			",user-invited = '" + userInvited + '\'' + 
			",companyId = '" + companyId + '\'' + 
			",phone-number-mobile = '" + phoneNumberMobile + '\'' + 
			",has-access-to-new-projects = '" + hasAccessToNewProjects + '\'' + 
			",last-changed-on = '" + lastChangedOn + '\'' + 
			",user-name = '" + userName + '\'' + 
			",lengthOfDay = '" + lengthOfDay + '\'' + 
			",user-invited-date = '" + userInvitedDate + '\'' + 
			",login-count = '" + loginCount + '\'' + 
			",openId = '" + openId + '\'' + 
			",title = '" + title + '\'' + 
			",administrator = '" + administrator + '\'' + 
			",in-owner-company = '" + inOwnerCompany + '\'' + 
			",useShorthandDurations = '" + useShorthandDurations + '\'' + 
			",address-city = '" + addressCity + '\'' + 
			",last-name = '" + lastName + '\'' + 
			",phone-number-office-ext = '" + phoneNumberOfficeExt + '\'' + 
			",profile-text = '" + profileText + '\'' + 
			",address = '" + address + '\'' + 
			",email-address = '" + emailAddress + '\'' + 
			",textFormat = '" + textFormat + '\'' + 
			",deleted = '" + deleted + '\'' + 
			",phone-number-mobile-parts = '" + phoneNumberMobileParts + '\'' + 
			"}";
		}
}