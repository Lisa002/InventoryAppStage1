package com.example.android.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.inventoryappstage1.data.HeadphonesContract.HeadphonesEntry;
import com.example.android.inventoryappstage1.data.ProductDbHelper;


public class MainActivity extends AppCompatActivity {

    private ProductDbHelper mDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new ProductDbHelper(this);
        insertProduct();
        displayDatabaseInfo();
    }

    private void insertProduct() {

        try {

            SQLiteDatabase db = mDbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(HeadphonesEntry.COLUMN_HEADPHONES_PRODUCT_NAME, "Ear buds");
            values.put(HeadphonesEntry.COLUMN_HEADPHONES_PRICE, 258);
            values.put(HeadphonesEntry.COLUMN_HEADPHONES_QUANTITY, 2);
            values.put(HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_NAME, "Rudolf");
            values.put(HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_PHONE_NUMBER, 03);

            long newRowId = db.insert("headphones", null, values);


        } catch (Exception e) {

        }
    }

    private void displayDatabaseInfo() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                BaseColumns._ID,
                HeadphonesEntry.COLUMN_HEADPHONES_PRODUCT_NAME,
                HeadphonesEntry.COLUMN_HEADPHONES_PRICE,
                HeadphonesEntry.COLUMN_HEADPHONES_QUANTITY,
                HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_NAME,
                HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_PHONE_NUMBER

        };

        Cursor cursor = db.query(
                HeadphonesEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null


        );
        try {

            int idColumnIndex = cursor.getColumnIndex(HeadphonesEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(HeadphonesEntry.COLUMN_HEADPHONES_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(HeadphonesEntry.COLUMN_HEADPHONES_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(HeadphonesEntry.COLUMN_HEADPHONES_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_NAME);
            int supplierPhoneNumberColumnIndex = cursor.getColumnIndex(HeadphonesEntry.COLUMN_HEADPHONES_SUPPLIER_PHONE_NUMBER);


            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {

                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                int currentPrice = cursor.getInt(priceColumnIndex);
                int currentQuantity = cursor.getInt(quantityColumnIndex);
                String currentSupplierName = cursor.getString(supplierNameColumnIndex);
                int currentSupplierPhoneNumber = cursor.getInt(supplierPhoneNumberColumnIndex);

                Log.d("Product", "prodcut id " + currentID);
                Log.d("Product", "prodcut name " + currentName);

            }


            // Use that index to extract the String or Int value of the word
            // at the current row the cursor is on.


        } finally {

            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}

