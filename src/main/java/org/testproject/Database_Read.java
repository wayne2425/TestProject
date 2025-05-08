package org.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database_Read {
    private final Connection con;

    public Database_Read(Connection con) {
        this.con = con;
    }

    protected void read(){
        try {
            //statement yay ml ==> yoe" statement shi tl , prepared statement shi tl SQL injection krr kwel , user input yu ml so tone
            PreparedStatement ps = con.prepareStatement("SELECT * FROM offices WHERE country = ? ");
            ps.setString(1,"USA"); //parameter index ka ? shi tae ny yrr
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.print(rs.getInt(1));
                System.out.print("|");
                System.out.print(rs.getString("city"));
                System.out.println();
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
