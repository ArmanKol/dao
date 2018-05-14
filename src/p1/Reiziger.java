package src.p1;

import java.sql.Date;

public class Reiziger {

    private String naam;
    private Date gbdatum;
    private int id;

    public Reiziger(int id, String naam, Date gbdatum){
        this.id = id;
        this.naam = naam;
        this.gbdatum = gbdatum;
    }

    public Reiziger(){
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGBdatum() {
        return gbdatum;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setGBdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public boolean equals(Object obj){
        if (obj instanceof Reiziger){
            Reiziger r = (Reiziger) obj;
            return r.getId() == id;
        }
        return false;
    }

    public String toString(){
        return "Reiziger: [id: " + id + "] [naam: " + naam + "] - [geboortedatum: " + gbdatum + "]";
    }

}
