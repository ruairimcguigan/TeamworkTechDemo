package demo.teamwork.aquidigital.repository.api.peoplemodel;

import com.google.gson.annotations.SerializedName;

public class Address{

	@SerializedName("zipcode")
	private String zipcode;

	@SerializedName("country")
	private String country;

	@SerializedName("city")
	private String city;

	@SerializedName("countrycode")
	private String countrycode;

	@SerializedName("state")
	private String state;

	@SerializedName("line2")
	private String line2;

	@SerializedName("line1")
	private String line1;

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public String getZipcode(){
		return zipcode;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setCountrycode(String countrycode){
		this.countrycode = countrycode;
	}

	public String getCountrycode(){
		return countrycode;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLine2(String line2){
		this.line2 = line2;
	}

	public String getLine2(){
		return line2;
	}

	public void setLine1(String line1){
		this.line1 = line1;
	}

	public String getLine1(){
		return line1;
	}

	@Override
 	public String toString(){
		return 
			"Address{" + 
			"zipcode = '" + zipcode + '\'' + 
			",country = '" + country + '\'' + 
			",city = '" + city + '\'' + 
			",countrycode = '" + countrycode + '\'' + 
			",state = '" + state + '\'' + 
			",line2 = '" + line2 + '\'' + 
			",line1 = '" + line1 + '\'' + 
			"}";
		}
}