package week15_mid_prep.InvoiceManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    private static List<Invoice> invoices;

    @BeforeEach
    public void SetUp(){
        invoices = InvoiceProcessor.loadInvoices("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/invoices.csv");
    }

    @Test
    public void ifFieldsMissing_ThrowCustomException(){
        assertThrows(InvalidInvoiceException.class, ()->{InvoiceProcessor.loadInvoices("/Users/selmadjozic/IdeaProjects/OOP_labss/src/test/resources/invoices_with_empty_fields.csv");},
                "InvalidInvoiceException shall be thrown when there are some mandatory fields missing.");
    }

    @Test
    public void ifFileloaded_verifyConditions(){
        assertAll(
                ()->assertEquals(3000.00, invoices.get(1).getTotalAmount()),
                ()->assertEquals(3, invoices.size())
        );
    }

    @Test
    public void ifFileMissing_assertCauseIsFileNotFoundException(){
        try{
            InvoiceProcessor.loadInvoices("/path/to/nonexistent/file.csv");
        }
        catch(RuntimeException e){
            assertTrue(e.getCause() instanceof FileNotFoundException);
        }
    }
}