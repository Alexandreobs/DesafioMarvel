
package com.example.desafiomarvel.model.pojos.herois;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Personagem implements Parcelable {

    @Expose
    private String attributionHTML;
    @Expose
    private String attributionText;
    @Expose
    private Long code;
    @Expose
    private String copyright;
    @Expose
    private Data data;
    @Expose
    private String etag;
    @Expose
    private String status;

    protected Personagem(Parcel in) {
        attributionHTML = in.readString();
        attributionText = in.readString();
        if (in.readByte() == 0) {
            code = null;
        } else {
            code = in.readLong();
        }
        copyright = in.readString();
        etag = in.readString();
        status = in.readString();
    }

    public static final Creator<Personagem> CREATOR = new Creator<Personagem>() {
        @Override
        public Personagem createFromParcel(Parcel in) {
            return new Personagem(in);
        }

        @Override
        public Personagem[] newArray(int size) {
            return new Personagem[size];
        }
    };

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(attributionHTML);
        parcel.writeString(attributionText);
        if (code == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(code);
        }
        parcel.writeString(copyright);
        parcel.writeString(etag);
        parcel.writeString(status);
    }
}
