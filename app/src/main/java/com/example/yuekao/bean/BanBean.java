package com.example.yuekao.bean;

import java.io.Serializable;

public class BanBean implements Serializable {
    /**
     * msg : 获取版本信息成功
     * code : 0
     * data : {"apkUrl":"http://www.zhaoapi.cn/apatch/new.apatch","desc":null,"type":0,"vId":1,"versionCode":"101","versionName":"1.0.1"}
     */

    private String msg;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * apkUrl : http://www.zhaoapi.cn/apatch/new.apatch
         * desc : null
         * type : 0
         * vId : 1
         * versionCode : 101
         * versionName : 1.0.1
         */

        private String apkUrl;
        private Object desc;
        private String type;
        private String vId;
        private String versionCode;
        private String versionName;

        public String getApkUrl() {
            return apkUrl;
        }

        public void setApkUrl(String apkUrl) {
            this.apkUrl = apkUrl;
        }

        public Object getDesc() {
            return desc;
        }

        public void setDesc(Object desc) {
            this.desc = desc;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVId() {
            return vId;
        }

        public void setVId(String vId) {
            this.vId = vId;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }
    }
}
