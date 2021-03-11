package instrument_financiar;

public enum Status {
    TRANZACTIONABIL("TRANZACTIONABIL"),
    NETRANZACTIONABIL("NETRANZACTIONABIL"),
    NECUNOSCUT("NECUNOSCUT");

    String valoare;

    Status(String valoare) {
        this.valoare = valoare;
    }
}
