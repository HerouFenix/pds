package p05.ex01;

abstract class Container{
    private State[] acceptedState;
    private Temperature[] acceptedTemp;
    private Commodity content;

    public void placeCommodity(Commodity c){
        this.content = c;
    }

    public Commodity getContent(){
        return this.content;
    }

    public String toString(){
        return "";
    }
}

class PlasticBottle extends Container{

    PlasticBottle(){
        super();
    }

    @Override
    public String toString(){
        return "PlasticBottle " + this.getContent().toString();
    }
}

class TermicBottle extends Container{

    TermicBottle(){
        super();
    }

    @Override
    public String toString(){
        return "TermicBottle " + this.getContent().toString();
    }
}

class Tupperware extends Container{

    Tupperware(){
        super();
    }

    @Override
    public String toString(){
        return "Tupperware " + this.getContent().toString();
    }
}


class PlasticBag extends Container{

    PlasticBag(){
        super();
    }

    @Override
    public String toString(){
        return "PlasticBag " + this.getContent().toString();
    }
}
