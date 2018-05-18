package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class MicrosoftConnectors implements Item {

	@SerializedName("enabled")
	public abstract boolean isEnabled();

	public static TypeAdapter<MicrosoftConnectors> typeAdapter(Gson gson) {
		return new AutoValue_MicrosoftConnectors.GsonTypeAdapter(gson);
	}
}