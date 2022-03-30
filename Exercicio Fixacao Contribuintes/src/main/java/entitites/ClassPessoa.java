package entitites;

public abstract class ClassPessoa{
    private String nome;
    private Double rendaAnual;

    public ClassPessoa(String nome, Double rendaAnual) {
        setNome(nome);
        setRendaAnual(rendaAnual);
    }

    public abstract double imposto();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getRendaAnual() {
        return rendaAnual;
    }
    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }
}
