package com.xiaoyi.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 * Created by 小逸 on 2020/8/11.
 *
 * @author 小逸
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private  final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);


    @ExceptionHandler({Exception.class})
    public ModelAndView exceptionHandler(HttpServletRequest request , Exception e) throws Exception {
        logger.error("Request URL: {}, Exception : {}",request.getRequestURL(),e );
        // 根据异常和返回状态判断，没有返回状态的话，交给spring异常处理
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");

        return modelAndView;
    }

}
