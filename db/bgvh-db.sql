DROP SCHEMA IF EXISTS `bgvh_crm_db`;

CREATE SCHEMA IF NOT EXISTS `bgvh_crm_db`
CHARACTER SET `utf8`;

USE `bgvh_crm_db` ;

CREATE TABLE `departments` (
  `pk_group_id` TINYINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `group_name` VARCHAR(255) NOT NULL
  );


CREATE TABLE `profile_positions` (
  `pk_position_id` TINYINT NOT NULL PRIMARY KEY,
  `position_name` VARCHAR(255) NULL DEFAULT NULL
);


CREATE TABLE `profile_statuses` (
  `pk_status_id` TINYINT NOT NULL PRIMARY KEY,
  `status_name` VARCHAR(255) NULL DEFAULT NULL
  );
  

CREATE TABLE `profiles` (
  `pk_profile_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `middle_name` VARCHAR(255) NOT NULL,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `fk_group_id` TINYINT NOT NULL,
  `fk_position_id` TINYINT NOT NULL,
  `fk_status_id` TINYINT NOT NULL,

  CONSTRAINT `fk_profile_to_group` FOREIGN KEY (`fk_group_id`) REFERENCES `departments` (`pk_group_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_profile_to_position` FOREIGN KEY (`fk_position_id`) REFERENCES `profile_positions` (`pk_position_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_profile_to_status` FOREIGN KEY (`fk_status_id`) REFERENCES `profile_statuses` (`pk_status_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    );


CREATE TABLE `task_project_statuses` (
  `pk_status_id` TINYINT NOT NULL PRIMARY KEY,
  `status_name` VARCHAR(255) NULL DEFAULT NULL
);


CREATE TABLE `projects` (
  `pk_project_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `project_name` VARCHAR(255) NULL DEFAULT NULL,
  `date_of_creation` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `date_of_end` DATETIME NULL DEFAULT NULL,
  `fk_group_id` TINYINT NOT NULL,
  `fk_profile_id` INTEGER NOT NULL,
  `fk_status_id` TINYINT NOT NULL,
  
  CONSTRAINT `fk_project_to_group` FOREIGN KEY (`fk_group_id`) REFERENCES `departments` (`pk_group_id`)
	ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_project_to_profile` FOREIGN KEY (`fk_profile_id`) REFERENCES `profiles` (`pk_profile_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_project_to_status` FOREIGN KEY (`fk_status_id`) REFERENCES `task_project_statuses` (`pk_status_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);



CREATE TABLE `projects_to_profiles` (
  `fk_profile_id` INTEGER NOT NULL,
  `fk_project_id` INTEGER NOT NULL,

  CONSTRAINT `profile_to_project` FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`pk_project_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `project_to_profile` FOREIGN KEY (`fk_profile_id`) REFERENCES `profiles` (`pk_profile_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
    );


CREATE TABLE `tasks` (
  `pk_task_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `task_name` VARCHAR(255) NULL DEFAULT NULL,
  `priority` TINYINT NOT NULL,
  `date_of_creation` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `date_of_end` DATETIME NULL DEFAULT NULL,
  `fk_project_id` INTEGER NOT NULL,
  `fk_profile_id` INTEGER,
  `fk_parent_task_id` INTEGER NULL DEFAULT NULL,
  `fk_status_id` TINYINT NULL DEFAULT NULL,
  
  CONSTRAINT `fk_task_to_profile` FOREIGN KEY (`fk_profile_id`) REFERENCES `profiles` (`pk_profile_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_task_to_project` FOREIGN KEY (`fk_project_id`) REFERENCES `projects` (`pk_project_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_task_to_status` FOREIGN KEY (`fk_status_id`) REFERENCES `task_project_statuses` (`pk_status_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
    
  CONSTRAINT `fk_task_to_task` FOREIGN KEY (`fk_parent_task_id`) REFERENCES `tasks` (`pk_task_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);


CREATE TABLE `tasktime` (
  `pk_tasktime_id` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `start_task` TIMESTAMP NULL DEFAULT NULL,
  `finish_task` TIMESTAMP NULL DEFAULT NULL,
  `fk_task_id` INTEGER NOT NULL,
  
  CONSTRAINT `fk_tasktime_to_task` FOREIGN KEY (`fk_task_id`) REFERENCES `tasks` (`pk_task_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);




INSERT INTO `profile_positions` (`pk_position_id`, `position_name`) VALUES ('6', 'Инженер');
INSERT INTO `profile_positions` (`pk_position_id`, `position_name`) VALUES ('4', 'Инженер I категории');
INSERT INTO `profile_positions` (`pk_position_id`, `position_name`) VALUES ('5', 'Инженер II категории');
INSERT INTO `profile_positions` (`pk_position_id`, `position_name`) VALUES ('3', 'Ведущий инженер');
INSERT INTO `profile_positions` (`pk_position_id`, `position_name`) VALUES ('2', 'Главный специалист');
INSERT INTO `profile_positions` (`pk_position_id`, `position_name`) VALUES ('1', 'ГИП');

INSERT INTO `profile_statuses` (`pk_status_id`, `status_name`) VALUES ('1', 'Owner');
INSERT INTO `profile_statuses` (`pk_status_id`, `status_name`) VALUES ('2', 'Administrator');
INSERT INTO `profile_statuses` (`pk_status_id`, `status_name`) VALUES ('3', 'GroupLeader');
INSERT INTO `profile_statuses` (`pk_status_id`, `status_name`) VALUES ('4', 'Worker');

INSERT INTO `task_project_statuses` (`pk_status_id`, `status_name`) VALUES ('1', 'Finished');
INSERT INTO `task_project_statuses` (`pk_status_id`, `status_name`) VALUES ('2', 'Active');
INSERT INTO `task_project_statuses` (`pk_status_id`, `status_name`) VALUES ('3', 'Suspended');



INSERT INTO `departments` (`pk_group_id`, `group_name`) VALUES ('1', 'GMP5');
INSERT INTO `departments` (`pk_group_id`, `group_name`) VALUES ('2', 'GMP4');
INSERT INTO `departments` (`pk_group_id`, `group_name`) VALUES ('3', 'GMP2');


INSERT INTO `profiles` (`first_name`, `last_name`, `middle_name`, `login`, `password`, `fk_group_id`, `fk_position_id`, `fk_status_id`) 
VALUES ('Роман', 'Бондарович', 'Александрович','rbond','rbond', '1', '4', '4');
INSERT INTO `profiles` (`first_name`, `last_name`, `middle_name`, `login`, `password`, `fk_group_id`, `fk_position_id`, `fk_status_id`) 
VALUES ('ГИП', 'Гипов', 'ГИПович','gip','gip', '1', '1', '3');
INSERT INTO `profiles` (`first_name`, `last_name`, `middle_name`, `login`, `password`, `fk_group_id`, `fk_position_id`, `fk_status_id`) 
VALUES ('ГлавСпец', 'Спецов', 'Спецович','spec','spec', '1', '2', '3');
INSERT INTO `profiles` (`first_name`, `last_name`, `middle_name`, `login`, `password`, `fk_group_id`, `fk_position_id`, `fk_status_id`) 
VALUES ('Раб', 'Рабов', 'Рабинович','rab','rab', '1', '6', '4');


INSERT INTO `projects` (`project_name`, `fk_group_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Проект№1', '1', '1','2');
INSERT INTO `projects` (`project_name`, `fk_group_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Проект№2', '1', '2','2');
INSERT INTO `projects` (`project_name`, `fk_group_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Проект№3', '1', '3','2');

INSERT INTO `projects_to_profiles` (`fk_profile_id`, `fk_project_id`) VALUES ('1', '2');
INSERT INTO `projects_to_profiles` (`fk_profile_id`, `fk_project_id`) VALUES ('1', '3');
INSERT INTO `projects_to_profiles` (`fk_profile_id`, `fk_project_id`) VALUES ('2', '1');
INSERT INTO `projects_to_profiles` (`fk_profile_id`, `fk_project_id`) VALUES ('2', '3');
INSERT INTO `projects_to_profiles` (`fk_profile_id`, `fk_project_id`) VALUES ('4', '1');
INSERT INTO `projects_to_profiles` (`fk_profile_id`, `fk_project_id`) VALUES ('4', '2');

INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№1', '1', '1','1','2');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№2', '8', '1','3','2');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№3', '7', '1','4','3');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№4', '1', '1','4','1');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№1', '1', '2','1','1');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№2', '1', '2','1','1');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_status_id`) VALUES ('Задача№1', '1', '3','3','1');


INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_parent_task_id`, `fk_status_id`) VALUES ('Подзадача№1', '1', '1','1', '1','2');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_parent_task_id`, `fk_status_id`) VALUES ('Подзадача№2', '1', '1','1', '1','2');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_parent_task_id`, `fk_status_id`) VALUES ('Подзадача№3', '1', '1','1', '1','2');
INSERT INTO `tasks` (`task_name`, `priority`, `fk_project_id`, `fk_profile_id`, `fk_parent_task_id`, `fk_status_id`) VALUES ('Подзадача№4', '1', '1','1', '1','2');



