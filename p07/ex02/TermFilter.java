package p07.ex02;

//Nota: I basically had no idea what the teacher wanted here, so I made it so the
//term filter just returns one word at a time rather than a whole paragraph...meh
class TermFilter extends TextReaderDecorator{
    private String[] buffer;
    private int bufferCounter;

    TermFilter(TextReaderInterface r){
        super(r);
        this.buffer = new String[0];
        this.bufferCounter = 0;
    }

    @Override
    public String next(){
        if (this.bufferCounter == this.buffer.length){
            this.buffer = super.next().split(" ");
            this.bufferCounter = 0;
        }
        
        String nextWord = this.buffer[this.bufferCounter];
        this.bufferCounter++;

        return nextWord;
        
    };

}