package src.p2;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {

    private String voorletters, tussenvoegsel, achternaam;
    private Date geboortedatum;
    private int id;
    private ArrayList<OVChipkaart> ovchipkaarten;

    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum){
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.ovchipkaarten = new ArrayList<>();
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() { return voorletters; }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public int getId() {
        return id;
    }

    public ArrayList<OVChipkaart> getOvchipkaarten(){
        return ovchipkaarten;
    }

    public void voegOVChipkaartToe(OVChipkaart ovChipkaart){
        ovchipkaarten.add(ovChipkaart);
    }

    public boolean equals(Object obj){
        if (obj instanceof Reiziger){
            Reiziger r = (Reiziger) obj;
            return r.getId() == id;
        }
        return false;
    }

    public String toString(){
        return "Reiziger: [id: " + id + "] [voorletters: " + voorletters + "] [tussenvoegsel: " + tussenvoegsel + "] - [achternaam: " + achternaam + "] - [geboortedatum: " + geboortedatum + "]";
    }

}
