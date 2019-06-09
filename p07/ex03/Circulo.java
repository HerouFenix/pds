package p07.ex03;

class Circulo extends Component {
    private String name;

    Circulo(String name){
        this.name = name;
    }

    public void printComponent(){
        System.out.println(super.getIndent().toString() + "Circulo " + this.name);
    }

}