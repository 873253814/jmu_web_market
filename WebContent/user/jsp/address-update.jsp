<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="jmu_web.market.book.entity.*"%>
<%@ page import="jmu_web.market.book.dao.*"%>
<%@ page import="jmu_web.market.book.dao.impl.*"%>
<%@ page import="jmu_web.market.address.dao.impl.*"%>
<%@ page import="jmu_web.market.address.dao.*"%>
<%@ page import="jmu_web.market.address.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <title>我的订单 - 达内学子商城</title>
    <link href="../css/my.order.css" rel="stylesheet" />
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/set.css" rel="stylesheet" />
     <%
    	String product = request.getParameter("product");
   		String count = request.getParameter("count");
   		String sid = (String)session.getAttribute("sessionId");
    	BookDAO dao = new BookDAOImpl();
    	List<Book> bookList = dao.getBookByIsbn1(product);
    	AddressDAO dao1 = new AddressDAOImpl();
    	List<Address> addressList = dao1.getAddress(sid);
    	
    %>
</head>
<body>
<div id="header">
    <!-- 头部-->
    <header id="top">
    	<input type="hidden" id="sid" value=<%=sid %>>
        <div id="logo" class="lf">
            <img class="animated jello" src="../img/header/logo.png" alt="logo"/>
        </div>
        <div id="top_input" class="lf">
            <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

            <a href="" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
        </div>
        <div class="rt">
	        <ul class="lf">
	            <li><a href="index.jsp" >首页</a><b>|</b></li>
	            <li><a href="collect.jsp" >收藏</a><b>|</b></li>
	            <li><a href="order.jsp" >订单</a><b>|</b></li>
	            <li><a href="cart.jsp" >购物车</a><b>|</b></li>
	            <li><a href="password-change.jsp">设置</a><b>|</b></li>
	            <li><a href="login.jsp">退出</a><b>|</b></li>
	            <li><a href="lookforward.html">帮助</a></li>
	        </ul>
        </div>
    </header>
    <!-- 主导航-->

    <!-- 主导航-->
    <nav id="nav1">
        <!-- 我的订单导航栏-->
        <div id="nav_order" class="lf">
            <ul>
                <li></li>
            </ul>
        </div>
    </nav>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt onClick="changeImage()">帐号管理<img src="../img/myOrder/myOrder1.png"></dt>
            <dd class="first_dd"><a href="password-change.jsp">修改密码</a></dd>
            <dd><a href="address-add.jsp">添加地址</a></dd>
            <dd><a href="address-update.jsp">修改地址</a></dd>
        </dl>

    </div>
    <!-- 右边栏-->
    <div class="rightsidebar_box rt" >
    <div id="container" class="clear">
    <!--收货地址-->
    <div class="adress_choice">
    <input type="hidden" id="count" value=<%=count %>>
    <input type="hidden" id="product" value=<%=product %>>
        <p>选择您要修改的地址</p>
	<%for(Address a:addressList){ %>
        <div id="addresId1">
        <% if(a.getRid().equals("1")) {%>
			<i class="user_choice">
                <input type="radio" name="address" value=<%=a.getRid() %> checked />
            </i>
            <%}else{ %>
            <i class="user_choice">
                <input type="radio" name="address" value=<%=a.getRid() %>  />
            </i>
            <%} %>
            <i class="address_name">
                <%=a.getReceiver() %> 
            </i>
            <i class="user_address">
                <%=a.getAddress() %> <%=a.getReceiverPhone() %>
            </i>
        </div>
        <%} %>
        <span class="go_pay">确认并修改</span>&nbsp;
        <span class="go_delete">确认并删除</span>
    </div>
    </div>
    </div>
</div>
<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../img/footer/icon1.png" alt=""/>
        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../img/footer/icon2.png" alt=""/>
        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../img/footer/icon3.png" alt=""/>
        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../img/footer/icon4.png" alt=""/>
        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
             <p class="footer1"><img src="../img/footer/tedu.png" alt="" class=" footLogo"/></p>
             <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../img/footer/wechat.png" alt=""/>
                    <img src="../img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
            <img src="../img/footer/ios.png" class="lf">
            <img src="../img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../img/footer/erweima.png">
        </div>
    </div>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script src="../js/order.js"></script>
<script type="text/javascript">

$(".go_pay").click(function () {
	var rid = $("input[name='address']:checked").val();
	//alert(rid);
    location.href = "address-update-infor.jsp?rid="+rid;
});

$('.go_delete').click(function(){
    //读取用户的输入——表单序列化
    var rid = $("input[name='address']:checked").val();
    var inputData = $('#fm-changep').serialize();
	console.log(">>>"+inputData);
    //alert(inputData);
    //alert(rid);
    //异步提交请求
    $.ajax({
    	async: true,
        type: 'POST',
        url: '../../AddressDeleteServlet?rid='+rid,
        data: inputData,
        success: function(txt, msg, xhr){
        	 //alert("*"+txt+"*");
            if(txt.trim()=='true'){  //修改成功
            	alert("删除成功!");
                window.location.href =  "address-update.jsp";
            }else{ //修改失败
            	alert("删除失败!");
                window.location.href =  "address-update.jsp";
                /* $('#changeFail').html('修改失败！');
                $("#changeFail").css("color","red"); */
            }
        }
    });
});
</script>
</html>
