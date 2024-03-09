-- Вставка тестовых данных в таблицу Candidate
INSERT INTO Candidate (first_name, last_name, middle_name, photo, description, cv_file)
VALUES ('John', 'Doe', 'Middle', 'photo.jpg', 'Some description', 'cv_file.pdf');

-- Вставка тестовых данных в таблицу Test
INSERT INTO Test (name, description)
VALUES ('Test 1', 'Description for Test 1'),
       ('Test 2', 'Description for Test 2');

-- Вставка тестовых данных в таблицу Candidate_Test
INSERT INTO Candidate_Test (candidate_id, test_id)
VALUES (1, 1),  -- соответствует кандидату John и тесту Test 1
       (1, 2);  -- соответствует кандидату John и тесту Test 2

-- Вставка тестовых данных в таблицу Test_Result
INSERT INTO Test_Result (date, grade, candidate_test_id)
VALUES ('2024-03-09', 85, 1);  -- соответствует результату теста кандидата John по Test 1

-- Вставка тестовых данных в таблицу Direction
INSERT INTO Direction (name, description, candidate_id, test_id)
VALUES ('Direction 1', 'Description for Direction 1', 1, 1),
       ('Direction 2', 'Description for Direction 2', 1, 2);
