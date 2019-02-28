package com.google.hashcode;

import java.util.List;

public class Photo {
    private int id;
    private List<String> tags;
    private boolean horizontal;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(final boolean horizontal) {
        this.horizontal = horizontal;
    }
}
