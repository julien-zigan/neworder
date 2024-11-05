
package invoice.letterfields;

import invoice.Invoice;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import user.User;

import java.awt.*;
import java.io.IOException;


public class Content {
    static final float POS_X = 70.8661F;
    static final float POS_Y = 503.0267F;
    static final float WIDTH = 467.717F;
    static final float LINE_HEIGHT = 15F;
    static final int FONT_SIZE = 10;
    static final int HEADING_FONT_SIZE = 20;
    static final float HEADING_LINE_HEIGHT = 30;

    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    static final PDType1Font BOLD = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
    static final PDType1Font OBLIQUE = new PDType1Font(Standard14Fonts.FontName.HELVETICA_OBLIQUE);
    static final String STD_TEXT_LINE1 = "Ich bedanke mich für die gute Zusammenarbeit " +
            "und stelle Ihnen vereinbarungsgemäß folgende";
    static final String STD_TEXT_LINE2 = "Leistungen in Rechnung:";
    static final String ENDING_TEXT = "Zahlung bitte innerhalb von 21 Tagen an die oben angegebene Bankverbindung.";

    static final float BEZEICHNUNG_OFFSET = 42.8F;
    static final float MENGE_OFFSET_LEFT_ALIGN = 346 - BEZEICHNUNG_OFFSET - POS_X;
    static final float EINZEL_OFFSET_LEFT_ALIGN = 118F;
    static final float GESAMT_OFFSET_LEFT_ALIGN = 61F;

    public static void print(PDPageContentStream cs, User user, Invoice invoice) throws IOException {
        cs.beginText();
        cs.setNonStrokingColor(Color.BLACK);

        cs.newLineAtOffset(POS_X, POS_Y - HEADING_LINE_HEIGHT);
        cs.setFont(BOLD, HEADING_FONT_SIZE);
        cs.showText(String.format("Rechnung Nr. %s", invoice.getInvoiceNr())); //TODO create Invoice Class

        cs.newLineAtOffset(0, - HEADING_LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText(STD_TEXT_LINE1);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.setFont(FONT, FONT_SIZE);
        cs.showText(STD_TEXT_LINE2);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.setFont(BOLD, FONT_SIZE);
        float underscoreWidth = (FONT.getStringWidth("_") / 1000.0f) * FONT_SIZE;
        int numberOfUnderscores = (int) (WIDTH / underscoreWidth);
        String horizontalLine = "_".repeat(numberOfUnderscores - 2);
        cs.showText(horizontalLine);

        cs.newLineAtOffset(0, - HEADING_LINE_HEIGHT);
        cs.showText("Pos.");

        cs.newLineAtOffset(BEZEICHNUNG_OFFSET, 0);
        cs.showText("Bezeichnung");

        String menge = "Menge";
        float mengeWidth = (FONT.getStringWidth(menge) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(MENGE_OFFSET_LEFT_ALIGN - mengeWidth, 0);
        cs.showText(menge);

        String einzel = "Einzel (€)";
        float einzelWidth = (FONT.getStringWidth(einzel) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(EINZEL_OFFSET_LEFT_ALIGN + mengeWidth - einzelWidth, 0);
        cs.showText(einzel);

        String gesamt = "Gesamt (€)";
        float gesamtWidth = (FONT.getStringWidth(gesamt) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(POS_X
                + WIDTH
                - BEZEICHNUNG_OFFSET
                - MENGE_OFFSET_LEFT_ALIGN
                - EINZEL_OFFSET_LEFT_ALIGN
                - einzelWidth
                - gesamtWidth, 0);
        cs.showText(gesamt);

        float lineWidth = (FONT.getStringWidth(horizontalLine) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(gesamtWidth - lineWidth, -(LINE_HEIGHT));
        cs.setFont(FONT, FONT_SIZE);
        cs.showText(horizontalLine);

        int invoicePosition = 0;

        // First Line
        cs.newLineAtOffset(0, - HEADING_LINE_HEIGHT);
        cs.showText(String.valueOf(++invoicePosition));

        String placeholerBezeichnung = "Dolmetschen";
        cs.newLineAtOffset(BEZEICHNUNG_OFFSET, 0);
        cs.setFont(BOLD, FONT_SIZE);
        cs.showText(placeholerBezeichnung);

        String placeholderMenge = String.format("%.1f Std", invoice.getDeployment().getDuration());
        float placeholderMengeWidth = (FONT.getStringWidth(placeholderMenge) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(MENGE_OFFSET_LEFT_ALIGN - placeholderMengeWidth, 0);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText(placeholderMenge);

        String placeholderEinzel = String.format(" %.2f", invoice.getDeployment().getRate());
        float placeholderEinzelWidth = (FONT.getStringWidth(placeholderEinzel) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(EINZEL_OFFSET_LEFT_ALIGN + placeholderMengeWidth - placeholderEinzelWidth, 0);
        cs.showText(placeholderEinzel);

        String placeholderGesamt = String.format("%.2f", invoice.getDeployment().getRate() * invoice.getDeployment().getDuration());
        float placeholderGesamtWidth = (FONT.getStringWidth(placeholderGesamt) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(POS_X
                + WIDTH
                - BEZEICHNUNG_OFFSET
                - MENGE_OFFSET_LEFT_ALIGN
                - EINZEL_OFFSET_LEFT_ALIGN
                - placeholderEinzelWidth
                - placeholderGesamtWidth
                - placeholderGesamtWidth, 0);
        cs.showText(placeholderGesamt);

        //additional Information
        cs.newLineAtOffset(BEZEICHNUNG_OFFSET + placeholderGesamtWidth - lineWidth - 2F, - LINE_HEIGHT);
        cs.setNonStrokingColor(0.47F, 0.47F, 0.47F);
        cs.setFont(FONT, FONT_SIZE);
        String placeholerBezeichnungInfo = invoice.getDeployment().getLanguage();
        cs.showText(placeholerBezeichnungInfo);

        cs.newLineAtOffset(0, - LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        String placeholerAuftraggeberName = invoice.getDeployment().getContractor();
        cs.showText(placeholerAuftraggeberName);

        cs.newLineAtOffset(0, - LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        String placeholerClient = invoice.getDeployment().getClient();
        cs.showText(placeholerClient);

        cs.newLineAtOffset(0, - LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        String placeholerDeploymentDate = String.format("am: %s", invoice.getDeployment().getDate());
        cs.showText(placeholerDeploymentDate);

        // Second Line
        cs.newLineAtOffset(-BEZEICHNUNG_OFFSET, - HEADING_LINE_HEIGHT);

        if (invoice.getDeployment().isTravelPaid()){
            cs.setNonStrokingColor(Color.BLACK);
        } else {
            cs.setNonStrokingColor(1F, 1F, 1F);
        }

        cs.showText(String.valueOf(++invoicePosition));

        String anfahrt = "Anfahrt";
        cs.newLineAtOffset(BEZEICHNUNG_OFFSET, 0);
        cs.setFont(BOLD, FONT_SIZE);
        cs.showText(anfahrt);

        String pauschal = "1 Pauschal";
        float pauschalWidth = (FONT.getStringWidth(pauschal) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(MENGE_OFFSET_LEFT_ALIGN - pauschalWidth, 0);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText(pauschal);

        String placeholderEinzelLine2 = String.format("%.2f", invoice.getDeployment().getTravelCost());
        float placeholderEinzelWidthLine2 = (FONT.getStringWidth(placeholderEinzelLine2) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(EINZEL_OFFSET_LEFT_ALIGN + pauschalWidth - placeholderEinzelWidthLine2, 0);
        cs.showText(placeholderEinzelLine2);

        float placeholderGesamtWidthLine2 = (FONT.getStringWidth(placeholderEinzelLine2) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(POS_X
                + WIDTH
                - BEZEICHNUNG_OFFSET
                - MENGE_OFFSET_LEFT_ALIGN
                - EINZEL_OFFSET_LEFT_ALIGN
                - placeholderEinzelWidthLine2
                - placeholderGesamtWidthLine2
                - placeholderGesamtWidthLine2
                - 4F, 0);
        cs.showText(placeholderEinzelLine2);

        //Total
        cs.setNonStrokingColor(Color.BLACK);
        String totalLine = "_".repeat((numberOfUnderscores - 2) / 2);
        float totalLineWidth = (FONT.getStringWidth(totalLine) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(placeholderGesamtWidthLine2 - totalLineWidth, - HEADING_LINE_HEIGHT);
        cs.setFont(BOLD, FONT_SIZE);
        cs.showText(totalLine);

        String total = String.format("€ %.2f", invoice.getDeployment().getTotal());
        float totalWidth = (FONT.getStringWidth(total) / 1000.0f) * FONT_SIZE;
        cs.newLineAtOffset(totalLineWidth - totalWidth, - LINE_HEIGHT);
        cs.setFont(BOLD, FONT_SIZE);
        cs.showText(total);

        String sumTotal = "Rechnungsbetrag";
        cs.newLineAtOffset(-66.5F - totalWidth, 0);
        cs.setFont(BOLD, FONT_SIZE);
        cs.showText(sumTotal);

        cs.newLineAtOffset(66.5F + totalWidth + totalWidth - totalLineWidth , - HEADING_LINE_HEIGHT);
        cs.setFont(BOLD, FONT_SIZE);
        cs.setNonStrokingColor(0.75F, 0.75F, 0.75F);
        cs.showText(totalLine);

        //ending
        cs.newLineAtOffset(totalLineWidth - lineWidth, - HEADING_LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        cs.setNonStrokingColor(Color.BLACK);
        cs.showText(ENDING_TEXT);

        cs.newLineAtOffset(0, -LINE_HEIGHT);

        cs.newLineAtOffset(0, -LINE_HEIGHT);
        cs.showText("Mit freundlichen Grüßen");

        cs.newLineAtOffset(0, -19);
        cs.setNonStrokingColor(0.40F, 0.40F, 0.40F);
        cs.setFont(FONT, 14F);
        cs.showText(user.getFirstName() + " " + user.getLastName());

        cs.endText();

    }

}
