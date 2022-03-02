INSERT INTO CARGOS (id,nombre_cargo) values (1,'ADMINISTRADOR');
INSERT INTO CARGOS (id,nombre_cargo) values (2,'SOPORTE');
INSERT INTO CARGOS (id,nombre_cargo) values (3,'ASESOR DE VENTAS');

INSERT INTO USUARIOS (id,username,nombre,edad,cargo,fecha_ingreso) values (1,'ADMIN','JUAN JIMENEZ','23',1,CURRENT_DATE);
INSERT INTO USUARIOS (id,username,nombre,edad,cargo,fecha_ingreso) values (2,'USER','PEDRO GONZALES','25',2,CURRENT_DATE);
INSERT INTO USUARIOS (id,username,nombre,edad,cargo,fecha_ingreso) values (3,'USER2','OSCAR PARRA','27',3,CURRENT_DATE);

INSERT INTO ARTICULOS (id,nombre,producto,cantidad,fecha_ing,fecha_act,username_ing,username_act) values (1, 'ACEITE MOBIL 20W 50', 'ACEITE', '5', CURRENT_DATE, CURRENT_DATE,1,1);
INSERT INTO ARTICULOS (id,nombre,producto,cantidad,fecha_ing,fecha_act,username_ing,username_act) values (2, 'ACEITE MOBIL 10W 50', 'ACEITE', '4', CURRENT_DATE, CURRENT_DATE,1,1);
INSERT INTO ARTICULOS (id,nombre,producto,cantidad,fecha_ing,fecha_act,username_ing,username_act) values (3, 'ACEITE MOTUL 20W 50', 'ACEITE', '20', CURRENT_DATE, CURRENT_DATE,1,1);
INSERT INTO ARTICULOS (id,nombre,producto,cantidad,fecha_ing,fecha_act,username_ing,username_act) values (4, 'ACEITE MOTUL 10W 50', 'ACEITE', '6', CURRENT_DATE, CURRENT_DATE,1,1);
INSERT INTO ARTICULOS (id,nombre,producto,cantidad,fecha_ing,fecha_act,username_ing,username_act) values (5, 'LLANTA MICHELLIN 265/65 R17', 'LLANTA', '30', CURRENT_DATE, CURRENT_DATE,2,2);
INSERT INTO ARTICULOS (id,nombre,producto,cantidad,fecha_ing,fecha_act,username_ing,username_act) values (6, 'LLANTA CONTROL 265/65 R17', 'LLANTA', '25', CURRENT_DATE, CURRENT_DATE,2,2);