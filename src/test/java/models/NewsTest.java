package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;

public class NewsTest {
    @Test
    public void news_instantiatesCorrectly_true() {
        News newNews = new News("Get Money","I be getting Money");
        assertEquals(true, newNews instanceof News);
    }

    @Test
    public void title_returnsTitle_title(){
        News news = createNews();
        assertEquals("Get Money", news.getTitle());
    }

    @Test
    public void description_returnsDescription() {
        News news = createNews();
        assertEquals("I be getting Money", news.getDescription());
    }

    @Test
    public void description_returnsType() {
        News news = createNews();
        assertEquals("General", news.getType());
    }

    @Test
    public void description_setsType() {
        News news = createNews();
        news.setType("Department");
        assertEquals("Department", news.getType());
    }

    @Test
    public void description_returnsId() {
        News news = createNews();
        news.setId(1);
        assertEquals(1, news.getId());
    }

    @Test
    public void title_setsTitle() {
        News news = createNews();
        news.setTitle("Get Paper");
        assertEquals("Get Paper", news.getTitle());
    }

    @Test
    public void title_setsDescription() {
        News news = createNews();
        news.setDescription("I be getting Paper");
        assertEquals("I be getting Paper", news.getDescription());
    }

    @Test
    public void news_titleAndDescriptionAreTheSame_true() {
        News news1 = createNews();
        News news2 = createNews();
        assertEquals(true, news1.equals(news2));
    }

    public News createNews(){
        return new News("Get Money","I be getting Money");
    }
}
