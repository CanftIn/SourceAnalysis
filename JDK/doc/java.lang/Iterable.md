# Iterable
---
*interface* **Iterable**

 * 内部迭代器，常用作容器类的接口，以支持遍历操作（同时支持流式遍历）
 * 内部迭代器的特点是嵌入式
 * 其迭代行为必须在容器对象内部实现（借助了外部比较器）
 * 一个类如果实现了Iterable接口，就意味着“该类本身支持遍历”，并可以通过for-each这种循环语法来直接遍历
 * 当然，一个类如果没有实现Iterable接口，也可以通过挂载外部迭代器Iterator进行遍历
 * 注1：区别于外部迭代器Iterator
 * 注2：区别于枚举器Enumeration
 * 注3：区别于流迭代器Spliterator


- 借助外部迭代器实现遍历
```Java
Iterator<T> iterator();
```

- 流式遍历。遍历每个元素，并对其执行相应的择取操作
```Java
default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }
}
```

- 将普通迭代器转换为可分割迭代器，用于流式操作
```Java
default Spliterator<T> spliterator() {
    return Spliterators.spliteratorUnknownSize(iterator(), 0);
}
```















