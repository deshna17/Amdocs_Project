CREATE OR REPLACE FUNCTION addCOURSE(
        p_course_name IN COURSE.C_NAME%TYPE,
        p_course_desp IN COURSE.C_DESP%TYPE,
        p_course_fees IN COURSE.C_FEES%TYPE,
        p_course_resource IN COURSE.C_RESOURCE%TYPE)
RETURN COURSE.course_id%TYPE IS
    p_course_id COURSE.course_id%TYPE;
BEGIN
    p_course_id := course_id.nextval;  
    INSERT INTO COURSE ("COURSE_ID","C_NAME","C_DESP","C_FEES","C_RESOURCE") 
    VALUES (p_course_id,p_course_name,p_course_desp,p_course_fees,p_course_resource);
    COMMIT;
    RETURN p_course_id;
END;