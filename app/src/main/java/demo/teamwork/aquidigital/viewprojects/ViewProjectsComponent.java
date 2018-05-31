package demo.teamwork.aquidigital.viewprojects;

public interface ViewProjectsComponent {

    void inject(ViewProjectsActivity activity);

    void inject(ViewProjectsPresenter presenter);

    void inject(ViewProjectsListFragment fragment);

    void inject(ViewProjectAdapter adapter);
}
