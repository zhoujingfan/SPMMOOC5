/**
 * 借用管理初始化
 */
var Myborrow = {
    id: "BorowTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Myborrow.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},

        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '设备名', field: 'devicename', visible: true, align: 'center', valign: 'middle'},
        {title: '借用者', field: 'username', visible: true, align: 'center', valign: 'middle'},
        {title: '借出时间', field: 'borrowtime', visible: true, align: 'center', valign: 'middle'},
        {title: '预计归还时间', field: 'returntime', visible: true, align: 'center', valign: 'middle'},
        {title: '排队人数', field: 'count', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'state', visible: true, align: 'center', valign: 'middle'}

    ];
};

/**
 * 检查是否选中
 */
Myborrow.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Myborrow.seItem = selected[0];
        return true;
    }
};

/**
 * 归还设备
 */
Myborrow.return = function () {
    if (this.check()) {
        if (this.seItem.nextuser === 0) {
            var ajax = new $ax(Feng.ctxPath + "/myborrow/return", function (data) {
                Feng.success("归还成功!");
                Myborrow.table.refresh();
            }, function (data) {
                Feng.error("操作失败!" + data.responseJSON.message + "!");
            });
            ajax.set("borowId", this.seItem.id);
            ajax.start();
        }else {
            Feng.info("仍在排队不可归还！");
        }
    }
};

/**
 * 查询借用列表
 */
Myborrow.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Myborrow.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Myborrow.initColumn();
    var table = new BSTable(Myborrow.id, "/myborrow/list", defaultColunms);
    table.setPaginationType("client");
    Myborrow.table = table.init();
});
