CREATE TABLE konex.medicamento (
     id INT NOT NULL AUTO_INCREMENT,
     nombre CHAR(90) NOT NULL,
     laboratorio_fabrica CHAR(90) NOT NULL,
     fecha_fabricacion DATE DEFAULT (CURRENT_DATE),
     fecha_vencimiento DATE DEFAULT (CURRENT_DATE),
     cantiad_stock INT NOT NULL,
     valor INT NOT NULL,
     PRIMARY KEY (ID)
);
CREATE TABLE konex.venta (
     id INT NOT NULL AUTO_INCREMENT,
     fecha DATE DEFAULT (CURRENT_DATE),
     cantidad INT NOT NULL,
     valor_unitario INT NOT NULL,
     valor_total INT NOT NULL,
     medicamento INT NOT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (medicamento) REFERENCES konex.medicamento(id)
);

DELIMITER $$
CREATE PROCEDURE konex.p_venta (IN p_id INT, IN p_cantidad INT)
BEGIN
	DECLARE v_id INT;
    DECLARE v_correcto INT;
    DECLARE v_cantiad_stock INT;
    DECLARE v_valor INT;
    DECLARE v_mensaje CHAR(60);
    SET v_id = 0;
    
    SELECT m.id, m.cantiad_stock, m.valor INTO v_id, v_cantiad_stock, v_valor FROM konex.medicamento as m WHERE m.id = p_id AND p_cantidad <=  m.cantiad_stock;
    
    IF v_id > 0 THEN
		START TRANSACTION;
			INSERT INTO konex.venta (cantidad, valor_unitario, valor_total, medicamento ) 
			VALUES (p_cantidad , v_valor, v_valor * p_cantidad, p_id);
			SET v_id = (select last_insert_id());
            
            UPDATE konex.medicamento SET cantiad_stock = cantiad_stock - p_cantidad WHERE id = p_id;
            SET v_mensaje = 'Correcto';
		COMMIT;
    ELSE 
		SET v_mensaje = 'la cantidad exede';
	END IF;
    SELECT v_id, v_mensaje; 
END$$
