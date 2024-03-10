-- Вставка еще одного кандидата
INSERT INTO Candidate (first_name, last_name, middle_name, photo, description, cv_file)
VALUES ('Jane', 'Doe', 'Middle', 'jane_photo.jpg', 'Another description', 'jane_cv_file.pdf');

-- Вставка тестовых данных в таблицу Test
INSERT INTO Test (name, description)
VALUES ('Test 3', 'Description for Test 3'),
       ('Test 4', 'Description for Test 4');

-- Вставка тестовых данных в таблицу Candidate_Test
INSERT INTO Candidate_Test (candidate_id, test_id)
VALUES (2, 3),  -- соответствует кандидату Jane и тесту Test 3
       (2, 4);  -- соответствует кандидату Jane и тесту Test 4

-- Вставка тестовых данных в таблицу Test_Result
INSERT INTO Test_Result (date, grade, candidate_test_id)
VALUES ('2024-03-09', 92, 3),  -- соответствует результату теста кандидата Jane по Test 3
       ('2024-03-10', 78, 4);  -- соответствует результату теста кандидата Jane по Test 4

-- Вставка тестовых данных в таблицу Direction
INSERT INTO Direction (name, description, candidate_id, test_id)
VALUES ('Direction 3', 'Description for Direction 3', 2, 3),
       ('Direction 4', 'Description for Direction 4', 2, 4);
