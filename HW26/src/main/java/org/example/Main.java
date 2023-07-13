package org.example;

import org.example.entities.Homework;
import org.example.entities.Lesson;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Приклад використання LessonDao

            // Створення з'єднання з базою даних
            Connection connection = DataBaseConnection.getConnection();

            // Створення екземпляру LessonDao
            LessonDao lessonDao = new LessonDao();

            // Створення об'єкта Homework
            Homework homework = new Homework(1, "Homework 1", "Description for Homework 1");

            // Створення об'єкта Lesson
            Lesson lesson = new Lesson(1, "Lesson 1", homework);

            // Додавання уроку до бази даних
            lessonDao.addLesson(lesson);

            // Отримання всіх уроків з бази даних
            List<Lesson> lessons = lessonDao.getAllLessons();
            for (Lesson l : lessons) {
                System.out.println("Lesson ID: " + l.getId());
                System.out.println("Lesson Name: " + l.getName());
                System.out.println("Homework ID: " + l.getHomework().getId());
                System.out.println("Homework Name: " + l.getHomework().getName());
                System.out.println("Homework Description: " + l.getHomework().getDescription());
                System.out.println("---------------------------");
            }

            // Отримання уроку за ID
            Lesson retrievedLesson = lessonDao.getLessonById(1);
            if (retrievedLesson != null) {
                System.out.println("Retrieved Lesson:");
                System.out.println("Lesson ID: " + retrievedLesson.getId());
                System.out.println("Lesson Name: " + retrievedLesson.getName());
                System.out.println("Homework ID: " + retrievedLesson.getHomework().getId());
                System.out.println("Homework Name: " + retrievedLesson.getHomework().getName());
                System.out.println("Homework Description: " + retrievedLesson.getHomework().getDescription());
            } else {
                System.out.println("Lesson not found.");
            }

            // Видалення уроку з бази даних
            lessonDao.deleteLesson(4);

            // Закриття з'єднання з базою даних
            DataBaseConnection.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
