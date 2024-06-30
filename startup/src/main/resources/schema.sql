CREATE TABLE IF NOT EXISTS packing_list
(
    id   BINARY(16) PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Create the localization table
CREATE TABLE IF NOT EXISTS localization
(
    id              BINARY(16) PRIMARY KEY,
    city            VARCHAR(255) NOT NULL,
    country         VARCHAR(255) NOT NULL,
    packing_list_id BINARY(16),
    CONSTRAINT fk_packing_list FOREIGN KEY (packing_list_id) REFERENCES packing_list (id)
);

-- Create the packing_item table
CREATE TABLE IF NOT EXISTS packing_item
(
    id              BINARY(16) PRIMARY KEY,
    name            VARCHAR(255) NOT NULL,
    quantity        INT          NOT NULL,
    is_packed       BOOLEAN,
    packing_list_id BINARY(16),
    CONSTRAINT fk_packing_list_item FOREIGN KEY (packing_list_id) REFERENCES packing_list (id)
);