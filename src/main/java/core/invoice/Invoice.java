package core.invoice;

import core.deployment.Deployment;

import java.time.LocalDate;


public class Invoice {
    private int invoiceNr;
    private LocalDate date;
    private Deployment deployment;
    private String path;

    public Invoice(Deployment deployment) {
        invoiceNr = InvoiceNrGenerator.generate();
        date = LocalDate.now();
        this.deployment = deployment;
        path = String.format("./invoices/%s-%d.pdf", date.toString(),invoiceNr);
    }

    public int getInvoiceNr() {
        return invoiceNr;
    }

    public void setInvoiceNr(int invoiceNr) {
        this.invoiceNr = invoiceNr;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
