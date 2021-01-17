学习笔记

递归：
本质就是函数体循环；
递归模板代码：
牢记

public void recur(int level, int param){
	//terminator
	if(level > MAX_LEVEL){
		//process result
		return;
	}
	
	//process current logic
	process(level, param);
	
	//drill down
	recur(leve+1,newParam);
	
	//restore current status
}

1.不要人肉进行递归
2.找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3.数学归纳法思维

回溯：