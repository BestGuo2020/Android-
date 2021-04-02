package com.example.viewpager2study;

public class Item {

    private int color;
    private String text;
    private int textColor;

    public Item(int color, String text, int textColor) {
        this.color = color;
        this.text = text;
        this.textColor = textColor;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
