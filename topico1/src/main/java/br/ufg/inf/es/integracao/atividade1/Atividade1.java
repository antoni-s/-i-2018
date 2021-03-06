/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.integracao.atividade1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Classe que recebe como único argumento um nome de arquivo e exibe os 4 primeiros
 * bytes (inteiro de 32 bits) em formato hexadecimal na saída padrão.
 */
public class Atividade1 {

    /**
     * Método responsável pela entrada e exibição dos dados do programa.
     *
     * @param args nome do arquivo a ser lido.
     */
    public static void main(String[] args) {

        try {
            System.out.println(retornaHexa(args[0]));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * Método recebe o nome de um arquivo e retorna os 4 primeiros bytes do arquivo.
     *
     * @param file entrada de uma String com o nome do arquivo.
     * @return os 4 primeiros bytes do arquivo.
     * @throws IOException caso o nome do arquivo esteja em branco.
     */
    public static int retornaHexa(String file) throws IOException {


        if(nomeValido(file)) {
            FileInputStream arq = new FileInputStream(file);
            DataInputStream arquivo = new DataInputStream(arq);
            int aux = arquivo.readInt();
            arquivo.close();

            return Integer.parseInt(Integer.toHexString(aux));
        } else {
            throw new IllegalArgumentException("Ops, nome de arquivo é invalido!");
        }

    }

    /**
     * Método que verifica se o nome de um arquivo é valido.
     * @param file Nome do arquivo.
     * @return True nome valido.
     */
    private static boolean nomeValido(String file) {
        if (file.equals(null) || file.trim().isEmpty()) {
            return false;
        }

        return true;
    }

}
