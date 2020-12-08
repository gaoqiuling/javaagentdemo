# javaagentdemo
参考文档:https://www.cnblogs.com/rickiyang/p/11368932.html
步骤：
1.生成agent.jar
在manifest.mf所在目录执行命令： jar cfm agent.jar MANIFEST.MF

2.测试类启动时候加上这个vm option: -javaagent:C:\Users\gaoqiuling\Desktop\demo\agent.jar

