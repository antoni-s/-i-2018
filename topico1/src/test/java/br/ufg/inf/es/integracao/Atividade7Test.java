/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.integracao;

import br.ufg.inf.es.integracao.atividade7.Atividade7;
import org.junit.Test;

public class Atividade7Test {
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoOneInexistenteGeraExcecao() throws Exception {
        Atividade7.convertsArqToBinary("", "/topico1/test.bat");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoNomeEmBrancoOneGeraExcecao() throws Exception {
        Atividade7.convertsArqToBinary(" ", "/topico1/test.bat");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoSemNomeOneGeraExcecao() throws Exception {
        Atividade7.convertsArqToBinary("", "/topico1/test.bat");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoTwoInexistenteGeraExcecao() throws Exception {
        Atividade7.convertsArqToBinary("/topico1/test.txt", "");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoNomeEmBrancoTwoGeraExcecao() throws Exception {
        Atividade7.convertsArqToBinary("/topico1/test.txt", " ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void arquivoSemNomeTwoGeraExcecao() throws Exception {
        Atividade7.convertsArqToBinary("/topico1/test.txt", "");
    }
    
}
