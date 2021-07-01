package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

//КЭШ ПРОГРАММА - УДАЛЯЕТ НЕИСПОЛЬЗУЕМЫЕ ДАННЫЕ, НА ЭТОМ ПРИМЕРЕ ОСТАВЛЯЕТ ТОЛЬКО ПОСЛЕДНИЕ ДОБАВЛЕННЫЕ 2 ЭЛЕМЕНТА
public class Cacsh<K, V> extends LinkedHashMap<K, V> {//НАСЛЕДОВАНИЕ ОТ LinkedHashMap
    private final int capacity;//РАЗМЕР КЭША, ЕСЛИ БОЛЬШЕ ЭТОГО, ТО СТАРЫЕ ДАННЫЕ БУДУТ УДАЛЕНЫ

    public Cacsh(int capacity) {
        super(capacity + 1, 2, true);//СОЗДАЕМ  LinkedHashMap С ТАКИМИ ДАННЫМИ: РАЗМЕР 2 ЭЛЕМЕНТА, loadFactor - коэффициент загрузки, accessOrder - режим заказа - true для порядка доступа, false для порядка размещения
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {//БЕЗ ПЕРЕОПРЕДЕЛЕНИЯ ЭТОГО МЕТОДА НЕ РАБОТАЕТ
    return this.size() > capacity;
    }

    public static void main(String[] args) {
        Cacsh c = new Cacsh(2);
        c.put(1, 5);
        c.put(2, 9);
        c.put(3, 99);
        c.put(9, 100);
        System.out.println(c);





    }
}
