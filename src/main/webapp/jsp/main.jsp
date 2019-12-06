<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>员工表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/boot/css/back.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/jqgrid/css/jquery-ui.css">
    <script src="${pageContext.request.contextPath}/boot/js/jquery-2.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/boot/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/jqgrid/js/trirand/src/jquery.jqGrid.js"></script>
    <script src="${pageContext.request.contextPath}/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript">
        $(function () {
            //表格初始化
            $("#empTable").jqGrid(
                {
                    url: "${pageContext.request.contextPath}/emp/findAll",
                    datatype: "json",
                    colNames: ['ID', '姓名', '年龄', '性别', '生日', '地址', '部门'],
                    colModel: [
                        {name: 'id', hidden: true},
                        {name: 'name', align: "center", editable: true, editrules: {required: true}},
                        {name: 'age', search: false, align: "center", editable: true},
                        {
                            name: 'sex',
                            align: "center",
                            editable: true,
                            edittype: "select",
                            editoptions: {value: "男:男;男:女"}
                        },
                        {name: 'birth', search: false, align: "center", editable: true, edittype: "date"},
                        {name: 'address', align: "center", editable: true, editoptions: {required: true}},
                        {
                            name: 'dept',
                            align: "center",
                            editable: true,
                            edittype: "select",
                            editoptions: {value: "轻音部:轻音部;音乐部:音乐部;动漫部:动漫部"}
                        },
                    ],
                    rowNum: 3,
                    rowList: [1, 3, 5, 10],
                    pager: '#empPage',
                    mtype: "post",
                    viewrecords: true,
                    height: 500,
                    caption: "员工信息表",
                    styleUI: "Bootstrap",
                    autowidth: true,
                    editurl: "${pageContext.request.contextPath}/emp/change"
                });
            $("#empTable").jqGrid('navGrid', '#empPage',
                {
                    edit: true, add: true, del: true,
                    edittext: "编辑", addtext: "添加", deltext: "删除"
                },
                // edit add del
                {
                    closeAfterEdit: true,
                    // frm ---> 表单对象
//                beforeShowForm:function (frm) {
//                    frm.find('#url').attr("disabled",true)
//                },
                }, {
                    closeAfterAdd: true,

                }, {
                    closeAfterDel: true,
                },
                {
                    sopt: ['eq', 'ne', 'cn']//配置搜索条件如何
                },//对搜索时的配置对象
            );
        });
    </script>
</head>
<body>
<div class="row">
    <div class="col-sm-8 col-sm-offset-2">
        <div>
            <h1>员工信息</h1>
            <hr>
            <!--创建表格-->
            <table id="empTable"></table>

            <!--分页工具栏-->
            <div id="empPage">
            </div>

        </div>
    </div>
</div>
</body>
</html>



