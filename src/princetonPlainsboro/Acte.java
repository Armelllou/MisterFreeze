package princetonPlainsboro;

import java.util.ArrayList;
import java.util.List;

public class Acte {
    private Code code;
    private int coef;
    private List<Code> codes;
    private String type;

        public Acte(Code code, int coef, String type) {
        this.code = code;
        this.coef = coef;
        this.codes = new ArrayList<Code>();
        this.type = type;
        //codes.add();

    }

    public Code getCode() {
        return code;
    }

    public int getCoef() {
        return coef;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (code.toString().length() > 0) {
            builder.append(code.toString());
        }
        if (coef != 0) {
            builder.append(", coefficient : ").append(coef);
        }
        if (type.length() > 0) {
            builder.append(", type : ").append(type);
        }
        return builder.toString();
    }

    public String toStringCout() {
        return code.toString() + ", coefficient : " + coef;
    }

    public double cout() {
        return code.calculerCout(coef);
    }

    public double rechercheCout(Code code, int coef) {
        return code.calculerCout(coef);
    }

    public String getType() {
        return type;
    }
}
