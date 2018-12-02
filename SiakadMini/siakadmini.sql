DROP DATABASE IF EXISTS siakadmini;

CREATE DATABASE siakadmini;

USE siakadmini;

CREATE TABLE mahasiswa
(
    nim INTEGER PRIMARY KEY NOT NULL,
    nama VARCHAR(255),
    alamat VARCHAR(255)
);

INSERT INTO mahasiswa (nim, nama, alamat)
	VALUES(1, 'Ani', 'Malang');