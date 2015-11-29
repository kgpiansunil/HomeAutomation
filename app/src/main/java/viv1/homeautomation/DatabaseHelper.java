package viv1.homeautomation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 29/11/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "spn_room.db";
    private static final int DATABASE_VERSION = 1;

    //SQL statement for creating a Table
    private static final String CREATE_TABLE_ROOM= "create table room"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "bid" + " text not null, "
            + "room_name" + " text not null, "
            + "room_address" + " text not null, "
            + "isVisible" + " text not null " + ")";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ROOM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CREATE_TABLE_ROOM);
    }
}