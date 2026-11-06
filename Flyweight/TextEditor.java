import java.io.IOException;

public class TextEditor{
    public static void main(String[] args)throws IOException{
        
        TextStyleFactory factory = new TextStyleFactory();
        TextEditorDocument document = new TextEditorDocument();

        TextStyle hellostyle = factory.getTextStyle("Arial", "Black", 14);
        TextStyle worldStyle = factory.getTextStyle("Calibri", "Blue", 12);
        TextStyle courseStyle = factory.getTextStyle("Verdana", "Red", 16);
        TextStyle courseNumberStyle = factory.getTextStyle("Calibri", "Black", 12);

        addText(document, "Hello", hellostyle);
        addText(document, "World", worldStyle);
        addText(document, "CS", courseStyle );
        addText(document,"3560",courseNumberStyle);

        DocumentFileManager fileManager = new DocumentFileManager(factory);

        fileManager.save(document, "HelloWorldCS3560.txt");

        TextEditorDocument loadedDocument = fileManager.load("HelloWorldCS3560.txt");

        for (TextCharacter character :loadedDocument.getTextCharacters()) {
            
            TextStyle style =character.textStyle();
            
            System.out.println(character.getCharacter()+ " - " + style.font + ", "+ style.color+ ", "+ style.size);
        }
    }

    private static void addText(TextEditorDocument document, String text,TextStyle style) {

        for (int i = 0; i < text.length(); i++) {
            document.addCharacters(new TextCharacter(text.charAt(i),style)
            );
        }
    }
}