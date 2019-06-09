package p07.ex02;

class TextReaderDecorator implements TextReaderInterface{
    private TextReaderInterface reader;
    
    TextReaderDecorator(TextReaderInterface r){
        this.reader = r;
    }

    public boolean hasNext(){
        return this.reader.hasNext();
    };
    
    public String next(){
        return this.reader.next();
    };

}