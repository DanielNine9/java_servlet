CREATE DATABASE finaltest1
GO

USE finaltest1

--drop database finaltest1
GO

CREATE TABLE USERS (
	ID VARCHAR(255),
	PASSWORD VARCHAR(255),
	FULLNAME VARCHAR(255),
	EMAIL VARCHAR(255),
	image VARCHAR(255),
	hobby VARCHAR(255),
	married bit,
	ADMIN BIT
)
GO

INSERT INTO USERS (ID, PASSWORD, FULLNAME, EMAIL, ADMIN, married)
VALUES ('admin', '1234', 'John Doe', 'john.doe@example.com', 1, 1);
go



-- Add a single column
ALTER TABLE Users
ADD new_column_name VARCHAR(255);
go
-- Add multiple columns
ALTER TABLE Users
ADD column1_name VARCHAR(255),
    column2_name BIT,
    column3_name INTEGER;
	go
-- Remove a single column
ALTER TABLE Users
DROP COLUMN new_column_name
go
-- Remove multiple columns
ALTER TABLE Users
DROP COLUMN column1_name, column2_name, column3_name;
go

-- ALTER COLUMN
ALTER TABLE USERS
ALTER COLUMN FULLNAME VARCHAR(255);
go

SELECT * FROM USERS
