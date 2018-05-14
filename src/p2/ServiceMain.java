package src.p2;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Objects;

public class ServiceMain {

    public static void main(String[] args) throws SQLException {
        ReizigerOracleDaoImpl rdao = new ReizigerOracleDaoImpl();
        OVChipkaartOracleDaoImpl odao = new OVChipkaartOracleDaoImpl();
        Reiziger r1 = new Reiziger(110, "M", "", "Kichouhi", Date.valueOf("1999-05-14"));
        OVChipkaart o1 = new OVChipkaart(8, Date.valueOf("2018-06-21"), 1, 20.00, r1);
        r1.voegOVChipkaartToe(o1);
        rdao.save(r1);
        odao.save(o1);
        rdao.findAll().stream().filter(Objects::nonNull).forEach(System.out::println);
        odao.findByReiziger(r1).stream().filter(Objects::nonNull).forEach(System.out::println);
        odao.delete(o1);
        System.out.println("Print after delete");
        odao.findByReiziger(r1).stream().filter(Objects::nonNull).forEach(System.out::println);
    }
}
