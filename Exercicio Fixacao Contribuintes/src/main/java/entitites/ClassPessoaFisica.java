package entitites;

public class ClassPessoaFisica extends ClassPessoa{
    private Double gastoComSaude;

    public ClassPessoaFisica(String nome, double rendaAnual, double gastoComSaude) {
        super(nome, rendaAnual);
        setGastoComSaude(gastoComSaude);
    }
    @Override
    public String toString() {
        return String.format("%s: $%.2f", getNome(), imposto());
    }

    @Override
    public double imposto() {
        double tax;
        if(getRendaAnual()<20000.00) tax = 0.15;
        else tax = 0.25;
        if(getGastoComSaude()>0) return (getRendaAnual() * tax) - (getGastoComSaude() * 0.5);
        else return (getRendaAnual() * tax);

    }

    public Double getGastoComSaude() {
        return gastoComSaude;
    }
    public void setGastoComSaude(Double gastoComSaude) {
        this.gastoComSaude = gastoComSaude;
    }
}
