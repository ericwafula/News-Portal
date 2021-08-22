package models;

import java.util.Objects;

public class News {
    private String title;
    String description;
    private String type;
    private int id;

    public News(String title, String description) {
        this.title = title;
        this.description = description;
        this.type = "General";
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return getId() == news.getId() &&
                Objects.equals(getTitle(), news.getTitle()) &&
                Objects.equals(getDescription(), news.getDescription()) &&
                Objects.equals(getType(), news.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getType(), getId());
    }
}
