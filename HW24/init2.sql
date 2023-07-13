
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

INSERT INTO Homework (name, description)
VALUES ('Homework 1', 'Description for Homework 1'),
       ('Homework 2', 'Description for Homework 2'),
       ('Homework 3', 'Description for Homework 3');

INSERT INTO Lesson (name, updatedAt, homework_id)
VALUES ('Lesson 1', CURRENT_TIMESTAMP, 1),
       ('Lesson 2', CURRENT_TIMESTAMP, 2),
       ('Lesson 3', CURRENT_TIMESTAMP, 3);


INSERT INTO Schedule (name, updatedAt)
VALUES ('Schedule 1', CURRENT_TIMESTAMP),
       ('Schedule 2', CURRENT_TIMESTAMP),
       ('Schedule 3', CURRENT_TIMESTAMP);


INSERT INTO LessonSchedule (lesson_id, schedule_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 3);