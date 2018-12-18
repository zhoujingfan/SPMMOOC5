/**
 * 初始化借用详情对话框
 */
var BorowInfoDlg = {
    borowInfoData : {}
};

/**
 * 清除数据
 */
BorowInfoDlg.clearData = function() {
    this.borowInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BorowInfoDlg.set = function(key, val) {
    this.borowInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BorowInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BorowInfoDlg.close = function() {
    parent.layer.close(window.parent.Borow.layerIndex);
}

/**
 * 收集数据
 */
BorowInfoDlg.collectData = function() {
    this
    .set('id')
    .set('deviceid')
    .set('userid')
    // .set('borrowtime')
    // .set('returntime');
}

/**
 * 提交添加
 */
BorowInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/borow/add", function(data){
        Feng.success("添加成功!");
        window.parent.Borow.table.refresh();
        BorowInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.borowInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BorowInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/borow/update", function(data){
        Feng.success("修改成功!");
        window.parent.Borow.table.refresh();
        BorowInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.borowInfoData);
    ajax.start();
}

$(function() {

});
