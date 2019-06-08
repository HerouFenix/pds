package p06.ex01;
import java.util.ArrayList;
import java.util.List;

class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Guarda empregado
    
    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        //Funçao comeca por iterar sobre todos os empregados registados para verificar se não estamos a tentar adicionar um duplicado
        for (Empregado e : this.empregados){

            if(e.equals(emp)){
                System.out.println("Erro! Empregado ja existe no sistema!");
                return;
            }

        }
        
        this.empregados.add(emp);

    }

    public void remove(int codigo) {
        //Primeiro verificamos se o empregado existe, depois removemos-lo
        if (this.isEmpregado(codigo)){
            for (Empregado e : this.empregados){
                if(e.codigo() == codigo){
                    this.empregados.remove(e);
                }
            }
        }

    }
    public boolean isEmpregado(int codigo) {
        for (Empregado e : this.empregados){
            if(e.codigo() == codigo){
                return true;
            }
        }

        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        return this.empregados;
    }
}