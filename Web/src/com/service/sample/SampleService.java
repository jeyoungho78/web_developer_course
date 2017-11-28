package com.service.sample;

import java.util.*;

import com.dao.sample.SampleDao;
import com.entity.sample.SampleEntity;

public class SampleService {
	
	public ArrayList getSampleList(SampleEntity sampleEntity) {
		// 데이터를 처리 및 가공
		/*SampleDao sDao = new SampleDao();
		ArrayList list = sDao.getSampleList(sampleEntity);
		
		return list;*/
		
		SampleDao sDao = new SampleDao();
		//sampleEntity.setDeptCode("10");
		//sampleEntity.setDeptName("간호학과");
		//ArrayList list = sDao.getSampleListIBatis(sampleEntity);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("deptCode", "10");
		
		ArrayList list = sDao.getSampleListIBatisMap(map);
		
		return list;
	}
	
	public ArrayList getSampleList(HashMap<String, String> sampleMap) {
		// 데이터를 처리 및 가공
		SampleDao sDao = new SampleDao();
		ArrayList list = sDao.getSampleList(sampleMap);
		
		return list;
	}

	public ArrayList getSampleAllList() {
		// 데이터를 처리 및 가공
		SampleDao sDao = new SampleDao();
		ArrayList list = sDao.getSampleAllList();
		
		return list;
	}
	
	public void insertSampleMap(HashMap<String, String> sampleMap) {
		// 데이터를 신규 입력
		SampleDao sDao = new SampleDao();
		sDao.insertSampleMap(sampleMap);
		
	}
	
	public int sampleInsertEnd(HashMap<String, String> map) {
		SampleDao sDao = new SampleDao();
		return sDao.sampleInsertEnd(map);
	}

	
}
