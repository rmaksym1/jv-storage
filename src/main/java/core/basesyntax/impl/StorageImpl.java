package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    Object[] idstorage = new Object[10];
    Object[] storage = new Object[10];
    private K key;
    private V value;
    int currentkey = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < currentkey; i++) {
            if (idstorage[i] == null && key == null) {
                storage[i] = value;
                return;
            }
            if (idstorage[i] != null && idstorage[i].equals(key)) {
                storage[i] = value;
                return;
            }
        }
        storage[currentkey] = value;
        idstorage[currentkey] = key;
        currentkey++;
    }


    @Override
    public V get(K key) {
        for (int i = 0; i < idstorage.length; i++) {
            if (idstorage[i] == null && key == null) {
                return (V) storage[i];
            } else if (idstorage[i] != null && idstorage[i].equals(key)) {
                return (V) storage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int length = 0;
        for (int i = 0; i < currentkey; i++) {
            boolean alreadyCounted = false;
            for (int j = 0; j < i; j++) {
                if (idstorage[i] == null && idstorage[j] == null) {
                    alreadyCounted = true;
                    break;
                } else if (idstorage[i] != null && idstorage[i].equals(idstorage[j])) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (!alreadyCounted) {
                length++;
            }
        }
        return length;
    }

}
