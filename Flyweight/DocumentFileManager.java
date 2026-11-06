import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentFileManager {

    private TextStyleFactory textStyleFactory;

    public DocumentFileManager(TextStyleFactory textStyleFactory) {
        this.textStyleFactory = textStyleFactory;
    }

    public void save(TextEditorDocument document, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        for (TextCharacter character :document.getTextCharacters()) {
            
            TextStyle style = character.textStyle();
            
            writer.write(
                character.getCharacter()
                + "|" + style.font
                + "|" + style.color
                + "|" + style.size
                + "\n"
            );
        }

        writer.close();
    }

    public TextEditorDocument load(String fileName) throws IOException {

        TextEditorDocument document = new TextEditorDocument();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");

            char character =
                    parts[0].charAt(0);

            String font = parts[1];
            String color = parts[2];
            int size = Integer.parseInt(parts[3]);

            TextStyle style =
                    textStyleFactory.getTextStyle(
                            font, color, size
                    );

            TextCharacter textCharacter =
                    new TextCharacter(character, style);

            document.addCharacters(textCharacter);
        }

        reader.close();

        return document;
    }
}