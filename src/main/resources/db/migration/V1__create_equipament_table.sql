CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE equipaments (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    issue VARCHAR(250) NOT NULL,
    equipamenttype VARCHAR(100) NOT NULL,
    status VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);