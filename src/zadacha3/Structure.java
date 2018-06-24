package zadacha3;

public class Structure {
    private String exp;
    private Correction isCorrect;
    public Structure(String s){
        this.exp = s;
        this.isCorrect = new Correction(3);
        isCorrect.addModification(FirstVerifying());
        isCorrect.addModification(SecondVerifying());
        isCorrect.addModification(ThirdVerifying());
    }
    private boolean FirstVerifying(){
        String Alphabet =
                "qwertyuiopasdfghjklzxcvbnm" +
                        "йцукенгшщзфывапролдячсмить";
        String uniqChars = "!@#$%^&_/?><,.";
        String[] temp = exp.split("");
        for(String s: temp){
            if(Alphabet.contains(s) ||
                    Alphabet.contains(s.toLowerCase()) ||
                    uniqChars.contains(s))
                return false;

        }
        return true;
    }
    private boolean SecondVerifying() {
        String word = "";
        for(String s : exp.split(""))
            if(s != " ") word+=s;
        String[] temp = word.split("");
        String chars = "+=-\\*";
        for(int i = 2;i < temp.length;i++){
            if(chars.contains(temp[i]))
                if(temp[i] == temp[i-2] && temp[i] == temp[i-1] && temp[i-1] == temp[i-2]){
                return false;
                }

        }
        return true;
    }
    private boolean ThirdVerifying(){
        char[] temp = exp.toCharArray();
        int opened = 0;
        int closed = 0;
        for(char ch : temp){
            if(ch == '(') opened++;
            if(ch == ')') closed++;
        }
        if(opened == closed)
            return true;
        return false;
    }
    public boolean isCor(){
        return isCorrect.isCorrect();
    }
}
