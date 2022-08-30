package com.a1tech.saveappstateexample;

import android.os.Parcel;
import android.os.Parcelable;

public class MyObject implements Parcelable {
    String color;
    String number;

    public MyObject(String number, String color) {
        this.color = color;
        this.number = number;
    }

    private MyObject(Parcel in) {
        color = in.readString();
        number = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return number + ": " + color;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(color);
        out.writeString(number);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>() {
        public MyObject createFromParcel(Parcel in) {
            return new MyObject(in);
        }

        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };
}