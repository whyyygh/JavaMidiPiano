# Java Midi Piano
[](https://github.com/whyyygh/JavaMidiPiano/blob/master/ScreenShot/v1.png)
大学时用 java 写的 midi 模拟钢琴键盘,致敬大学时代.
* This project since 2004.
* 2004年,那时最棒的 java 开发软件还是 JBuilder x.x
* 2004年,那时 jdk 的版本还是 V1.2
* 2004年,那时总想钢琴的脚踏板怎么用键盘模拟
* 2004年,那时有个牛X的 midi 电脑钢琴叫 VOS,EOP(EveryOne Piano)还没有上线
* 2004年,那时还没有 midi '迷笛' 音乐节
## 安装 / install
* 1.随便一个版本大于 V1.2 的 jdk
* 2.文件夹 com 是当时用 JBuilder 时处理 GUI 的包,运行时记得要引用
* 3.在 windows 运行需要安装合适的声卡驱动
* 4.可直接下载运行 [release](https://github.com/whyyygh/JavaMidiPiano/releases)
## 运行 / run
    java JavaMusicianSimulator
## 说明 / man
* up/down/left/right 上下左右控制 midi 的排号和乐器号
* ` 键左上角,BackSpace 键右上角,控制当前键盘区域位置
* 23456789 wertyuio sdfghjkl xcvbnm,. 对应表示音符 12344567,适应食指 F J 位置,中间4的位置左右手都可按
* Esc 表示退出 
## 版本打包 / Version Release
* V1.0版就先把class文件打包放在一起吧,容易运行.

## 未来版本计划做的改进
* 重构GUI,使用比较常见的界面框架
* 推出几种按键布局方法
* 连接midi硬件电钢琴