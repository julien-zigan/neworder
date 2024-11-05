package deployment;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;


public class Deployment {
    private double rate;
    private boolean travelcost;
    private double travelcostRate;
    private String date;
    private double duration;
    private String language;
    private String contractor;
    private String client;
    private double total;

    private Compositor compositor;

    public Deployment() {
        rate = 50.;
        travelcost = true;
        travelcostRate = 10.;
        compositor = new Compositor();
    }

    public Deployment(PDDocument confirmation) throws IOException {
        this();
        compositor.compose(this, confirmation);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isTravelcost() {
        return travelcost;
    }

    public void setTravelcost(boolean travelcost) {
        this.travelcost = travelcost;
    }

    public double getTravelcostRate() {
        return travelcostRate;
    }

    public void setTravelcostRate(double travelcostRate) {
        this.travelcostRate = travelcostRate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public java.lang.String getContractor() {
        return contractor;
    }

    public void setContractor(java.lang.String contractor) {
        this.contractor = contractor;
    }

    public java.lang.String getClient() {
        return client;
    }

    public void setClient(java.lang.String client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
