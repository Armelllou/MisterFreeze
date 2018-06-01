package princetonPlainsboro;

public enum RechercheActe {
    diagnostique,
    therapeutique;

    public String toString(){
        return "acte " + super.toString();
    }
}
