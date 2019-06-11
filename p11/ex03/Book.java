package p11.ex03;

class Book{
    private String title;

    private int ISBN;
    private static int currentISBN = 0;

    private int year;
    private String author;

    private State currentState;

    Book(String t, int y, String a){
        this.title = t;
        this.ISBN = ++currentISBN;
        this.year = y;
        this.author = a;

        this.currentState = new Inventory();
    }

    public void setState(State s){
        this.currentState = s;
    }

    public void registBook(){
        this.currentState.registBook(this);
    };
    
    public void requestBook(){
        this.currentState.requestBook(this);
    };
    
    public void returnBook(){
        this.currentState.returnBook(this);
    };
    
    public void cancelBook(){
        this.currentState.cancelBook(this);
    };
    
    public void reserveBook(){
        this.currentState.reserveBook(this);
    };
    
    @Override
    public String toString() {
        return String.format("Book: %-5d %-20s %-20s %-15s", ISBN, title, author,
                "[" + currentState.getClass().getSimpleName() + "]");
    }
}