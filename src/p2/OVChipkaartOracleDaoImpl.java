package src.p2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {

    public OVChipkaartOracleDaoImpl() throws SQLException {
        getConnection();
    }

    @Override
    public List<OVChipkaart> findAll(){
        ArrayList<OVChipkaart> ovChipkaarten = new ArrayList<>();
        try {
            String query = "SELECT * FROM ov_chipkaart";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                OVChipkaart ovChipkaart = new OVChipkaart(result.getInt(1), result.getDate(2), result.getInt(3), result.getDouble(4), null);
                ovChipkaarten.add(ovChipkaart);
            }
            result.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return ovChipkaarten;
    }

    @Override
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
        ArrayList<OVChipkaart> ovChipkaarten = new ArrayList<>();
        try {
            String query = "SELECT * FROM ov_chipkaart WHERE reizigerid = " + reiziger.getId();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()){
                OVChipkaart ovChipkaart = new OVChipkaart(result.getInt(1), result.getDate(2), result.getInt(3), result.getDouble(4), reiziger);
                ovChipkaarten.add(ovChipkaart);
            }
            result.close();
            statement.close();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return ovChipkaarten;
    }

    @Override
    public OVChipkaart save(OVChipkaart ovChipkaart) {
        try {
            String query = "INSERT INTO ov_chipkaart VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ovChipkaart.getKaartNummer());
            statement.setDate(2, ovChipkaart.getGeldigTot());
            statement.setInt(3, ovChipkaart.getKlasse());
            statement.setDouble(4, ovChipkaart.getSaldo());
            statement.setInt(5, ovChipkaart.getReiziger().getId());
            statement.executeUpdate();
            //statement.close();
        } catch (SQLException se){
            se.printStackTrace();
        }
        return ovChipkaart;
    }

    @Override
    public OVChipkaart update(OVChipkaart ovChipkaart) {
        try {
            String query = "UPDATE ov_chipkaart SET geldigtot = ?, klasse = ?, reizigerid = ?, saldo = ? WHERE kaartnummer = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, ovChipkaart.getGeldigTot());
            statement.setInt(2, ovChipkaart.getKlasse());
            statement.setInt(3, ovChipkaart.getReiziger().getId());
            statement.setDouble(4, ovChipkaart.getSaldo());
            statement.setInt(5, ovChipkaart.getKaartNummer());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return ovChipkaart;
    }

    @Override
    public boolean delete(OVChipkaart ovChipkaart) {
        try {
            String query = "DELETE FROM ov_chipkaart WHERE kaartnummer = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ovChipkaart.getKaartNummer());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    private boolean contains(OVChipkaart ovChipkaart){
        for (OVChipkaart ov : findAll()){
            if (ov.equals(ovChipkaart))
                return true;
        }
        return false;
    }

}
