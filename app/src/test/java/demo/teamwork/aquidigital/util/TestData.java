package demo.teamwork.aquidigital.util;

import java.util.ArrayList;
import java.util.List;

import demo.teamwork.aquidigital.repository.api.projectsmodel.BoardData;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Category;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Company;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;

public class TestData {

    ProjectsResponse response = new ProjectsResponse();
    List<ProjectItem> projectList = new ArrayList<>();

    public static Category buildCategory(){
        Category category = new Category();
        category.setName("categoryName");
        category.setId("100");
        category.setColor("green");
        return category;
    }

    public static Company buildCompany(){
        Company company = new Company();
        company.setName("companyName");
        company.setId("113332");
        company.setIsOwner("true");
        return company;
    }

    public static ProjectItem buildProjectItem(){
        ProjectItem projectItem = new ProjectItem();

        projectItem.setName("Cool Project");
        projectItem.setId("301444");
        projectItem.setAnnouncement("");
        projectItem.setAnnouncementHTML("");
        projectItem.setBoardData(new BoardData());
        projectItem.setCategory(buildCategory());
        projectItem.setCompany(buildCompany());
        projectItem.setCreatedOn("2016-08-20T19:16:13Z");
        projectItem.setDefaultPrivacy("open");
        projectItem.setDescription("Accelerate your team's performance by assigning tasks");
        projectItem.setStartDate("20160820");
        projectItem.setEndDate("20200306");
        projectItem.setHarvestTimersEnabled(false);
        projectItem.setFilesAutoNewVersion(true);
        projectItem.setLogo("https://s3.amazonaws.com/TWFiles/349705/projectLogo/tf_09C80679-C7D0-231B-91DC65CE6274CFDF.teamwork.png");
        projectItem.setNotifyeveryone(false);
        projectItem.setOverviewStartPage("default");
        projectItem.setPrivacyEnabled(false);
        projectItem.setReplyByEmailEnabled(true);
        projectItem.setShowAnnouncement(true);
        projectItem.setStarred(false);
        projectItem.setStatus("open");
        projectItem.setSubStatus("current");
        projectItem.setTags(new ArrayList<>(4));
        projectItem.setTasksStartPage("default");
        projectItem.setLastChangedOn("2018-05-11T14:39:44Z");
        projectItem.setDefaultPrivacy("open");
        projectItem.setIsProjectAdmin(true);

        return projectItem;
    }

    public static ProjectsResponse getProjectResponse(){

        ProjectsResponse response = new ProjectsResponse();
        List<ProjectItem> projects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            projects.add(buildProjectItem());
        }
        response.setStatus("OK");
        response.setProjectItems(projects);

        return response;
    }
}
