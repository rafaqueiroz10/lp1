package br.cefetmg.inf.llp1.lista18.ConstrutoraFMC;

import java.util.Scanner;
import java.util.Locale;
import br.cefetmg.inf.llp1.lista18.ConstrutoraFMC.Funcionario;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        int n = input.nextInt();
        input.nextLine();

        Funcionario funcionarios[] = new Funcionario[n];

        for(int i = 0; i < n; i++) {
            int codigo = input.nextInt();
            input.nextLine();
            String nome = input.nextLine();

            funcionarios[i] = new Funcionario(nome, codigo);
        }

        int m = input.nextInt();
        input.nextLine();

        for(int i = 0; i < m; i++) {
            String data = input.nextLine();
            int codigo = input.nextInt();
            input.nextLine();
            float horasTrabalhadas = input.nextFloat();
            input.nextLine();

            for(int j = 0; j < n; j++) {
                if(funcionarios[j].getCodigo() == codigo) {
                    float horas = funcionarios[j].getHorasTrabalhadas();
                    funcionarios[j].setHorasTrabalhadas(horas + horasTrabalhadas);

                    if(horas > 8) {
                        float horasExtras = funcionarios[j].getHorasExtras();
                        funcionarios[j].setHorasExtras(horasExtras + (horas-8));
                    }
                }
            }

            input.nextLine();
        }

        for(Funcionario funcionario:funcionarios) {
            System.out.print(funcionario.getCodigo() + " ");
            System.out.print(funcionario.getNome() + " ");
            System.out.print(funcionario.getHorasTrabalhadas()  + " ");
            System.out.print(funcionario.getHorasExtras()  + " ");
            System.out.print(funcionario.calculaValorHorasExtras()  + " ");
            System.out.print(funcionario.calculaSalarioBruto() + " ");
            System.out.print(funcionario.calculaAliquotaINSS() + " ");
            System.out.print(funcionario.calculaValorINSS()  + " ");
            System.out.print(funcionario.calculaSalarioBruto() - funcionario.calculaValorINSS()  + " ");
            System.out.print(funcionario.calculaAliquotaIRPF()  + " ");
            System.out.print(funcionario.calculaValorIRPF() + " ");
            System.out.print((funcionario.calculaValorINSS() + funcionario.calculaValorIRPF())  + " ");
            System.out.print(funcionario.calculaSalarioLiquido() + " ");
        }
    }
}