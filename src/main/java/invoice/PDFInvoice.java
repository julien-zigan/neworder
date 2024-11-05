package invoice;

import deployment.Deployment;
import invoice.letterfields.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import user.User;

import java.io.IOException;

public class PDFInvoice extends PDDocument {
    private final PDPageContentStream contentStream;

    public PDFInvoice() throws IOException {
        PDPage page = new PDPage(PDRectangle.A4);
        addPage(page);
        contentStream = new PDPageContentStream(this, page);
    }

    public void addFoldingMarks() throws IOException {
        FoldingMarks.print(contentStream);
    }

    public void addReturnInfo(User contact) throws IOException {
        ReturnInfo.print(contentStream, contact);
    }

    public void addAddressField(String contact) throws IOException {
        AddressField.print(contentStream, contact);
    }

    public void addInfoBlock(User address, Invoice invoice) throws IOException {
        InfoBlock.print(contentStream, address, invoice);
    }

    public void addContent(User contact, Invoice invoice) throws IOException {
        Content.print(contentStream, contact, invoice);
    }

    public void closeContentStream() throws IOException {
        contentStream.close();
    }

}
