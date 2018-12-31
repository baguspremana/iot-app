package com.example.user_pc.iotapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class SaldoVerif implements Parcelable {

	@SerializedName("weight")
	private String weight;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("rek_number")
	private String rekNumber;

	@SerializedName("rek_id")
	private String rekId;

	@SerializedName("rubbish_name")
	private String rubbishName;

	@SerializedName("balance")
	private String balance;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("rubbish_price")
	private String rubbishPrice;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("rubbish_id")
	private String rubbishId;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private String status;

	protected SaldoVerif(Parcel in) {
		weight = in.readString();
		createdAt = in.readString();
		rekNumber = in.readString();
		rekId = in.readString();
		rubbishName = in.readString();
		balance = in.readString();
		updatedAt = in.readString();
		rubbishPrice = in.readString();
		name = in.readString();
		id = in.readInt();
		rubbishId = in.readString();
		email = in.readString();
		status = in.readString();
	}

	public static final Creator<SaldoVerif> CREATOR = new Creator<SaldoVerif>() {
		@Override
		public SaldoVerif createFromParcel(Parcel in) {
			return new SaldoVerif(in);
		}

		@Override
		public SaldoVerif[] newArray(int size) {
			return new SaldoVerif[size];
		}
	};

	public void setWeight(String weight){
		this.weight = weight;
	}

	public String getWeight(){
		return weight;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setRekNumber(String rekNumber){
		this.rekNumber = rekNumber;
	}

	public String getRekNumber(){
		return rekNumber;
	}

	public void setRekId(String rekId){
		this.rekId = rekId;
	}

	public String getRekId(){
		return rekId;
	}

	public void setRubbishName(String rubbishName){
		this.rubbishName = rubbishName;
	}

	public String getRubbishName(){
		return rubbishName;
	}

	public void setBalance(String balance){
		this.balance = balance;
	}

	public String getBalance(){
		return balance;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setRubbishPrice(String rubbishPrice){
		this.rubbishPrice = rubbishPrice;
	}

	public String getRubbishPrice(){
		return rubbishPrice;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRubbishId(String rubbishId){
		this.rubbishId = rubbishId;
	}

	public String getRubbishId(){
		return rubbishId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"SaldoVerif{" + 
			"weight = '" + weight + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",rek_number = '" + rekNumber + '\'' + 
			",rek_id = '" + rekId + '\'' + 
			",rubbish_name = '" + rubbishName + '\'' + 
			",balance = '" + balance + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",rubbish_price = '" + rubbishPrice + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",rubbish_id = '" + rubbishId + '\'' + 
			",email = '" + email + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(weight);
		parcel.writeString(createdAt);
		parcel.writeString(rekNumber);
		parcel.writeString(rekId);
		parcel.writeString(rubbishName);
		parcel.writeString(balance);
		parcel.writeString(updatedAt);
		parcel.writeString(rubbishPrice);
		parcel.writeString(name);
		parcel.writeInt(id);
		parcel.writeString(rubbishId);
		parcel.writeString(email);
		parcel.writeString(status);
	}
}