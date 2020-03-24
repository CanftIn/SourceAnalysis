# Iterator
---
*interface* **Iterator**

 * 外部迭代器，支持对容器中的元素进行遍历和移除，还支持流式遍历
 * 外部迭代器的特点是：可拔插
 * 其迭代行为可以挂载到待比较对象的外部
 * 此外，外部迭代器往往用来支撑内部迭代器的实现。
 * 注1：区别于内部迭代器Iterable
 * 注2：区别于枚举器Enumeration
 * 注3：区别于流迭代器Spliterator
 
 - 是否存在下一个未遍历元素
```Java
boolean hasNext();
```
- 返回下一个元素
```Java
    E next();
```
- 移除上一个遍历的元素
```Java
default void remove() {
    throw new UnsupportedOperationException("remove");
}
```
- 流式遍历。遍历每个元素，并对其执行相应的择取操作
```Java
default void forEachRemaining(Consumer<? super E> action) {
    Objects.requireNonNull(action);
    while(hasNext()) {
        action.accept(next());
    }
}
```