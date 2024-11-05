package invoice.letterfields;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import user.User;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class InfoBlock {
    static final float POS_X =354.331F;
    static final float POS_Y = 751.1811F;
    static final float WIDTH = 184.252F;
    static final float LINE_HEIGHT = 15F;
    static final int FONT_SIZE = 10;
    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    static final PDType1Font BOLD = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
    static final PDType1Font OBLIQUE = new PDType1Font(Standard14Fonts.FontName.HELVETICA_OBLIQUE);

    public static void print(PDPageContentStream cs, User user) throws IOException {
        cs.beginText();
        cs.setNonStrokingColor(Color.BLACK);

        cs.newLineAtOffset(POS_X, POS_Y - LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText("Rechnungsnr. 1234566");

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        String emptyLine = "";
        cs.showText(emptyLine);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.setFont(BOLD, FONT_SIZE);
        String name = user.getFirstName()
                + " "
                + user.getLastName();
        cs.showText(name);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText(user.getAdditional());
        cs.setFont(FONT, FONT_SIZE);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText("Tel: " + user.getPhone());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText(user.getEmail());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText(user.getWebsite());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText(emptyLine);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.setFont(OBLIQUE, FONT_SIZE);
        cs.showText("Zahlungsinformation");
        cs.setFont(FONT, FONT_SIZE);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText(user.getBankname());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText("IBAN: " + user.getIban());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText("BIC: " + user.getBic());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText("Kto. Inh.: "
                + user.getFirstName()
                + " "
                + user.getLastName());

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.showText(emptyLine);

        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        cs.showText("Datum: " + format.format(date));

        cs.endText();
    }

}
