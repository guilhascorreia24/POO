/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class List<T> implements Cloneable{
    private int size = 0;
    private Object[] eleObjects;

    /**
     * incializa a lista com a criacao de um array
     * @inv size reprsenta o tamanho da lista
     * @inv eleObject representa o array de objectos
     */
    public List() {
        eleObjects = new Object[10];
    }

    /**
     * Tamanho da lista
     * @pre o size nao pode ser nulo
     * @return devolve o tamanho 
     */
    public int size() throws IllegalArgumentException{
        if(size<0){
            throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * limpa a lista
     * @throws lancada quando o tamanho da lista e menor que 0
     */
    public void clear() {
        int i = size - 1;
        if(size<0){
            throw new IllegalArgumentException();
        }
        while (i >= 0) {
            removeindex(i);
            i--;
        }
    }

    /**
     * remove o Objecto o da lista
     * @param o Objecto queremos eliminar
     * 
     */
    public void remove(T o) throws IllegalArgumentException {
        int i = 0;
        if(o.equals(null)){
            throw new IllegalArgumentException();
        }
        while (i < size && !getfirstElementOf(i).equals(o)) {
            i++;
        }
        if (i < size)
            removeindex(i);
    }

    /**
     * returna objeto com o index selecionado
     * @pre o index i tem de ser entre 0 e o tamanho maximo da lista
     * @param i index na lista
     * @return return objecto com index i
     */
    public Object getfirstElementOf(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        return eleObjects[i];
    }

    /**
     * adiciona o objecto a lista
     * @pre o nao pode ser nulo
     * @param o objecto que queremos adicionar
     * 
     */
    public void add(T o) {
        if(o.equals(null)){
            throw new IllegalArgumentException();
        }
        if (size == eleObjects.length) {
            ensureCapacity();
        }
        eleObjects[size++] = o;
    }

    /**
     * remove o index da lista
     * @pre i tem ser maior 0 e menor que o tamanho maximo da lista
     * @param i index na lista
     */
    public void removeindex(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        int numElts = eleObjects.length - (i + 1);
        System.arraycopy(eleObjects, i + 1, eleObjects, i, numElts);
        size--;
    }

    /**
     * adciona capacidade ao array
     */
    private void ensureCapacity() {
        int newSize = eleObjects.length * 2;
        Object[] newarr=new Object[newSize];
        for(int i=0;i<newSize;i++){
            if(i<eleObjects.length)
                newarr[i]=eleObjects[i];
            else
                newarr[i]=null;
        }
        eleObjects=new Object[newSize];
        eleObjects=newarr; 
    }

    /**
     * Impressao da Lista
     * @return String devolve a impressao da lista
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(eleObjects[i].toString());
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Procura a existencia de um objecto na lista
     * @return devolve um boolean que indica a existencia do objecto o na lista
     * @throws lancado quando o index colocado nao esta entre 0 e o tamanho da lista
     */
    public boolean contains(Object o) {
        for (int k=0;k<size();k++) {
            Object x=eleObjects[k];
            if (x.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     *Clona a lista 
     * @return devolve uma lista igual a original
     */
    @Override
    public List<T> clone() {
        List<T> clone = new List<T>();
        clone.size = size;
        while(clone.eleObjects.length<size){
            clone.ensureCapacity();
        }
        for (int i = 0; i < size; i++)
            clone.eleObjects[i] = eleObjects[i];
        return clone;
    }
}