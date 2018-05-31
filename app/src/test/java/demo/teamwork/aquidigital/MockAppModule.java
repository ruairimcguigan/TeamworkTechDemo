package demo.teamwork.aquidigital;

import android.app.Application;

import dagger.Module;
import demo.teamwork.aquidigital.common.injection.AppModule;

@Module
public class MockAppModule extends AppModule{

    public MockAppModule(Application application) {
        super(application);
    }


}
