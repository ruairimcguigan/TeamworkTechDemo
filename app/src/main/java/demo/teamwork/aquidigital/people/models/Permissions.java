package demo.teamwork.aquidigital.people.models;

import com.google.gson.annotations.SerializedName;

public class Permissions{

	@SerializedName("can-add-projects")
	private boolean canAddProjects;

	@SerializedName("canManagePortfolio")
	private boolean canManagePortfolio;

	@SerializedName("can-access-templates")
	private boolean canAccessTemplates;

	@SerializedName("can-manage-people")
	private boolean canManagePeople;

	@SerializedName("canAccessPortfolio")
	private boolean canAccessPortfolio;

	public void setCanAddProjects(boolean canAddProjects){
		this.canAddProjects = canAddProjects;
	}

	public boolean isCanAddProjects(){
		return canAddProjects;
	}

	public void setCanManagePortfolio(boolean canManagePortfolio){
		this.canManagePortfolio = canManagePortfolio;
	}

	public boolean isCanManagePortfolio(){
		return canManagePortfolio;
	}

	public void setCanAccessTemplates(boolean canAccessTemplates){
		this.canAccessTemplates = canAccessTemplates;
	}

	public boolean isCanAccessTemplates(){
		return canAccessTemplates;
	}

	public void setCanManagePeople(boolean canManagePeople){
		this.canManagePeople = canManagePeople;
	}

	public boolean isCanManagePeople(){
		return canManagePeople;
	}

	public void setCanAccessPortfolio(boolean canAccessPortfolio){
		this.canAccessPortfolio = canAccessPortfolio;
	}

	public boolean isCanAccessPortfolio(){
		return canAccessPortfolio;
	}

	@Override
 	public String toString(){
		return 
			"Permissions{" + 
			"can-add-projects = '" + canAddProjects + '\'' + 
			",canManagePortfolio = '" + canManagePortfolio + '\'' + 
			",can-access-templates = '" + canAccessTemplates + '\'' + 
			",can-manage-people = '" + canManagePeople + '\'' + 
			",canAccessPortfolio = '" + canAccessPortfolio + '\'' + 
			"}";
		}
}