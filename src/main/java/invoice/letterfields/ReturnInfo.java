package invoice.letterfields;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import user.User;

import java.io.IOException;


public class ReturnInfo {
    static final float POS_X = 70.8661F;
    static final float POS_Y = 765.3544F;
    static final float WIDTH = 226.772F;
    static final float LINE_HEIGHT = 10.034646F;
    static final int NUMBER_OF_LINES = 5;
    static final int FONT_SIZE = 8;
    static final PDType1Font FONT = new PDType1Font(Standard14Fonts.FontName.HELVETICA);

    public static void print(PDPageContentStream cs, User sender) throws IOException {
        cs.beginText();
        cs.newLineAtOffset(POS_X, POS_Y - LINE_HEIGHT * NUMBER_OF_LINES); // DIN prescribes to begin at bottom line
        cs.setNonStrokingColor(0.47F, 0.47F, 0.47F);
        cs.setFont(FONT, FONT_SIZE);
        cs.showText(compose(sender));
        cs.endText();
    }

    private static String compose(User contact) {
        String separator = " | ";
        StringBuilder name = new StringBuilder();
        StringBuilder mailingAddress = new StringBuilder();

        mailingAddress.append(separator);

        mailingAddress.append(contact.getStreet());
        mailingAddress.append(separator);
        mailingAddress.append(contact.getZip());
        mailingAddress.append(" ");
        mailingAddress.append(contact.getCity());

        String company = contact.getCompany();

        if (company.isEmpty()) {
            String firstName = contact.getFirstName();
            String lastName = contact.getLastName();

            name.append(firstName);
            name.append(" ");
            name.append(lastName);

            try {
                float addressWidth = FONT.getStringWidth(mailingAddress.toString()) / 1000.0F * FONT_SIZE;
                float nameWidth = FONT.getStringWidth(name.toString()) / 1000.0F * FONT_SIZE;
                if (addressWidth + nameWidth > WIDTH) {
                    int nameLength = firstName.length();
                    String initialLetter = String.valueOf(contact.getFirstName().charAt(0)) + ".";
                    name.replace(0, nameLength, initialLetter);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            try {
                name.append(company);
                float addressWidth = FONT.getStringWidth(mailingAddress.toString()) / 1000.0F * FONT_SIZE;
                float nameWidth = FONT.getStringWidth(name.toString()) / 1000.0F * FONT_SIZE;
                if (addressWidth + nameWidth > WIDTH) {
                    throw new RuntimeException("Address is too long. Please abbreviate where appropriate");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return name.append(mailingAddress).toString();
    }
}
