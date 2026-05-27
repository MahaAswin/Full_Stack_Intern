package com.eduhub.eduhub_backend.exception;

public class ResourseNotFoundException extends RuntimeException{
    public ResourseNotFoundException(String resourse,String field,String error){
        super(String.format("%s not found with %s : %s",resourse,field,error));
    }
}
