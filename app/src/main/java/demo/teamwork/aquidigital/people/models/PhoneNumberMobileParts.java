package demo.teamwork.aquidigital.people.models;

import com.google.gson.annotations.SerializedName;

public class PhoneNumberMobileParts{

	@SerializedName("phone")
	private String phone;

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("countryCode")
	private String countryCode;

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setPrefix(String prefix){
		this.prefix = prefix;
	}

	public String getPrefix(){
		return prefix;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
	}

	@Override
 	public String toString(){
		return 
			"PhoneNumberMobileParts{" + 
			"phone = '" + phone + '\'' + 
			",prefix = '" + prefix + '\'' + 
			",countryCode = '" + countryCode + '\'' + 
			"}";
		}
}