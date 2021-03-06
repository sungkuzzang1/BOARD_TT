<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../inc/header.jsp" %>

<c:if test="${member == null}">
	<script>
		alert("로그인을 해주세요");
		location.replace("${path}/");			
	</script>		
</c:if>

<style>
.view_wrap{width:100%}
.view_tit_wrap{text-align:center;border-bottom:2px solid #eee;padding-bottom:30px}
.view_tit_wrap > .view_tit{font-size:30px;color:#000;font-weight:bold}
.view_tit_wrap > .view_date{font-size:17px;margin-top:20px}
.view_tit_wrap > .view_writer{margin-top:20px}
.view_content_wrap{box-sizing:border-box;border-bottom:2px solid #eee;padding:50px 100px}
.view_btn_wrap{padding-top:30px}
.view_btn_wrap:after{clear:both;display:block;content:''}
.view_btn_wrap > a{float:right;width:100px;height:40px;line-height:40px;font-size:14px;color:#4d4d4d;text-align:center;border:1px solid #4d4d4d;text-decoration:none}
</style>

	<div class="sub_contents">
		<div class="sub_contents_inner">
			<div class="view_wrap">
				<div class="view_tit_wrap">
					<h2 class="view_tit">${read.title}</h2>
					<p class="view_date"><fmt:formatDate value="${read.regdate}" pattern="yyyy-MM-dd"/></p>
					<p class="view_writer">${read.writer}</p>
				</div>
				<div class="view_content_wrap">
					${read.content}
				</div>
				<div class="view_btn_wrap">
					<a href="<%=request.getContextPath()%>/board/updateView?bno=${read.bno}">수정</a>
					<a href="<%=request.getContextPath()%>/board/delete?bno=${read.bno}">삭제</a>					
					<a href="<%=request.getContextPath()%>/board/list">목록보기</a>
				</div>
			</div>
			
			<div class="view_reply_wrap">
				<c:forEach items="${replyList}" var="replyList">
					<div>
						<p>
							작성자 : ${replyList.writer}<br />
        					작성 날짜 :  <fmt:formatDate value="${replyList.regdate}" pattern="yyyy-MM-dd" />
						</p>
						<p>${replyList.content}</p>
					</div>
				</c:forEach>
			</div>
			
			<div class="view_reply_form">
				<form action="<%=request.getContextPath() %>/board/replyWrite" method="post">
					<input type="hidden" name="bno" value="${read.bno }">
					<div class="">
						<label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer" />
					    <br/>
					    <label for="content">댓글 내용</label><input type="text" id="content" name="content" />
					    <br>
					    <input type="submit" value="작성">
					</div>
				</form>
			</div>
																																					
		</div>				
	</div>			
<%@ include file="../inc/footer.jsp" %>