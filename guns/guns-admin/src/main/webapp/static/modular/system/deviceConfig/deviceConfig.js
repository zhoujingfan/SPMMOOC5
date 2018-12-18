/**
 * 设备详情管理初始化
 */
var DeviceConfig = {
    id: "DeviceConfigTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DeviceConfig.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '设备类型（1：手机 2：电脑）', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '系统版本', field: 'systemVersion', visible: true, align: 'center', valign: 'middle'},
            {title: '陀螺仪（1：有 2：无）', field: 'gyroscope', visible: true, align: 'center', valign: 'middle'},
            {title: '气压传感器（1：有 2：无）', field: 'barometric', visible: true, align: 'center', valign: 'middle'},
            {title: '地磁旋转矢量传感器（1：有 2：无）', field: 'geomagnetic', visible: true, align: 'center', valign: 'middle'},
            {title: '加速度传感器（1：有 2：无）', field: 'acceleration', visible: true, align: 'center', valign: 'middle'},
            {title: '温度传感器（1：有 2：无）', field: 'temperature', visible: true, align: 'center', valign: 'middle'},
            {title: '重力传感器（1：有 2：无）', field: 'gravity', visible: true, align: 'center', valign: 'middle'},
            {title: '心率传感器（1：有 2：无）', field: 'heartRate', visible: true, align: 'center', valign: 'middle'},
            {title: '光线传感器（1：有 2：无）', field: 'light', visible: true, align: 'center', valign: 'middle'},
            {title: '线性加速度传感器（1：有 2：无）', field: 'linearAcceleration', visible: true, align: 'center', valign: 'middle'},
            {title: '磁场传感器（1：有 2：无）', field: 'magneticField', visible: true, align: 'center', valign: 'middle'},
            {title: '方向传感器（1：有 2：无）', field: 'direction', visible: true, align: 'center', valign: 'middle'},
            {title: '压力传感器（1：有 2：无）', field: 'pressure', visible: true, align: 'center', valign: 'middle'},
            {title: '湿度传感器（1：有 2：无）', field: 'humidity', visible: true, align: 'center', valign: 'middle'},
            {title: '旋转矢量传感器（1：有 2：无）', field: 'rotationVector', visible: true, align: 'center', valign: 'middle'},
            {title: '计步传感器（1：有 2：无）', field: 'step', visible: true, align: 'center', valign: 'middle'},
            {title: '步行检测传感器（1：有 2：无）', field: 'walk', visible: true, align: 'center', valign: 'middle'},
            {title: '后置摄像头数量（1 2 3 4）', field: 'rearCamera', visible: true, align: 'center', valign: 'middle'},
            {title: '前置摄像头数量（1 2 3）', field: 'frontCamera', visible: true, align: 'center', valign: 'middle'},
            {title: '人脸识别（1：有 2：无）', field: 'faceRecognition', visible: true, align: 'center', valign: 'middle'},
            {title: '指纹识别（1：有 2：无）', field: 'fingerprint', visible: true, align: 'center', valign: 'middle'},
            {title: '虹膜识别（1：有 2：无）', field: 'iris', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
DeviceConfig.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DeviceConfig.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加设备详情
 */
DeviceConfig.openAddDeviceConfig = function () {
    var index = layer.open({
        type: 2,
        title: '添加设备详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/deviceConfig/deviceConfig_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看设备详情详情
 */
DeviceConfig.openDeviceConfigDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '设备详情详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/deviceConfig/deviceConfig_update/' + DeviceConfig.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除设备详情
 */
DeviceConfig.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/deviceConfig/delete", function (data) {
            Feng.success("删除成功!");
            DeviceConfig.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("deviceConfigId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询设备详情列表
 */
DeviceConfig.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DeviceConfig.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DeviceConfig.initColumn();
    var table = new BSTable(DeviceConfig.id, "/deviceConfig/list", defaultColunms);
    table.setPaginationType("client");
    DeviceConfig.table = table.init();
});
