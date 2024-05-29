use ordersystem;
DELIMITER //
CREATE FUNCTION generate_random_string(length INT) RETURNS VARCHAR(255)
BEGIN
  DECLARE characters VARCHAR(255) DEFAULT '0123456789';
  DECLARE result VARCHAR(255) DEFAULT '';
  DECLARE i INT DEFAULT 0;

  WHILE i < length DO
    SET result = CONCAT(result, SUBSTRING(characters, FLOOR(RAND() * LENGTH(characters) + 1), 1));
    SET i = i + 1;
  END WHILE;

  RETURN result;
END //
DELIMITER ;