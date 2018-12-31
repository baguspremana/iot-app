package com.example.user_pc.iotapp.model;

import com.google.gson.annotations.SerializedName;

public class RekNumber{

	@SerializedName("rek_number")
	private String rekNumber;

	public void setRekNumber(String rekNumber){
		this.rekNumber = rekNumber;
	}

	public String getRekNumber(){
		return rekNumber;
	}

	@Override
 	public String toString(){
		return 
			"RekNumber{" + 
			"rek_number = '" + rekNumber + '\'' + 
			"}";
		}
}