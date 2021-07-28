CREATE OR REPLACE FUNCTION submitFeedback(     
        p_user_id IN feedback.USER_ID%TYPE,
        p_feedback_message IN feedback.FEEDBACK_MESSAGE%TYPE)
RETURN FEEDBACK.F_ID%TYPE IS
    p_f_id FEEDBACK.F_ID%TYPE;
BEGIN
    p_f_id := f_id.NEXTVAL;
    INSERT INTO feedback("USER_ID","F_ID","FEEDBACK_MESSAGE")
    VALUES (p_user_id,p_f_id,p_feedback_message);
    COMMIT;
    RETURN p_f_id;
END;