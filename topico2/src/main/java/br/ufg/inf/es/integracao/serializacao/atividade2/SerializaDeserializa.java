/*
 * Copyright (c) 2018.
 * Antonio Arlis Santos da Silva
 * Creative Commons Attribution 4.0 International License.
 */

package br.ufg.inf.es.integracao.serializacao.atividade2;

import java.io.*;

/**
 * Classe que gera exerção ao tentar serializar um obleto.
 */
public class SerializaDeserializa {

    /**
     * Método responsável pela inicialização do programa.
     * @param args argumentos de entrada do metodo persistir.
     */
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream byt = new ByteArrayOutputStream();
            Funcionario funcionario = new Funcionario("Jonelson", "1234");
            byte[] bytes = serializar(funcionario);
            Funcionario funcionarios = deserializar(args[2]);
            System.out.println(funcionarios.getMatricula());
            System.out.println(funcionarios.getNome());
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que serializar um objeto.
     * @param objeto objeto a ser serializado.
     * @throws IOException caso o nome do arquivo seja invalido.
     */
    public static byte[] serializar(Object objeto) throws IOException {

        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        ObjectOutputStream objAux = new ObjectOutputStream(aux);

        objAux.writeObject(objeto);
        objAux.close();

        byte[] byteArray = aux.toByteArray();

        return byteArray;

    }

    /**
     * Método que deserializar um objeto.
     * @param nomeArquivo nome do arquivo onde o objeto encontra-se salvo.
     * @return Objeto do tipo funcionario.
     * @throws IOException caso o nome do arquivo seja invalido.
     * @throws ClassNotFoundException caso apresente erro na leitura do objeto.
     */
    public static Funcionario deserializar(String nomeArquivo) throws IOException, ClassNotFoundException {

        if (!nomeValido(nomeArquivo)) {
            throw new IllegalArgumentException("Ops, nome de arquivo é invalido!");
        } else {

            FileInputStream inFile = new FileInputStream(nomeArquivo);
            ObjectInputStream d = new ObjectInputStream(inFile);
            Funcionario objeto = (Funcionario) d.readObject();

            d.close();
            return objeto;
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
