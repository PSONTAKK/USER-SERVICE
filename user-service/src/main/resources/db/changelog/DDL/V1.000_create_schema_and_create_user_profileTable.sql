DO $$
BEGIN
    IF NOT EXISTS (
        SELECT schema_name
        FROM information_schema.schemata
        WHERE schema_name = 'users'
    ) THEN
        CREATE SCHEMA users;
    END IF;
END
$$;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT *
        FROM information_schema.tables
        WHERE table_schema = 'users'
        AND table_name = 'user_profile'
    ) THEN
        CREATE TABLE users.user_profile (
            id BIGINT NOT NULL PRIMARY KEY,
            ref_no VARCHAR(50) NOT NULL,
            user_name VARCHAR(10),
            user_mobile_no VARCHAR(10),
            user_email VARCHAR(80),
            is_active BOOLEAN,
            password VARCHAR(50),
            referal varchar(50),
            created_date TIMESTAMP,
            created_by VARCHAR(50),
            updated_date TIMESTAMP,
            updated_by VARCHAR(50)
        );
    END IF;
END $$;
