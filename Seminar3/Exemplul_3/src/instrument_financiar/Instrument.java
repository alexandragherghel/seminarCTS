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

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public Status getStare() {
        return stare;
    }

    public void setStare(Status stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
//        return "Instrument{" +
//                "simbol='" + simbol + '\'' +
//                ", nume='" + nume + '\'' +
//                ", pret=" + pret +
//                '}';
        return this.simbol + "," +
                this.nume + "," +
                Double.toString(this.pret) + "," +
                stare.toString();
    }
}
