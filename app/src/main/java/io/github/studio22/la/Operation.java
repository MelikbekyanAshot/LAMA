package io.github.studio22.la;

import android.os.Parcel;
import android.os.Parcelable;

public class Operation implements Parcelable {

    private String name;

    public Operation(String name){
        this.name=name;
    }

    protected Operation(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Operation> CREATOR = new Creator<Operation>() {
        @Override
        public Operation createFromParcel(Parcel in) {
            return new Operation(in);
        }

        @Override
        public Operation[] newArray(int size) {
            return new Operation[size];
        }
    };

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
