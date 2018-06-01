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


    public String toString() {
        return code.toString() + ", coefficient : " + coef;
    }

    public double cout() {
        return code.calculerCout(coef);
    }

    public int rechercherCout (Code codeATrouver){
        int i=0;
        while (code!=codeATrouver){
            i++;
        }
        return i;
    }



}
