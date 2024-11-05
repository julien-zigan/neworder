package deployment;

import static deployment.Extractor.*;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;


public class Compositor {
    public void compose(Deployment deployment, PDDocument confirmation) throws IOException {

        String conf = getText(confirmation);

        double duration = getDuration(conf);
        double travelcost = deployment.isTravelcost() ? deployment.getTravelcostRate() : 0;
        double total = deployment.getRate() * duration + travelcost;

        deployment.setDate(getDate(conf));
        deployment.setDuration(duration);
        deployment.setLanguage(getLanguage(conf));
        deployment.setContractor(getContractor(conf));
        deployment.setClient(getClient(conf));
        deployment.setTotal(total);
        deployment.setInvoiceAdress(getAddress(conf));

    }
}
