package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class Company implements Item {

	@SerializedName("id")
	public abstract String id();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("is-owner")
	public abstract String isOwner();

	public static TypeAdapter<Company> typeAdapter(Gson gson) {
		return new AutoValue_Company.GsonTypeAdapter(gson);
	}
}