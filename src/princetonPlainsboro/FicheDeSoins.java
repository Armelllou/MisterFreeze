package princetonPlainsboro;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;
import java.util.Vector;

public class FicheDeSoins implements Printable {

    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'

    public FicheDeSoins(Patient patient, Medecin medecin, Date date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
    }

    public Patient getPatient() {
        return patient;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Date getDate() {
        return date;
    }

    public void ajouterActe(Acte acte) {
        actes.add(acte);
    }

    public void ajouterActe(Code code, int coefficient, String type) {
        Acte acte = new Acte(code, coefficient, type);
        actes.add(acte);
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder("Fiche de soins du " + date.toString() + "\n");
        t.append("- Medecin : ").append(medecin.toString()).append("\n");
        t.append("- Patient : ").append(patient.toString()).append("\n");
        if (!actes.isEmpty()) {
            t.append("- Actes medicaux : " + "\n");
            for (Acte a : actes) {
                t.append("    > ").append(a.toString()).append("\n");
            }
        }
        t.append("- Cout total : ").append(String.format("%.2f", coutTotal())).append("\n");
        return t.toString();
    }

    public void afficher() {
        System.out.println("Fiche de soins du " + date.toString());
        System.out.println("- medecin : " + medecin.toString());
        System.out.println("- patient : " + patient.toString());
        System.out.println("- actes medicaux :");
        for (int i = 0; i < actes.size(); i++) {
            Acte a = actes.get(i);
            System.out.println("    > " + a.toString());
        }
    }

    public double coutTotal() {
        double total = 0;
        for (int i = 0; i < actes.size(); i++) {
            Acte a = actes.get(i);
            total += a.cout();
        }
        return total;
    }

    public List<Acte> getActes() {
        return actes;

    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        /* On définit une marge  */
        int marge = 30;

        /* Récupère les coordonnées des bords de la page */
        int x = (int) pageFormat.getImageableX();
        int y = (int) pageFormat.getImageableY();
        int w = (int) pageFormat.getImageableWidth();
        int h = (int) pageFormat.getImageableHeight();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("Arial", Font.PLAIN, 14));
        graphics.setColor(Color.BLACK);
        graphics.drawString(toString(), x + marge, y + marge);
        return PAGE_EXISTS;
    }
}
