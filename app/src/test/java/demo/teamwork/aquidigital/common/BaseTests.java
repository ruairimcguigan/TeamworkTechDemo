package demo.teamwork.aquidigital.common;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import demo.teamwork.aquidigital.util.RxSchedulersOverrideRule;

import static org.mockito.Mockito.when;

public abstract class BaseTests {

    @Mock
    protected Context context;

    @Mock
    protected Resources resources;

    @Rule
    public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

    protected void initMocks() {
        MockitoAnnotations.initMocks(this);
        when(context.getResources()).thenReturn(resources);
    }
}
