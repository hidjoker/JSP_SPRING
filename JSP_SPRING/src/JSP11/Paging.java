package JSP11;

public class Paging {
	private int curPage;	//?˜„?¬ ?˜?´ì§? ë²ˆí˜¸ (?˜„?¬ ?„ ?ƒ?•œ ?˜?´ì§?)

	private int totalCount;	//ì´? ê²Œì‹œê¸? ?ˆ˜ (DB ì¡°íšŒ ê²°ê³¼ë¡? ?–»?–´?˜´)
	private int listCount;	//?•œ ?˜?´ì§??‹¹ ì¶œë ¥?  ê²Œì‹œê¸? ?ˆ˜ (ì§ì ‘ ?„¤? •?•¨)
	private int totalPage;	//ì´? ?˜?´ì§? ?ˆ˜ (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)

	private int pageCount;	//?•œ ?™”ë©´ì— ì¶œë ¥?  ?˜?´ì§? ?ˆ˜ (ì§ì ‘ ?„¤? •?•¨)
	private int startPage;	//?™”ë©´ì— ë³´ì´?Š” ?‹œ?‘ ?˜?´ì§? (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	private int endPage;	//?™”ë©´ì— ë³´ì´?Š” ? ?˜?´ì§? (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	
	private int startNo;	//ê²Œì‹œë¬¼ë¦¬?Š¤?Š¸ ì²? ë²ˆí˜¸
	private int endNo;	//ê²Œì‹œë¬¼ë¦¬?Š¤?Š¸ ë§ˆì?ë§? ë²ˆí˜¸
	
	// ì´? ê²Œì‹œê¸? ?ˆ˜ë§? ?…? ¥?•˜?Š” ?ƒ?„±?
	//	curPage == 1
	//	pageCount == 10
	//	listCount == 10
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		makePaging();
	}

	// ì´? ê²Œì‹œê¸? ?ˆ˜?? ?˜„?¬ ?˜?´ì§?ë¥? ?…? ¥?•˜?Š” ?ƒ?„±?
	//	pageCount == 10
	//	listCount == 10
	public Paging(int totalCount, int curPage) {
		this(totalCount);
		this.setCurPage(curPage);
		
		makePaging();
	}

	// ì´? ê²Œì‹œê¸? ?ˆ˜?? ?˜„?¬ ?˜?´ì§?, ë³´ì—¬ì§??Š” ê²Œì‹œê¸? ?ˆ˜ë¥? ?…? ¥?•˜?Š” ?ƒ?„±?
	//	listCount == 10
	public Paging(int totalCount, int curPage, int listCount) {
		this(totalCount, curPage);
		this.setListCount(listCount);
		
		makePaging();
	}

	// ì´? ê²Œì‹œê¸? ?ˆ˜?? ?˜„?¬ ?˜?´ì§?, ë³´ì—¬ì§??Š” ê²Œì‹œê¸? ?ˆ˜, ?˜?´ì§? ?ˆ˜ë¥? ?…? ¥?•˜?Š” ?ƒ?„±?
	//	listCount == 10
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this(totalCount, curPage, listCount);
		this.setPageCount(pageCount);
		
		makePaging();
	}

	// ?˜?´ì§? ? •ë³? ?ƒ?„±
	private void makePaging() {
		if(totalCount == 0)	return; //ê²Œì‹œê¸??´ ?—†?Š” ê²½ìš°
		if(curPage == 0)	setCurPage(1);	//ê¸°ë³¸ê°’ìœ¼ë¡? ì²? ?˜?´ì§?(1) ?„¸?Œ…
		if(pageCount == 0)	setPageCount(10); //?•œ ?™”ë©´ì— ë³´ì´?Š” ?˜?´ì§??ˆ˜ ê¸°ë³¸ê°?(10) ?„¸?Œ…
		if(listCount == 0)	setListCount(10); //?•œ ?™”ë©´ì— ë³´ì´?Š” ê²Œì‹œê¸??ˆ˜ ê¸°ë³¸ê°?(10) ?„¸?Œ…
		
		// ì´? ?˜?´ì§??ˆ˜ ê³„ì‚°
		totalPage = totalCount / listCount;
		if( totalCount % listCount > 0 )	totalPage++;

		// ?˜„?¬ ?˜?´ì§?ê°? ì´? ?˜?´ì§?ë³´ë‹¤ ?¬ê²? ?…? ¥?˜ë©?
		// ê°•ì œë¡? ë§ˆì?ë§‰í˜?´ì§? ê³ ì •
		if (totalPage < curPage)	curPage = totalPage;
		
		
		// ?™”ë©´ì— ë³´ì¼ ?‹œ?‘ ?˜?´ì§? & ? ?˜?´ì§? ?„¤? • 
		startPage = ((curPage-1)/pageCount)*pageCount+1;
		endPage = startPage+pageCount-1;

		// ê³„ì‚°?œ ë§ˆì?ë§? ?˜?´ì§?ê°? totalPageë³´ë‹¤ ì»¤ì§ˆ ê²½ìš°
		// ê°•ì œë¡? ìµœì¢… ?˜?´ì§?ê¹Œì?ë§? ë³´ì´?„ë¡? ?„¤? •
		if(endPage > totalPage)	endPage = totalPage;
		
		
		// ê²Œì‹œê¸? ?‹œ?‘ë²ˆí˜¸
		startNo = (curPage-1)*listCount+1;
		// ê²Œì‹œê¸? ?ë²ˆí˜¸
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
