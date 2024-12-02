package com.madimadica.aoc2024.common;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

public class Counter<T> {

    private final Map<T, LongAdder> counter;

    public Counter() {
        counter = new ConcurrentHashMap<>();
    }

    private LongAdder getAdder(T element) {
        return counter.computeIfAbsent(element, ignored -> new LongAdder());
    }

    public void increment(T element) {
        getAdder(element).increment();
    }

    public void increment(T element, long amount) {
        getAdder(element).add(amount);
    }

    public void decrement(T element) {
        getAdder(element).decrement();
    }

    public void decrement(T element, long amount) {
        getAdder(element).add(-amount);
    }

    public void reset(T element) {
        getAdder(element).reset();
    }

    /**
     * If the element doesn't exist, a count of 0 is returned.
     * @param element counter key
     * @return number of occurences
     */
    public long get(T element) {
        return getAdder(element).longValue();
    }

    public List<T> getListAscending() {
        return counter.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(counterEntry -> counterEntry.getValue().longValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<T> getListDecending() {
        return counter.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(counterEntry -> -counterEntry.getValue().longValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return '[' + counter.entrySet()
                .stream()
                .sorted(Comparator.comparingLong(counterEntry -> counterEntry.getValue().longValue()))
                .map(e -> String.format("%s => %s", e.getKey(), e.getValue()))
                .collect(Collectors.joining("\n")) + ']';
    }
}
