package com.kktv.radio.type;

import java.util.ArrayList;
import android.os.Parcel;
import android.os.Parcelable;

public class RadioListType implements Parcelable {

	private String name;
	private ArrayList<RadioType> list;

	public RadioListType() {

	}

	public RadioListType(Parcel in) {
		readFromParcel(in);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public void readFromParcel(Parcel in) {
		name = in.readString();
		list = new ArrayList<RadioType>();
		in.readTypedList(list, RadioType.CREATOR);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeTypedList(list);
	}

	public static final Creator<RadioListType> CREATOR = new Creator<RadioListType>() {

		@Override
		public RadioListType createFromParcel(Parcel source) {
			return new RadioListType(source);
		}

		@Override
		public RadioListType[] newArray(int size) {
			return new RadioListType[size];
		}
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<RadioType> getList() {
		return list;
	}

	public void setList(ArrayList<RadioType> list) {
		this.list = list;
	}

}
