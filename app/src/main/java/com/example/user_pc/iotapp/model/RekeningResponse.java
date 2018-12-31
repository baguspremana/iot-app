package com.example.user_pc.iotapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RekeningResponse implements Parcelable {

	@SerializedName("balance")
	private String balance;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("rubbish_price")
	private String rubbishPrice;

	@SerializedName("name")
	private String name;

	@SerializedName("weight")
	private String weight;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("rek_id")
	private String rekId;

	@SerializedName("rubbish_id")
	private String rubbishId;

	@SerializedName("status")
	private String status;

	protected RekeningResponse(Parcel in) {
		balance = in.readString();
		updatedAt = in.readString();
		rubbishPrice = in.readString();
		name = in.readString();
		weight = in.readString();
		createdAt = in.readString();
		id = in.readInt();
		rekId = in.readString();
		rubbishId = in.readString();
		status = in.readString();
	}

	public static final Creator<RekeningResponse> CREATOR = new Creator<RekeningResponse>() {
		@Override
		public RekeningResponse createFromParcel(Parcel in) {
			return new RekeningResponse(in);
		}

		@Override
		public RekeningResponse[] newArray(int size) {
			return new RekeningResponse[size];
		}
	};

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRekId(String rekId){
		this.rekId = rekId;
	}

	public String getRekId(){
		return rekId;
	}

	public void setRubbishId(String rubbishId){
		this.rubbishId = rubbishId;
	}

	public String getRubbishId(){
		return rubbishId;
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
			"RekeningResponse{" + 
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
		parcel.writeString(balance);
		parcel.writeString(updatedAt);
		parcel.writeString(rubbishPrice);
		parcel.writeString(name);
		parcel.writeString(weight);
		parcel.writeString(createdAt);
		parcel.writeInt(id);
		parcel.writeString(rekId);
		parcel.writeString(rubbishId);
		parcel.writeString(status);
	}
}