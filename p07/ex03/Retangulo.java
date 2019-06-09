package p07.ex03;

class Retangulo extends Component {
    private String name;

    Retangulo(String name){
        this.name = name;
    }

    public void printComponent(){
        System.out.println(super.getIndent().toString() + "Retangulo " + this.name);
    }

}