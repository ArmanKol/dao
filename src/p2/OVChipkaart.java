package src.p2;

import java.sql.Date;

public class OVChipkaart {

    private int kaartNummer;
    private Date geldigTot;
    private int klasse;
    private double saldo;
    private Reiziger reiziger;

    public OVChipkaart(int kaartNummer, Date geldigTot, int klasse, double saldo, Reiziger reiziger){
        this.kaartNummer = kaartNummer;
        this.geldigTot = geldigTot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
    }

    public int getKaartNummer() {
        return kaartNummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public boolean equals(Object obj){
        if (obj instanceof OVChipkaart){
            OVChipkaart ov = (OVChipkaart) obj;
            return ov.getKaartNummer() == kaartNummer;
        }
        return false;
    }

    public String toString(){
        return "OVChipkaart: [kaartnummer: " + kaartNummer + "] [geldig tot: " + geldigTot + "] [klasse: " + klasse + "] [saldo: " + saldo + "] - " + reiziger;
    }
}
