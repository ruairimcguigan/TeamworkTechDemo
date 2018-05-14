package demo.teamwork.aquidigital.common.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import demo.teamwork.aquidigital.common.injection.ApplicationContext;
import demo.teamwork.aquidigital.common.injection.module.AppModule;
import demo.teamwork.aquidigital.projects.api.TeamworkService;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ApplicationContext
    Context context();

    Application application();

    TeamworkService teamworkService();
}
