/**
 * 失效审批管理初始化
 */
var HandledApply = {
    id: "HandledApplyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
HandledApply.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '申请主题', field: 'title', visible: true, align: 'center', valign: 'middle'},
        {title: '申请详情', field: 'body', visible: true, align: 'center', valign: 'middle'},
        {title: '申请者', field: 'applyername', visible: true, align: 'center', valign: 'middle'},
        {title: '申请时间', field: 'applytime', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '是否批准', field: 'agreedname', visible: true, align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
HandledApply.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        HandledApply.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加失效审批
 */
HandledApply.openAddHandledApply = function () {
    var index = layer.open({
        type: 2,
        title: '添加失效审批',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/handledApply/handledApply_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看失效审批详情
 */
HandledApply.openHandledApplyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '失效审批详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/handledApply/handledApply_update/' + HandledApply.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除失效审批
 */
HandledApply.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/handledApply/delete", function (data) {
            Feng.success("删除成功!");
            HandledApply.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("handledApplyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询失效审批列表
 */
HandledApply.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    HandledApply.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = HandledApply.initColumn();
    var table = new BSTable(HandledApply.id, "/handledApply/list", defaultColunms);
    table.setPaginationType("client");
    HandledApply.table = table.init();
});
