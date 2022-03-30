package entitites;

public class ClassPessoaJuridica extends ClassPessoa{
    private Integer numeroFuncionarios;

    public ClassPessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        setNumeroFuncionarios(numeroFuncionarios);
    }
    @Override
    public String toString() {
        return String.format("%s: $%.2f", getNome(), imposto());
    }

    @Override
    public double imposto() {
        double tax;
        if(getNumeroFuncionarios()>10) tax = 0.14;
        else tax = 0.16;
        return getRendaAnual() * tax;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }
    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

}
