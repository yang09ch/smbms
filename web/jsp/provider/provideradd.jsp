<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <form id="providerForm" name="providerForm" method="post" action="${pageContext.request.contextPath }/provide/doadd">
			<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="proCode">供应商编码：</label>
                    <input type="text" name="procode" id="proCode" value="">
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="proName">供应商名称：</label>
                   <input type="text" name="proname" id="proname" value="">
					<font color="red"></font>
                </div>
               <input type="hidden" value="${sessionScope.user.id}" name="createdby"/>
                    <div>
                    <label for="proContact">联系人：</label>
                    <input type="text" name="procontact" id="proContact" value="">
					<font color="red"></font>

                </div>
                <div>
                    <label for="proPhone">联系电话：</label>
                    <input type="text" name="prophone" id="proPhone" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="proAddress">联系地址：</label>
                    <input type="text" name="proaddress" id="proAddress" value="">
                </div>
                <div>
                    <label for="proFax">传真：</label>
                    <input type="text" name="profax" id="proFax" value="">
                </div>
                <div>
                    <label for="proDesc">描述：</label>
                    <input type="text" name="prodesc" id="proDesc" value="">
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存">
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
     </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/provideradd.js"></script>
