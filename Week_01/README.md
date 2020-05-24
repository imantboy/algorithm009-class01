##学习笔记


### 数组、链表、跳表
   * [Java中的LinkedList是一个双向链表](http://developer.classpath.org/doc/java/util/LinkedList-source.html) 
   * 跳表只能用于元素有序的情况，在热门项目中用来替代平衡树 如Redis、LevelDB
        * [LRU 缓存机制](https://leetcode-cn.com/problems/lru-cache/)
        * [跳跃表](https://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)
        * [为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](https://www.zhihu.com/question/20202931)
   * 维度升级 + 空间换时间
   * 三者的时间服务度、空间复杂度对比

### 栈、队列、优先队列、双端队列

#### Deque 代码改写

```java
class Test {
    public static void main(String[] args){
      
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addLast("b");
        System.out.println(deque); //[a,b]

        deque.addFirst("c");
        System.out.println(deque); //[c,a,b]

        String first = deque.getFirst();
        System.out.println(first); //c
        System.out.println(deque); // [c,a,b]

        while (!deque.isEmpty()) {
            System.out.println(deque.pop());
        }
        System.out.println(deque); //[]
    }
}
```

#### PriorityQueue源代码分析
   


## 本周总结
之前一个人刷leetcode时效率不高，而且挫败感很强，而且无法保证系统性，看了授课视频，学写了五毒神掌，感觉掌握了通关技巧，希望经过10周的学习，对算法有个极大的提升；
    

