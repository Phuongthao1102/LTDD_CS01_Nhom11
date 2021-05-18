package com.example.ungdungtaptheduc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int verson) {
        super(context,name,factory,verson);
    }
//    public Database(Context context) {
//        super(context,"Workout.db",null,1);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("Create Table BMI(ChieuCao text primary key,CanNang text,Bmi text)");
        db.execSQL("CREATE TABLE Alarm(id INTEGER PRIMARY KEY AUTOINCREMENT, hour INTEGER , minute INTEGER, " +
                "days TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Workout.db");
        db.execSQL("DROP TABLE IF EXISTS Alarm");
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public boolean ThemBMI(String chieucao,String cannang,String bmi,int Chon,String NhanXet){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ChieuCao",chieucao);
        contentValues.put("CanNang",cannang);
        contentValues.put("Bmi",bmi);
        contentValues.put("Chon",Chon);
        contentValues.put("NhanXet",NhanXet);

        long result = DB.insert("BMI",null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean CapNhatBMI(String chieucao,String cannang,String bmi,int Chon,String NhanXet){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CanNang",cannang);
        contentValues.put("Bmi",bmi);
        contentValues.put("Chon",Chon);
        contentValues.put("NhanXet",NhanXet);

        Cursor cursor = DB.rawQuery("Select * from BMI where cannang=?",new String[]{cannang});
        if(cursor.getCount() > 0) {
            long result = DB.update("BMI", contentValues, "cannang=?", new String[]{cannang});
            if (result == -1)
                return false;
            else
                return true;
        }
        else{
            return  false;
        }
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql,null);
//        Cursor cursor = database.rawQuery("Select * from BMI", null);
//        return cursor;
    }


    public Boolean insertAlarm(int hour, int minute, String days) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hour", hour);
        contentValues.put("minute", minute);
        contentValues.put("days", days);

        long result = DB.insert("Alarm", null, contentValues);
        if(result == -1) {
            return false;
        }else {
            return true;
        }
    }

    public Boolean updateAlarm(int id, int hour, int minute, String days) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hour", hour);
        contentValues.put("minute", minute);
        contentValues.put("days", days);

        Cursor cursor = DB.rawQuery("select * from Alarm where id = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Alarm", contentValues, "id = ?", new String[]{String.valueOf(id)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }


    public Boolean deleteAlarm(int id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Cursor cursor = DB.rawQuery("select * from Alarm where id = ?", new String[]{String.valueOf(id)});
        if(cursor.getCount() > 0) {
            long result = DB.delete("Alarm", "id = ?", new String[]{String.valueOf(id)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getDataAlarm() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Alarm", null);
        return cursor;
    }
}
