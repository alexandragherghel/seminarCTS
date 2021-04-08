package ro.ase.acs.factoryMethod;

public class MicrosoftOfficeFactory implements DocumentFactory {

    @Override
    public Document getDocument(DocumentType documentType, String name) throws NoSuchDocumentException {

        if(documentType==DocumentType.TEXT_EDITOR)
        {
            return new WordDocument(name);
        } else  if(documentType==DocumentType.SPREADSHEET)
        {
            return new ExcelDocument(name);
        }
            throw new NoSuchDocumentException();
    }
}
