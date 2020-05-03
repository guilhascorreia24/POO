/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public interface MyList{
    /**
     * tamanho da lista
     */
    int size();
    /**
     * limpa a lista
     */
    void clear();
    /**
     * 
     * @param i index do elemento na lista
     * @return devolve o Objecto correspondente
     */
    Object getfirstElementOf(int i);
    /**
     * 
     * @param o Objecto que queremos procurar
     * @param i index da lista
     * @return devolve um boolean 
     */
    boolean contains(Object o, int i);
}