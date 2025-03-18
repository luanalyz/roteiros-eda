

public class FIFOEvictionStrategy {

    private FIFOCache f;

    public FIFOEvictionStrategy(int capacidade) {
        this.f = new FIFOCache(capacidade);
    }

    /*
    * retorna "hit" se estiver no cache.
    * retorna "miss" se não estiver no cache e adiciona no mesmo.
    * Note que essa é uma simplificação. Idealmente, esse método retornaria o
    * objeto com a chave passada como parâmetro.
    **/
    public String get(String chave) {
        if(!f.contains(chave)) {
            f.addLast(chave);
            return "miss";
        }
        return "hit";
    }

    /*
    * retorna o próximo que deve sair do cache caso entre mais alguém e ele esteja cheio.
    * se não for sair ninguém, ou seja, se ainda não estiver cheio, retorna null.
    **/
    public String getNextEviction() {
        if(this.f.isEmpty() || !this.f.isFull()) return null;
        return this.f.getFirst();
    }    

    //retorna a quantidade de elementos no cache.
    public int size() {
        return this.f.size();
    }

}
