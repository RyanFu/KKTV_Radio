package com.kktv.radio.type;

import android.os.Parcel;
import android.os.Parcelable;

public class RadioType implements Parcelable {

	private String url;
	private String name;
	private int flag;

	@Override
	public int describeContents() {
		return 0;
	}

	public RadioType() {

	}

	private RadioType(Parcel in) {
		readFromParcel(in);
	}

	public void readFromParcel(Parcel in) {
		url = in.readString();
		name = in.readString();
		flag = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(url);
		dest.writeString(name);
		dest.writeInt(flag);
	}

	public static final Creator<RadioType> CREATOR = new Creator<RadioType>() {

		@Override
		public RadioType createFromParcel(Parcel source) {
			return new RadioType(source);
		}

		@Override
		public RadioType[] newArray(int size) {
			return new RadioType[size];
		}

	};

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}
