package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import demo.teamwork.aquidigital.util.ui.Item;

@AutoValue
public abstract class BoardData implements Item {

	public static TypeAdapter<BoardData> typeAdapter(Gson gson) {
		return new AutoValue_BoardData.GsonTypeAdapter(gson);
	}
}