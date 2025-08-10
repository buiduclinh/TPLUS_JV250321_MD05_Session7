package com.example.ex.repo.impl;

import com.example.ex.model.Movie;
import com.example.ex.repo.MovieDAO;
import com.example.ex.util.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieImpl implements MovieDAO {
    @Override
    public List<Movie> getMovies() {
        String sql = "{CALL get_all_movie()}";
        List<Movie> movies = new ArrayList<>();
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseDate(Date.valueOf(rs.getString("release_date")).toLocalDate());
                movie.setGenre(rs.getString("genre"));
                movie.setPoster(rs.getString("poster"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        String sql = "{CALL get_movie_by_id(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement stmt = conn.prepareCall(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseDate(LocalDate.parse(rs.getString("release_date")));
                movie.setGenre(rs.getString("genre"));
                movie.setPoster(rs.getString("poster"));
                return movie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMovie(Movie movie) {
        String sql = "{CALL add_movie(?,?,?,?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement callStmt = conn.prepareCall(sql);) {
            callStmt.setString(1, movie.getTitle());
            callStmt.setString(2, movie.getDirector());
            callStmt.setString(3, movie.getGenre());
            callStmt.setDate(4, Date.valueOf(movie.getReleaseDate()));
            callStmt.setString(5, movie.getPoster());
            int row = callStmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        String sql = "{CALL update_movie(?,?,?,?,?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement callStmt = conn.prepareCall(sql);) {
            callStmt.setString(1, movie.getTitle());
            callStmt.setString(2, movie.getDirector());
            callStmt.setString(3, movie.getGenre());
            callStmt.setDate(4, Date.valueOf(movie.getReleaseDate()));
            callStmt.setString(5, movie.getPoster());
            callStmt.setInt(6, movie.getId());
            int row = callStmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMovie(int id) {
        String sql = "{CALL delete_movie(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement callStmt = conn.prepareCall(sql);) {
            callStmt.setInt(1, id);
            int row = callStmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
