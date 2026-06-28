// Factory Method Pattern - Document Management

abstract class Document {
    public abstract void create();
    public abstract void open();
}

class WordDocument extends Document {
    public void create() {
        System.out.println("Creating a Word document...");
    }
    public void open() {
        System.out.println("Opening Word document");
    }
}
class PdfDocument extends Document {
    public void create() {
        System.out.println("Creating a PDF document...");
    }
    public void open() {
        System.out.println("Opening PDF document");
    }
}
class ExcelDocument extends Document {
    public void create() {
        System.out.println("Creating an Excel document...");
    }
    public void open() {
        System.out.println("Opening Excel document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}
public class FactoryMethodPattern {
    public static void main(String[] args) {
        // Create Word document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.create();
        wordDoc.open();
        
        System.out.println();
        
        // Create PDF document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.create();
        pdfDoc.open();
        
        System.out.println();
        
        // Create Excel document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.create();
        excelDoc.open();
    }
}
