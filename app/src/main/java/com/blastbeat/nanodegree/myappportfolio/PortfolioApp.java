package com.blastbeat.nanodegree.myappportfolio;

/**
 * Created by ilkka on 6.3.2016.
 */
public class PortfolioApp {
    private String mName;
    private String mToastMessage;
    private boolean mHighlighted;

    PortfolioApp(String name, String toastMessage) {
        this(name, toastMessage, false);
    }

    PortfolioApp(String name, String toastMessage, boolean highlighted) {
        mName = name;
        mToastMessage = toastMessage;
        mHighlighted = highlighted;
    }

    public final String getName() {
        return mName;
    }

    public final String getToastMessage() {
        return mToastMessage;
    }

    public final boolean isHighlighted() { return mHighlighted; }

    @Override
    public String toString() {
        return mName;
    }
}
