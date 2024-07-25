create database polyoe_new
go

use polyoe_new



CREATE TABLE USERS(
    ID NVARCHAR(50) primary key,
    PASSWORD NVARCHAR(50),
    FULLNAME NVARCHAR(50),
    EMAIL NVARCHAR(50),
    ADMIN BIT
);

CREATE TABLE Videos (
    id NVARCHAR(255) PRIMARY KEY,
    title NVARCHAR(255) NOT NULL,
    poster NVARCHAR(255),
    description NVARCHAR(MAX),
    views INT DEFAULT 0,
    active BIT DEFAULT 1
);

CREATE TABLE Favorites (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    UserId NVARCHAR(50) NOT NULL,
    VideoId NVARCHAR(255) NOT NULL,
    likeDate DATE NOT NULL DEFAULT GETDATE(),
    CONSTRAINT UC_Favorites UNIQUE (VideoId, UserId),
    CONSTRAINT FK_Favorites_User FOREIGN KEY (UserId) REFERENCES Users(ID),
    CONSTRAINT FK_Favorites_Video FOREIGN KEY (VideoId) REFERENCES Videos(id)
);

delete favorites
delete videos
delete users


INSERT INTO USERS (ID, PASSWORD, FULLNAME, EMAIL, ADMIN)
VALUES 
('user1', 'password1', 'John Doe', 'john@example.com', 0),
('user2', 'password2', 'Jane Smith', 'jane@example.com', 1),
('user3', 'password3', 'Alice Johnson', 'alice@example.com', 0),
('user4', 'password4', 'Bob Brown', 'bob@example.com', 0),
('user5', 'password5', 'Carol White', 'carol@example.com', 1),
('user6', 'password6', 'David Black', 'david@example.com', 0),
('user7', 'password7', 'Eva Green', 'eva@example.com', 0);

-- Insert data into the Videos table
INSERT INTO Videos (id, title, poster, description, views, active)
VALUES 
('video1', 'Introduction to SQL', 'poster1.png', 'An introductory video on SQL.', 100, 1),
('video2', 'Advanced SQL Queries', 'poster2.png', 'A video on advanced SQL query techniques.', 150, 1),
('video3', 'Database Design', 'poster3.png', 'A video on designing relational databases.', 200, 1),
('video4', 'Normalization in Databases', 'poster4.png', 'A video explaining normalization.', 250, 1),
('video5', 'SQL Performance Tuning', 'poster5.png', 'A video on optimizing SQL queries.', 300, 1),
('video6', 'Transactions and Concurrency', 'poster6.png', 'A video on handling transactions and concurrency in SQL.', 350, 1),
('video7', 'Introduction to NoSQL', 'poster7.png', 'An introductory video on NoSQL databases.', 400, 1);
('java1', 'Java for beginners', 'poster1.png', 'Java for beginners, give you understand for all.', 100, 1)

-- Insert data into the Favorites table
INSERT INTO Favorites (UserId, VideoId, likeDate)
VALUES 
('user1', 'video1', GETDATE()),
('user1', 'video2', GETDATE()),
('user2', 'video2', GETDATE()),
('user2', 'video3', GETDATE()),
('user3', 'video1', GETDATE()),
('user3', 'video3', GETDATE()),
('user4', 'video4', GETDATE()),
('user5', 'video5', GETDATE()),
('user6', 'video6', GETDATE()),
('user7', 'video7', GETDATE()),
('user7', 'video1', GETDATE()),
('user6', 'video4', GETDATE()),
('user5', 'video2', GETDATE()),
('user4', 'video3', GETDATE());



