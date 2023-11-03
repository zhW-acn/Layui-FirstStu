# 我的第一个基于Layui实现增删改查的学生管理数据表格

可以删除addStu.html和update.html。我觉得写在同一个html中太冗长了，分几个页面可阅读性会高一点。

但是我想实现一个操作之后只刷新局部信息，这样展示会流畅一点。所以从大佬那拷了一个弹窗功能的div，改变style属性的display值

`<div class="layui-row" id="addStu" style="display:none;">`


## 回忆一下我踩过的坑
~~不算是坑吧，就是自己不会用~~
1. form表单的提交：layui在脚本中可以不用写action而通过form.on("submit(提交按钮的lay-filter)","点击后执行函数，通常写ajax")方法提交表单，

而我在form上又填了一边action，导致它不通过ajax提交，ajax success后也不执行任何函数，页面卡死。我还以为是Servlet那里需要转发重定向，浪费了很多时间在这里

2. 提交的data格式： 在student.html中的326行的data与367行的data并不是一个东西，ajax中的data很有迷惑性（导致我以为提交的就是data，而不是json）。这里debugger两三遍就发现问题了

3. 页面传值：我的一个需求是更改操作需要把当前行的数据自动填充到弹窗里的form表单中。谷歌百度GPT搜了个遍就差没问星火大模型了，结果昨晚睡不着在[b站](https://www.bilibili.com/video/BV1jX4y1t7EH/?p=6&share_source=copy_web&vd_source=1697141e3e3763e3917ed950f71a6c1c&t=421)

上一搜。人家一个函数就搞定了我无语了。这里花的时间最长，主要是对iframe，弹窗，JQuery和Layui整体的使用不熟练。

这是我目前做的第一个自以为比较满意的小项目
