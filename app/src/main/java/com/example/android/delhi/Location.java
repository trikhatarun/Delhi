package com.example.android.delhi;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by trikh on 11-10-2016.
 */

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
    private int mTitleId;
    private int mImageId;
    private int mLocationUrlId;
    private int mDescriptionId;

    public Location(int titleId, int imageId, int descriptionId, int locationUrlId) {
        mTitleId = titleId;
        mImageId = imageId;
        mDescriptionId = descriptionId;
        mLocationUrlId = locationUrlId;
    }

    public Location(Parcel in) {
        mTitleId = in.readInt();
        mImageId = in.readInt();
        mDescriptionId = in.readInt();
        mLocationUrlId = in.readInt();
    }

    public int getmTitleId() {
        return mTitleId;
    }

    public int getmImageId() {
        return mImageId;
    }

    public int getmDescriptionId() {
        return mDescriptionId;
    }

    public int getmLocationUrlId() {
        return mLocationUrlId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mTitleId);
        parcel.writeInt(mImageId);
        parcel.writeInt(mDescriptionId);
        parcel.writeInt(mLocationUrlId);
    }
}
