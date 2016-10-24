package com.hwang.employee.controller;

import com.hwang.employee.dto.PageDto;

public class PageController {
	public PageController() {

	}
	
	public PageDto PageControll(int totalRecord, int numPerPage, int pagePerBlock, int curPage ){
		int totalPage = 0;
		
		if(totalRecord != 0){
			if(totalRecord % numPerPage == 0){
				totalPage = totalRecord / numPerPage;
			}else{
				totalPage = totalRecord / numPerPage + 1;
			}
		}
		
		if(curPage== 0){
			curPage = 1;
		}

		int curblock = 1;
		
		if(curPage % pagePerBlock == 0){
			curblock = curPage / pagePerBlock;
		}else{
			curblock = curPage / pagePerBlock + 1;
		}
		
		int firstPage = (curblock -1) * pagePerBlock +1;
		int lastPage = curblock * pagePerBlock;
		
		int totalBlock = 0;
		
		if(totalPage > 0){
			if(totalPage % pagePerBlock == 0){
				totalBlock = totalPage / pagePerBlock;
			}else{
				totalBlock = totalPage / pagePerBlock + 1;
			}
		}
		
		int prevPage = 0;
		if(curblock > 1){
			prevPage = firstPage -1;
		}
		
		if(curblock >= totalBlock){
			lastPage = totalPage;
		}
		
		int nextPage = 0;
		if(curblock < totalBlock){
			nextPage = lastPage +1;
		}
		
		
		
		PageDto pDto = new PageDto();
		pDto.setFirstPage(firstPage);
		pDto.setLastPage(lastPage);
		pDto.setNextPage(nextPage);
		pDto.setPrevPage(prevPage);
		
		return pDto;
	}
}
