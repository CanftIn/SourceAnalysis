# BinaryOperator
 * 函数式接口：BinaryOperator<T>
 * 二元操作，继承了BiFunction<T, T, T>
 * 参数：T, T
 * 返回：T
 
 
 
 * 求最小值
 * Comparator<Integer> cmp = (a, b) -> a - b;
 * BinaryOperator<Integer> f = BinaryOperator.minBy(cmp);
 * System.out.println(f.apply(3, 5));

 * 求最大值
 * Comparator<Integer> cmp = (a, b) -> a - b;
 * BinaryOperator<Integer> f = BinaryOperator.maxBy(cmp);
 * System.out.println(f.apply(3, 5));
