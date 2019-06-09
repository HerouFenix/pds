package p06.ex01;


class CompanyAdapter{
    private Database db;
    private Registos reg;

    CompanyAdapter(){
        this.db = new Database();
        this.reg = new Registos();
    }

    //Depending on if we're adding and employee or an empregado
    public boolean addEmployee(Employee emp){
        return this.db.addEmployee(emp);
    }
    public void addEmployee(Empregado emp){
        this.reg.insere(emp);
    }


    public void removeEmployee(int code){
        this.db.deleteEmployee(code);
        this.reg.remove(code);
    }

    public void isInCompany(int code){
        if (this.reg.isEmpregado(code)){
            System.out.println("Employee belongs to company!");
        }else{
            for(Employee i : this.db.getAllEmployees()){
                if (i.getEmpNum() == code){
                    System.out.println("Employee belongs to company!");
                    return;
                }
            }
            System.out.println("Employee does not belong to company!");

        }
    }

    public void printAllEmployees(){
        for(Employee i : this.db.getAllEmployees()){
            System.out.println(i.getName());
        } 
        for(Empregado i : this.reg.listaDeEmpregados()){
            System.out.println(i.nome() + " " + i.apelido());
        } 
    }
}