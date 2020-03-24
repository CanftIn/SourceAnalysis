# Function

 * 函数式接口：Function<T, R>
 * 参数：T
 * 返回：R
 * 示例：将字符串s转换为整数
 * Function<String, Integer> f = s->Integer.parseInt(s);
 
 f1.compose(f2)：先执行f2，再执行f1
 f1.andThen(f2)：先执行f1，再执行f2
 
