package src.p2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {

    public ReizigerOracleDaoImpl() throws SQLException {
        getConnection();
    }

    @Override
    public List<Reiziger> findAll(){
        ArrayList<Reiziger> reizigers = new ArrayList<>();
        try {
            String query = "SELECT * FROM reiziger";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                Reiziger reiziger = new Reiziger(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5));
                reizigers.add(reiziger);
            }
            result.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String GBdatum){
        ArrayList<Reiziger> reizigers = new ArrayList<>();
        try {
            String query = "SELECT * FROM reiziger WHERE gebortedatum = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf(GBdatum));
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Reiziger reiziger = new Reiziger(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getDate(5));
                reizigers.add(reiziger);
            }
            result.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        if (contains(reiziger)) {
            throw new IllegalStateException("Reiziger already saved!");
        }
        Reiziger r = null;
        try {
            String query = "INSERT INTO reiziger VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, reiziger.getId());
            statement.setString(2, reiziger.getVoorletters());
            statement.setString(3, reiziger.getTussenvoegsel());
            statement.setString(4, reiziger.getAchternaam());
            statement.setDate(5, reiziger.getGeboortedatum());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return r;
    }

    @Override
    public Reiziger update(Reiziger reiziger){
        try {
            String query = "UPDATE reiziger SET voorletters = ?, tussenvoegsel = ?, achternaam = ?, gebortedatum = ? WHERE reizigerid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, reiziger.getVoorletters());
            statement.setString(2, reiziger.getTussenvoegsel());
            statement.setString(3, reiziger.getAchternaam());
            statement.setDate(4, reiziger.getGeboortedatum());
            statement.setInt(5, reiziger.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger){
        try {
            String query = "DELETE FROM reiziger WHERE reizigerid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, reiziger.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    private boolean contains(Reiziger reiziger){
        for (Reiziger r : findAll()){
            if (r.equals(reiziger))
                return true;
        }
        return false;
    }

}
