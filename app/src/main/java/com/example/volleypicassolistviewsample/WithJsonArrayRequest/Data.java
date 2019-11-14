package com.example.volleypicassolistviewsample.WithJsonArrayRequest;

public class Data {

    private String imageurl;
    private String download_count;
    private String view_count;

    public Data(String imageurl, String download_count, String view_count) {

        this.imageurl = imageurl;
        this.download_count = download_count;
        this.view_count = view_count;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getDownload_count() {
        return download_count;
    }

    public String getView_count() {
        return view_count;
    }
}
