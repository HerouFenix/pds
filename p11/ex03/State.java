package p11.ex03;

interface State{
    void registBook(Book wrappee);
    void requestBook(Book wrappee);
    void returnBook(Book wrappee);
    void cancelBook(Book wrappee);
    void reserveBook(Book wrappee);
}

class Inventory implements State{
    public void registBook(Book wrappee){
        wrappee.setState(new Available());
    };
    
    public void requestBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void returnBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void cancelBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void reserveBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
}

class Available implements State{
    public void registBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void requestBook(Book wrappee){
        wrappee.setState(new Lent());
    };
    
    public void returnBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void cancelBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void reserveBook(Book wrappee){
        wrappee.setState(new Reserved());
    };
}

class Lent implements State{
    public void registBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void requestBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void returnBook(Book wrappee){
        wrappee.setState(new Available());
    };
    
    public void cancelBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void reserveBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
}

class Reserved implements State{
    public void registBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void requestBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void returnBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
    
    public void cancelBook(Book wrappee){
        wrappee.setState(new Available());
    };
    
    public void reserveBook(Book wrappee){
        throw new UnsupportedOperationException("Operation not available.");
    };
}