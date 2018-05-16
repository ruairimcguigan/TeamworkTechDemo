package demo.teamwork.aquidigital.repository.api.apimodel;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class BoardData{

	public static TypeAdapter<BoardData> typeAdapter(Gson gson) {
		return new AutoValue_BoardData.GsonTypeAdapter(gson);
	}
}