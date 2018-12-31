package com.example.user_pc.iotapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RekeningUser implements Parcelable {

	@SerializedName("balance")
	private int balance;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("rubbish_price")
	private int rubbishPrice;

	@SerializedName("name")
	private String name;

	@SerializedName("weight")
	private int weight;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("rek_id")
	private int rekId;

	@SerializedName("rubbish_id")
	private int rubbishId;

	@SerializedName("status")
	private int status;

	protected RekeningUser(Parcel in) {
		balance = in.readInt();
		updatedAt = in.readString();
		rubbishPrice = in.readInt();
		name = in.readString();
		weight = in.readInt();
		createdAt = in.readString();
		id = in.readInt();
		rekId = in.readInt();
		rubbishId = in.readInt();
		status = in.readInt();
	}

	public static final Creator<RekeningUser> CREATOR = new Creator<RekeningUser>() {
		@Override
		public RekeningUser createFromParcel(Parcel in) {
			return new RekeningUser(in);
		}

		@Override
		public RekeningUser[] newArray(int size) {
			return new RekeningUser[size];
		}
	};

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRekId(int rekId){
		this.rekId = rekId;
	}

	public int getRekId(){
		return rekId;
	}

	public void setRubbishId(int rubbishId){
		this.rubbishId = rubbishId;
	}

	public int getRubbishId(){
		return rubbishId;
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
			"RekeningUser{" + 
			"balance = '" + balance + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",rubbish_price = '" + rubbishPrice + '\'' + 
			",name = '" + name + '\'' + 
			",weight = '" + weight + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",rek_id = '" + rekId + '\'' + 
			",rubbish_id = '" + rubbishId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(balance);
		parcel.writeString(updatedAt);
		parcel.writeInt(rubbishPrice);
		parcel.writeString(name);
		parcel.writeInt(weight);
		parcel.writeString(createdAt);
		parcel.writeInt(id);
		parcel.writeInt(rekId);
		parcel.writeInt(rubbishId);
		parcel.writeInt(status);
	}
}