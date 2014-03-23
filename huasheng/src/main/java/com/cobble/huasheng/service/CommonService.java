package com.cobble.huasheng.service;

import java.util.List;
/**
 * TDTO dto type
 * STDTO search ${TYPE} dto
 * @author publiclzhc@sina.com
 *
 * @param <TDTO>
 * @param <STDTO>
 */
public interface CommonService<TDTO, STDTO> {
	public void create(TDTO tDTO) throws Exception;
	public void update(TDTO tDTO) throws Exception;
	public List<TDTO> finds(STDTO stDTO) throws Exception;
	public List<TDTO> finds(STDTO stDTO, int start, int limit) throws Exception;
	public TDTO findById(Long id) throws Exception;
	public long getCount(STDTO stDTO) throws Exception;
	public void delete(TDTO tDTO)  throws Exception;
}
