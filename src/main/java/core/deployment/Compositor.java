package core.deployment;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;


public class Compositor {
    public void compose(Deployment deployment, PDDocument confirmation) throws IOException {

        String conf = Extractor.getText(confirmation);

        double duration = Extractor.getDuration(conf);
        double travelcost = deployment.isTravelPaid() ? deployment.getTravelcostRate() : 0.;
        double total = deployment.getRate() * duration + travelcost;

        deployment.setDate(Extractor.getDate(conf));
        deployment.setDuration(duration);
        deployment.setLanguage(Extractor.getLanguage(conf));
        deployment.setContractor(Extractor.getContractor(conf));
        deployment.setClient(Extractor.getClient(conf));
        deployment.setTravelCost(travelcost);
        deployment.setTotal(total);
        deployment.setInvoiceAdress(Extractor.getAddress(conf));

    }
}
