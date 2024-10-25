USE DB2023Team03;


-- DB2023_bookmark 테이블의 인덱스 제거
DROP INDEX idx_bookmark_id ON DB2023_bookmark;
DROP INDEX idx_bookmark_theme ON DB2023_bookmark;

-- DB2023_menu 테이블의 인덱스 제거
ALTER TABLE DB2023_menu DROP FOREIGN KEY db2023_menu_ibfk_1;
DROP INDEX idx_menu_num_registed ON DB2023_menu;
DROP INDEX idx_menu_eating_id ON DB2023_menu;


DROP TABLE DB2023_bookmark;
DROP TABLE DB2023_menu;
DROP TABLE DB2023_eating;
DROP TABLE DB2023_festival;
DROP TABLE DB2023_entertainment_korea;

drop view DB2023_cheap_eating;
drop view DB2023_high_score_eating;

drop database DB2023Team03;