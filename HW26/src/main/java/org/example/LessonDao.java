package org.example;
import org.example.entities.Homework;
import org.example.entities.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    public void addLesson(Lesson lesson) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DataBaseConnection.getConnection();
            String query = "INSERT INTO Lesson (name, homework_id) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            DataBaseConnection.close(connection);
        }
    }

    public void deleteLesson(int lessonId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DataBaseConnection.getConnection();
            String query = "DELETE FROM Lesson WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        } finally {
            if (statement != null) {
                statement.close();
            }
            DataBaseConnection.close(connection);
        }
    }

    public List<Lesson> getAllLessons() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT Lesson.id, Lesson.name, Homework.id, Homework.name, Homework.description " +
                    "FROM Lesson INNER JOIN Homework ON Lesson.homework_id = Homework.id";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            List<Lesson> lessons = new ArrayList<>();
            while (resultSet.next()) {
                int lessonId = resultSet.getInt(1);
                String lessonName = resultSet.getString(2);
                int homeworkId = resultSet.getInt(3);
                String homeworkName = resultSet.getString(4);
                String homeworkDescription = resultSet.getString(5);

                Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);
                Lesson lesson = new Lesson(lessonId, lessonName, homework);
                lessons.add(lesson);
            }

            return lessons;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            DataBaseConnection.close(connection);
        }
    }

    public Lesson getLessonById(int lessonId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DataBaseConnection.getConnection();
            String query = "SELECT Lesson.id, Lesson.name, Homework.id, Homework.name, Homework.description " +
                    "FROM Lesson INNER JOIN Homework ON Lesson.homework_id = Homework.id " +
                    "WHERE Lesson.id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String lessonName = resultSet.getString(2);
                int homeworkId = resultSet.getInt(3);
                String homeworkName = resultSet.getString(4);
                String homeworkDescription = resultSet.getString(5);

                Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);
                return new Lesson(lessonId, lessonName, homework);
            }

            return null; // Повертаємо null, якщо урок не знайдено
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            DataBaseConnection.close(connection);
        }
    }
}