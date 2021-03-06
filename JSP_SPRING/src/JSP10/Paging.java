package JSP10;

public class Paging {
	private int curPage;	//??¬ ??΄μ§? λ²νΈ (??¬ ? ?? ??΄μ§?)

	private int totalCount;	//μ΄? κ²μκΈ? ? (DB μ‘°ν κ²°κ³Όλ‘? ?»?΄?΄)
	private int listCount;	//? ??΄μ§??Ή μΆλ ₯?  κ²μκΈ? ? (μ§μ  ?€? ?¨)
	private int totalPage;	//μ΄? ??΄μ§? ? (κ³μ°?Όλ‘? ???)

	private int pageCount;	//? ?λ©΄μ μΆλ ₯?  ??΄μ§? ? (μ§μ  ?€? ?¨)
	private int startPage;	//?λ©΄μ λ³΄μ΄? ?? ??΄μ§? (κ³μ°?Όλ‘? ???)
	private int endPage;	//?λ©΄μ λ³΄μ΄? ? ??΄μ§? (κ³μ°?Όλ‘? ???)
	
	private int startNo;	//κ²μλ¬Όλ¦¬?€?Έ μ²? λ²νΈ
	private int endNo;	//κ²μλ¬Όλ¦¬?€?Έ λ§μ?λ§? λ²νΈ
	
	// μ΄? κ²μκΈ? ?λ§? ?? ₯?? ??±?
	//	curPage == 1
	//	pageCount == 10
	//	listCount == 10
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		makePaging();
	}

	// μ΄? κ²μκΈ? ??? ??¬ ??΄μ§?λ₯? ?? ₯?? ??±?
	//	pageCount == 10
	//	listCount == 10
	public Paging(int totalCount, int curPage) {
		this(totalCount);
		this.setCurPage(curPage);
		
		makePaging();
	}

	// μ΄? κ²μκΈ? ??? ??¬ ??΄μ§?, λ³΄μ¬μ§?? κ²μκΈ? ?λ₯? ?? ₯?? ??±?
	//	listCount == 10
	public Paging(int totalCount, int curPage, int listCount) {
		this(totalCount, curPage);
		this.setListCount(listCount);
		
		makePaging();
	}

	// μ΄? κ²μκΈ? ??? ??¬ ??΄μ§?, λ³΄μ¬μ§?? κ²μκΈ? ?, ??΄μ§? ?λ₯? ?? ₯?? ??±?
	//	listCount == 10
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this(totalCount, curPage, listCount);
		this.setPageCount(pageCount);
		
		makePaging();
	}

	// ??΄μ§? ? λ³? ??±
	private void makePaging() {
		if(totalCount == 0)	return; //κ²μκΈ??΄ ?? κ²½μ°
		if(curPage == 0)	setCurPage(1);	//κΈ°λ³Έκ°μΌλ‘? μ²? ??΄μ§?(1) ?Έ?
		if(pageCount == 0)	setPageCount(10); //? ?λ©΄μ λ³΄μ΄? ??΄μ§?? κΈ°λ³Έκ°?(10) ?Έ?
		if(listCount == 0)	setListCount(10); //? ?λ©΄μ λ³΄μ΄? κ²μκΈ?? κΈ°λ³Έκ°?(10) ?Έ?
		
		// μ΄? ??΄μ§?? κ³μ°
		totalPage = totalCount / listCount;
		if( totalCount % listCount > 0 )	totalPage++;

		// ??¬ ??΄μ§?κ°? μ΄? ??΄μ§?λ³΄λ€ ?¬κ²? ?? ₯?λ©?
		// κ°μ λ‘? λ§μ?λ§ν?΄μ§? κ³ μ 
		if (totalPage < curPage)	curPage = totalPage;
		
		
		// ?λ©΄μ λ³΄μΌ ?? ??΄μ§? & ? ??΄μ§? ?€?  
		startPage = ((curPage-1)/pageCount)*pageCount+1;
		endPage = startPage+pageCount-1;

		// κ³μ°? λ§μ?λ§? ??΄μ§?κ°? totalPageλ³΄λ€ μ»€μ§ κ²½μ°
		// κ°μ λ‘? μ΅μ’ ??΄μ§?κΉμ?λ§? λ³΄μ΄?λ‘? ?€? 
		if(endPage > totalPage)	endPage = totalPage;
		
		
		// κ²μκΈ? ??λ²νΈ
		startNo = (curPage-1)*listCount+1;
		// κ²μκΈ? ?λ²νΈ
		endNo = curPage*listCount;
	}


	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	@Override
	public String toString() {
		return "curPage="+curPage+
				", totalCount="+totalCount+
				", listCount="+listCount+
				", totalPage="+totalPage+
				", pageCount="+pageCount+
				", startPage="+startPage+
				", endPage="+endPage+"]";
	}
}
