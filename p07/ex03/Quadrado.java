package p07.ex03;

class Quadrado extends Component {
    private String name;

    Quadrado(String name){
        this.name = name;
    }

    public void printComponent(){
        System.out.println(super.getIndent().toString() + "Quadrado " + this.name);
    }

}