<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../inc/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>	
	.sub_tbl_area{margin-top:50px;width:100%;box-sizing:border-box;border-top:2px solid #000}
	.sub_tbl_area .sub_tbl{width:100%}
	.sub_tbl_area .sub_tbl th{border-bottom:1px solid #e6e6e6;font-size:14px;color:#1e1e1e;padding:17px 0}
	.sub_tbl_area .sub_tbl td{border-bottom:1px solid #e6e6e6;font-size:14px;color:#666;padding:17px 0;text-align:center}
	.sub_tbl_area .sub_tbl td.tit > a{color:#1e1e1e;display:block}
</style>

	<div class="sub_contents">
		<div class="sub_contents_inner">
			<div class="sub_tit_area">
				<h2>게시판</h2>
			</div>			
			<div class="sub_tbl_area">
							
				<table class="sub_tbl">
					<caption class="hide_txt">게시판</caption>
					<colgroup>
						<col style="width:10%">
						<col style="width:*">
						<col style="width:18%">
						<col style="width:18%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>						
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.bno}" /></td>
								<td class="tit"><a href="<%=request.getContextPath()%>/board/readView?bno=${list.bno}"><c:out value="${list.title}" /></a></td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>																					
				</table>	
				<div class="list_pager_wrap">
				  <ul class="list_pager">
				    <c:if test="${pageMaker.prev}">
				    	<li><a href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
				    </c:if> 
				
				    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				    	<li><a href="list${pageMaker.makeSearch(idx)}">${idx}</a></li>
				    </c:forEach>
				
				    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				    	<li><a href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
				    </c:if> 
				  </ul>
				</div>
				<div class="list_search_wrap">
					<form method="get" role="form">					
						<select name="searchType">
					      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
					      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
					      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
					      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
					      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
					    </select>
					     <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
					    <input type="submit" value="검색">
					    </form>			
					<script>
				      $(function(){
				        $('#searchBtn').click(function() {
				          self.location = "list" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
				        });
				      });   
				    </script>
				</div>
					
			</div>
		</div>				
	</div>		
<%@ include file="../inc/footer.jsp" %>	
	