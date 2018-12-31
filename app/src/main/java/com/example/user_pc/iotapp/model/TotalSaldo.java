package com.example.user_pc.iotapp.model;

import com.google.gson.annotations.SerializedName;

public class TotalSaldo{

	@SerializedName("total_saldo")
	private String totalSaldo;

	public void setTotalSaldo(String totalSaldo){
		this.totalSaldo = totalSaldo;
	}

	public String getTotalSaldo(){
		return totalSaldo;
	}

	@Override
 	public String toString(){
		return 
			"TotalSaldo{" + 
			"total_saldo = '" + totalSaldo + '\'' + 
			"}";
		}
}