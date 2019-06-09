package p07.ex03;
import java.util.ArrayList;

class Bloco extends Component {
    private ArrayList<Component> elements;
    private String name;

    Bloco(String name){
        this.elements = new ArrayList<>();
        this.name = name;
    }

    public void add(Component c){
        elements.add(c);
    }

    public void printComponent(){
        System.out.println(super.getIndent().toString() + "Window " + this.name);
        
        super.getIndent().append("   ");    //Indent further

        for(Component i : elements){ //Print elements
            i.printComponent();
        }

        super.getIndent().setLength(super.getIndent().length() - 3); //Get back to base indent
    }

}