/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package princetonPlainsboro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.util.List;

/**
 *
 * @author jlgb2
 */
public class ImprimerFiche implements Printable{


        private FicheDeSoins fiche;
	private boolean result;
	//private int reel;
	private int acte;
	private List<Acte> l;
	
	public ImprimerFiche (FicheDeSoins fiche) {
		this.fiche=fiche;
		this.result=false;
	//	this.reel=-1;
		this.acte=0;
		this.l=fiche.getActes();
	}
	
	public ImprimerFiche() {
		System.out.println("Hello World");
	}
	
	@Override
	public int print(Graphics graphic, PageFormat p, int num) throws PrinterException {
		
            // Récupère les coordonnées des bords de la page */             
		int x=(int) p.getImageableX();
		int y=(int) p.getImageableY();
		int h=(int) p.getImageableHeight();
		int w=(int) p.getImageableWidth();
               // On définit une marge et l'interligne
		int marge=30;
                int interligne = 20;
		int nbLignes = 0;		
		if(num==0) {
			graphic.setFont(new Font("Times New Roman", Font.BOLD, 24));
			graphic.setColor(Color.BLACK);
			graphic.drawString("Fiche de soins", x+marge, y+marge+nbLignes*interligne);
			nbLignes++;
			graphic.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			graphic.drawString(fiche.toString(), x+marge, y+marge+nbLignes*interligne);
			nbLignes++;
			graphic.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			graphic.drawString("Patient : "+fiche.getPatient().toString(), x+marge, y+marge+nbLignes*interligne);
			nbLignes++;
			graphic.drawString(" Medecin : "+fiche.getMedecin().toString(), x+marge, y+marge+nbLignes*interligne);
			nbLignes++;
			nbLignes++;
			graphic.drawString("Actes effectués : ", x+marge, y+marge+nbLignes*interligne);
			nbLignes++;
		}
		int i=acte; //indice de l'acte
		while(i<l.size() && y+marge+nbLignes*interligne<p.getHeight()-interligne) {
			String s=l.get(i).toString();
			graphic.drawString(s, x+marge, y+marge+nbLignes*interligne);
			nbLignes++;
			i++;
		}
		acte=i;
		
		if(l.size()==i)
			this.result=true;
		
		System.out.println(this.acte+ " "+i+" " +this.hashCode());
		graphic.setFont(new Font("Tahoma", Font.ITALIC|Font.BOLD, 10));
		graphic.setColor(Color.RED);
		graphic.drawString("Imprimer en java", x+marge, (int) p.getHeight()-interligne);
		
		if(result && num>=1 )
			return Printable.NO_SUCH_PAGE;
		
		return Printable.PAGE_EXISTS;
	}


        
    
    /*
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        /* On définit une marge  */
        //int marge = 30;

        /* Récupère les coordonnées des bords de la page */
        /*int x = (int) pageFormat.getImageableX();
        int y = (int) pageFormat.getImageableY();
        int w = (int) pageFormat.getImageableWidth();
        int h = (int) pageFormat.getImageableHeight();
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.setFont(new Font("Arial", Font.PLAIN, 14));
        graphics.setColor(Color.BLACK);
        graphics.drawString(toString(), x + marge, y + marge);
        return PAGE_EXISTS;
    }*/
    
}
