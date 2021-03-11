package instrument_financiar;


public class Instrument {
    private String simbol;
    private String nume;
    private double pret;
    private Status stare;

    public Instrument(String simbol, String nume, double pret, Status stare) {
        this.simbol = simbol;
        this.nume = nume;
        this.pret = pret;
        this.stare = stare;
    }

    public Instrument() {
        this.simbol = null;
        this.nume = null;
        this.pret = 0.F;
        this.stare = Status.NECUNOSCUT;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setStare(Status stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return this.simbol + "," +
                this.nume + "," +
                stare.toString();
    }
}
