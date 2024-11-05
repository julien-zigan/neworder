package deployment;

import static deployment.Extractor.*;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;


public class Compositor {
    public void compose(Deployment deployment, PDDocument confirmation) throws IOException {
        String conf = getText(confirmation);

        deployment.setDate(getDate(conf));
        deployment.setDuration(getDuration(conf));
        deployment.setLanguage(getLanguage(conf));
        deployment.setContractor(getContractor(conf));
        deployment.setClient(getClient(conf));
    }
}
