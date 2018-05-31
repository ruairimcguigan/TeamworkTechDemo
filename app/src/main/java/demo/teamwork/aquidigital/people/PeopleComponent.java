package demo.teamwork.aquidigital.people;

/**
 * Injects dependencies in the People component
 */
public interface PeopleComponent {

    void inject(PeopleFragment fragment);

    void inject(PeoplePresenter presenter);

}
