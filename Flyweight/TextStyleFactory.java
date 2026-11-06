import java.util.HashMap;

public class TextStyleFactory {
    private HashMap <String, TextStyle> textStyles = new HashMap<>();

    public TextStyle getTextStyle(String font, String color, int size){
        
        String key = font + "-" + color + "-" + size;

        if(!textStyles.containsKey(key)){
            TextStyle style = new TextStyle(font, color, size);
            
            textStyles.put(key,style);
        }
        return textStyles.get(key);
    } 
    
}
