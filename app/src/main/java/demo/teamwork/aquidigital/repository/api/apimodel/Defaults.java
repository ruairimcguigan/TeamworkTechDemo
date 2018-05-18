package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class Defaults implements Item {

	@SerializedName("privacy")
	public abstract String privacy();

	public static TypeAdapter<Defaults> typeAdapter(Gson gson) {
		return new AutoValue_Defaults.GsonTypeAdapter(gson);
	}
}