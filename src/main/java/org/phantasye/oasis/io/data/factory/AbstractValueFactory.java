package org.phantasye.oasis.io.data.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractValueFactory<K, V> {

    private Map<K, V> valueMap = new HashMap<>();

    public Optional<V> getValue(K key) {
        V value = valueMap.get(key);

        if (value == null) {
            value = loadValueFor(key);
        }
        valueMap.put(key, value);
        return Optional.of(value);
    }

    public abstract V loadValueFor(K key);
}
