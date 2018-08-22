<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
<nav>
  <ul class="pagination">	
	<!-- 이전 페이지 -->
	<!-- 첫 페이지라면 금지 표시 -->
	<li>
	<c:if test="${paging.curPage eq 1 }"> 
	<!--첫페이지일떄 -->	
      <a href="/board/pagingList.do"
       aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>	
	</c:if>
	<!-- 첫페이지가 아닐떄 -->
	<c:if test="${paging.curPage ne 1 }"> 
      <a href="/board/pagingList.do?curPage=${paging.curPage-1 }"
       aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>    
    </c:if>
    </li>
    <c:forEach begin="${paging.startPage }" 
    	end="${paging.endPage }"
    	var="page">
    	<c:if test="${paging.curPage eq page }">	
    	<li class="active">
    	</c:if>
    	<c:if test="${paging.curPage ne page}">
    	<li>
    	</c:if>
    	<a href="/board/pagingList.do?curPage=${page }">
    		${page }
    	</a>
    	</li>   	
    </c:forEach>
    <li>
    <c:if test="${paging.curPage ne paging.totalPage }"> 
	<!--마지막 페이지 아닐때 -->	
      <a href="/board/pagingList.do?curPage=${paging.curPage+1 }"
       aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>	
	</c:if>
	<!-- 마지막 페이지 일때-->
	<c:if test="${paging.curPage eq paging.totalPage }"> 
      <a href="/board/pagingList.do?curPage=${paging.totalPage}"
       aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>    
    </c:if>
    </li>
  </ul>
</nav>
</div>

</body>
</html>