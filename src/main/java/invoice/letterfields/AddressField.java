package invoice.letterfields;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.IOException;
import java.util.StringTokenizer;

public class AddressField {
    static final float POS_X = 70.8661F;
    static final float POS_Y = 715.1811F;
    static final float WIDTH = 226.772F;
    static final float LINE_HEIGHT = 12.89764F;
    static final int NUMBER_OF_LINES = 6;
    static final int FONT_SIZE = 10;
    static final int FONT_BIGGER = 12;
    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
    static final PDType1Font BOLD_FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);


    public static void print(PDPageContentStream cs, String address) throws IOException {
        StringTokenizer st = tokenize(address);
        

        cs.beginText();
        cs.setNonStrokingColor(Color.BLACK);

        cs.newLineAtOffset(POS_X, POS_Y - LINE_HEIGHT);
        cs.setFont(FONT, FONT_SIZE);
        String emptyLine = "";
        cs.showText(emptyLine);


        cs.newLineAtOffset(0, -(LINE_HEIGHT));
        cs.setFont(BOLD_FONT, FONT_BIGGER);
        cs.showText(st.nextToken());

        cs.setFont(FONT, FONT_SIZE);
        while (st.hasMoreTokens()) {
            cs.newLineAtOffset(0, -(LINE_HEIGHT));
            cs.showText(st.nextToken().trim());
        }

        cs.endText();
    }

    private static StringTokenizer tokenize(String s) {
        String noRN = s.replaceAll("\r\n", "");
        return new StringTokenizer(noRN, ",");
    }

}

