package persistence;

import core.deployment.Deployment;
import core.invoice.Invoice;
import core.persistence.Database;
import org.junit.jupiter.api.Test;
import core.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseTest {
//
//    @Test
//    void testAddInvoice() throws Exception {
//        Deployment deployment = new Deployment();
//
//        Invoice invoice1 = new Invoice(deployment);
//        Database.add(invoice1);
//
//        Invoice invoice2 = new Invoice(deployment);
//        Database.add(invoice2);
//
//        assertEquals(invoice1.getInvoiceNr() + 1, invoice2.getInvoiceNr());
//    }
//
//    @Test
//    void testAddUserLoadUser() throws Exception {
//        User user = new User();
//        user.setCompany("");
//        user.setFirstName("Dr. hab. Maximilian");
//        user.setAdditional("Dolmetscher");
//        user.setLastName("Mustermann");
//        user.setStreet("Muster-Minion-Allee 5b");
//        user.setZip("12345");
//        user.setCity("Musterstadt");
//        user.setEmail("mustermann.maximilian@dolmetscher.de");
//        user.setPhone("+491234/5678901234");
//        user.setWebsite("www.maximilian-mustermann.de");
//        user.setBankname("Musterbank Musterstadt");
//        user.setIban("DE34233004333401");
//        user.setBic("GENODE61FR1");
//
//        Database.add(user);
//
//        User loadedUser = Database.loadUserData();
//
//        assertEquals(user.getCompany(), loadedUser.getCompany());
//        assertEquals(user.getFirstName(), loadedUser.getFirstName());
//        assertEquals(user.getLastName(), loadedUser.getLastName());
//        assertEquals(user.getAdditional(), loadedUser.getAdditional());
//        assertEquals(user.getStreet(), loadedUser.getStreet());
//        assertEquals(user.getZip(), loadedUser.getZip());
//        assertEquals(user.getCity(), loadedUser.getCity());
//        assertEquals(user.getEmail(), loadedUser.getEmail());
//        assertEquals(user.getPhone(), loadedUser.getPhone());
//        assertEquals(user.getWebsite(), loadedUser.getWebsite());
//        assertEquals(user.getBankname(), loadedUser.getBankname());
//        assertEquals(user.getIban(), loadedUser.getIban());
//        assertEquals(user.getBic(), loadedUser.getBic());
//    }
}
