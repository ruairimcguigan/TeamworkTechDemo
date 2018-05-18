package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class Xero implements Item {

	@SerializedName("connected")
	public abstract String connected();

	@SerializedName("basecurrency")
	public abstract String basecurrency();

	@SerializedName("countrycode")
	public abstract String countrycode();

	@SerializedName("organisation")
	public abstract String organisation();

	@SerializedName("enabled")
	public abstract boolean isEnabled();

	public static TypeAdapter<Xero> typeAdapter(Gson gson) {
		return new AutoValue_Xero.GsonTypeAdapter(gson);
	}
}