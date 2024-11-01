CREATE TABLE `e-commerce`.address
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    title         VARCHAR(255) NULL,
    address       VARCHAR(255) NULL,
    city          VARCHAR(255) NULL,
    country       VARCHAR(255) NULL,
    postal_code   VARCHAR(255) NULL,
    landmark      VARCHAR(255) NULL,
    phone_number  VARCHAR(255) NULL,
    user_id       BIGINT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.cart_item_product_sku
(
    cart_item_id   BIGINT NOT NULL,
    product_sku_id BIGINT NOT NULL,
    CONSTRAINT pk_cartitem_productsku PRIMARY KEY (cart_item_id, product_sku_id)
);

CREATE TABLE `e-commerce`.cart_items
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    cart_id       BIGINT NULL,
    product_id    BIGINT NULL,
    quantity      INT NULL,
    CONSTRAINT pk_cart_items PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.carts
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    total DOUBLE NULL,
    user_id       BIGINT NULL,
    CONSTRAINT pk_carts PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.categories
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.order_details
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    user_id       BIGINT NULL,
    total         DECIMAL NULL,
    CONSTRAINT pk_order_details PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.order_item
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    order_id      BIGINT NULL,
    product_id    BIGINT NULL,
    quantity      INT NULL,
    CONSTRAINT pk_order_item PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.order_product_sku
(
    order_item_id  BIGINT NOT NULL,
    product_sku_id BIGINT NOT NULL,
    CONSTRAINT pk_order_productsku PRIMARY KEY (order_item_id, product_sku_id)
);

CREATE TABLE `e-commerce`.payment_details
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_date    datetime NOT NULL,
    modified_date   datetime NULL,
    deleted_date    datetime NULL,
    order_detail_id BIGINT NULL,
    amount          DECIMAL NULL,
    provider        VARCHAR(255) NULL,
    status          BIT(1) NULL,
    CONSTRAINT pk_payment_details PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.permission
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    name          VARCHAR(255) NULL,
    code          VARCHAR(255) NULL,
    CONSTRAINT pk_permission PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.product_attributes
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    type          SMALLINT NULL,
    value         VARCHAR(255) NULL,
    CONSTRAINT pk_product_attributes PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.product_sku_attribute
(
    product_attribute_id BIGINT NOT NULL,
    product_sku_id       BIGINT NOT NULL,
    CONSTRAINT pk_productsku_attribute PRIMARY KEY (product_attribute_id, product_sku_id)
);

CREATE TABLE `e-commerce`.products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    summary       VARCHAR(255) NULL,
    cover         VARCHAR(255) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.products_skus
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    product_id    BIGINT NULL,
    sku           VARCHAR(255) NULL,
    quantity      INT NULL,
    price         DECIMAL NULL,
    CONSTRAINT pk_products_skus PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.role_permissions
(
    permission_id BIGINT NOT NULL,
    role_id       BIGINT NOT NULL,
    CONSTRAINT pk_role_permissions PRIMARY KEY (permission_id, role_id)
);

CREATE TABLE `e-commerce`.roles
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    name          VARCHAR(255) NULL,
    code          VARCHAR(255) NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.sub_categories
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    parent_id     BIGINT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_sub_categories PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.sub_category_product
(
    product_id      BIGINT NOT NULL,
    sub_categroy_id BIGINT NOT NULL,
    CONSTRAINT pk_sub_category_product PRIMARY KEY (product_id, sub_categroy_id)
);

CREATE TABLE `e-commerce`.user_roles
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_roles PRIMARY KEY (role_id, user_id)
);

CREATE TABLE `e-commerce`.users
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    profile       VARCHAR(255) NULL,
    first_name    VARCHAR(255) NULL,
    last_name     VARCHAR(255) NULL,
    user_name     VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    phone_number  VARCHAR(255) NULL,
    dob           date NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE `e-commerce`.wish_lists
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_date  datetime NOT NULL,
    modified_date datetime NULL,
    deleted_date  datetime NULL,
    user_id       BIGINT NULL,
    product_id    BIGINT NULL,
    CONSTRAINT pk_wish_lists PRIMARY KEY (id)
);

ALTER TABLE `e-commerce`.order_details
    ADD CONSTRAINT uc_order_details_user UNIQUE (user_id);

ALTER TABLE `e-commerce`.payment_details
    ADD CONSTRAINT uc_payment_details_orderdetail UNIQUE (order_detail_id);

ALTER TABLE `e-commerce`.cart_item_product_sku
    ADD CONSTRAINT fk_cariteprosku_on_product_sku_entity FOREIGN KEY (product_sku_id) REFERENCES `e-commerce`.products_skus (id);

ALTER TABLE `e-commerce`.order_product_sku
    ADD CONSTRAINT fk_ordprosku_on_product_sku_entity FOREIGN KEY (product_sku_id) REFERENCES `e-commerce`.products_skus (id);

ALTER TABLE `e-commerce`.product_sku_attribute
    ADD CONSTRAINT fk_proskuatt_on_product_sku_entity FOREIGN KEY (product_sku_id) REFERENCES `e-commerce`.products_skus (id);

ALTER TABLE `e-commerce`.role_permissions
    ADD CONSTRAINT fk_rolper_on_permission_entity FOREIGN KEY (permission_id) REFERENCES `e-commerce`.permission (id);

ALTER TABLE `e-commerce`.role_permissions
    ADD CONSTRAINT fk_rolper_on_role_entity FOREIGN KEY (role_id) REFERENCES `e-commerce`.roles (id);

ALTER TABLE `e-commerce`.user_roles
    ADD CONSTRAINT fk_userol_on_role_entity FOREIGN KEY (role_id) REFERENCES `e-commerce`.roles (id);

ALTER TABLE `e-commerce`.user_roles
    ADD CONSTRAINT fk_userol_on_user_entity FOREIGN KEY (user_id) REFERENCES `e-commerce`.users (id);