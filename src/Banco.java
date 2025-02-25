import java.util.*;

public class Banco {
    private List<ContaBancaria> contas;

    Banco(){
        contas = new ArrayList<>();
    }


public void adicionarConta(ContaBancaria conta){
    contas.add(conta);
    System.out.println("conta adicionada com sucesso");
}
public void removerConta(String numeroConta){
    ContaBancaria contaParaRemover = null;
    for (ContaBancaria conta:contas){
        if(conta.getNumeroConta().equals(numeroConta)){
            contaParaRemover = conta;
            break;
        }
    }
    if (contaParaRemover != null) {
        contas.remove(contaParaRemover);
        System.out.println("conta removida com suscesso");
    }else{
        System.out.println("conta nao encontrada");
    }

}
public void listarcontas(){
    for(ContaBancaria conta:contas){
        System.out.println("Numero da Conta: " + conta.getNumeroConta() + ", Titular: " + conta.getTitular() + ", Saldor R$" + conta.getSaldo());
    }
}
public ContaBancaria encontrarConta(String numeroConta){
    for(ContaBancaria conta:contas) {
        if (conta.getNumeroConta().equals(numeroConta)) {
            return conta;
        }
    }
    return null;
}

}