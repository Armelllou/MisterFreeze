package princetonPlainsboro;

public enum RechercheActe {
    diagnostique,
    therapeutique;

    @Override
    public String toString(){
        return "acte " + super.toString();
    }
}
