jQuery(document).ready(function() {
	var userid = request.QueryString("userid");
	var noncestr = request.QueryString("noncestr");
	var sign = request.QueryString("sign");
	
	if (null == userid || noncestr == null || sign == null) {
		userid = "e227a7df-b828-41b1-892f-14f7c40257f7";
		noncestr = "D0220444";
		sign = "B3864D13149C5ADAD58C11167549F4ED";
	}
	
	var url="http://play.sohouer.com/app/invite_apprentice";
	var object = new Object();
	object.userid = userid;
	object.noncestr = noncestr;
	object.sign = sign;
	var result = postAsyncAjax(url,object);
	if (null != result) {
		result= $.parseJSON(result);
		$("#begin").attr("href", result.urlscheme + "://invite=" + userid);
		$("#down").on('click', function() {
			alert('温馨提示:安装完成后务必返回该页面,点击"打开搜猴儿",才能激活一键任务模式!');
			$("#down").attr("href", result.downloadurl);	
		});
	}
});



function postAsyncAjax(url, data) {
	
	var json = null;
	$.ajax({
		type : "GET",
		url : url,
		data : data,
		async : false,
		success : function(msg) {
			json = msg;
		},
		error : function(request) {
		   
		}
	});

return json;
}



/**
 * ҳ���������
 */
var request = {
	QueryString : function(val) {
		var uri = window.location.search;
		var re = new RegExp("" + val + "\=([^\&\?]*)", "ig");
		return ((uri.match(re)) ? (uri.match(re)[0].substr(val.length + 1))
				: null);
	},
	QueryStrings : function() {
		var uri = window.location.search;
		var re = /\w*\=([^\&\?]*)/ig;
		var retval = [];
		while ((arr = re.exec(uri)) != null)
			retval.push(arr[0]);
		return retval;
	},
	setQuery : function(val1, val2) {
		var a = this.QueryStrings();
		var retval = "";
		var seted = false;
		var re = new RegExp("^" + val1 + "\=([^\&\?]*)$", "ig");
		for (var i = 0; i < a.length; i++) {
			if (re.test(a[i])) {
				seted = true;
				a[i] = val1 + "=" + val2;
			}
		}
		retval = a.join("&");
		return "?" + retval
				+ (seted ? "" : (retval ? "&" : "") + val1 + "=" + val2);
	}
};
