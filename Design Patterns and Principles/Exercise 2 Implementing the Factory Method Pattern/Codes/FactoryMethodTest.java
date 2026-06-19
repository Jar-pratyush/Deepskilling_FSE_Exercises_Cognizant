public class FactoryMethodTest {
    public static void main(String[] args) {
        // Create factories for each type
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // Use factories to create documents smoothly
        Document doc1 = wordFactory.createDocument();
        Document doc2 = pdfFactory.createDocument();
        Document doc3 = excelFactory.createDocument();

        // Work with the created instances
        doc1.open();
        doc1.close();

        System.out.println("---------------------------------");

        doc2.open();
        doc2.close();

        System.out.println("---------------------------------");

        doc3.open();
        doc3.close();
    }
}