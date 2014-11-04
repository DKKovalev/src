import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.*;

public class SomeTests {

    @Test
    public void testingEquality() {
        SystemError expectedError = new SystemError(1, "File not found", "The system cannot find the file");
        SystemError actualError = new SystemError(1, "File not found", "The system cannot find the file");
        assertEquals("Testing errors equality", expectedError, actualError);
    }

    @Test
    public void testingRemoval() {
        LinkedHashSet<SystemError> systemErrors = new LinkedHashSet<SystemError>();
        systemErrors.add(new SystemError(1, "File not found", "The system cannot find the file"));
        systemErrors.add(new SystemError(2, "Not enough memory", "Not enough storage is available"));
        systemErrors.add(new SystemError(4, "Read error", "The system cannot read the file"));
        systemErrors.add(new SystemError(3, "Write error", "The system cannot write file"));
        systemErrors.add(new SystemError(5, "Network access denied", "Network access is denied"));
        systemErrors.add(new SystemError(6, "Buffer overflow", "The file name is too long"));

        SystemError toRemove = new SystemError(1, "File not found", "The system cannot find the file");
        systemErrors.remove(toRemove);

        LinkedHashSet<SystemError> modifiedSystemErrors = new LinkedHashSet<SystemError>();
        modifiedSystemErrors.add(new SystemError(2, "Not enough memory", "Not enough storage is available"));
        modifiedSystemErrors.add(new SystemError(4, "Read error", "The system cannot read the file"));
        modifiedSystemErrors.add(new SystemError(3, "Write error", "The system cannot write file"));
        modifiedSystemErrors.add(new SystemError(5, "Network access denied", "Network access is denied"));
        modifiedSystemErrors.add(new SystemError(6, "Buffer overflow", "The file name is too long"));

        assertEquals("Testing removal", modifiedSystemErrors, systemErrors);
    }

    @Test
    public void testingCompleteRemoval() {
        LinkedHashSet<SystemError> systemErrors = new LinkedHashSet<SystemError>();
        systemErrors.add(new SystemError(1, "File not found", "The system cannot find the file"));
        systemErrors.add(new SystemError(2, "Not enough memory", "Not enough storage is available"));
        systemErrors.add(new SystemError(4, "Read error", "The system cannot read the file"));
        systemErrors.add(new SystemError(3, "Write error", "The system cannot write file"));
        systemErrors.add(new SystemError(5, "Network access denied", "Network access is denied"));
        systemErrors.add(new SystemError(6, "Buffer overflow", "The file name is too long"));

        systemErrors.clear();

        assertTrue(systemErrors.isEmpty());
    }

    @Test
    public void testingIsHashSetNotNull() {
        LinkedHashSet<SystemError> systemErrors = new LinkedHashSet<SystemError>();
        systemErrors.add(new SystemError(1, "File not found", "The system cannot find the file"));
        systemErrors.add(new SystemError(2, "Not enough memory", "Not enough storage is available"));
        systemErrors.add(new SystemError(4, "Read error", "The system cannot read the file"));
        systemErrors.add(new SystemError(3, "Write error", "The system cannot write file"));
        systemErrors.add(new SystemError(5, "Network access denied", "Network access is denied"));
        systemErrors.add(new SystemError(6, "Buffer overflow", "The file name is too long"));

        assertNotNull(systemErrors);
    }

    @Test
    public void testingArguments() {
        SystemError error = new SystemError(1, "File not found", "The system cannot find the file");

        double sloppyId = 1.135;
        String sloppyTitle = "Ohmaigawditsaerror";
        String sloppyDescription = null;

        assertNotSame(sloppyId, error.getErrorId());
        assertNotSame(sloppyTitle, error.getErrorTitle());
        assertNotSame(sloppyDescription, error.getErrorDescription());
    }

    /**
     * Тест будет завален.
     */

    @Test(expected = IllegalArgumentException.class)
    public void testingException(){
        SystemError error = new SystemError();
        error.setErrorId(25);
    }

}