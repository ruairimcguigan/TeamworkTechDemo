package demo.teamwork.aquidigital.people;

import demo.teamwork.aquidigital.people.ViewPeopleContract.Model;
import demo.teamwork.aquidigital.people.models.PeopleResponse;
import demo.teamwork.aquidigital.repository.api.TeamworkApi;
import io.reactivex.Observable;

class ViewPeopleModel implements Model {

    @Override
    public Observable<PeopleResponse> providePeople(TeamworkApi api) {
        return api.getPeople();
    }
}
