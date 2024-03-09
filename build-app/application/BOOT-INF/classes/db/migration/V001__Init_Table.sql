CREATE TABLE Candidate (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    middle_name VARCHAR(255),
    photo VARCHAR(255),
    description TEXT,
    cv_file VARCHAR(255)
);

CREATE TABLE Test (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT
);

CREATE TABLE Candidate_Test (
    id SERIAL PRIMARY KEY,
    candidate_id BIGINT,
    test_id BIGINT,
    FOREIGN KEY (candidate_id) REFERENCES Candidate(id),
    FOREIGN KEY (test_id) REFERENCES Test(id)
);

CREATE TABLE Test_Result (
    id SERIAL PRIMARY KEY,
    date DATE,
    grade INTEGER,
    candidate_test_id BIGINT,
    FOREIGN KEY (candidate_test_id) REFERENCES Candidate_Test(id)
);

CREATE TABLE Direction (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    candidate_id BIGINT,
    test_id BIGINT,
    FOREIGN KEY (candidate_id) REFERENCES Candidate(id),
    FOREIGN KEY (test_id) REFERENCES Test(id)
);

