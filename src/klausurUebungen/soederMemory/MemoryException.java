package klausurUebungen.soederMemory;

public class MemoryException extends Exception {

    enum MemoryExceptions{

        PLAYERS("At least too players required"),
        IMAGES("Too few images available");

        String description;

        MemoryExceptions(String s) {
            this.description = s;
        }
    }

    public MemoryException(MemoryExceptions memoryExceptions) {
        super(memoryExceptions.description);
    }
}
