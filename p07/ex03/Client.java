package p07.ex03;

//Patterns used:
//  -Composite Pattern (Todas as classes implementa: Component ; Blocos podem conter qualquer um dos outros Components)

//Other stuff used:
//  -StringBuffer -> Real interesting way of creating indetnations in composites! (See Component class)

class Client {
    public static void main(String[] args) {
        Bloco principal = new Bloco("Main");
        Bloco top = new Bloco("Top");
        Bloco bot = new Bloco("Bottom");
        
        top.add(new Retangulo("jogo"));
        
        principal.add(top);
        principal.add(bot);
        
        bot.add(new Circulo("rosa"));
        bot.add(new Quadrado("verde"));

        principal.printComponent();

    }
}