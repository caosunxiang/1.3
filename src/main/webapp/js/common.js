//var baseurl = "http://localhost:8080/huiyuan";
var baseurl = "http://localhost:8080/1.3";
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	}
	return null;
}