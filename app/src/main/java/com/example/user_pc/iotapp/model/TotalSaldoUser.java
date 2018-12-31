package com.example.user_pc.iotapp.model;

import com.google.gson.annotations.SerializedName;

public class TotalSaldoUser{

	@SerializedName("total_saldo")
	private String totalSaldo;

	@SerializedName("updated_terakhir")
	private String updatedTerakhir;

	@SerializedName("name")
	private String name;

	@SerializedName("rek_number")
	private String rekNumber;

	public void setTotalSaldo(String totalSaldo){
		this.totalSaldo = totalSaldo;
	}

	public String getTotalSaldo(){
		return totalSaldo;
	}

	public void setUpdatedTerakhir(String updatedTerakhir){
		this.updatedTerakhir = updatedTerakhir;
	}

	public String getUpdatedTerakhir(){
		return updatedTerakhir;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRekNumber(String rekNumber){
		this.rekNumber = rekNumber;
	}

	public String getRekNumber(){
		return rekNumber;
	}

	@Override
 	public String toString(){
		return 
			"TotalSaldoUser{" + 
			"total_saldo = '" + totalSaldo + '\'' + 
			",updated_terakhir = '" + updatedTerakhir + '\'' + 
			",name = '" + name + '\'' + 
			",rek_number = '" + rekNumber + '\'' + 
			"}";
		}
}