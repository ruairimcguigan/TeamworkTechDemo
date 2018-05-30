package demo.teamwork.aquidigital.repository.api.addprojectmodel;

public class ProjectRequest {

    private Project project;

    public ProjectRequest(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
