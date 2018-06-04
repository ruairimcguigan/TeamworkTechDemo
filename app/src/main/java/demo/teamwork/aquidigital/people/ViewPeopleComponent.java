package demo.teamwork.aquidigital.people;

/**
 * Injects dependencies in the People component
 */
public interface ViewPeopleComponent {

    void inject(ViewPeopleFragment fragment);

    void inject(ViewPeoplePresenter presenter);

}
