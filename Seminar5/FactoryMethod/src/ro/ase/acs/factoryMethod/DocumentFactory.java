package ro.ase.acs.factoryMethod;

public interface DocumentFactory {
    public Document getDocument(DocumentType documentType, String name) throws NoSuchDocumentException;
}
