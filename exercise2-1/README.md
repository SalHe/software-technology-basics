# Exercise3 - Catfish

## 源码说明及其改动

- [Catfish.java](./src/Catfish.java):
  定义了小鱼所对应的类，包含了其所在列的属性（可被外部获取以知晓）、剩余的能量（当能量不足时，小鱼不能移动），以及小鱼移动的方法。主要在改代码中实现了小鱼列的获取、小鱼的移动、根据小鱼状态给定对应的小鱼图片。
- Html*.java: 用于表示HTML文档节点的类，并能够生成对应节点的HTML代码以渲染HTML页面。
- [Simulation.java](./src/Simulation.java): 是一个用于模拟鱼池和模拟鱼在池内移动的类。
- [SimulationServlet.java](./src/SimulationServlet.java): 用于处理来自网页请求的`Servlet`，其负责创建鱼池、维护鱼池的状态、小鱼的移动。
- [SimulationView.java](./src/SimulationView.java): 一个负责将`Simulation`内的鱼池和小鱼借助Html节点类生成展示用的HTML代码的工具类，供`Servlet`使用。

- [index.html](./web/index.html): 负责与`SimulationServlet`打交道完成鱼池的创建。为`form`指定`action`和`method`。