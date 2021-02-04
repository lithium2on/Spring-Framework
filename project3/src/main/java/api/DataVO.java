package api;

import java.sql.Timestamp;

public class DataVO {
   private int num;
   private int amount;
   private String ownership;
   private int dealyear;
   private int dealmonth;
   private int dealday;
   private String apartmentname;
   private int dong;
   private String sigungu;
   private int areause;
   private int jibun;
   private int regionalcode;
   private int floor;
   
   private int readcount;
   private Timestamp writedate;
   
//   public DataVO(String apartmentname) {
//     super();
//     this.apartmentname = apartmentname;
//   }
//
   
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
      
   public int getAmount() {
      return amount;
   }
   public void setAmount(int amount) {
      this.amount = amount;
   }
   
   
   
   
   
   public String getOwnership() {
      return ownership;
   }
   public void setOwnership(String ownership) {
      this.ownership = ownership;
   }
   
   
   public String getApartmentname() {
      return apartmentname;
   }
   public void setApartmentname(String apartmentname) {
      this.apartmentname = apartmentname;
   }

   

   
   public int getReadcount() {
      return readcount;
   }
   public void setReadcount(int readcount) {
      this.readcount = readcount;
   }
   
   public Timestamp getWritedate() {
      return writedate;
   }
   public void setWritedate(Timestamp writedate) {
      this.writedate = writedate;
   }
   
}