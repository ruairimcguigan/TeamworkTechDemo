package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Category{

	@SerializedName("id")
	public abstract String id();

	@SerializedName("name")
	public abstract String name();

	@SerializedName("color")
	public abstract String color();

	public static TypeAdapter<Category> typeAdapter(Gson gson) {
		return new AutoValue_Category.GsonTypeAdapter(gson);
	}
}