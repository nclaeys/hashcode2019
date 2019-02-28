package com.google.hashcode;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class Photo {
    private int id;
    private List<String> tags;
    private boolean horizontal;

    public Photo(int index, String orientation, List<String> tags) {
        this.id = index;
        if(orientation.equals("H")) {
            horizontal = true;
        }
        this.tags = tags;
    }

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        return new EqualsBuilder()
                .append(id, photo.id)
                .append(horizontal, photo.horizontal)
                .append(tags, photo.tags)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(tags)
                .append(horizontal)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("tags", tags)
                .append("horizontal", horizontal)
                .toString();
    }
}
