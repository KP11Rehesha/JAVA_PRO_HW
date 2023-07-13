
CREATE TABLE Homework (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  description TEXT
);


CREATE TABLE Lesson (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  updatedAt TIMESTAMP,
  homework_id INT,
  FOREIGN KEY (homework_id) REFERENCES Homework(id)
);


CREATE TABLE Schedule (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  updatedAt TIMESTAMP
);

-- Зв'язок many-to-many між таблицями Lesson і Schedule
CREATE TABLE LessonSchedule (
  lesson_id INT,
  schedule_id INT,
  FOREIGN KEY (lesson_id) REFERENCES Lesson(id),
  FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
  PRIMARY KEY (lesson_id, schedule_id)
);