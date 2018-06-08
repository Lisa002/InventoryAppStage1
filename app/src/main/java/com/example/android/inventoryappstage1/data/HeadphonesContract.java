package com.example.android.inventoryappstage1.data;

import android.provider.BaseColumns;

public class HeadphonesContract {


    private HeadphonesContract() {
    }

    public static class HeadphonesEntry implements BaseColumns {
        public static final String TABLE_NAME = "headphones";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HEADPHONES_PRODUCT_NAME = "product_name";
        public static final String COLUMN_HEADPHONES_PRICE = "price";
        public static final String COLUMN_HEADPHONES_QUANTITY = "quantity";
        public static final String COLUMN_HEADPHONES_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_HEADPHONES_SUPPLIER_PHONE_NUMBER = "supplier_phone_number";

    }
}
