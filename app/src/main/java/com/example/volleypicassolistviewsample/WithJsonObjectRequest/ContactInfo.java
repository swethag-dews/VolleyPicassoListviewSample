package com.example.volleypicassolistviewsample.WithJsonObjectRequest;

public class ContactInfo {

    String id, name, emailId, phNo;

    public ContactInfo(String id, String name, String emailId, String phNo){
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phNo = phNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhNo() {
        return phNo;
    }
}
