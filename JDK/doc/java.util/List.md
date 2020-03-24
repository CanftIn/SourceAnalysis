# List
---
*interface* **List**

> 线性表接口，其实现可以是顺序存储结构，也可以是链式存储结构

- 将元素e追加到当前线性表中
```Java
boolean add(E e);
```

- 将元素element添加到线性表index处
```Java
void add(int index, E element);
```

- 将指定容器中的元素追加到当前线性表中
```Java
boolean addAll(Collection<? extends E> c);
```

- 更新当前线性表中所有元素，更新策略由operator决定
```Java
default void replaceAll(UnaryOperator<E> operator) {
    Objects.requireNonNull(operator);
    final ListIterator<E> li = this.listIterator();
    while (li.hasNext()) {
        li.set(operator.apply(li.next()));
    }
}
```

- 返回指定元素的正序索引(正序查找首个匹配的元素)
```Java
int indexOf(Object o);
```

- 返回指定元素的逆序索引(逆序查找首个匹配的元素)
```Java
int lastIndexOf(Object o);
```

- 返回[fromIndex, toIndex)之间的元素的视图
```Java
List<E> subList(int fromIndex, int toIndex);
```

- 返回当前线性表的一个增强的迭代器，且设定下一个待遍历元素为索引index处的元素
```Java
ListIterator<E> listIterator();
```

- 使用指定的比较器对当前线性表内的元素进行排序
```Java
default void sort(Comparator<? super E> c) {
    Object[] a = this.toArray();
    Arrays.sort(a, (Comparator) c);
    ListIterator<E> i = this.listIterator();
    for (Object e : a) {
        i.next();
        i.set((E) e);
    }
}
```

