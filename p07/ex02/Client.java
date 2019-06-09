package p07.ex02;

//Patterns used:
//  -Decorator Pattern (More interesting than the other)

//Other stuff used:
//  -Lots of File Manipulation!


class Client{
    public static void main(String[] args) {
        System.out.println("Using no filters:");
        TextReaderInterface reader = new TextReader("p07/ex02/TestFile.txt");
        System.out.println(reader.next()+"\n");

        System.out.println("Using CodeFilter:");
        reader = new CodeFilter(new TextReader("p07/ex02/TestFile.txt"));
        System.out.println(reader.next()+"\n");

        System.out.println("Using ReverseFilter:");
        reader = new ReverseFilter(new TextReader("p07/ex02/TestFile.txt"));
        reader.next();
        System.out.println(reader.next()+"\n");

        System.out.println("Using TermFilter:");
        reader = new TermFilter(new TextReader("p07/ex02/TestFile.txt"));
        reader.next();
        System.out.println(reader.next()+"\n");


        System.out.println("Using all filters:");
        reader = new ReverseFilter(new TermFilter(new TextReader("p07/ex02/TestFile.txt")));
        reader.next();
        System.out.println(reader.next());
    }
}