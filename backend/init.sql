create database IF NOT EXISTS `meetdoc` collate utf8mb4_general_ci;
create user 'ssafy'@'%' identified by 'ssafy';
grant all privileges on *.* to ssafy@'%';
flush privileges;