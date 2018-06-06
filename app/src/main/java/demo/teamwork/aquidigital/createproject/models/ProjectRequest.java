package demo.teamwork.aquidigital.createproject.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectRequest)) return false;
        ProjectRequest request = (ProjectRequest) o;
        return Objects.equals(project, request.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project);
    }
}
