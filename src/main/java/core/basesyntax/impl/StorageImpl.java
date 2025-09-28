package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private final static int DEFAULT_CAPACITY = 10;
    private int currentkey = 0;
    private int size = 0;

    public StorageImpl() {
        keys = (K[]) new Object[DEFAULT_CAPACITY];
        values = (V[]) new Object[DEFAULT_CAPACITY];
    }


    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentkey; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                return;
            }
        }
        keys[currentkey] = key;
        values[currentkey] = value;
        currentkey++;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null && key == null) {
                return values[i];
            } else if (keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
