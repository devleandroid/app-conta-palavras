package palavras.conta.br.app.contapalavras.controller;

import java.io.Serializable;
import java.util.*;

/**
 * Created by leandro on 29/05/17.
 */
public class SequenciaCaracteres implements Serializable {

    private String palavra;
    private Map<Character, Integer> contaCaracter = new TreeMap<Character, Integer>(  );
    private SortedMap<Integer, List<Character>> quantidades;

    @Override
    public String toString() {
        return "SequenciaCaracteres{" +
                "palavra='" + palavra + '\'' +
                ", contaCaracter=" + contaCaracter +
                ", quantidades=" + quantidades +
                '}';
    }

    public Map<Character, Integer> contaCaracter(){
        return contaCaracter;
    }

    public SortedMap<Integer, List<Character>> contaQuantidade(){
        return this.quantidades;
    }

    public void verificar(){

        quantidades = new TreeMap<Integer, List<Character>>(  );
        if(!palavra.isEmpty())
        for (char caracter : palavra.toCharArray()) {
            int count = 0;
            if (contaCaracter.containsKey( caracter )) {
                count = contaCaracter.get( caracter );
            }
            contaCaracter.put( caracter, count +1 );
        }
        for (Map.Entry<Character, Integer> entry : contaCaracter.entrySet()) {
            List<Character> characters = quantidades.get( entry.getValue() );
            if (characters == null) {
                characters = new ArrayList<Character>(  );
                characters.add( entry.getKey() );
                quantidades.put( entry.getValue(), characters );
            }
        }
    }

    public void limparLista(){
        this.quantidades.clear();
    }
    public List<Character> contaRepetidos(){
        return quantidades.get( quantidades.lastKey() );
    }

    public List<Character> menosRepetidos(){
        return quantidades.get( quantidades.firstKey() );
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}

