package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

class Acte {
    private Code code;
    private int coef;
    private List<Code> codes;

    public Acte(Code code, int coef) {
        this.code = code;
        this.coef = coef;
        this.codes = new ArrayList<Code>();
        //codes.add();

    }

    public Code getCode() {
        return code;
    }

    public int getCoef() {
        return coef;
    }

    public String toString() {
        return code.toString() + ", coefficient : " + coef;
    }

    public double cout() {
        return code.calculerCout(coef);
    }

    public int rechercherCout(Code codeATrouver) {
        int i = 0;
        while (i< codes.size() && code != codeATrouver) { //si utilisateur écrit un code faux.
            i++;
        }
        
        return i;
    }


}
