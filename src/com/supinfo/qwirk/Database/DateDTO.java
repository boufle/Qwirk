package com.supinfo.qwirk.Database;

import java.sql.*;

/**
 * com.supinfo.qwirk.Database
 * Created by Theo on 13/12/2016 for Qwirk.
 */
public class DateDTO {

    public static Timestamp getdateServeur(ApplicationData applicationData ) throws SQLException {
        Connection con = applicationData.getConnection();
        Statement stmt = null;




        String query = "select Now() as dateserveur  from Channel_Message  where  1=1 LIMIT 1";


        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
               return rs.getTimestamp("dateserveur");
            }

        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }
}
