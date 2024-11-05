import deployment.Deployment;
import invoice.Invoice;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import persistence.Database;
import user.User;

import java.io.File;

public class CLI {

    public static void main(String[] args) throws Exception {
        User user = new User();
        Database.loadUserData(user);

        File file = new File("X:\\neworder\\src\\test\\ressources\\TestConfirmation.pdf");
        PDDocument confirmation = Loader.loadPDF(file);

        Deployment deployment = new Deployment(confirmation);
        Invoice invoice = new Invoice(deployment);

    }

}
