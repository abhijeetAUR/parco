package com.hexagon.parcodriver.model;

import android.graphics.drawable.Drawable;

public class NevigationItem {
    public String menuname;
    public Drawable drawable;

    public NevigationItem(String menuname, Drawable drawable) {
        this.menuname = menuname;
        this.drawable = drawable;
    }
}
