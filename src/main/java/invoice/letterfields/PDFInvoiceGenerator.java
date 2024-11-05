package invoice.letterfields;

import deployment.Deployment;
import invoice.PDFInvoice;
import user.User;

import java.io.IOException;

public class PDFInvoiceGenerator {
    public static PDFInvoice generate(User user, Deployment deployment) throws IOException {
        PDFInvoice pdfInvoice = new PDFInvoice();
        pdfInvoice.addFoldingMarks();
        pdfInvoice.addReturnInfo(user);
        pdfInvoice.addAddressField(deployment.getInvoiceAdress());
        pdfInvoice.addContent(user);
        pdfInvoice.closeContentStream();

        return pdfInvoice;
    }
}
