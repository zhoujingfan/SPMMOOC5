/**
 * 初始化设备详情详情对话框
 */
var DeviceConfigInfoDlg = {
    deviceConfigInfoData : {}
};

/**
 * 清除数据
 */
DeviceConfigInfoDlg.clearData = function() {
    this.deviceConfigInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeviceConfigInfoDlg.set = function(key, val) {
    this.deviceConfigInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeviceConfigInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DeviceConfigInfoDlg.close = function() {
    parent.layer.close(window.parent.DeviceConfig.layerIndex);
}

/**
 * 收集数据
 */
DeviceConfigInfoDlg.collectData = function() {
    this
    .set('id')
    .set('type')
    .set('systemVersion')
    .set('gyroscope')
    .set('barometric')
    .set('geomagnetic')
    .set('acceleration')
    .set('temperature')
    .set('gravity')
    .set('heartRate')
    .set('light')
    .set('linearAcceleration')
    .set('magneticField')
    .set('direction')
    .set('pressure')
    .set('humidity')
    .set('rotationVector')
    .set('step')
    .set('walk')
    .set('rearCamera')
    .set('frontCamera')
    .set('faceRecognition')
    .set('fingerprint')
    .set('iris');
}

/**
 * 提交添加
 */
DeviceConfigInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/deviceConfig/add", function(data){
        Feng.success("添加成功!");
        window.parent.DeviceConfig.table.refresh();
        DeviceConfigInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.deviceConfigInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DeviceConfigInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/deviceConfig/update", function(data){
        Feng.success("修改成功!");
        window.parent.DeviceConfig.table.refresh();
        DeviceConfigInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.deviceConfigInfoData);
    ajax.start();
}

$(function() {

});
