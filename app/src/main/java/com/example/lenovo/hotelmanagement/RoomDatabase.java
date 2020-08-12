package com.example.lenovo.hotelmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RoomDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_ROOM = "room";

    // User Table Columns names
    private static final String COLUMN_ROOM_ID = "user_id";
    private static final String COLUMN_ROOM_NO = "user_name";
    private static final String COLUMN_ROOM_RATE = "user_email";
    private static final String COLUMN_ROOM_TYPE = "user_password";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_ROOM + "("
            + COLUMN_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ROOM_NO + " INTEGER,"
            + COLUMN_ROOM_RATE + " INTEGER," + COLUMN_ROOM_TYPE + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_ROOM;

    /**
     * Constructor
     *
     * @param context
     */
    public RoomDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        addUser(101,3000,"Quad");
        addUser(102,2000,"Double");
        addUser(103,1500,"Single");
        addUser(104,3000,"Quad");
        addUser(105,2000,"Double");
        addUser(201,1500,"Single");
        addUser(202,3000,"Quad");
        addUser(203,2000,"Double");
        addUser(204,1500,"Single");
        addUser(205,3000,"Quad");
        addUser(301,2000,"Double");
        addUser(302,1500,"Single");
        addUser(303,3000,"Quad");
        addUser(304,2000,"Double");
        addUser(305,1500,"Single");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     */
    public void addUser(int roomNo,int roomRate,String roomType) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROOM_NO,roomNo );
        values.put(COLUMN_ROOM_RATE, roomRate);
        values.put(COLUMN_ROOM_TYPE, roomType);

        // Inserting Row
        db.insert(TABLE_ROOM, null, values);
        db.close();
    }


    public boolean checkUser(String username, String password){
        String[] columns = {COLUMN_ROOM_ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COLUMN_ROOM_NO + " = ?" + " AND " + COLUMN_ROOM_TYPE + " = ?";

        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_ROOM,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;

    }
}
