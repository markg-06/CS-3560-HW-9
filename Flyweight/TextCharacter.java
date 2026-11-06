public class TextCharacter{
    
    private char character;
    private TextStyle textStyle;

    public TextCharacter(char character, TextStyle textStyle){
        this.character = character;
        this.textStyle = textStyle;

    }
    public char getCharacter(){
        return character;
    }
    public TextStyle textStyle(){
        return textStyle;
    }

}