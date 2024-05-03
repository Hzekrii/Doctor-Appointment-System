
-- DB Name : hospital_appointment_system

-- Création de la table `doctors`
CREATE TABLE `doctors` (
  `doctor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cin` VARCHAR(200) UNIQUE NOT NULL,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `tele` VARCHAR(14) NOT NULL,
  `speciality` VARCHAR(200) NOT NULL,
  `registration_num` INT(15) NOT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;



-- Création de la table `patient`
CREATE TABLE `patients` (
  `patient_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cin` VARCHAR(200) UNIQUE NOT NULL,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `tele` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;




-- Création de la table `appointments`
CREATE TABLE `appointments` (
  `appointment_id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `doctor_id` INT(11) NOT NULL,
  `appointment_date` DATE NOT NULL,
  `appointment_time` TIME NOT NULL,
  `appointment_status` VARCHAR(200) NOT NULL,
  `appointment_room` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`appointment_id`),
  CONSTRAINT `fk_appointments_patient_id` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`patient_id`),
  CONSTRAINT `fk_appointments_doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;



-- Création de la table `login`
CREATE TABLE `login` (
  `login_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `role` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;



-- Création de la table `secretary`
CREATE TABLE `secretary` (
  `secretary_id` INT(11) NOT NULL AUTO_INCREMENT,
  `login_id` INT(11) UNIQUE,
  `cin` VARCHAR(200) UNIQUE NOT NULL,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `tele` VARCHAR(14) NOT NULL,
  FOREIGN KEY (`login_id`) REFERENCES `login` (`login_id`),
  PRIMARY KEY (`secretary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;




-- Création de la table `admin`
CREATE TABLE `admin` (
  `admin_id` INT(11) NOT NULL AUTO_INCREMENT,
  `login_id` INT(11) UNIQUE,
  `cin` VARCHAR(200) UNIQUE NOT NULL,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `tele` VARCHAR(14) NOT NULL,
  FOREIGN KEY (`login_id`) REFERENCES `login` (`login_id`),
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
