学习笔记
数组、链表、跳表
特性：
1.内存上一段连续的地址空间；
2.可以通过下标访问元素，时间复杂度为O(1);
问题所在：
1.增加和删除数组元素时会伴随元素前后移动；
2.往数组中间插入元素，需要将该位置后面的元素后移；
3.删除元素时，也会将删除位置之后的元素前移；
所以，数组插入删除元素的时间复杂度是O(n)；

学习Java类库中ArrayList实现；主要看add，remove；
public boolean add(E e) {
	//判断长度，是否需要扩容
	ensureCapacityInternal(size + 1);  // Increments modCount!!
	//将元素保存到数组末尾
	elementData[size++] = e;
	return true;
}
//指定位置插入元素
public void add(int index, E element) {
	//判断index合法性
	rangeCheckForAdd(index);
	ensureCapacityInternal(size + 1);  // Increments modCount!!
	//index及之后的元素后移
	//将elementData中的元素，从index开始，复制到elementData中的index+1的位置，复制size-index个
	System.arraycopy(elementData, index, elementData, index + 1,
					 size - index);
	//将element保存到index位置上
	elementData[index] = element;
	size++;
}

数组操作时间复杂度：
prepend		O(1)	正常情况下数组的prepend操作的时间复杂度是O(n)，但是可以进行特殊化到O(1)。采用的方式是申请稍大一些的内存空间，然后在数组最开始预留一部分空间，然后prepend的操作则是把头下标前移一个位置即可；
append		O(1)
lookup		O(1)
insert		O(n)
delete		O(n)


综上可知：
如果对ArrayList进行大量的修改，会涉及到大量的array copy操作；

链表：
弥补数组中频繁增删元素时带来的array copy；
链表能带来O(1)复杂度的增删操作；
特性：
next指针指向下一个元素；单向链表；
prev指针指向前一个元素，形成双向链表；
插入和删除元素，只需要修改next指针即可，时间复杂度是O(1);

问题所在：
访问元素需要遍历链表；O(n)的时间复杂度；

链表操作时间复杂度：
prepend		O(1)
append		O(1)
lookup		O(n)
insert		O(1)
delete		O(1)

根据实际的应用场景选择数组还是链表；


跳表：
主要解决有序链表在访问时时间复杂度为O(n)的一种优化；
进行升纬；
跳表中的元素必须是有序的；

跳表是一种插入、删除、搜索都是O(logn)时间复杂度的数据结构；
主要用于对标平衡树、二分查找；
跳表是一种空间换时间的数据结构；通过多级索引来达到加速的目的；

一维的数据结构可以通过升纬来加速；

问题所在：
随着增加和删除，会导致它的索引不工整；
空间复杂度是O(n)

LRU: https://leetcode-cn.com/problems/lru-cache/
为啥 redis 使用跳表(skiplist)而不是使用 red-black？
https://www.zhihu.com/question/20202931




栈和队列的实现与特性

Stack：先入后出；添加、删除皆为O(1);
Queue：先入先出；添加、删除皆为O(1);

因为元素是无序的，所以查询的时间复杂度是O(n)；

Deque：双端队列；可以两端插入和删除；

掌握重点：
Java中Stack、Queue、Deque
掌握查询文档技巧，掌握三者常用API；

掌握PriorityQueue；
1.插入操作：O(1);
2.取出操作：O(logN)-按照元素的优先级取出
按照优先级取出；
3.底层具体实现的数据结构较为多样和复杂：heap、bst；
BST：二叉搜索树；

分析Queue和PriorityQueue源码；




















































