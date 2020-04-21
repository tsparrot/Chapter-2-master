# Chapter2
Android基础UI开发

* app:课堂代码
* homework:课后作业
* homework-debug.apk 是课后作业的示例，可以使用
adb install -t homework-debug.apk 进行安装

## UI的标注资源 请参考这里：

https://app.zeplin.io/project/5c402caf0c6b0938570c4953/screen/5c402eaf5838d5bff1178c68

* 账号：397717749@qq.com
* 密码：123456
## 实验效果

### Exercise 1

利用比Activity生命周期更长的static变量存储界面数据以解决。

[作业安装包](https://github-production-release-asset-2e65be.s3.amazonaws.com/256977494/a9359d80-8271-11ea-9fbf-b018c3ec833b?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20200419%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200419T111424Z&X-Amz-Expires=300&X-Amz-Signature=ee798db99e267e73b681954a8a2e04737d0b838d3bdd2c1d2d0719282d4d6980&X-Amz-SignedHeaders=host&actor_id=32817183&repo_id=256977494&response-content-disposition=attachment%3B%20filename%3Dtsparrot-chap2.apk&response-content-type=application%2Fvnd.android.package-archive)

![旋转前](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183435_chapter.android.aweme..jpg)

![旋转后](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183457_chapter.android.aweme..jpg)

![恢复后](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183512_chapter.android.aweme..jpg)

### Exercise 2

由于ViewGroup是树形结构，实质上要完成树的遍历，可采用DFS/BFS，这里使用了DFS实现。

![恢复后](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183610_chapter.android.aweme..jpg)

### Exercise 3

`ScrollView`布局中似乎只能添加一个元素，由于想实现较为真实的聊天界面效果，故将内层的`ScrollView`替换为`RecyclerView`，配合以.9图为`TextView`背景的子项来实现。

![恢复后](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183645_chapter.android.aweme..jpg)

![恢复后](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183706_chapter.android.aweme..jpg)

![恢复后](https://github.com/tsparrot/Chapter-2-master/blob/master/pic/Screenshot_20200419_183759_chapter.android.aweme..jpg)
