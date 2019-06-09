package p07.ex03;
import java.lang.StringBuffer;;

abstract class Component{
    private static StringBuffer indent = new StringBuffer();
    public abstract void printComponent();

    public StringBuffer getIndent(){
        return indent;
    }
}