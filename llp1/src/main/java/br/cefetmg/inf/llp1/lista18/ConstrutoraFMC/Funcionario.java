package br.cefetmg.inf.llp1.lista18.ConstrutoraFMC;

public class Funcionario {
    private final int codigo;
    private final String nome;
    private float horasTrabalhadas;
    private float horasExtras;

    Funcionario(String nome, int codigo, float horasTrabalhadas, float horasExtras) {
        this.nome = nome;
        this.codigo = codigo;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExtras = horasExtras;
    }

    Funcionario(String nome, int codigo) {
        this(nome, codigo, 0, 0);
    }

    public void setHorasTrabalhadas(float horas) {
        horasTrabalhadas = horas;
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasExtras(float horas) {
        horasExtras = horas;
    }

    public float getHorasExtras() {
        return horasExtras;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double calculaValorHorasExtras() {
        return 150 * horasExtras;
    }

    public double calculaSalarioBruto() {
        double valorHoraExtra = calculaValorHorasExtras();
        return 100 * (horasTrabalhadas - horasExtras) + valorHoraExtra;
    }

    public double calculaAliquotaINSS() {
        double salarioBruto = calculaSalarioBruto();

        if(salarioBruto < 1212.01) 
            return 0.075;
        
        else if(salarioBruto < 2427.36) 
            return 0.09;
        
        else if(salarioBruto < 3641.04) 
            return 0.12;
        
        return 0.14;
    }

    public double calculaValorINSS() {
        double salarioBruto = calculaSalarioBruto();
        double aliquota = calculaAliquotaINSS();
        return aliquota * salarioBruto / 100;
    }

    public double calculaAliquotaIRPF() {
        double salarioBruto = calculaSalarioBruto();

        if(salarioBruto < 1903.99)
            return 0;
        
        else if(salarioBruto < 2826.66)
            return 7.5;
        
        else if(salarioBruto < 3751.06)
            return 15;
        
        else if(salarioBruto < 4664.69)
            return 22.5;

        return 27.5;
    }

    public double calculaDeducaoIRPF() {
        double salarioBruto = calculaSalarioBruto();

        if(salarioBruto < 1903.99)
            return 0;
        
        else if(salarioBruto < 2826.66)
            return 142.8;
        
        else if(salarioBruto < 3751.06)
            return 354.8;
        
        else if(salarioBruto < 4664.69)
            return 636.13;

        return 869.36;
    }

    public double calculaValorIRPF() {
        double deducao = calculaDeducaoIRPF();
        double valorINSS = calculaValorINSS();
        double salarioBruto = calculaSalarioBruto();
        double aliquotaIRPF = calculaAliquotaIRPF();

        double valorAposINSS = salarioBruto - valorINSS;
        return ((aliquotaIRPF * valorAposINSS) / 100) - deducao;
    }

    public double calculaSalarioLiquido() {
        double valorINSS = calculaValorINSS();
        double salarioBruto = calculaSalarioBruto();
        double valorIRPF = calculaValorIRPF();

        return salarioBruto - (valorINSS + valorIRPF);
    }
}