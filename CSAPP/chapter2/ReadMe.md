# Charpter2 Note

**1.字(word)的表示和存储**

    小端法机器永远是最低有效位先输出，例：```0x00003039```，先输出 ```0x39```。

程序：
1. 十六进制输出int、float、pointer：[show_bytes](./show_bytes.c)