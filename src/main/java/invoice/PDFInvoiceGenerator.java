package invoice;

import deployment.Deployment;
import user.User;

import java.io.IOException;

public class PDFInvoiceGenerator {
    public static PDFInvoice generate(User user, Invoice invoice) throws IOException {
        PDFInvoice pdfInvoice = new PDFInvoice();
        pdfInvoice.addFoldingMarks();
        pdfInvoice.addReturnInfo(user);
        pdfInvoice.addAddressField(invoice.getDeployment().getInvoiceAdress());
        pdfInvoice.addInfoBlock(user);
        pdfInvoice.addContent(user);
        pdfInvoice.closeContentStream();

        return pdfInvoice;
    }
}
