CREATE DATABASE CarWashDB;
GO
USE CarWashDB;
GO

-- Bookings Table
CREATE TABLE CarWashBookings (
    BookingID INT IDENTITY PRIMARY KEY,
    CustomerName NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(15) NOT NULL,
    Email NVARCHAR(100),
    Location NVARCHAR(200) NOT NULL,
    Latitude NVARCHAR(50),
    Longitude NVARCHAR(50),
    ServiceType NVARCHAR(50) NOT NULL,
    BookingDate DATETIME DEFAULT GETDATE()
);

-- Admin Table
CREATE TABLE AdminUsers (
    AdminID INT IDENTITY PRIMARY KEY,
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL
);

-- Default Admin
INSERT INTO AdminUsers (Username, Password) VALUES ('admin', 'admin123');
