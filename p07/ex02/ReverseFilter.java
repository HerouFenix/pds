package p07.ex02;

class ReverseFilter extends TextReaderDecorator{
    
    ReverseFilter(TextReaderInterface r){
        super(r);
    }

    @Override
    public String next(){
        String nextWord = super.next();
        return new StringBuilder(nextWord).reverse().toString();
    };

}