<%@ page language="java" pageEncoding="UTF-8"%>	
<%@ include file="../inc/header.jsp" %>
	
	<div class="sub_contents">
		<div class="sub_contents_inner">
			<div class="sub_tit_area">
				<h2>글쓰기</h2>
			</div>			
			<div>						
				<form method="post" action="<%=request.getContextPath() %>/board/write">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" />
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content" ></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label><input type="text" id="writer" name="writer" />
								</td>
							<tr>
								<td>						
									<button type="submit">작성</button>
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
			</div>
		</div>
	</div>			
<%@ include file="../inc/footer.jsp" %>