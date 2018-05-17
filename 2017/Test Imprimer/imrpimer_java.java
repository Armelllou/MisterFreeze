/** Méthode: http://codes-sources.commentcamarche.net/faq/10779-imprimer-avec-java 
Pour imprimer:
La classe doit implémenter la méthode Printable
Printable possède une seule méthode print

Dans la méthode print, on dispose des méthodes de l'instance graphics
de la classe Graphics: setColor(), setFont(), drawString() pour afficher
un texte et fillRect() pour dessiner un rectangle
*/

/* DEFINIR L'AFFICHAGE DE L'IMPRESSION */ 

public class Impression implements Printable { 

	@Override
	public int print (Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex > 0) {
			return NO_SUCH_PAGE; // pageIndex est trop grand et la page n'existe pas 
		}
		
		/* On définit une marge pour l'impression */
		int marge=30;

		/* On récupère les coordonnées des bords de la page */
		int x = (int)pageFormat.getImageableX();
		int y = (int)pageFormat.getImageableY();
		int w = (int)pageFormat.getImageableWidth();
		int h = (int)pageFormat.getImageableHeight();

		/* Dessin d'un cadre gris clair*/
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(x+10, y+10, w-20, h-20);
		
		/* Centrer son texte: il faut rajouter xCentre et yCentre en param de drawImage*/ 
		FontMetrics fm = graphics.getFontMetrics();
		int xCentre = (w - fm.stringWidth(texte)) / 2;
		int yCentre = (fm.getAscent() + h - (fm.getAscent() + fm.getDescent())) / 2);

		/* Insérer une image */
		BufferedImage image = ImageIO.read(new File(/*adresseImage*/));
		graphics.drawImage(image, 0, 0, null);
		
		/* On écrit une ligne de titre en noir de taille 18 */
		graphics.setFont(new Font("Arial", Font.BOLD, 16));
		graphics.setColor(Color.BLACK);
		graphics.drawString("Centre hospitalier de Princeton-Plainsboro /n /n /n /n", xCentre, yCentre);
		
		/* On écrit une ligne de titre en rouge, en gras de taille 18 */
		graphics.setFont(new Font("Arial", Font.BOLD, 24));
		graphics.setColor(Color.BLACK);
		graphics.drawString("Registre Médical", xCentre, yCentre);
		
		graphics.setFont(new Font("Arial", Font.PLAIN, 14));
		Date d=new Date();
		String date = d.getDay()+"/"+d.getMonth()+"/"+d.getYear();
		graphics.drawString("Imprimé le"+date, xCentre, yCentre);

		/* On écrit une ligne en noir de taille 14 - METTRE NOTRE AFFICHAGE */
		graphics.setFont(new Font("Arial", Font.PLAIN, 14));
		graphics.setColor(Color.BLACK);
		graphics.drawString("Première ligne du rapport", x+marge, y+marge+20);
		
		return PAGE_EXISTS; // la page existe
}


/* LANCER L'IMPRESSION */ 

/* Il faut lancer le contenu à imprimer à un service d'impression. 
C'est la classe PrinterJob. Elle a une méthode getPrinterJob() pour récupérer
une instance de la classe PrinterJob.
setPrintable (Printable printable) pour définir le contenu à imprimer
printDialog() pour afficer la boîte de dialogue avant impression 
print() pour lancer l'option d'impression */ 


/* à mettre dans le main ou la méthode qui code le bouton */
PrinterJob job = PrinterJob.getPrinterJob();
/* On donne le contenu à imprimer au job */
job.setPrintable(/*Notre objet qui implémente Printable*/);
/* Affichage de la boite de dialogue d'impression */
boolean doPrint = job.printDialog();
if(doPrint) {
	try {
		/* Lancement de l'impression */
		job.print();
	}
	catch (PrinterException e1) {
		e1.printStackTrace();
	}
} 