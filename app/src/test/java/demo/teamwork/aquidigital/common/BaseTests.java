package demo.teamwork.aquidigital.common;

import android.content.Context;
import android.content.res.Resources;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import demo.teamwork.aquidigital.addprojects.MockAddProjectModule;
import demo.teamwork.aquidigital.di.MockApiModule;
import demo.teamwork.aquidigital.di.MockAppComponent;
import demo.teamwork.aquidigital.di.MockAppModule;
import demo.teamwork.aquidigital.people.MockPeopleModule;
import demo.teamwork.aquidigital.taskdetail.MockTaskDetailModule;
import demo.teamwork.aquidigital.tasks.MockTaskModule;
import demo.teamwork.aquidigital.viewprojects.MockViewProjectDetailsModule;
import demo.teamwork.aquidigital.viewprojects.MockViewProjectsModule;

import static org.mockito.Mockito.when;

public abstract class BaseTests {

    @Mock
    protected Context context;

    @Mock
    protected Resources resources;

    protected MockAppModule                 appMocks;
    protected MockTaskModule                taskMocks;
    protected MockTaskDetailModule          taskDetailMocks;
    protected MockViewProjectsModule        viewProjectsMocks;
    protected MockViewProjectDetailsModule  mockViewProjectDetailsMocks;
    protected MockAddProjectModule          mockAddProjectMocks;
    protected MockPeopleModule              mockPeopleMocks;
    protected MockApiModule                 mockApiMocks;

    protected MockAppComponent injector;

    protected void initMocks() {
        MockitoAnnotations.initMocks(this);

        when(context.getResources()).thenReturn(resources);

        appMocks = new MockAppModule(context);
        MockitoAnnotations.initMocks(appMocks);

        taskMocks = new MockTaskModule();
        MockitoAnnotations.initMocks(taskMocks);

        taskDetailMocks = new MockTaskDetailModule();
        MockitoAnnotations.initMocks(taskDetailMocks);

        viewProjectsMocks = new MockViewProjectsModule();
        MockitoAnnotations.initMocks(viewProjectsMocks);

        mockViewProjectDetailsMocks = new MockViewProjectDetailsModule();
        MockitoAnnotations.initMocks(mockViewProjectDetailsMocks);

        mockAddProjectMocks = new MockAddProjectModule();
        MockitoAnnotations.initMocks(mockAddProjectMocks);

        mockPeopleMocks = new MockPeopleModule();
        MockitoAnnotations.initMocks(mockPeopleMocks);

        mockApiMocks = new MockApiModule();
        MockitoAnnotations.initMocks(mockApiMocks);
//
//        injector = DaggerMockAppComponent.builder()
//                .MockAppModule(appMocks)
//                .MockTaskModule(taskMocks)
//                .MockTaskDetailModule(taskDetailMocks)
//                .MockViewProjectsModule(viewProjectsMocks)
//                .MockViewProjectDetailsModule(mockViewProjectDetailsMocks)
//                .MockAddProjectModule(mockAddProjectMocks)
//                .MockPeopleModule(mockPeopleMocks)
//                .MockApiModule(mockApiMocks)
//                .build();
//    }

    }
}
