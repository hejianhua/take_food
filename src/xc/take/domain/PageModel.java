package xc.take.domain;

public class PageModel {
	
	//索引,也就是查询开始的地方
	private int pageIndex;
	
	//页码
	private int pageNumber;
	
	// 数据总数
	private int  totalCount;
	
	//页显示的数据条数
	private int  pageSize;
	
	//总页数
	private int pageCount;

	
	
	
	
	
	public int getPageIndex() {
		int _pageNumber= this.pageNumber;
		int _pageSize= this.pageSize;
		this.pageIndex=(_pageNumber-1)*_pageSize;
		
		
		return this.pageIndex;
	}


	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	
	}

	public int getPageSize() {
		
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
	}

	//总页数
	public int getPageCount() {
		int _totalCount=this.totalCount;
		int _pageSize=this.pageSize;
		if(_totalCount%_pageSize==0){
			this.pageCount = _totalCount/_pageSize;
		}else{
			this.pageCount = ((_totalCount/_pageSize)+1);
		}
		
		return this.pageCount;
	}	
}
