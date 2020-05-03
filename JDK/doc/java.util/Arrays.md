# Arrays

## 常量&变量
```Java
//小于等于这个值时，就使用插入排序。将被废弃
private static final int INSERTIONSORT_THRESHOLD = 7;

/*
并行排序的最小数组长度，数组长度小于这个数则不在划分数组
数组长度较小会导致排序的任务竞争内存导致效率降低
*/
private static final int MIN_ARRAY_SORT_GRAN = 1 << 13;
```

## rangeCheck
```Java
//私有方法，检查是否越界
private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
    if (fromIndex > toIndex) {
        throw new IllegalArgumentException(
                "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
    }
    if (fromIndex < 0) {
        throw new ArrayIndexOutOfBoundsException(fromIndex);
    }
    if (toIndex > arrayLength) {
        throw new ArrayIndexOutOfBoundsException(toIndex);
    }
}
```

## sort
```Java

```








































