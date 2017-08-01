package com.fjw.myapp.model;

/**
 * 首页List
 * Created by 范佳伟 on 2017/7/31.
 */

public class MainListModel {


    private int id;

    private String titleName;

    private int goActivityName;

    public MainListModel(int id, String titleName, int goActivityName) {
        this.id = id;
        this.titleName = titleName;
        this.goActivityName = goActivityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getGoActivityName() {
        return goActivityName;
    }

    public void setGoActivityName(int goActivityName) {
        this.goActivityName = goActivityName;
    }
}
