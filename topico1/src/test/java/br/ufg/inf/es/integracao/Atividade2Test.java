package br.ufg.inf.es.integracao;

import br.ufg.inf.es.integracao.atividade2.Atividade2;
import org.junit.Test;

public class Atividade2Test {
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoInexistenteGeraExcecao() throws Exception {
        Atividade2.verificaArquivo("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoNomeEmBranco() throws Exception {
        Atividade2.verificaArquivo(" ");
    }
    
}
