# Collection
---
*interface* **Iterable**
> 一元容器的顶级接口，其实现类包括线性表（比如List、Queue、Stack）和集合（Set）

- 向当前容器中添加元素
```Java
    boolean add(E e);
```

- 移除指定的元素，返回值指示是否移除成功
```Java
    boolean remove(Object o);
```
- 移除满足条件的元素，移除条件由filter决定，返回值指示是否移除成功
```Java
default boolean removeIf(Predicate<? super E> filter) {
    Objects.requireNonNull(filter);
    boolean removed = false;
    final Iterator<E> each = iterator();
    while(each.hasNext()) {
        if(filter.test(each.next())) {
            each.remove();
            removed = true;
        }
    }
    return removed;
}
```
- (匹配则移除)移除当前容器中所有与给定容器中的元素匹配的元素
```Java
boolean removeAll(Collection<?> c);
```
    
- (不匹配则移除)移除当前容器中所有与给定容器中的元素不匹配的元素
```Java
boolean retainAll(Collection<?> c);
```
    
- 清空当前容器中所有元素
```Java
void clear();
```
- 判断当前容器中是否包含元素o
```Java
boolean contains(Object o);
```
- 判读指定容器中的元素是否都包含在当前容器中
```Java
boolean containsAll(Collection<?> c);
```
- 以数组形式返回当前容器中的元素
```Java
Object[] toArray();
```
- 将当前容器中的元素存入数组a后返回，需要将容器中的元素转换为T类型
```Java
<T> T[] toArray(T[] a);
```
- 返回一个包含了当前容器中所有元素的数组
```Java
default <T> T[] toArray(IntFunction<T[]> generator) {
    return toArray(generator.apply(0));
}
```
- 返回当前容器的迭代器
```Java
Iterator<E> iterator();
```
- 返回描述此容器中元素的Spliterator
```Java
@Override
default Spliterator<E> spliterator() {
    return Spliterators.spliterator(this, 0);
}
```
- 获取当前容器的顺序数据流
```Java
default Stream<E> stream() {
    return StreamSupport.stream(spliterator(), false);
}
```
- 获取当前容器的并行数据流
```Java
default Stream<E> parallelStream() {
    return StreamSupport.stream(spliterator(), true);
}
```
- 返回当前容器的元素数量
```Java
int size();
```
- 判断当前容器是否为空
```Java
boolean isEmpty();
```
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
