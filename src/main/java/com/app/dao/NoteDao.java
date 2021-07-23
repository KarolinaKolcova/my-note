package com.app.dao;

import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NoteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNote(Note note) {
        jdbcTemplate.update("INSERT INTO notes (title, description, author, categories) " +
                "VALUES(?, ?, 1, 'COL')", note.getTitle(), note.getDescription());
    }

    public List<Note> getAllNotes() {
        RowMapper<Note> rowMapper = (rs, i) -> mapNote(rs);
        return jdbcTemplate.query( "SELECT n.title, n.description, n.categories, u.first_name, u.last_name, u.email " +
                "FROM notes n " +
                "LEFT OUTER JOIN users u ON n.author = u.id",rowMapper);
    }

    private Note mapNote(ResultSet rs) throws SQLException {
        User user = new User(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"));

        return new Note(
                rs.getString("Title"),
                rs.getString("Description"),
                user,
                Categories.valueOf(rs.getString("categories"))
        );
    }

}
