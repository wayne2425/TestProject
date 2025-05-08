package org.testproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Database_Read {
    private final Connection con;

    public Database_Read(Connection con) {
        this.con = con;
    }

    protected ArrayList<Offices> read() {
        try {
            //statement yay ml ==> yoe" statement shi tl , prepared statement shi tl SQL injection krr kwel , user input yu ml so tone
            PreparedStatement ps = con.prepareStatement("SELECT * FROM offices WHERE country = ? ");
            ps.setString(1, "USA"); //parameter index ka ? shi tae ny yrr
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                aloffice.add(new Offices(rs.getString(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9)));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aloffice;
    }

    protected void display(ArrayList<Offices> aloffice) {

    }
}
