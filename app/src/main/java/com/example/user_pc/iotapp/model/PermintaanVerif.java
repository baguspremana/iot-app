package com.example.user_pc.iotapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PermintaanVerif implements Parcelable {

	@SerializedName("weight")
	private int weight;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("rek_number")
	private String rekNumber;

	@SerializedName("rek_id")
	private int rekId;

	@SerializedName("rubbish_name")
	private String rubbishName;

	@SerializedName("balance")
	private int balance;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("rubbish_price")
	private int rubbishPrice;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("rubbish_id")
	private int rubbishId;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private int status;

	protected PermintaanVerif(Parcel in) {
		weight = in.readInt();
		createdAt = in.readString();
		rekNumber = in.readString();
		rekId = in.readInt();
		rubbishName = in.readString();
		balance = in.readInt();
		updatedAt = in.readString();
		rubbishPrice = in.readInt();
		name = in.readString();
		id = in.readInt();
		rubbishId = in.readInt();
		email = in.readString();
		status = in.readInt();
	}

	public static final Creator<PermintaanVerif> CREATOR = new Creator<PermintaanVerif>() {
		@Override
		public PermintaanVerif createFromParcel(Parcel in) {
			return new PermintaanVerif(in);
		}

		@Override
		public PermintaanVerif[] newArray(int size) {
			return new PermintaanVerif[size];
		}
	};

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
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

	public void setRekId(int rekId){
		this.rekId = rekId;
	}

	public int getRekId(){
		return rekId;
	}

	public void setRubbishName(String rubbishName){
		this.rubbishName = rubbishName;
	}

	public String getRubbishName(){
		return rubbishName;
	}

	public void setBalance(int balance){
		this.balance = balance;
	}

	public int getBalance(){
		return balance;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setRubbishPrice(int rubbishPrice){
		this.rubbishPrice = rubbishPrice;
	}

	public int getRubbishPrice(){
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

	public void setRubbishId(int rubbishId){
		this.rubbishId = rubbishId;
	}

	public int getRubbishId(){
		return rubbishId;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"PermintaanVerif{" + 
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
		parcel.writeInt(weight);
		parcel.writeString(createdAt);
		parcel.writeString(rekNumber);
		parcel.writeInt(rekId);
		parcel.writeString(rubbishName);
		parcel.writeInt(balance);
		parcel.writeString(updatedAt);
		parcel.writeInt(rubbishPrice);
		parcel.writeString(name);
		parcel.writeInt(id);
		parcel.writeInt(rubbishId);
		parcel.writeString(email);
		parcel.writeInt(status);
	}
}