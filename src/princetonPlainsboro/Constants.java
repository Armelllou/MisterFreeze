package princetonPlainsboro;

public enum Constants {
    // Fonts
    TAHOMA("Tahoma"),
    COPPERPLATE("Copperplate Gothic Light"),
    SEGOE("Segoe UI"),

    // Exceptions
    IOEXC("Exception de type 'IOException' lors de la lecture du fichier : "),
    XMLEXC("Exception de type 'XMLStreamException' lors de la lecture du fichier : "),

    // Fichiers
    REB_BASE("src/donnees/"),

    // Autres
    SEPARATION("------------------------"),
    VALIDER("Valider");

    String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
