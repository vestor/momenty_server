package com.momenty.entity;

import org.springframework.data.annotation.Id;

import java.util.Map;

/**
 * Created by manish on 13/09/16.
 */
public class Selection {

    @Id
    private String id;
    private String url;
    private Long userId;
    private String text;
    private Map<String,Object> range;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selection selection = (Selection) o;

        if (id != null ? !id.equals(selection.id) : selection.id != null) return false;
        if (url != null ? !url.equals(selection.url) : selection.url != null) return false;
        if (userId != null ? !userId.equals(selection.userId) : selection.userId != null) return false;
        if (text != null ? !text.equals(selection.text) : selection.text != null) return false;
        return range != null ? range.equals(selection.range) : selection.range == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (range != null ? range.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Selection{");
        sb.append("id='").append(id).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", text='").append(text).append('\'');
        sb.append(", range=").append(range);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getRange() {
        return range;
    }

    public void setRange(Map<String, Object> range) {
        this.range = range;
    }

    private Selection(Builder builder) {
        this.url = builder.url;
        this.userId = builder.userId;
        this.text = builder.text;
        this.range = builder.range;
        this.id = builder.id;
    }

    public static Builder getBuilder() {
        return new Builder();
    }


    public static class Builder {

        private String id;
        private String url;
        private Long userId;
        private String text;
        private Map<String,Object> range;

        private Builder() {}

        public Builder url(String url) {
            this.url= url;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder range(Map<String, Object> range) {
            this.range = range;
            return this;
        }

        public Selection build() {
            Selection build = new Selection(this);
            return build;
        }
    }



}
