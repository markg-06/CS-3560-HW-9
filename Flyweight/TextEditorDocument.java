import java.util.ArrayList;
import java.util.List;

public class TextEditorDocument{

    private List<TextCharacter> characters = new ArrayList<>();

    public void addCharacters(TextCharacter character){
        characters.add(character);
    }
    public List<TextCharacter> getTextCharacters(){
        return characters;
    }

}