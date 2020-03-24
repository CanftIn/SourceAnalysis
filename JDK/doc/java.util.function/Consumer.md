 # Consumer
 
 * 函数式接口：Consumer<T>
 * 参数：T
 * 返回：void
 * 示例：打印字符串
 * Consumer<String> f = s->System.out.println(s);
 
 **API:**
 
 ```Java
void accept(T t);
// f1.andThen(f2)：先执行f1，再执行f2
default java.util.function.Consumer<T> andThen(java.util.function.Consumer<? super T> after) {
    Objects.requireNonNull(after);
    return (T t) -> {
        accept(t);
        after.accept(t);
    };
} 
```