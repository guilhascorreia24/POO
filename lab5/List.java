public class List<T> implements MyList, Cloneable{
    private int size = 0;
    private Object[] eleObjects;

    public List() {
        eleObjects = new Object[10];
    }

    @Override
    public int size() throws IllegalArgumentException{
        if(size<0){
            throw new IllegalArgumentException();
        }
        return size;
    }

    @Override
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

    @Override
    public Object getfirstElementOf(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        return eleObjects[i];
    }

    public void add(T o) {
        if(o.equals(null)){
            throw new IllegalArgumentException();
        }
        if (size == eleObjects.length) {
            ensureCapacity();
        }
        eleObjects[size++] = o;
    }

    private void removeindex(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size);
        }
        int numElts = eleObjects.length - (i + 1);
        System.arraycopy(eleObjects, i + 1, eleObjects, i, numElts);
        size--;
    }

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

    @Override
    public boolean contains(Object o,int i) {
        for (Object x : eleObjects) {
            if (x.equals(o)) {
                return true;
            }
        }
        return false;
    }

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