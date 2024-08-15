CREATE DATABASE huydqpc07859_finaltest1
GO

USE huydqpc07859_finaltest1
GO

CREATE TABLE USERS (
	ID VARCHAR(255),
	PASSWORD VARCHAR(255),
	FULLNAME VARCHAR(255),
	EMAIL VARCHAR(255),
	ADMIN BIT
)
GO

INSERT INTO USERS (ID, PASSWORD, FULLNAME, EMAIL, ADMIN)
VALUES ('admin', '1234', 'John Doe', 'john.doe@example.com', 1);




-- Add a single column
ALTER TABLE Users
ADD MARRIED BIT;

-- Add multiple columns
ALTER TABLE Users
ADD column1_name VARCHAR(255),
    column2_name BIT,
    column3_name INTEGER;

-- Step 1: Drop the default constraint, if it has constraint
ALTER TABLE Users
DROP CONSTRAINT DF__USERS__MARRIED__25869641
-- Remove a single column
ALTER TABLE Users
DROP COLUMN MARRIED

-- Remove multiple columns
ALTER TABLE Users
DROP COLUMN column1_name, column2_name, column3_name;


-- ALTER COLUMN
ALTER TABLE USERS
ALTER COLUMN FULLNAME VARCHAR(255);


SELECT * FROM USERS
