package dev.giuliopime;

public class AttributiCondivisi {
    private static AttributiCondivisi instance;

    private String nazione;
    private Integer eta;
    private String genere;

    public static AttributiCondivisi getInstance() {
        if (instance == null)
            instance = new AttributiCondivisi();

        return instance;
    }

    private AttributiCondivisi() {}

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
