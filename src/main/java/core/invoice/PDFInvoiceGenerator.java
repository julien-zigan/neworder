package core.invoice;

import core.user.User;

import java.io.IOException;

public class PDFInvoiceGenerator {
    public static PDFInvoice generate(User user, Invoice invoice) throws IOException {
        PDFInvoice pdfInvoice = new PDFInvoice();
        pdfInvoice.addFoldingMarks();
        pdfInvoice.addReturnInfo(user);
        pdfInvoice.addAddressField(invoice.getDeployment().getInvoiceAdress());
        pdfInvoice.addInfoBlock(user, invoice);
        pdfInvoice.addContent(user, invoice);
        pdfInvoice.closeContentStream();

        return pdfInvoice;
    }
}
