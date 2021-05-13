# RouterDemo
动手写一个路由，巩固：APT、Trasform+ASM 的使用.


## 分支介绍
- main: 使用DexFile遍历所有已加载类，下沉路由注册方法， 即拿到特定路径的类， 进行反射实例及注册方法调用, 此方法涉及类遍历，当类过多时，会出现性能问题。故需要 APT+Transform