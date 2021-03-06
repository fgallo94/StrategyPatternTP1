package com.utn.dao;


import com.utn.model.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class ResultDao {

    private ConnectionInstance conn = ConnectionInstance.getConnection();

    /**
     * Save Result into a data base
     *
     * @param result Result to insert
     */
    public void saveResult(Result result) {
        String sq = "insert into ResultBattle(name_of_winner,drink_in_body) values (?,?)";
        try {
            conn.connect();
            PreparedStatement st = conn.getConn().prepareStatement(sq);
            st.setString(1, result.getNameOfWinner());
            st.setInt(2, result.getDrinkInBody());
            st.executeUpdate();
        } catch (SQLException es) {
            es.printStackTrace();
        } finally {
            try {
                conn.disconnect();
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    /**
     * Get all the result of the data base as ArrayList of Result.
     *
     * @return ArrayList<Result>
     */
    public ArrayList<Result> getResults() {
        ArrayList<Result> results = new ArrayList<>();
        String sq = "select * from ResultBattle rb order by rb.id";
        try {
            conn.connect();
            PreparedStatement st = conn.getConn().prepareStatement(sq);
            ResultSet rs = st.executeQuery();
            if (rs == null) {
                System.out.println(" No hay registros en la base de datos");
            }
            while (Objects.requireNonNull(rs).next()) {
                Result result = new Result(rs.getString("name_of_winner"), rs.getInt("drink_in_body"));
                results.add(result);
            }
        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            try {
                conn.disconnect();
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
        return results;
    }
}
