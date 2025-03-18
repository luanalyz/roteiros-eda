package main.java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Multiplicacao {
    private ArrayList<Integer>[] tabela;
    private final int CAPACIDADE_DEFAULT = 53;

    public static void main(String[] args) {
        Multiplicacao tab = new Multiplicacao();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";

            while((line = reader.readLine()) != null) {
                tab.put(Integer.parseInt(line));
            }
        } catch(IOException ioe) {}

        System.out.println(tab.seila());
    }
    
    private String imprime() {
        String out = "";
        for(int i = 0; i < CAPACIDADE_DEFAULT; i++) {
            if(out.equals("")) {
                out += i + ", " + this.tabela[i];
            } else {
                out += "\n" + i + ", " + this.tabela[i];
            }
        }
        return out;
    }

    public int seila() {
        int soma = -53;
        for(int i = 0; i < CAPACIDADE_DEFAULT; i++) {
            soma += this.tabela[i].size();
        }
        return soma;
    }

    @SuppressWarnings("unchecked")
    public Multiplicacao() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }

    private int hash(int chave) {
        double aux = (((chave * 0.6180339887) % 1) * CAPACIDADE_DEFAULT);
        return (int)aux;
    }

    public void put(Integer chave) {
        int hash = hash(chave);
        ArrayList<Integer> chaves = this.tabela[hash];

        if(chaves == null) {
            chaves = new ArrayList<Integer>();
            chaves.add(chave);
            this.tabela[hash] = chaves;
        } else {
            chaves.add(chave);
        }
    }
}
