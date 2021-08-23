package dao;

import db.DB;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oNewsDao implements NewsDao{


    @Override
    public void add(News news) {
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO news (title, description) VALUES (:title, :description)";
            int id = (int) conn.createQuery(sql, true)
//                    .addParameter("title", news.getTitle())
//                    .addParameter("description", news.getDescription())
//                    .addParameter("type", news.getType())
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Exception ex){
            System.out.println("Unable to add news: " + ex);
        }
    }



    @Override
    public void addNewsToDepartment(int deptId, int newsId, int employeeId) {
        try(Connection conn = DB.sql2o.open()){
            String sql = "INSERT INTO departments_news (deptid, newsid, userid) VALUES (:deptId, :newsId, :employeeId)";
            conn.createQuery(sql)
                    .addParameter("deptId", deptId)
                    .addParameter("newsId", newsId)
                    .addParameter("employeeId", employeeId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Unable to add news to department: " + ex);
        }
    }

    @Override
    public List<News> AllNews() {
        try(Connection conn = DB.sql2o.open()){
            String sql = "SELECT * FROM news";
            return conn.createQuery(sql).executeAndFetch(News.class);
        }
    }

    @Override
    public List<News> allDepartmentsNews() {
        try(Connection conn = DB.sql2o.open()){
            String sql = "SELECT * FROM news";
            return conn.createQuery(sql)
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public void deleteById(int id) {
        try(Connection conn = DB.sql2o.open()){
            String sql = "DELETE from news WHERE id=:id";
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Delete news by id: " + id);
        }
    }

    @Override
    public void clearAll() {
        try(Connection conn = DB.sql2o.open()){
            String sql = "DELETE FROM news";
            conn.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println("Unable to delete all: " + ex);
        }
    }
}
