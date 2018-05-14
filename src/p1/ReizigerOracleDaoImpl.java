package src.p1;

import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl implements ReizigerDao {

    private ArrayList<Reiziger> reizigers = new ArrayList<>();

    @Override
    public List<Reiziger> findAll(){
        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String GBdatum){
        List<Reiziger> list = new ArrayList<>();
        for (Reiziger r : reizigers){
            if (r.getGBdatum().toString().equals(GBdatum))
                list.add(r);
        }
        return list;
    }

    @Override
    public Reiziger save(Reiziger reiziger){
        Reiziger r = new Reiziger(reiziger.getId(), reiziger.getNaam(), reiziger.getGBdatum());
        reizigers.add(r);
        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger){
        Reiziger r = new Reiziger(reiziger.getId(), reiziger.getNaam(), reiziger.getGBdatum());
        reizigers.set(reizigers.indexOf(reiziger), r);
        return r;
    }

    @Override
    public boolean delete(Reiziger reiziger){
        return reizigers.remove(reiziger);
    }

}
