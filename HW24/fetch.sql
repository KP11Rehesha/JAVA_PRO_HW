-- Отримання всіх записів Homework
SELECT * FROM Homework;

-- Отримання всіх записів Lesson з даними Homework
SELECT Lesson.*, Homework.*
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id;

-- Отримання всіх записів Lesson з даними Homework, відсортованих за часом оновлення
SELECT Lesson.*, Homework.*
FROM Lesson
JOIN Homework ON Lesson.homework_id = Homework.id
ORDER BY Lesson.updatedAt;

-- Отримання всіх записів Schedule з даними Lesson
SELECT Schedule.*, Lesson.*
FROM Schedule
JOIN LessonSchedule ON Schedule.id = LessonSchedule.schedule_id
JOIN Lesson ON Lesson.id = LessonSchedule.lesson_id;

-- Отримання кількості Lesson для кожного Schedule
SELECT Schedule.id, Schedule.name, COUNT(LessonSchedule.lesson_id) AS lesson_count
FROM Schedule
LEFT JOIN LessonSchedule ON Schedule.id = LessonSchedule.schedule_id
GROUP BY Schedule.id, Schedule.name;