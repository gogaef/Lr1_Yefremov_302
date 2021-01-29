package Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Map;


public interface IUser {
   public void Inicialization(ResultSet result);
   public String getPermission();
   public Map<String,String> getValues();

}
