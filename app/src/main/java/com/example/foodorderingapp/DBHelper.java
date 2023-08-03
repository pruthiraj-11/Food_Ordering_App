package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderingapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

   final static String DBNAME="mydatabase.db";
   final static int DBVERSION=2;
    public DBHelper(@Nullable Context context) {
        super(context,DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(
            "create table orders"+
                    "(id integer primary key autoincrement," +
                    " name text,"+
                    "phone text,"+
                    "price int,"+
                    "image int,"+
                    "description text,"+
                    "foodname text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS orders");
        onCreate(db);
    }
    public boolean insertOrder(String name,String phone,int price,int image,String desc,String foodname){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodname);
        long id=db.insert("orders",null,values);
        if(id<=0){
            return false;
        }
        else {
            return true;
        }
    }
    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select *from orders",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrdersModel model=new OrdersModel(R.drawable.mushroom, "Mushroom", "4", "7467");
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(6));
                model.setOrderImage(cursor.getInt(4));
                model.setPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        db.close();
        return orders;
    }
    public Cursor getOrderById(int id){
            SQLiteDatabase db=this.getWritableDatabase();
            Cursor cursor=db.rawQuery("select *from orders where id= "+id,null);
            if(cursor!=null){
                cursor.moveToFirst();
            }

            return cursor;
    }
    public boolean updateOrder(String name,String phone,int price,int image,String desc,String foodname,int id){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodname);
        long row=db.update("orders",values,"id="+id,null);
        if(row<=0){
            return false;
        }
        else {
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("orders","id="+id,null);
    }
}
