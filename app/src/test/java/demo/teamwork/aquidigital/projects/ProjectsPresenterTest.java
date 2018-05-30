package demo.teamwork.aquidigital.projects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import demo.teamwork.aquidigital.projects.ProjectsContract.Model;
import demo.teamwork.aquidigital.projects.ProjectsContract.View;
import demo.teamwork.aquidigital.repository.api.projectsmodel.ProjectItem;

import static demo.teamwork.aquidigital.projects.ProjectsContract.*;
import static org.junit.Assert.*;

public class ProjectsPresenterTest {

    @Mock private View view;
    @Mock private Model model;

    private Presenter presenter;
    private ProjectItem project;

    @Before
    public void setUp() throws Exception {
        project = new ProjectItem();
    }

    @Test
    public void attachView() {
    }

    @Test
    public void onTagFetchSuccess() {
    }
}