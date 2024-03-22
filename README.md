### 1.代码结构：
1.1 src/main/kotlin/api/service.kt 文件为 ProductService 和 InventoryService 定义获取商品列表和商品库存列表的接口

1.2 src/main/kotlin/dataModel/model.kt 文件为 Product 和 Inventory 定义商品和库存的数据结构

1.3 src/main/kotlin/Main.kt 文件为主程序，主要包含获取商品列表和库存列表以及计算逻辑，执行后能在控制台展示商品列表

1.4 src/test/kotlin/unitTest/ServiceTest.kt  文件为单元测试， 模拟了两个接口的调用是否符合预期

### 2.执行代码：

在IDEA中点击运行Main.kt或者在命令行输入 ./gradlew run

### 3.执行测试：

在IDEA中点击运行ServiceTest.kt或者在命令行输入 ./gradlew test