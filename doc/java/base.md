# Java基础
## 基本数据类型
1. 整数型：byte(1),short(2),int(4),long(8)
2. 浮点型：float(4),double(8)
3. 字符型：char(1)
4. 布尔型：boolean(1)

## Java异常
### Throwable类
#### Exception:程序本身可以处理的异常
##### Checked Exception:受检异常 编译时异常（@Transactional 默认不回滚）
1. FileNotFound
2. ClassNotFound
##### Unchecked Exception：非受检异常 运行时异常
1. NullPoint
2. IndexOutOfBounds
#### Error：程序无法处理的错误
1. OOM
2. SOF

## String类
### 不可变性
1. 保存字符串的数组被final修饰（不可覆盖），private修饰（不可直接修改），且对外没有暴露修改字符串的方法。
2. String类被final修饰（不可被继承），避免子类破坏其不可变性。


## 面向对象
### 封装：把对象的属性隐藏在对象内部，不允许外部对象直接访问对象的内部信息，对外提供一些可以被外界访问的方法来操作属性
1. 实现：private(本类内)，缺省(本包内)，protected(其他包的子类)，public(其他包的非子类)
2. 高内聚：内部数据操作由自己完成，不允许外部干涉
3. 低耦合：对外提供少量方法给外部使用，方便外部调用

### 继承：使用已存在的类作为基础建立新类
1. 减少代码冗余，提高代码复用
2. 建立类间联系，提升可读性，有利于功能拓展

### 多态：表示一个对象具有多种状态，具体表现为父类的引用指向子类的对象
#### 使用前提
1. 类的继承关系
2. 方法重写

