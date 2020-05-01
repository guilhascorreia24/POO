

public class List<T> implements MyList, Cloneable{
    private int size = 0;
    private Object[] eleObjects;

    public List() {
        eleObjects = new Object[10];
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public void clear() {
        int i = size - 1;
        while (i >= 0) {
            // System.out.println(size+" "+i);
            removeindex(i);
            i--;
        }
    }

    public void remove(T o) {
        int i = 0;
        while (i < size && !getfirstElementOf(i).equals(o)) {
            i++;
        }
        //System.out.println(i+" "+this);
        if (i < size)
            removeindex(i);
    }

    @Override
    public Object getfirstElementOf(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return eleObjects[i];
    }

    public void add(T o) {
        if (size == eleObjects.length) {
            ensureCapacity();
        }
        eleObjects[size++] = o;
    }

    private void removeindex(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        int numElts = eleObjects.length - (i + 1);
        System.arraycopy(eleObjects, i + 1, eleObjects, i, numElts);
        size--;
    }

    private void ensureCapacity() {
        int newSize = eleObjects.length * 2;
        for(int i=0;i<newSize;i++){
            if(i<size)
                eleObjects[i]=eleObjects[i];
            else
                eleObjects[i]=null;
        }
        //eleObjects = Arrays.copyOf(eleObjects, newSize);
    }

    @Override
    public String toString() {
        // System.out.println(size);
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