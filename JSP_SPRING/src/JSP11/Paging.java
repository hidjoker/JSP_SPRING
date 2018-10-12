package JSP11;

public class Paging {
	private int curPage;	//?��?�� ?��?���? 번호 (?��?�� ?��?��?�� ?��?���?)

	private int totalCount;	//�? 게시�? ?�� (DB 조회 결과�? ?��?��?��)
	private int listCount;	//?�� ?��?���??�� 출력?�� 게시�? ?�� (직접 ?��?��?��)
	private int totalPage;	//�? ?��?���? ?�� (계산?���? ?��?��?��)

	private int pageCount;	//?�� ?��면에 출력?�� ?��?���? ?�� (직접 ?��?��?��)
	private int startPage;	//?��면에 보이?�� ?��?�� ?��?���? (계산?���? ?��?��?��)
	private int endPage;	//?��면에 보이?�� ?�� ?��?���? (계산?���? ?��?��?��)
	
	private int startNo;	//게시물리?��?�� �? 번호
	private int endNo;	//게시물리?��?�� 마�?�? 번호
	
	// �? 게시�? ?���? ?��?��?��?�� ?��?��?��
	//	curPage == 1
	//	pageCount == 10
	//	listCount == 10
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		makePaging();
	}

	// �? 게시�? ?��?? ?��?�� ?��?���?�? ?��?��?��?�� ?��?��?��
	//	pageCount == 10
	//	listCount == 10
	public Paging(int totalCount, int curPage) {
		this(totalCount);
		this.setCurPage(curPage);
		
		makePaging();
	}

	// �? 게시�? ?��?? ?��?�� ?��?���?, 보여�??�� 게시�? ?���? ?��?��?��?�� ?��?��?��
	//	listCount == 10
	public Paging(int totalCount, int curPage, int listCount) {
		this(totalCount, curPage);
		this.setListCount(listCount);
		
		makePaging();
	}

	// �? 게시�? ?��?? ?��?�� ?��?���?, 보여�??�� 게시�? ?��, ?��?���? ?���? ?��?��?��?�� ?��?��?��
	//	listCount == 10
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this(totalCount, curPage, listCount);
		this.setPageCount(pageCount);
		
		makePaging();
	}

	// ?��?���? ?���? ?��?��
	private void makePaging() {
		if(totalCount == 0)	return; //게시�??�� ?��?�� 경우
		if(curPage == 0)	setCurPage(1);	//기본값으�? �? ?��?���?(1) ?��?��
		if(pageCount == 0)	setPageCount(10); //?�� ?��면에 보이?�� ?��?���??�� 기본�?(10) ?��?��
		if(listCount == 0)	setListCount(10); //?�� ?��면에 보이?�� 게시�??�� 기본�?(10) ?��?��
		
		// �? ?��?���??�� 계산
		totalPage = totalCount / listCount;
		if( totalCount % listCount > 0 )	totalPage++;

		// ?��?�� ?��?���?�? �? ?��?���?보다 ?���? ?��?��?���?
		// 강제�? 마�?막페?���? 고정
		if (totalPage < curPage)	curPage = totalPage;
		
		
		// ?��면에 보일 ?��?�� ?��?���? & ?�� ?��?���? ?��?�� 
		startPage = ((curPage-1)/pageCount)*pageCount+1;
		endPage = startPage+pageCount-1;

		// 계산?�� 마�?�? ?��?���?�? totalPage보다 커질 경우
		// 강제�? 최종 ?��?���?까�?�? 보이?���? ?��?��
		if(endPage > totalPage)	endPage = totalPage;
		
		
		// 게시�? ?��?��번호
		startNo = (curPage-1)*listCount+1;
		// 게시�? ?��번호
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
