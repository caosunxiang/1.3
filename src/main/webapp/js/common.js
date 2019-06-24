//var baseurl = "http://localhost:8080/huiyuan";
var baseurl = "http://47.97.163.4:6058/1.3";
//var baseurl = "http://localhost:8080/1.3";
//var baseurl = "http://suzijidi.natapp1.cc/1.3";
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	}
	return null;
}
      Date.prototype.format = function (fmt) { //author: meizz  
	    	    var o = {  
	    	        "M+": this.getMonth() + 1, //月份  
	    	        "d+": this.getDate(), //日  
	    	        "h+": this.getHours(), //小时  
	    	        "m+": this.getMinutes(), //分  
	    	        "s+": this.getSeconds(), //秒   
	    	        "q+": Math.floor((this.getMonth() + 3) / 3),    //q是季度
	    	        "S": this.getMilliseconds() //毫秒  
	    	    };  
	    	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
	    	    for (var k in o)  
	    	        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
	    	    return fmt;  
	    	}  
	    	  
	    	String.prototype.format = function (args) {  
	    	    var result = this;  
	    	    if (arguments.length > 0) {  
	    	        if (arguments.length == 1 && typeof (args) == "loginTime") {  
	    	            for (var key in args) {  
	    	                if (args[key] != undefined) {  
	    	                    var reg = new RegExp("({" + key + "})", "g");  
	    	                    result = result.replace(reg, args[key]);  
	    	                }  
	    	            }  
	    	        }  
	    	        else {  
	    	            for (var i = 0; i < arguments.length; i++) {  
	    	                if (arguments[i] != undefined) {  
	    	                    //var reg = new RegExp("({[" + i + "]})", "g");//这个在索引大于9时会有问题  
	    	                    var reg = new RegExp("({)" + i + "(})", "g");  
	    	                    result = result.replace(reg, arguments[i]);  
	    	                }  
	    	            }  
	    	        }  
	    	    }  
	    	    return result;  
	    	}
	    	function dateFormat(value) {
	    	    return value ? new Date(value).format("yyyy-MM-dd hh:mm:ss") : "";  
	    	} 
	
	
	
	