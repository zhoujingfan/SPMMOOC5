/**
 * 借用管理初始化
 */
var Borow = {
    id: "BorowTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Borow.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},

        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '设备名', field: 'devicename', visible: true, align: 'center', valign: 'middle'},
        {title: '借用者', field: 'username', visible: true, align: 'center', valign: 'middle'},
        {title: '借出时间', field: 'borrowtime', visible: true, align: 'center', valign: 'middle'},
        {title: '预计归还时间', field: 'returntime', visible: true, align: 'center', valign: 'middle'},
        {title: 'a排队人数', field: 'count', visible: true, align: 'center', valign: 'middle'}

    ];
};

/**
 * 检查是否选中
 */
Borow.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Borow.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加借用
 */
Borow.openAddBorow = function () {
    var index = layer.open({
        type: 2,
        title: '添加借用',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/borow/borow_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看借用详情
 */
Borow.openBorowDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '借用详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/borow/borow_update/' + Borow.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除借用
 */
Borow.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/borow/delete", function (data) {
            Feng.success("删除成功!");
            Borow.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("borowId", this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询借用列表
 */
Borow.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Borow.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Borow.initColumn();
    var table = new BSTable(Borow.id, "/borow/list", defaultColunms);
    table.setPaginationType("client");
    Borow.table = table.init();
});
