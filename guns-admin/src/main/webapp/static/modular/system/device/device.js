/**
 * 设备管理初始化
 */
var Device = {
    id: "DeviceTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Device.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '设备名', field: 'name', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '设备类型', field: 'type', visible: true, align: 'center', valign: 'middle'},
        {title: '购买时间', field: 'buyTime', visible: true, align: 'center', valign: 'middle'},
        {title: '光线传感器', field: 'light', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '陀螺仪', field: 'gyroscope', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '气压传感器', field: 'barometric', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '前置摄像头数量', field: 'frontCamera', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '后置摄像头数量', field: 'rearCamera', visible: true, align: 'center', valign: 'middle', sortable: true},
        {title: '系统版本', field: 'systemVersion', visible: true, align: 'center', valign: 'middle'},
        {title: '排队人数', field: 'count', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '地磁旋转矢量传感器', field: 'geomagnetic', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '加速度传感器', field: 'acceleration', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '温度传感器', field: 'temperature', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '重力传感器', field: 'gravity', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '心率传感器', field: 'heartRate', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '线性加速度传感器', field: 'linearAcceleration', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '磁场传感器', field: 'magneticField', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '方向传感器', field: 'direction', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '压力传感器', field: 'pressure', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '湿度传感器', field: 'humidity', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '旋转矢量传感器', field: 'rotationVector', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '计步传感器', field: 'step', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '布星检测传感器', field: 'walk', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '人脸识别', field: 'faceRecognition', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '指纹识别', field: 'fingerprint', visible: true, align: 'center', valign: 'middle', sortable: true},
        // {title: '虹膜识别', field: 'iris', visible: true, align: 'center', valign: 'middle', sortable: true}
    ];
};

/**
 * 检查是否选中
 */
Device.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Device.seItem = selected[0];
        return true;
    }
};

/**
 * 检查是否借完
 */
Device.loanAll = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected[0].count == "3"){
        Feng.info("排队人数已满！");
        return false;
    }else{
        Device.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加设备
 */
Device.openAddDevice = function () {
    var index = layer.open({
        type: 2,
        title: '添加设备',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/device/device_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看设备详情
 */
Device.openDeviceDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '设备详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/device/device_update/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除设备
 */
Device.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/device/delete", function (data) {
            Feng.success("删除成功!");
            Device.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("deviceId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 打开借用设备
 */
Device.openBorrow = function () {
    if (this.check()&&this.loanAll()) {
        var index = layer.open({
            type: 2,
            title: '发起借用',
            area: ['500px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/device/device_borrow/' + this.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 查询设备列表
 */
Device.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Device.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Device.initColumn();
    var table = new BSTable(Device.id, "/device/list", defaultColunms);
    table.setPaginationType("client");
    Device.table = table.init();
});
