package com.example.swipeviewsusingviewpager.Module;

public class SwipeModule {


    private int imageItem;
    private String titleItem;
    private String descItem;


    public SwipeModule(int imageItem, String titleItem, String descItem) {
        this.imageItem = imageItem;
        this.titleItem = titleItem;
        this.descItem = descItem;
    }


    public int getImageItem() {
        return imageItem;
    }

    public void setImageItem(int imageItem) {
        this.imageItem = imageItem;
    }

    public String getTitleItem() {
        return titleItem;
    }

    public void setTitleItem(String titleItem) {
        this.titleItem = titleItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }
}
