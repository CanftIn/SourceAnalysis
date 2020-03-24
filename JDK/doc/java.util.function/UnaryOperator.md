# UnaryOperator


 * 函数式接口：UnaryOperator<T>
 * 一元操作，继承了Function<T, T>
 * 参数：T
 * 返回：T
 
 
- 标识转换（即自身到自身的转换）
```Java
static <T> java.util.function.UnaryOperator<T> identity() {
    return t -> t;
}
```