package org.itstep.step03;

import org.itstep.step02.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
// * Итерируемая коллекция объектов Pair.
// *
// * @author Michael S. Kirkpatrick and Nathan Sprague
// * @version V1, 8/2017
// */
public class Pairs<K, V> implements Iterable<Pair<K, V>> {

    /* TODO: Объявить массив фиксированного размера (максимум 10 элементов) объектов Pair */
    private int razmer = 10;
    private Pair<K,V>[] pairs;
    private int elem = 0;


    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */
    @SuppressWarnings("unchecked")
    public Pairs() {
        pairs = new Pair[razmer];
    }

    /**
    * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {

        if(elem >= pairs.length){
            return false;
        }
        pairs[elem++]=new Pair<>(first, second);
        return true;
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator();
    }

    /**
     * TODO: Реализуйте итератор здесь на основе документации API по адресу
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html Throw the exceptions as
     * specified
     */
    private class PairIterator implements Iterator<Pair<K, V>> {
        int i;
        boolean invokedHasNext = false;

        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
            if (pairs != null && pairs.length != 0) {
                invokedHasNext = true;
                return i < elem;
            }

            throw new UnsupportedOperationException();
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         * @throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
            if (hasNext()) {
                return pairs[i++];
            }
            throw new NoSuchElementException();
        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            if (!invokedHasNext) {
                throw new IllegalStateException();
            }
            invokedHasNext = false;
            boolean removed = false;
            for (int j = i; j < elem; j++) {
                pairs[j - 1] = pairs[j];
                removed = true;
            }
            if (isLastPair() || removed) {
                elem--;
            }
        }
        private boolean isLastPair() {
            return i == 0 && elem == 1;
        }
    }
}
