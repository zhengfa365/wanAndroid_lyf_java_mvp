package com.example.lyfwanandroid.module.main.model;

public class TabBean {
    private String tabName;
    private int tabIcon;

    public TabBean(String tabName, int tabIcon) {
        this.tabName = tabName;
        this.tabIcon = tabIcon;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getTabIcon() {
        return tabIcon;
    }

    public void setTabIcon(int tabIcon) {
        this.tabIcon = tabIcon;
    }
}
