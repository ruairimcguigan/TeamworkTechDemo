package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class Onedrivebusiness implements Item {

	@SerializedName("folder")
	public abstract String folder();

	@SerializedName("foldername")
	public abstract String folderName();

	@SerializedName("enabled")
	public abstract boolean isEnabled();

	@SerializedName("account")
	public abstract String account();

	public static TypeAdapter<Onedrivebusiness> typeAdapter(Gson gson) {
		return new AutoValue_Onedrivebusiness.GsonTypeAdapter(gson);
	}
}