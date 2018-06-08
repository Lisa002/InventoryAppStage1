package com.example.android.inventoryappstage1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.inventoryappstage1.data.HeadphonesContract.HeadphonesEntry;

public class ProductDbHelper extends SQLiteOpenHelper {

    /**
     * Creates constants for the databse name and database version
     */
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "product.db";

    /**
     * Creates a constructor
     */

    public ProductDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_HEADPHONES_TABLE = "CREATE TABLE " + HeadphonesEntry.TABLE_NAME + " ("
                + HeadphonesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HeadphonesEntry.COLUMN_HEADPHONES_PRODUCT_NAME + " TEXT, "
                + HeadphonesEntry.COLUMN_HEADPHONES_PRICE + " INTEGER NOT NULL, "
                + HeadphonesEntry.COLUMN_HEADPHONES_QUANTITY + " INTEGER, "
                + HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_NAME + " TEXT NOT NULL, "
                + HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_PHONE_NUMBER + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_HEADPHONES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}

}
