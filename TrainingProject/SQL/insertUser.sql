CREATE OR REPLACE FUNCTION insertUSER1(
        p_name IN USER1.name%TYPE,
        p_phone_no IN USER1.phone_no%TYPE,
        p_email IN USER1.email%TYPE,
        p_address IN USER1.address%TYPE,
        p_reg_date IN USER1.reg_date%TYPE,
        p_password IN USER1.password%TYPE,
        p_upload_photo IN USER1.upload_photo%TYPE)
RETURN USER1.USER_ID%TYPE IS
    p_userid USER1.USER_ID%TYPE;
BEGIN
    p_userid := userid.nextval;  
    INSERT INTO USER1 ("USER_ID", "NAME", "PHONE_NO","EMAIL", "ADDRESS", "REG_DATE", "PASSWORD", "UPLOAD_PHOTO") 
    VALUES (p_userid, p_name,p_phone_no, p_email,p_address,p_reg_date,p_password,p_upload_photo);
    COMMIT;
    RETURN p_userid;
END;