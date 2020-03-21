# AbstractStringBuilder
> 字符序列的抽象实现，是StringBuilder和StringBuffer的父类

- 内部变量
```Java
// 以字节形式存储字符序列
byte[] value;
/**
 * The id of the encoding used to encode the bytes in {@code value}.
 */
// 当前字符序列的编码：LATIN1或UTF16，由此可将ASB分为LATIN1-ASB或UTF16-ASB两类
byte coder;
/**
 * The count is the number of characters used.
 */
// 当前ASB内包含的char的数量
int count;
```

## 增加
- 向AbstractStringBuilder末尾添加一个字符序列，实现Appendable接口.
```Java
@Override
public AbstractStringBuilder append(CharSequence s) {
    if (s == null) {
        return appendNull();
    }
    if (s instanceof String) {
        return this.append((String)s);
    }
    if (s instanceof AbstractStringBuilder) {
        return this.append((AbstractStringBuilder)s);
    }
    return this.append(s, 0, s.length());
}
```

- 向AbstractStringBuilder末尾添加一个子序列，该子序列取自字符序列s的[start, end)范围
```Java
@Override
public AbstractStringBuilder append(CharSequence s, int start, int end) {
    if (s == null) {
        s = "null";
    }
    checkRange(start, end, s.length());
    int len = end - start;
    ensureCapacityInternal(count + len);
    if (s instanceof String) {
        appendChars((String)s, start, end);
    } else {
        appendChars(s, start, end);
    }
    return this;
}
```

- 向AbstractStringBuilder末尾添加一个字符串str
```Java
public AbstractStringBuilder append(String str) {
    if (str == null) {
        return appendNull();
    }
    int len = str.length();
    ensureCapacityInternal(count + len);
    putStringAt(count, str);
    count += len;
    return this;
}
```

- 向ASB末尾添加一个子序列，该子序列取自字符数组s的[offset, offset+len)范围
```Java
public AbstractStringBuilder append(char str[], int offset, int len) {
    int end = offset + len;
    checkRange(offset, end, str.length);
    ensureCapacityInternal(count + len);
    appendChars(str, offset, end);
    return this;
}
```

- 向ASB末尾添加一个boolean值的字符串序列
```Java
public AbstractStringBuilder append(boolean b) {
    ensureCapacityInternal(count + (b ? 4 : 5));
    int count = this.count;
    byte[] val = this.value;
    if (isLatin1()) {
        if (b) {
            val[count++] = 't';
            val[count++] = 'r';
            val[count++] = 'u';
            val[count++] = 'e';
        } else {
            val[count++] = 'f';
            val[count++] = 'a';
            val[count++] = 'l';
            val[count++] = 's';
            val[count++] = 'e';
        }
    } else {
        if (b) {
            count = StringUTF16.putCharsAt(val, count, 't', 'r', 'u', 'e');
        } else {
            count = StringUTF16.putCharsAt(val, count, 'f', 'a', 'l', 's', 'e');
        }
    }
    this.count = count;
    return this;
}
```

- 向ASB末尾添加一个子序列，该子序列取自字符数组s的[off, end)范围
```Java
private final void appendChars(char[] s, int off, int end) {
    int count = this.count;
    if (isLatin1()) {
        byte[] val = this.value;
        for (int i = off, j = count; i < end; i++) {
            char c = s[i];
            if (StringLatin1.canEncode(c)) {
                val[j++] = (byte)c;
            } else {
                this.count = count = j;
                inflate();
                StringUTF16.putCharsSB(this.value, j, s, i, end);
                this.count = count + end - i;
                return;
            }
        }
    } else {
        StringUTF16.putCharsSB(this.value, count, s, off, end);
    }
    this.count = count + end - off;
}

private final void appendChars(String s, int off, int end) {
    if (isLatin1()) {
        if (s.isLatin1()) {
            System.arraycopy(s.value(), off, this.value, this.count, end - off);
        } else {
            // We might need to inflate, but do it as late as possible since
            // the range of characters we're copying might all be latin1
            byte[] val = this.value;
            for (int i = off, j = count; i < end; i++) {
                char c = s.charAt(i);
                if (StringLatin1.canEncode(c)) {
                    val[j++] = (byte) c;
                } else {
                    count = j;
                    inflate();
                    System.arraycopy(s.value(), i << UTF16, this.value, j << UTF16, (end - i) << UTF16);
                    count += end - i;
                    return;
                }
            }
        }
    } else if (s.isLatin1()) {
        StringUTF16.putCharsSB(this.value, this.count, s, off, end);
    } else { // both UTF16
        System.arraycopy(s.value(), off << UTF16, this.value, this.count << UTF16, (end - off) << UTF16);
    }
    count += end - off;
}

private final void appendChars(CharSequence s, int off, int end) {
    if (isLatin1()) {
        byte[] val = this.value;
        for (int i = off, j = count; i < end; i++) {
            char c = s.charAt(i);
            if (StringLatin1.canEncode(c)) {
                val[j++] = (byte)c;
            } else {
                count = j;
                inflate();
                StringUTF16.putCharsSB(this.value, j, s, i, end);
                count += end - i;
                return;
            }
        }
    } else {
        StringUTF16.putCharsSB(this.value, count, s, off, end);
    }
    count += end - off;
}
```

## 删除
- 删除[start, end)范围内的char
```Java
public AbstractStringBuilder delete(int start, int end) {
    int count = this.count;
    if (end > count) {
        end = count;
    }
    checkRangeSIOOBE(start, end, count);
    int len = end - start;
    if (len > 0) {
        shift(end, -len);
        this.count = count - len;
    }
    return this;
}
```

- 删除索引为index的char
```Java
public AbstractStringBuilder delete(int start, int end) {
    int count = this.count;
    if (end > count) {
        end = count;
    }
    checkRangeSIOOBE(start, end, count);
    int len = end - start;
    if (len > 0) {
        shift(end, -len);
        this.count = count - len;
    }
    return this;
}
```

- 删除[start, end)范围内的char
```Java
public AbstractStringBuilder deleteCharAt(int index) {
    checkIndex(index, count);
    shift(index + 1, -1);
    count--;
    return this;
}
```


