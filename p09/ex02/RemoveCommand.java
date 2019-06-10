package p09.ex02;
import java.util.Stack;
import java.util.Collection;

class RemoveCommand<T> extends CommandAbstract{

    RemoveCommand(Collection<T> genericCollection){
        super(genericCollection);
    } 

    public boolean execute(T element){
        boolean success = this.genericCollection.remove(element); //Tries to remove the element to the collection
        
        if(success) //If it managed to do so, it pushes the element to the top of the elements stack
            this.elementsStack.push(element);

        return success;
    }

    public boolean undo(){
        boolean success = this.genericCollection.add(this.elementsStack.peek()); //Tries to add back the element from the collection
        if(success)
            this.elementsStack.pop(); //If it managed to do so, it pops the element out of the elements stack

        return success;
    }
}