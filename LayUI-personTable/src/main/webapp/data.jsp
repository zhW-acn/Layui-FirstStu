<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="js/jQuery.js"></script>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.7.6/css/layui.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.7.6/layui.js"></script>

        <title>Insert title here</title>
    </head>

    <body>

        <div class="layui-row">
            <div class="layui-col-md12">
                <table class="layui-hide" id="test" lay-filter="test"></table>
            </div>
        </div>
        <!-- 编辑弹框  -->
        <div class="layui-row" id="update" style="display:none;">
            <div class="layui-col-md10">
                <form class="layui-form layui-from-pane" action="" lay-filter="formTest" style="margin-top:20px">
                    <input type="hidden" name="did" id="did" />
                    <div class="layui-form-item">
                        <label class="layui-form-label">序号 ：</label>
                        <div class="layui-input-block">
                            <input type="text" name="id" id="id" readonly lay-verify="required" autocomplete="off"
                                placeholder="请输入id" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名：</label>
                        <div class="layui-input-block">
                            <input type="text" name="username" id="username" required lay-verify="required"
                                autocomplete="off" placeholder="请输入姓名" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码：</label>
                        <div class="layui-input-block">
                            <input type="text" name="password" id="password" required lay-verify="required"
                                autocomplete="off" placeholder="请输入密码" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item" style="margin-top:40px">
                        <div class="layui-input-block">
                            <button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="save">保存</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>





        <script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>

</script>
        <script type="text/javascript">
            layui.use(['table', 'form'], function () {
                var table = layui.table;
                var form = layui.form;

                var deptTable = table.render({
                    elem: '#test'
                    , height: 312
                    , url: 'GetPersonPageServlet' //数据接口
                    , page: true //开启分页
                    , cols: [[ //表头
                        { field: 'id', title: 'ID', width: 110, sort: true, fixed: 'left' }
                        , { field: 'username', title: '姓名', width: 110 }
                        , { field: 'password', title: '密码', width: 110, sort: true }
                        , { fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150 }
                    ]]
                });

                //工具条事件
                table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                    var data = obj.data; //获得当前行数据
                    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                    var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

                    if (layEvent === 'del') { //删除
                        layer.confirm('确定删除吗？', function (index) {
                            $.ajax({
                                type: 'post',
                                url: 'DeleteServlet',
                                data: { "id": data.id },
                                dataType: 'json',
                                success: function (data) {
                                    if (data.code == 'ok') {
                                        layer.msg("删除成功", { icon: 1 });
                                        deptTable.reload();//重新加载数据表格
                                    } else {
                                        layer.msg("删除失败", { icon: 5 });
                                    }
                                }
                            })
                        });




                    } else if (layEvent === 'edit') { //编辑
                        $("#did").val(data.did);
                        $("#id").val(data.id);
                        $("#username").val(data.username);
                        $("#password").val(data.password);

                        //修改弹框
                        layer.open({
                            type: 1,
                            title: "修改Person信息",
                            area: ['800px', '500px'],
                            content: $("#update")//引用的弹出层的页面层的方式加载修改界面表单


                        });
                    }
                });

                //监听表单提交
                //保存（修改、删除）
                form.on('submit(save)', function (data) {
                    $.ajax({
                        url: 'UpdateServlet',
                        type: 'POST',
                        dataType: "json",
                        data: data.field,
                        success: function (data) {

                            if (data.code == 200) {
                                layer.msg("保存成功", { icon: 1 });
                                setTimeout(function () {
                                    layer.closeAll();//关闭所有的弹出层
                                    deptTable.reload();//重新加载数据表格
                                }, 500);
                            } else {
                                layer.msg("操作失败！", { icon: 5 });
                            }
                        }
                    });
                    return false;
                });

            });



        </script>


    </body>

    </html>