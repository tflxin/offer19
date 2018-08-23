package com.offer66;

/**
 *  解这题需要把题意仔细研究清楚，反正我试了好多次才明白的。
 *     首先，考虑特殊情况：
 *          1>两个字符串都为空，返回true
 *          2>当第一个字符串不空，而第二个字符串空了，返回false（因为这样，就无法
 *             匹配成功了,而如果第一个字符串空了，第二个字符串非空，还是可能匹配成
 *             功的，比如第二个字符串是“a*a*a*a*”,由于‘*’之前的元素可以出现0次，
 *             所以有可能匹配成功）
 *     之后就开始匹配第一个字符，这里有两种可能：匹配成功或匹配失败。但考虑到pattern
 *     下一个字符可能是‘*’， 这里我们分两种情况讨论：pattern下一个字符为‘*’或
 *     不为‘*’：
 *           1>pattern下一个字符不为‘*’：这种情况比较简单，直接匹配当前字符。如果
 *             匹配成功，继续匹配下一个；如果匹配失败，直接返回false。注意这里的
 *             “匹配成功”，除了两个字符相同的情况外，还有一种情况，就是pattern的
 *             当前字符为‘.’,同时str的当前字符不为‘\0’。
 *           2>pattern下一个字符为‘*’时，稍微复杂一些，因为‘*’可以代表0个或多个。
 *             这里把这些情况都考虑到：
 *                a>当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，
 *                 跳过这个‘*’符号；
 *                b>当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符
 *                 不变。（这里匹配1个或多个可以看成一种情况，因为：当匹配一个时，
 *                 由于str移到了下一个字符，而pattern字符不变，就回到了上边的情况a；
 *                 当匹配多于一个字符时，相当于从str的下一个字符继续开始匹配）
 *     之后再写代码就很简单了。
 *//**
 情况非常复杂，利用递归思路，可以大大简化问题。其实，递归就是一步一步解决问题。
 当拿到一个字符串str和模式串pattern，如果下一个为*，则有三种情况，匹配0个，匹配一个，匹配两个及两个以上。
 如果下一个不为*，则直接匹配一个。
 分析：递归实现
 每次分别在str 和pattern中取一个字符进行匹配，如果匹配，则匹配下一个字符，否则，返回不匹配。
 设匹配递归函数 match(str, pattern)。
 如果模式匹配字符的下一个字符是‘*’:
 •如果pttern当前字符和str的当前字符匹配，：有以下可能情况
 （1）pttern当前字符能匹配 str 中的 0 个字符：match(str, pattern+2)
 （2）pttern当前字符能匹配 str 中的 当前 字符：match(str+1, pattern)
 •如果pttern当前字符和和str的当前字符不匹配
 pttern当前字符能匹配 str 中的 0 个字符：(str, pattern+2)
 如果模式匹配字符的下一个字符不是‘*’，进行逐字符匹配。
 对于 ‘.’ 的情况比较简单，’.’ 和一个字符匹配 match(str+1, pattern+1)
 另外需要注意的是：空字符串”” 和 “.*” 是匹配的
 */
public class match {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str == null && pattern != null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return macthHelper(str, strIndex, pattern, patternIndex);
    }

    private boolean macthHelper(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //均匹配到最后一个则成功了
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        //pattern已经匹配完了，但是第一个还没有，所以，失败了
        if (str.length != strIndex && pattern.length == patternIndex) {
            return false;
        }
        //检查pattern的下一个字符是否是*
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //当前字符匹配的情况
            if (str.length != strIndex && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                return macthHelper(str, strIndex, pattern, patternIndex + 2) || macthHelper(str, strIndex + 1, pattern, patternIndex + 2) || macthHelper(str, strIndex + 1, pattern, patternIndex);
            } else { // 当前字符不匹配,直接判断pattern的*后面的字符能够匹配吗（长度不用定相等的）
                return macthHelper(str, strIndex, pattern, patternIndex + 2);
            }
        }
            //如果下一位不是*，比较当前
            //如果当前匹配
            if (str.length != strIndex && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
                return macthHelper(str, strIndex + 1, pattern, patternIndex + 1);
            }
            //如果当前位置不匹配，完蛋了
            return false;

        }

    }


