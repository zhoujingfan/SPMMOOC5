/**
 * 初始化设备详情对话框
 */
var DeviceInfoDlg = {
    deviceInfoData : {},
    d: {
        name: {
            validators: {
                notEmpty: {
                    message: '设备名不能为空'
                }
            }
        },
        type: {
            validators: {
                notEmpty: {
                    message: '设备类型不能为空'
                }
            }
        },
        systemVersion: {
            validators: {
                notEmpty: {
                    message: '设备系统版本不能为空'
                }
            }
        },
        light: {
            validators: {
                notEmpty: {
                    message: '光线传感器不能为空'
                }
            }
        },
        gyroscope: {
            validators: {
                notEmpty: {
                    message: '陀螺仪不能为空'
                }
            }
        },
        barometric: {
            validators: {
                notEmpty: {
                    message: '气压传感器不能为空'
                }
            }
        },
        frontCamera: {
            validators: {
                notEmpty: {
                    message: '前置摄像头数量不能为空'
                }
            }
        },
        rearCamera: {
            validators: {
                notEmpty: {
                    message: '后置摄像头数量不能为空'
                }
            }
        }
    }
};

/**
 * 清除数据
 */
DeviceInfoDlg.clearData = function() {
    this.deviceInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeviceInfoDlg.set = function(key, val) {
    this.deviceInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DeviceInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DeviceInfoDlg.close = function() {
    parent.layer.close(window.parent.Device.layerIndex);
}

/**
 * 收集数据
 */
DeviceInfoDlg.collectData = function() {
    this.set('id').set('name').set('type').set('systemVersion').set('light').set('gyroscope').set('barometric').set('frontCamera').set('rearCamera');
}

/**
 * 提交添加设备
 */
DeviceInfoDlg.addSubmit = function() {
d
    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/device/add", function(data){
        Feng.success("添加成功!");
        window.parent.Device.table.refresh();
        DeviceInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.deviceInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DeviceInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/device/update", function(data){
        Feng.success("修改成功!");
        window.parent.Device.table.refresh();
        DeviceInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.deviceInfoData);
    ajax.start();
}

$(function() {
    Feng.initValidator("deviceInfoForm", DeviceInfoDlg.validateFields);

    //初始select选项
    $("#type").val($("#typeValue").val());
    $("#light").val($("#lightValue").val());
    $("#gyroscope").val($("#gyroscopeValue").val());
    $("#barometric").val($("#barometricValue").val());
    $("#frontCamera").val($("#frontCameraValue").val());
    $("#rearCamera").val($("#rearCameraValue").val());
});
