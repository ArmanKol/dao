package src.p1;

import java.util.List;

public interface ReizigerDao {

    List<Reiziger> findAll();
    List<Reiziger> findByGBdatum(String GBdatum);
    Reiziger save(Reiziger reiziger);
    Reiziger update(Reiziger reiziger);
    boolean delete(Reiziger reiziger);
}
