INSERT INTO PRODUCT (ID_PRODUCT, NAME, DESCRIPTION) VALUES (1, 'produto_1', 'First product.');
INSERT INTO PRODUCT (ID_PRODUCT, NAME, DESCRIPTION) VALUES (2, 'produto_2', 'Second product');
INSERT INTO PRODUCT (ID_PRODUCT, NAME, DESCRIPTION) VALUES (3, 'produto_3', 'Third product');
INSERT INTO PRODUCT (ID_PRODUCT, NAME, DESCRIPTION, ID_PARENT) VALUES (4, 'produto_4', 'Fourth product', 2);
INSERT INTO IMAGE (ID_IMAGE, ID_PRODUCT, DESCRIPTION) VALUES (1, 4, 'Auto description');
