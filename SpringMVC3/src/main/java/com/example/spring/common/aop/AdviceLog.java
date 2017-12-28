package com.example.spring.common.aop;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AdviceLog {
	private static final Logger logger = LoggerFactory.getLogger(AdviceLog.class);

    //���������� ����Ǿ�� �� ����Ͻ� ���� �޼ҵ�
//	@Around("within(com.example.spring..*)")
    public Object processTimeCheck(ProceedingJoinPoint proceedingJoinPoint){
    	
    	String name = proceedingJoinPoint.getSignature().toLongString();
    	logger.debug(name + " is start >>> ");
    	long startTime = System.currentTimeMillis();
    	
    	Object obj = null;
    	
		try {
			obj = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			long endTime = System.currentTimeMillis();
			logger.debug(name + " is finish >>> ");
			logger.debug(name + " �������ð�" + (endTime - startTime));
		}
    	
    	return obj;
    }
	
	//spring���� ����Ͻ������Լ�, �Ű�����, ������ ������ �ִ� ��ü
    //@Before("within(com.example.spring..*)")
    //@Before("within(com.example.spring.service.*)")
    //@After("within(com.example.spring.service.*)")
    
    /* execution([����������] [����Ÿ��] [Ŭ����] [�Լ��̸�] [�Ķ����])
     * '*'  : ��� ���� �ǹ� 
     * '..' : 1�� �̻��� �ǹ�
     * ��) 
     *   1)com.example.spring ��Ű�������� �Ķ���Ͱ� �������� �ʴ� �Լ��� �����϶� 
     *     execution(* com.example.spring.*.*())
     *     
     *   2)com.example.spring �Ϻ� ��Ű������ �Ķ���Ͱ� 1�� �̻��� �Լ�
     *     execution(* com.example.spring..*.*(..)) 
     *   
     *   3)com.example.spring.service ��Ű������ �Լ����� paramView�̸鼭 �Ķ���Ͱ� 1���̻��� ��
     *     execution(* com.example.spring.service.paramView(..))
     *   
     *   4)param���� ���۵Ǵ� �Լ��߿� �Ķ���Ͱ����� 1���̻��ΰͿ� ����
     *     execution(* param*(..))
     *   
     *   5)param���� ���۵Ǵ� �Լ��߿� �Ķ���Ͱ����� 1�����Լ����� ����
     *     execution(* param*(*))
     *   
     *   6)param���� ���۵Ǵ� �Լ��߿� �Ķ���Ͱ����� 2�����Լ����� ����
     *     execution(* param*(*, *))
     *      �� execution(String param*(*, *)) --> return�� String�� 
     *   
     *   7)param���� ���۵Ǵ� �Լ��߿� �Ķ���� ������ Ÿ���� String�̸鼭 �Ķ���͸� 2���� �޴� �Լ����� ����
     *     execution(* param*(String, *))
     *      �� execution(* param*(int, ..)) --> 2��° �Ķ���Ͱ� 1���̻��� �� 
     *      �� execution(* *list(..))       --> �Լ����� list�� ������ �� �߿� �Ķ���Ͱ� 1�� �̻��� �� ����  
     *     
     */
    //@After("execution(* com.example.spring.service.*.*())") 		// ����ȵ�
    //@After("execution(* com.example.spring..*.*(..))") 			// ��Ű�� �ؿ� ��� �Լ�
    @AfterThrowing("execution(* com.example.spring..*.*(..))") 		// ������ ���� �� ����
	public void beforeTest(JoinPoint joinPoint) {
		Signature method = joinPoint.getSignature();
		
		String methodName = method.getName();
		logger.debug("�Լ���:" + methodName);
		
		Object[] params = joinPoint.getArgs();	
	
		for(Object param : params) {
			if(param instanceof HashMap) {
				HashMap<String, Object> map = (HashMap)param;
				for(String key : map.keySet()) {
					logger.debug("key:" + key + ", value : " + map.get(key));
				}
			} else if (param instanceof List) {
				List<String> list = (List)param;
				for(String value : list) {
					logger.debug("value:" + value);
				}
			}
			
		}
		
		
	}
}
