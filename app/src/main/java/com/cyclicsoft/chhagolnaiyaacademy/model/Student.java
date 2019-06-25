package com.cyclicsoft.chhagolnaiyaacademy.model;

public class Student {
    private String UID;
    private String sName;
    private String sFather;
    private String sMother;
    private String sEmail;
    private String sPhone;
    private String sPAddress;
    private String sNID;
    private String sSSCBatch;
    private String sUniversity;
    private String sProfessions;
    private String sPrAddress;

    public Student(String UID) {
        this.UID = UID;
    }

    public Student(String UID, String sName, String sFather, String sMother, String sEmail, String sPhone, String sPAddress, String sNID, String sSSCBatch, String sUniversity, String sProfessions, String sPrAddress) {
        this.UID = UID;
        this.sName = sName;
        this.sFather = sFather;
        this.sMother = sMother;
        this.sEmail = sEmail;
        this.sPhone = sPhone;
        this.sPAddress = sPAddress;
        this.sNID = sNID;
        this.sSSCBatch = sSSCBatch;
        this.sUniversity = sUniversity;
        this.sProfessions = sProfessions;
        this.sPrAddress = sPrAddress;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsFather() {
        return sFather;
    }

    public void setsFather(String sFather) {
        this.sFather = sFather;
    }

    public String getsMother() {
        return sMother;
    }

    public void setsMother(String sMother) {
        this.sMother = sMother;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsPAddress() {
        return sPAddress;
    }

    public void setsPAddress(String sPAddress) {
        this.sPAddress = sPAddress;
    }

    public String getsNID() {
        return sNID;
    }

    public void setsNID(String sNID) {
        this.sNID = sNID;
    }

    public String getsSSCBatch() {
        return sSSCBatch;
    }

    public void setsSSCBatch(String sSSCBatch) {
        this.sSSCBatch = sSSCBatch;
    }

    public String getsUniversity() {
        return sUniversity;
    }

    public void setsUniversity(String sUniversity) {
        this.sUniversity = sUniversity;
    }

    public String getsProfessions() {
        return sProfessions;
    }

    public void setsProfessions(String sProfessions) {
        this.sProfessions = sProfessions;
    }

    public String getsPrAddress() {
        return sPrAddress;
    }

    public void setsPrAddress(String sPrAddress) {
        this.sPrAddress = sPrAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "UID='" + UID + '\'' +
                ", sName='" + sName + '\'' +
                ", sFather='" + sFather + '\'' +
                ", sMother='" + sMother + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sPAddress='" + sPAddress + '\'' +
                ", sNID='" + sNID + '\'' +
                ", sSSCBatch='" + sSSCBatch + '\'' +
                ", sUniversity='" + sUniversity + '\'' +
                ", sProfessions='" + sProfessions + '\'' +
                ", sPrAddress='" + sPrAddress + '\'' +
                '}';
    }
}
