CREATE OR REPLACE FUNCTION enrollCOURSE(
        p_user_id IN ENROLL.enroll_id%TYPE,
        p_course_id IN ENROLL.course_id%TYPE)
RETURN ENROLL.ENROLL_ID%TYPE IS
    p_enroll_id ENROLL.ENROLL_ID%TYPE;
BEGIN
    p_enroll_id := enroll_id.nextval;  
    INSERT INTO ENROLL ("ENROLL_ID", "USER_ID","COURSE_ID") 
    VALUES (p_enroll_id, p_user_id, p_course_id);
    COMMIT;
    RETURN p_enroll_id;
END;