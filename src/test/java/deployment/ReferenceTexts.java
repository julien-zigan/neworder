package deployment;

public enum ReferenceTexts {
    CONFIRMATION("Gesundheit Berlin-Brandenburg, Friedrichstr. 231, 10969 Berlin\r\n" +
            "Gemeindedolmetschdienst Berlin | GDD Vermittlungsdienst Honorardolmetsch-Pool\r\n" +
            "Gesundheit Berlin-Brandenburg e.V.\r\n" +
            "Gemeindedolmetschdienst Berlin | GDD\r\n" +
            "Frau Friedrichstraße 231, 10969 Berlin\r\n" +
            "Anita Zuzanna Pacholik-Zuromska Bürozeiten: Mo-Do 8:30-17 Uhr, Fr 8:30-16 Uhr\r\n" +
            "Tel: 030 443190-91\r\n" +
            "Fax: 030 443190-93\r\n" +
            "anfrage@gdd-berlin.de \r\n" +
            "www.gdd-berlin.de\r\n" +
            "www.gesundheitbb.de\r\n" +
            "Einsatzbestätigung für Ihren Dolmetscheinsatz, Auftrags-Nr. 129653\r\n" +
            "Datum / Uhrzeit: 4. Oktober 2024 / 14:00 - 15:00 Uhr\r\n" +
            "Dolmetschsprache: Polnisch\r\n" +
            "Honorardolmetscher*in: Frau Anita Zuzanna Pacholik-Zuromska\r\n" +
            "Fachgebiet: Pädiatrie\r\n" +
            "Einsatzadresse: Charité Virchow (CVK), Kinderklinik, Augustenburger Platz 1, Mittelallee 8, \r\n" +
            "13353 Berlin_St. 24_EG_Zi. 7\r\n" +
            "Klient*in/Patient*in:\r\n" +
            "Kund*in: Charité Virchow (CVK), Kinderklinik\r\n" +
            "Auftraggeber*in: Dähmlow, Hr. Dr.\r\n" +
            "Kontaktdaten: 030 450666579; 030 450666435, steffen.daehmlow@charite.de\r\n" +
            "Vergütung\r\n" +
            "(ohne Gewähr):\r\n" +
            "Rechnung an: Charité, Finanz- und Rechnungswesen, Zentraler Rechnungseingang, \r\n" +
            "Hindenburgdamm 30, 12200 Berlin\r\n" +
            "Bemerkungen:\r\n" +
            "Bei Bedarf zum Nachweis der Dolmetschleistung bitte ausfüllen:\r\n" +
            "Dolmetscheinsatz: am ____________________von __________ bis __________ Uhr\r\n" +
            "Patient*in/Klient*in: ______________________________________________________\r\n" +
            "Klinik/Station: ______________________________________________________\r\n" +
            "Stellenzeichen/Fall-Nr.: ______________________________________________________\r\n" +
            "Auftraggeber*in/Fachkraft: ______________________________________________________\r\n" +
            "Unterschrift/Stempel: ______________________________________________________\r\n"),
    ORDER_NR("129653"),
    ADDRESS("Charité, Finanz- und Rechnungswesen, Zentraler Rechnungseingang, \r\n" +
            "Hindenburgdamm 30, 12200 Berlin"),
    DATE("4. Oktober 2024"),
    LANGUAGE("Dolmetschsprache: Polnisch"),
    CONTRACTOR("Auftraggeber*in: Dähmlow, Hr. Dr."),
    CLIENT("Charité Virchow (CVK), Kinderklinik"),
    DURATION(1.0),
    TOTAL(60.);

    private String text;
    private double number;

    ReferenceTexts(String text) {
        this.text = text;
    }

    ReferenceTexts(double number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public double getNumber() {
        return number;
    }
}
