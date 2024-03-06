package com.example.quanylysinhvien.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanylysinhvien.R;
import com.example.quanylysinhvien.model.SinhVien;

import java.util.ArrayList;

public class DBHeplper extends SQLiteOpenHelper {
    public DBHeplper(@Nullable Context context) {
        super(context, "QUANLYSINHVIENFPTDB.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //tạo table lớp
        String sql = " CREATE TABLE LOP(maLop TEXT PRIMARY KEY, tenLop TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('TH1903','Lap Trinh Android')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('TH1904','Lap Trinh PHP')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('KH1901','Tri Tue Nhan Tao')";
        db.execSQL(sql);

        //tao table calendar event
        sql = "CREATE TABLE EventCalendar(Date TEXT, Event TEXT)";
        db.execSQL(sql);
        //tạo table sinh viên
        sql = " CREATE TABLE SINHVIEN(maSv TEXT PRIMARY KEY, tenSV TEXT ," + " email TEXT ,hinh TEXT, maLop TEXT REFERENCES LOP(maLop))";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('19DH110749','Truong Hue Dinh','trhudinjz@gmail.com','avatargirl','KH1901')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('19DH110651','Ta Anh Thi','TAT@gmail.com','avatarboy1','TH1903')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('19DH000001','Nano Na Kha','nano@gmail.','avatargirl1','TH1904')";
        db.execSQL(sql);
        //tạo table taikhoancom
        sql = "CREATE TABLE taiKhoan(tenTaiKhoan text primary key, matKhau text)";
        db.execSQL(sql);
        //tai khoan mac dinh admin
        sql = "INSERT INTO taiKhoan VALUES('admin','admin')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
