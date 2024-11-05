
package invoice.letterfields;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.IOException;


public class FoldingMarks {
    static final float POS_X = 0F;
    static final float POS_Y = 595.2758F;
    static final int FONT_SIZE = 10;
    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

    public static void print(PDPageContentStream cs) throws IOException {
        cs.beginText();
        cs.newLineAtOffset(POS_X, POS_Y); // DIN prescribes to begin at bottom line
        cs.setNonStrokingColor(Color.BLACK);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText("___");
        cs.endText();

        cs.beginText();
        cs.newLineAtOffset(POS_X, 420.94492F); // DIN prescribes to begin at bottom line
        cs.setNonStrokingColor(Color.BLACK);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText("_____");
        cs.endText();

        cs.beginText();
        cs.newLineAtOffset(POS_X, 297.6378F); // DIN prescribes to begin at bottom line
        cs.setNonStrokingColor(Color.BLACK);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText("___");
        cs.endText();
    }
}