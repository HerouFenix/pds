package p07.ex02;

import java.util.Base64;

class CodeFilter extends TextReaderDecorator{
    
    CodeFilter(TextReaderInterface r){
        super(r);
    }

    @Override
    public String next(){
        String nextWord = super.next();
        
        //Encode our word using Base64
        String encodedWord = Base64.getEncoder().encodeToString(nextWord.getBytes());
        return encodedWord;
    };

}