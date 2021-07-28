CREATE OR REPLACE FUNCTION insertADMIN1(
        p_name IN ADMIN1.name%TYPE,
        p_email IN ADMIN1.email%TYPE,
        p_password IN ADMIN1.password%TYPE)
RETURN ADMIN1.ADMIN_ID%TYPE IS
    p_userid ADMIN1.ADMIN_ID%TYPE;
BEGIN
    p_userid := userid.nextval;  
    INSERT INTO ADMIN1 ("ADMIN_ID", "NAME","EMAIL", "PASSWORD") 
    VALUES (p_userid, p_name, p_email,p_password);
    COMMIT;
    RETURN p_userid;
END;