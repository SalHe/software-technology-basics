# 《软件技术基础》实验代码库

## 实验内容

### 项目索引页(非实验内容)

地址：http://127.0.0.1:8080/lab-index

![项目索引页](./img/lab-index.gif)

### 第一次实验

实验题目及要求：[软件技术基础第一次实验课.pdf](./docs/软件技术基础第一次实验课.pdf)/[软件技术基础第一次实验课.docx](./docs/软件技术基础第一次实验课.docx)

- 实验1：http://127.0.0.1:8080/exercise1-1
  
  ![实验1效果图](./img/exercise1-1.gif)

- 实验2：http://127.0.0.1:8080/exercise1-2
  
  ![实验2效果图](./img/exercise1-2.gif)

## 如何运行

您可以选择以下两种方式运行本实验代码：

1. **使用IDEA自动部署到Tomcat（😁推荐）**
   
   1. 克隆本仓库：
       ```shell
       git clone https://github.com/SalHe/software-technology-basics.git
       ```
   2. 用IDEA Ultimate打开本仓库(是打开仓库根目录)。
   3. 启动服务。
       
       在目标中选择`TOMCAT 8.5.71`，点击运行。
       
       可能出现因为Tomcat配置不同而无法正常启动项目的情况，解决方案参见：[IDEA中配置Tomcat路径](#IDEA中配置Tomcat路径)
   
   4. 启动后IDEA会自动打开实验项目的索引页，选择想要查看的实验即可。

2. 直接放入Tomcat运行

   将实验相关文件放入到`Tomcat`的`webapps`文件夹中并启动`Tomcat`。然后在浏览器中进入实验代码对应的网址。

## 问题

### IDEA中配置Tomcat路径

1. 因为Tomcat路径的不同，刚克隆完仓库可能会出现无法直接启动项目的情况。当在Tomcat右上角看到一个红叉的图标的时候，说明我们需要手动配置Tomcat路径。按下下拉箭头，点击`Edit Configurations...`：
   
   ![无法正常启动项目](./img/edit_configuration.png)

2. 在弹出的对话框中，可以看到`Tomcat 8.5.71`标红，说明配置不正常，我们点击`Configure`。

   ![进入配置Tomcat](./img/configure_tomcat.png)

3. 为IDEA选择正确的Tomcat路径：
   
   ![配置Tomcat路径](./img/select_tomcat_home.png)
   
   正确选择后可以看到IDEA会为我们正确识别出对应的Tomcat版本。

4. 可以看到项目启动配置错误已经消除，可以正常启动了。

   ![配置OK](./img/configuration_ok.png)