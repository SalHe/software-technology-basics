# Exercise4 — Alive-basic

## 源码说明及其改动

- [Catfish.java](./src/Catfish.java):
  定义了小鱼所对应的类，包含了其所在行及列的属性（可被外部获取以知晓）、剩余的能量（当能量不足时，小鱼不能移动）、生命状态、年龄以及小鱼移动的方法等。主要在改代码中实现了小鱼行及列的获取、小鱼的活动（当无能量时小鱼死亡，并尝试让小鱼移动）、小鱼的移动（可随机朝四个方向之一移动一格）。
- Html*.java: 用于表示HTML文档节点的类，并能够生成对应节点的HTML代码以渲染HTML页面。
- [Simulation.java](./src/Simulation.java): 是一个用于模拟鱼池和模拟鱼在池内移动的类。
- [SimulationServlet.java](./src/SimulationServlet.java): 用于处理来自网页请求的`Servlet`，其负责创建鱼池、维护鱼池的状态、鱼池页面的自动刷新的控制。
- [SimulationView.java](./src/SimulationView.java): 一个负责将`Simulation`内的鱼池和小鱼借助Html节点类生成展示用的HTML代码的工具类，供`Servlet`使用。
- [MySimulation.java](./src/MySimulation.java): 一个能将提交过来的鱼池初始态复现，让用户进一步修改鱼池初始态并进入模拟的`Servlet`，是一个确认页面。


- [initialWorldFish.html](./web/initialWorldFish.html): 负责与`SimulationServlet`打交道完成鱼池的创建。写代码为`form`指定`action`和`method`。
- [MySimulation.html](./web/MySimulation.html): 负责与`MySimulation`(一个Servlet)打交道完成鱼池状态的填写并进一步确认，最后再进行模拟。写代码为`form`
  指定`action`和`method`。
- [initialWorldFish.html](./web/initialWorldFish.html)与[MySimulation.html](./web/MySimulation.html)的不同:
  两者都提供了一个选择小鱼出生点的表格，但是initialWorldFish.html是直接将出生点提交并立即开始模拟小鱼的生存；但是MySimulation.html会展示出一样出生点安排的表，然后再点击按钮才开始模拟小鱼生存，是一个实现给用户确认小鱼出生点的功能的页面。