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

    //정상적으로 실행되어야 될 비즈니스 로직 메소드
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
			logger.debug(name + " 실행경과시간" + (endTime - startTime));
		}
    	
    	return obj;
    }
	
	//spring에서 비즈니스로직함수, 매개변수, 정보를 가지고 있는 객체
    //@Before("within(com.example.spring..*)")
    //@Before("within(com.example.spring.service.*)")
    //@After("within(com.example.spring.service.*)")
    
    /* execution([접근지정자] [리턴타입] [클래스] [함수이름] [파라미터])
     * '*'  : 모든 값을 의미 
     * '..' : 1개 이상을 의미
     * 예) 
     *   1)com.example.spring 패키지내에서 파라미터가 존재하지 않는 함수를 실행하라 
     *     execution(* com.example.spring.*.*())
     *     
     *   2)com.example.spring 하부 패키지에서 파라미터가 1개 이상인 함수
     *     execution(* com.example.spring..*.*(..)) 
     *   
     *   3)com.example.spring.service 패키지내에 함수명이 paramView이면서 파라미터가 1개이상인 것
     *     execution(* com.example.spring.service.paramView(..))
     *   
     *   4)param으로 시작되는 함수중에 파라미터갯수가 1개이상인것에 적용
     *     execution(* param*(..))
     *   
     *   5)param으로 시작되는 함수중에 파라미터갯수가 1개인함수에서 적용
     *     execution(* param*(*))
     *   
     *   6)param으로 시작되는 함수중에 파라미터갯수가 2개인함수에서 적용
     *     execution(* param*(*, *))
     *      └ execution(String param*(*, *)) --> return이 String임 
     *   
     *   7)param으로 시작되는 함수중에 파라미터 데이터 타입이 String이면서 파라미터를 2개를 받는 함수에서 적용
     *     execution(* param*(String, *))
     *      └ execution(* param*(int, ..)) --> 2번째 파라미터가 1개이상인 것 
     *      └ execution(* *list(..))       --> 함수명이 list로 끝나는 것 중에 파라미터가 1개 이상인 것 적용  
     *     
     */
    //@After("execution(* com.example.spring.service.*.*())") 		// 실행안됨
    //@After("execution(* com.example.spring..*.*(..))") 			// 패키지 밑에 모든 함수
    @AfterThrowing("execution(* com.example.spring..*.*(..))") 		// 에러가 났을 때 실행
	public void beforeTest(JoinPoint joinPoint) {
		Signature method = joinPoint.getSignature();
		
		String methodName = method.getName();
		logger.debug("함수명:" + methodName);
		
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
