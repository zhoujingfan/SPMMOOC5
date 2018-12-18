/**
 * 申请管理初始化
 */
var Apply = {
    id: "ApplyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Apply.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '申请主题', field: 'title', visible: true, align: 'center', valign: 'middle'},
        {title: '申请详情', field: 'body', visible: true, align: 'center', valign: 'middle'},
        {title: '申请者', field: 'applyername', visible: true, align: 'center', valign: 'middle'},
        {title: '申请时间', field: 'applytime', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '是否已阅', field: 'readedname', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '是否批准', field: 'agreedname', visible: true, align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Apply.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Apply.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加申请
 */
Apply.openAddApply = function () {
    var index = layer.open({
        type: 2,
        title: '添加申请',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/apply/apply_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看申请详情
 */
Apply.openApplyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '申请详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/apply/apply_update/' + Apply.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除申请
 */
Apply.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/apply/delete", function (data) {
            Feng.success("删除成功!");
            Apply.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("applyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 同意申请
 */
Apply.accept = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/apply/accept", function (data) {
            Feng.success("已同意!");
            Apply.table.refresh();
        }, function (data) {
            Feng.error("操作失败!" + data.responseJSON.message + "!");
        });
        ajax.set("applyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 同意申请
 */
Apply.done = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/apply/done", function (data) {
            Feng.success("已失效!");
            Apply.table.refresh();
        }, function (data) {
            Feng.error("操作失败!" + data.responseJSON.message + "!");
        });
        ajax.set("applyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询申请列表
 */
Apply.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Apply.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Apply.initColumn();
    var table = new BSTable(Apply.id, "/apply/list", defaultColunms);
    table.setPaginationType("client");
    Apply.table = table.init();
});
