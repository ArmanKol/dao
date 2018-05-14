package src.p1;

import java.sql.Date;

public class ServiceMain {

    public static void main(String[] args){
        Reiziger reiziger = new Reiziger();
        reiziger.setGBdatum(Date.valueOf("1999-05-14"));
        reiziger.setNaam("Mohamed");
        reiziger.setId(1);
        ReizigerOracleDaoImpl dao = new ReizigerOracleDaoImpl();
        dao.save(reiziger);
        for (Reiziger r : dao.findAll()){
            if (r == null)
                continue;
            System.out.println(r);
        }
        reiziger.setNaam("Test");
        dao.update(reiziger);
        for (Reiziger r : dao.findAll()){
            if (r == null)
                continue;
            System.out.println(r);
        }
    }
}
