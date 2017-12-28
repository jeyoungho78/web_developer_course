package com.example.spring.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CommonInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

	//��Ʈ�ѷ��� ����Ǳ� ���� ����Ǵ� �ڵ�
	//���ϰ��� true : ��û�� ��Ʈ�ѷ� ����
	//���ϰ��� false : ��û�� ��Ʈ�ѷ��� �������� �ʰ� ����
	//�̰����� ���������� ��Ʈ�ѷ��� ����Ǳ� ���� �ʼ������� Ȯ�ε� �ڵ尡 ����. ��: �α��ο��� 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("CommonInterceptor preHandle ����");
		
		return true;
	}

	//��(jsp) �̵� �ٷ����� ����
	//��Ʈ�ѷ����� ������ �߻��ÿ��� ������� ����.
	//request.setAttribute("",) �̷� ������ ���� ���� �� ��� 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("CommonInterceptor postHandle ����");
		
		//modelAndView.addObject("endData", "postHandle Data");
		
		request.setAttribute("endData", "postHandle Data");
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		logger.info("CommonInterceptor afterCompletion ����");
		
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	
}
