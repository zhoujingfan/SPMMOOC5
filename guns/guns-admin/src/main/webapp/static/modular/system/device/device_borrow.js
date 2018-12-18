/**
 * 初始化设备借用详情对话框
 */
var DeviceBorrowDlg = {
    deviceBorrowData : {},
    d: {
        returntime: {
            validators: {
                notEmpty: {
                    message: '设备名不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
DeviceBorrowDlg.clearData = function() {
    this.deviceBorrowData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeviceBorrowDlg.set = function(key, val) {
    this.deviceBorrowData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeviceBorrowDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DeviceBorrowDlg.close = function() {
    parent.layer.close(window.parent.Device.layerIndex);
};

/**
 * 收集数据
 */
DeviceBorrowDlg.collectData = function() {
    this.set('deviceid').set('userid').set('returntime').set('sort');
};
    // .set('borrowtime')


/**
 * 提交添加借用
 */
DeviceBorrowDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/borow/add", function(data){
        Feng.success("添加成功!");
        window.parent.Device.table.refresh();
        DeviceBorrowDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.deviceBorrowData);
    ajax.start();
}

/**
 * 提交修改
 */
DeviceBorrowDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/borow/update", function(data){
        Feng.success("修改成功!");
        window.parent.Device.table.refresh();
        DeviceBorrowDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.deviceBorrowData);
    ajax.start();
}

$(function() {
    // Feng.initValidator("deviceBorrowForm", DeviceBorrowDlg.validateFields);

    //初始select选项
    var mydate = new Date();
    var str = "" + mydate.getFullYear() + "年";
    str += (mydate.getMonth()+1) + "月";
    str += mydate.getDate() + "日";
    $("#datenow").html("当前日期：" + str);

});
