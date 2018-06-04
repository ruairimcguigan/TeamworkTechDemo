package demo.teamwork.aquidigital.repository.api.addprojectmodel;

import com.google.gson.annotations.SerializedName;

public class Project {

    // Required
    @SerializedName("name")
    private final String name;

    @SerializedName("description")
    private final String description;

    @SerializedName("newCompany")
    private final String company;

    @SerializedName("tags")
    private final String tags;

    @SerializedName("category-id")
    private final int category;

    @SerializedName("startDate")
    private final String startDate;

    @SerializedName("endDate")
    private final String endDate;


    // Optional
	@SerializedName("privacyEnabled")
	private String privacyEnabled = "";

	@SerializedName("replyByEmailEnabled")
	private String replyByEmailEnabled = "";

	@SerializedName("companyId")
	private int companyId = 0;

	@SerializedName("harvest-timers-enabled")
	private String harvestTimersEnabled = "";


	public static class Builder {
	    // Required
        @SerializedName("name")
        private final String name;

        @SerializedName("description")
        private final String description;

        @SerializedName("newCompany")
        private final String company;

        @SerializedName("tags")
        private final String tags;

        @SerializedName("category-id")
        private final int category;

        @SerializedName("startDate")
        private final String startDate;

        @SerializedName("endDate")
        private final String endDate;


        // Optional
        @SerializedName("companyId")
        private int companyId               = 0;

        @SerializedName("privacyEnabled")
        private String privacyEnabled       = "";

        @SerializedName("replyByEmailEnabled")
        private String replyByEmailEnabled  = "";

        @SerializedName("harvest-timers-enabled")
        private String harvestTimersEnabled = "";


        public Builder(String name, String description, String company,
                       String tags, int category, String startDate, String endDate) {
            this.name = name;
            this.description = description;
            this.company = company;
            this.tags = tags;
            this.category = category;
            this.startDate = startDate;
            this.endDate = endDate;
        }


        public Builder privacyEnabled(String privacyEnabledValue){
            privacyEnabled = privacyEnabledValue;               return this;
        }
        public Builder replyByEmailEnabled(String replyByEmailEnabledValue){
            replyByEmailEnabled = replyByEmailEnabledValue;     return this;
        }
        public Builder harvestTimersEnabled(String harvestTimersEnabledValue){
            harvestTimersEnabled = harvestTimersEnabledValue;   return this;
        }
        public Builder companyId(int companyIdValue){
            companyId = companyIdValue;                         return this;
        }

        public Project build(){
            return new Project(this);
        }
    }

    private Project(Builder builder){
        name                    = builder.name;
        description             = builder.description;
        company                 = builder.company;
        tags                    = builder.tags;
        category                = builder.category;
        startDate               = builder.startDate;
        endDate                 = builder.endDate;
        privacyEnabled          = builder.privacyEnabled;
        replyByEmailEnabled     = builder.replyByEmailEnabled;
        companyId               = builder.companyId;
        harvestTimersEnabled    = builder.harvestTimersEnabled;
    }

	@Override
 	public String toString(){
		return
			"Project{" +
			"privacyEnabled = '" + privacyEnabled + '\'' +
			",replyByEmailEnabled = '" + replyByEmailEnabled + '\'' +
			",companyId = '" + companyId + '\'' +
			",endDate = '" + endDate + '\'' +
			",newCompany = '" + company + '\'' +
			",name = '" + name + '\'' +
			",description = '" + description + '\'' +
			",harvest-timers-enabled = '" + harvestTimersEnabled + '\'' +
			",category-id = '" + category + '\'' +
			",startDate = '" + startDate + '\'' +
			",tags = '" + tags + '\'' +
			"}";
		}
}