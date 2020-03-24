# AbstractList
> 线性表的抽象实现

- 将元素e追加到当前线性表中
```Java
public boolean add(E e) {
    add(size(), e);
    return true;
}
```

- 将元素element添加到线性表index处(unsupported)
```Java
public void add(int index, E element) {
    throw new UnsupportedOperationException();
}
```

- 将指定容器中的元素添加到当前线性表的index处
```Java
public boolean addAll(int index, Collection<? extends E> c) {
    rangeCheckForAdd(index);
    boolean modified = false;
    for (E e : c) {
        add(index++, e);
        modified = true;
    }
    return modified;
}
```

- 获取指定索引处的元素
```Java
public abstract E get(int index);
```

- 移除索引index处的元素，返回被移除的元素
```Java
public E remove(int index) {
    throw new UnsupportedOperationException();
}
```

- 移除当前线性表[fromIndex,toIndex]之间的元素
```Java
protected void removeRange(int fromIndex, int toIndex) {
    ListIterator<E> it = listIterator(fromIndex);
    for (int i=0, n=toIndex-fromIndex; i<n; i++) {
        it.next();
        it.remove();
    }
}
```

- 清空当前线性表中的元素
```Java
public void clear() {
    removeRange(0, size());
}
```

- 将index处的元素更新为element，并返回旧元素
```Java
public E set(int index, E element) {
    throw new UnsupportedOperationException();
}
```

- 返回[fromIndex, toIndex)之间的元素的视图
```Java
public List<E> subList(int fromIndex, int toIndex) {
    subListRangeCheck(fromIndex, toIndex, size());
    return (this instanceof RandomAccess ?
            new RandomAccessSubList<>(this, fromIndex, toIndex) :
            new SubList<>(this, fromIndex, toIndex));
}
```
