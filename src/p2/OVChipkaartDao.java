package src.p2;

import java.util.List;

public interface OVChipkaartDao {

    List<OVChipkaart> findAll();
    List<OVChipkaart> findByReiziger(Reiziger reiziger);
    OVChipkaart save(OVChipkaart ovChipkaart);
    OVChipkaart update(OVChipkaart ovChipkaart);
    boolean delete(OVChipkaart ovChipkaart);
}
