# Union-Find 알고리즘
### Union-Find 알고리즘이란?
   그래프 알고리즘의 일종으로, 여러 노드가 존재할 때 노드들을 같은 집합으로 묶어주고, 같은 집합에 있는지 확인도 하는 알고리즘이다.

### 구현
1 ) 같은 집합인지 확인하는 find() 메소드
~~~java
public static int find(int v){
    if(v==unf[v]) return v;
    else return unf[v]=Find(unf[v]);
}
~~~

2 ) 서로 다른 집합에 있다면 이를 같은 집합으로 표현하는 union() 메소드
~~~java
public static void union(int a, int b){
    int fa=Find(a);
    int fb=Find(b);
    if(fa!=fb) unf[fa]=fb;
}
~~~

### 관련 문제
[인프런 9-6](/src/union_find/inflearn/Ch9_6.java)