package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class Integrations implements Item {

	@SerializedName("xero")
	public abstract Xero xero();

	@SerializedName("onedrivebusiness")
	public abstract Onedrivebusiness onedrivebusiness();

	@SerializedName("microsoftConnectors")
	public abstract MicrosoftConnectors microsoftConnectors();

	public static TypeAdapter<Integrations> typeAdapter(Gson gson) {
		return new AutoValue_Integrations.GsonTypeAdapter(gson);
	}
}