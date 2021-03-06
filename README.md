# Lab6

> 本节目标：
>
> 1. 熟悉 Java 中方法（method）的编写，了解方法重载（method overriding）
> 2. 熟悉数组的基本操作（求数组长度、数组单个元素的取值、数组求和）

## Lab 要求

1. 请先从 GitHub 下载作业，然后使用 IntelliJ 打开 Lab6_Solution 工程。
2. 在本次 lab 中，需要你在 `Lab6` 这个类中完成 `compare` 方法的编写。
3. 运行 `TestLab6` ，你将得到正误的评判。给 TA 当面检查后，请上传至 FTP 本次 lab 的文件夹下。
4. 代码请上传到FTP的/classes/16/161 程序设计A （戴开宇）/WORK_UPLOAD/lab6 路径下，Lab5的Code Review文档请上传到FTP的/classes/16/161 程序设计A （戴开宇）/WORK_UPLOAD/Code Review/lab5路径。

## Problem 0: 回顾与思考

在上个 lab 中，大多数同学的代码都写的非常长，远远超过了必要的行数。代码多本身不是什么坏事，但往往反映了在解决问题时没有选择最优的方法，或是在具体的实现逻辑上出现了问题。不少同学在完成基础功能后，做附加功能时要修改之前的代码就无从下手了。因此，希望同学们在完成每个 lab 后养成回顾的习惯，思考自己的代码还有哪些可以优化的地方。TA 在每个 lab 结束后也会提供一份最佳实践供大家阅读和思考。

请大家先查看[Lab5 典型代码](https://github.com/java-a/lab5/issues/2)，提出你的修改建议，并和今天的代码一起上传。

在开始今天的内容前，花 10 - 15 分钟阅读 [Lab 5 最佳实践与思考题](https://github.com/java-a/lab5/issues/1) 。

## Problem 1: “数”的比较 

对于两个整数类型的值，我们可以很容易地进行比较（逻辑运算符 `>`、`<`）。但有的时候，我们需要比较一些较大的整数（比如二十位的正整数），而 `int` 类型的取值范围是 `-2147483648` 到 `2147483647`，也许并不够用。我们可以用字符串或者字符数组来表示这些大整数！

假设我们有如下三个字符数组：

```java
char[] a = {'1', '2', '3', '4', '5', '6'};
char[] b = {'1', '2', '2', '4', '5', '6'};
char[] c = {'6', '6', '6'};
char[] d = {'0', '7', '6', '6'};
```

分别代表正整数 `123456`、`122456` 以及 `666`。

我们需要完成完成第一个 `compare` 方法，比较任意两个字符数组所代表的正整数。以上面三个数组为例，我们希望有这样的结果：

```java
compare(a, b) == 1
compare(b, c) == 1
compare(c, a) == -1
compare(c, d) == -1
```

提示：

1. 比较两个字符数组的长度。对于任意数组 `a`，可以用 `a.length` 得到该数组的长度。显然数组长度更长的，其所代表的整数值越大。
2. 对于两个长度一样的整数，从最高位（即数组的首位）开始比较。
3. 参考注释中的提示。

## Problem 2: 客房容量的比较

我们可以用二维数组来表示一间酒店每个房间的可入住人数（默认每一层楼的房间数是相同的）。如：

```java
int[][] aa = {{3, 2, 3}, {2, 2, 2}, {1, 2, 2}};
int[][] ba = {{1, 2, 3, 3}, {2, 2, 2, 2}};
```

数组 `aa` 表示该酒店总共有 3 层楼，其中第一层有 3 间客房，分别可以入住 3 人、2 人、3 人；第二层3间客房都可入住 2 人；第 3 层的三间客房分别可以入住 1 人、2 人、2 人。同理，酒店 `bb` 我们认为有 2 层楼，第一层的客房分别可入住 1 人、2 人、3 人以及 3 人；第二层的客房都是可以入住 2 人。

这样，酒店 aa 总共可以入住 `3 + 2 + 3 + 2 + 2 + 2 + 1 + 2 + 2 = 19` 人，酒店 bb 总共可以入住 `1 + 2 + 3 + 3 + 2 + 2 + 2 + 2 = 17` 人，所以酒店 aa 的容量比酒店 bb 的容量大。所以，我们有：

```java
compare(aa, bb) == 1
```

提示：

1. Problem 2 的 `compare` 方法和 Problem 1 中编写的方法同名，但是彼此的参数列表不同，因而出现了方法重载的现象。Java 可以根据参数的不同找到对应的正确方法。
2. 二维数组的求和可以用 2 层 `for` 循环实现。想象用矩阵来表示一个二维数组，则 `a[i][j]` 可以用来表示第 `i` 行第 `j` 列的元素。
3. 参考注释中的提示。
