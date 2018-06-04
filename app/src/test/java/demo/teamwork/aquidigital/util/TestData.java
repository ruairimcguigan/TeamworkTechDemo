package demo.teamwork.aquidigital.util;

import java.util.ArrayList;
import java.util.List;

import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagResponse;
import demo.teamwork.aquidigital.repository.api.addprojectmodel.TagItem;
import demo.teamwork.aquidigital.repository.api.peoplemodel.PeopleItem;
import demo.teamwork.aquidigital.repository.api.peoplemodel.PeopleResponse;
import demo.teamwork.aquidigital.repository.api.projectsmodel.BoardData;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Category;
import demo.teamwork.aquidigital.repository.api.projectsmodel.Company;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectsResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TasksResponse;
import demo.teamwork.aquidigital.repository.api.tasksmodel.TodoItemsItem;

public class TestData {

    ProjectsResponse response = new ProjectsResponse();
    List<ProjectItem> projectList = new ArrayList<>();

    private static Category buildCategory(){
        Category category = new Category();
        category.setName("categoryName");
        category.setId("100");
        category.setColor("green");
        return category;
    }

    private static Company buildCompany(){
        Company company = new Company();
        company.setName("Great company");
        company.setId("111111");
        company.setIsOwner("true");
        return company;
    }

    private static ProjectItem buildProjectItem(){
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
        for (int i = 0; i < 3; i++) {
            projects.add(buildProjectItem());
        }
        response.setStatus("OK");
        response.setProjectItems(projects);

        return response;
    }

    public static PeopleResponse getPeopleResponse(){
        PeopleResponse peopleResponse = new PeopleResponse();

        peopleResponse.setPeople(buildPeopleItem());
        return peopleResponse;
    }

    private static List<PeopleItem> buildPeopleItem(){
        List<PeopleItem> people = new ArrayList<>();

        PeopleItem personOne = new PeopleItem();
        personOne.setFirstName("Ruairi");
        personOne.setLastName("McGuigan");
        personOne.setAdministrator(true);
        personOne.setAddressCity("Derry");
        personOne.setCompanyName("Aquidigital");

        PeopleItem personTwo = new PeopleItem();
        personTwo.setFirstName("John");
        personTwo.setLastName("Concanno");
        personTwo.setAdministrator(false);
        personTwo.setAddressCity("Belfast");
        personTwo.setCompanyName("SomeCompany");

        PeopleItem personThree = new PeopleItem();
        personThree.setFirstName("Joan");
        personThree.setLastName("Smith");
        personThree.setAdministrator(false);
        personThree.setAddressCity("Cork");
        personThree.setCompanyName("OtherCompany");

        people.add(personOne);
        people.add(personTwo);
        people.add(personThree);

        return people;
    }

    public static TasksResponse getTaskResponse(){
        TasksResponse taskResponse = new TasksResponse();

        taskResponse.setTodoItems(buildTaskItems());
        return taskResponse;
    }

    private static List<TodoItemsItem> buildTaskItems(){
        List<TodoItemsItem> tasks = new ArrayList<>();

        TodoItemsItem taskOne = new TodoItemsItem();
        taskOne.setTodoListName("Company name task 1");
        taskOne.setDescription("This is task one");
        taskOne.setContent("Task one content");

        TodoItemsItem taskTwo = new TodoItemsItem();
        taskTwo.setTodoListName("Company name task 2");
        taskTwo.setDescription("This is task two");
        taskTwo.setContent("Task two content");

        TodoItemsItem taskThree = new TodoItemsItem();
        taskThree.setTodoListName("Company name task 3");
        taskThree.setDescription("This is task three");
        taskThree.setContent("Task three content");

        tasks.add(taskOne);
        tasks.add(taskTwo);
        tasks.add(taskThree);

        return tasks;
    }

    public static TagResponse getTagResponse(){
        TagResponse tagResponse = new TagResponse();

        tagResponse.setTags(buildTagItems());
        return tagResponse;
    }

    private static List<TagItem> buildTagItems(){
        List<TagItem> tags = new ArrayList<>();

        TagItem tagOne = new TagItem();
        tagOne.setId("tag_100");
        tagOne.setName("tag 1");
        tagOne.setColor("red");

        TagItem tagTwo = new TagItem();
        tagTwo.setId("tag_200");
        tagTwo.setName("tag 2");
        tagTwo.setColor("green");

        TagItem tagThree = new TagItem();
        tagThree.setId("tag_300");
        tagThree.setName("tag 3");
        tagThree.setColor("blue");

        tags.add(tagOne);
        tags.add(tagTwo);
        tags.add(tagThree);

        return tags;
    }
}
