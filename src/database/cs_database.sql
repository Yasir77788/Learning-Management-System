CREATE DATABASE  IF NOT EXISTS `cs_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cs_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: cs_db_database
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` char(20) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('0','admin','1234abcd','Tong','Ha');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annoucement`
--

DROP TABLE IF EXISTS `annoucement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annoucement` (
  `annouce_id` varchar(25) NOT NULL,
  `student_id` varchar(45) DEFAULT NULL,
  `course_id` varchar(45) DEFAULT NULL,
  `annouce_title` varchar(500) DEFAULT NULL,
  `annouce_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `post_time` datetime DEFAULT NULL,
  `read` int DEFAULT '0',
  PRIMARY KEY (`annouce_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annoucement`
--

LOCK TABLES `annoucement` WRITE;
/*!40000 ALTER TABLE `annoucement` DISABLE KEYS */;
/*!40000 ALTER TABLE `annoucement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_current`
--

DROP TABLE IF EXISTS `course_current`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_current` (
  `current_id` varchar(20) NOT NULL,
  `meeting_start` varchar(10) DEFAULT NULL,
  `meeting_end` varchar(10) DEFAULT NULL,
  `meeting_day1` varchar(10) DEFAULT NULL,
  `meeting_day2` varchar(10) DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL,
  `course_status` int DEFAULT '1',
  `student_max` varchar(20) DEFAULT NULL,
  `student_join` varchar(20) DEFAULT '0',
  `subject_id` varchar(20) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  `course_id` varchar(20) DEFAULT NULL,
  `session_id` varchar(20) DEFAULT NULL,
  `mode_id` varchar(20) DEFAULT NULL,
  `location_id` varchar(20) DEFAULT NULL,
  `semester_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`current_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_current`
--

LOCK TABLES `course_current` WRITE;
/*!40000 ALTER TABLE `course_current` DISABLE KEYS */;
INSERT INTO `course_current` VALUES ('177292','9:00','11:30','Sat','','389',0,'35','0','ANTH','24995143','11','ES','Hb','1','528304'),('186049','18:15','20:45','Fri','','669',1,'39','0','CS','24995143','60','RAS','Hb','1','528304'),('193408','14:00','15:15','Mon','','526',0,'26','0','CS','88701293','53','EF','Itn','1','528304'),('329706','18:45','20:00','Mon','Wed','248',1,'35','0','ANTH','72629089','11','RAS','Hb','1','528304'),('356711','15:45','17:00','Mon','Wed','559',1,'26','0','CS','21019315','59','RAS','Hb','1','528304'),('439005','17:30','18:45','Tues','Thurs','334',1,'31','0','BA','94786594','31','EF','Hb','1','528304'),('471417','17:00','18:15','Mon','Wed','736',1,'35','0','ENGR','24995143','118','SS','Itn','1','528304'),('554148','16:45','19:15','Fri','','661',0,'33','0','CS','94786594','55','RAS','Itn','1','528304'),('603945','19:15','21:45','Sat','','617',1,'32','0','ANTH','72629089','10','EF','Hb','1','528304'),('616006','13:45','15:00','Mon','Wed','709',1,'29','0','ACC','35098773','4','ES','Hb','1','528304'),('642440','11:30','12:45','Mon','Wed','612',1,'40','0','CS','24995143','64','RAS','FtF','1',NULL),('649305','17:30','18:45','Mon','Wed','518',1,'26','0','BA','98145858','36','MS','FtF','1','528304'),('690571','13:15','15:45','Sat','','282',1,'35','0','DATA','52164921','82','ES','Hb','1','528304'),('703575','10:15','11:30','Mon','Wed','415',1,'20','0','BIOL','24995143','24','RAS','FtF','1',NULL),('718586','8:30','9:45','Tues','Thurs','216',1,'20','0','ANTH','39176927','11','RAS','FtF','1','528304'),('741227','18:15','20:45','Sat','','326',0,'39','0','BA','98145858','30','MS','Hb','1','528304'),('825395','9:00','10:15','Tues','Thurs','215',1,'40','0','BIOL','24995143','28','RAS','FtF','1',NULL),('858107','11:00','12:15','Mon','Wed','447',1,'33','0','BA','98145858','35','ES','Hb','1','528304'),('876327','17:45','19:00','Mon','Wed','787',0,'29','0','ENGR','60844794','117','MS','FtF','1','528304'),('894013','9:30','10:45','Mon','Wed','325',0,'30','0','BIOL','35098773','25','RAS','FtF','1','528304'),('913218','16:15','17:30','Mon','Wed','800',0,'27','0','ENGR','60844794','115','MS','Itn','1','528304'),('929802','8:00','10:30','Sat','','470',0,'40','0','ART','21019315','21','EF','Itn','1','528304'),('960866','11:00','13:30','Fri','','610',0,'25','0','ENGR','94786594','117','SS','Itn','1','528304'),('965977','10:45','12:00','Mon','Wed','414',0,'35','0','COMM','95765013','48','RAS','FtF','1','528304');
/*!40000 ALTER TABLE `course_current` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_list`
--

DROP TABLE IF EXISTS `course_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_list` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(200) NOT NULL,
  `course_credits` int NOT NULL DEFAULT '0',
  `course_class` int NOT NULL DEFAULT '0',
  `course_lab` int NOT NULL DEFAULT '0',
  `course_prerequisite` varchar(1000) NOT NULL DEFAULT 'NONE',
  `course_description` varchar(1000) NOT NULL,
  `subject_id` varchar(20) NOT NULL,
  `course_number` int NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_list`
--

LOCK TABLES `course_list` WRITE;
/*!40000 ALTER TABLE `course_list` DISABLE KEYS */;
INSERT INTO `course_list` VALUES ('1','Accounting for Non-Business Majors',3,3,0,'College-level math','The course will provide a working knowledge of financial statements, the accounting process and budgeting for non-business majors desirous of understanding how accounting is used in business operations, as well as to know how accounting and accounting reports are used by investors and other business stakeholders in their decision making process.','ACC',1301),('10','Physical Anthropology',3,3,0,'Completed or enrolled in ENG 1301 or 010 core complete.','Humans as physical beings, through the study of evolution, ancestry, prehistory and genetics. (ANTH 2301)','ANTH',2301),('100','Digital Logic with Lab',4,3,1,'EET 1411 ','Introduction to binary numbers, Boolean algebra, and Karnaugh maps. Logic gates, memory devices, counters, registers, arithmetic logic units, and data-handling circuits. A/D and D/A converters. Combined computer simulation and circuit testing in the laboratory.','EET',2431),('101','Electrical Power Systems',3,2,1,'EET 2421  (credit or enrollment).','Basic principles and applications of electrical power systems, power generation, transmission and distribution in utility and industrial systems. Included are lighting and grounding design, motor controls, transformers and area classification. Computer simulation of power systems.','EET',3334),('102','Computer Architecture and Design with Lab',4,3,1,'EET 2431.','The organization and design of digital computer systems, including microprogramming, register transfer language, micro-operations and control functions of the computer. Computer input/output. The microcomputer is emphasized. The basics of machine and assembly language are utilized with the hardware.','EET',3432),('103','Fundamentals of Automation and Control with Lab',4,3,1,'EET 2421, EET 2431; and MATH 2402 or ENGR 2411.','Study of plant dynamic modeling (first-and second order, transfer functions, nonlinear characteristics) and simulation, control system configurations (open-loop, closed-loop, combined feed forward/feedback control), types of controllers (analog, PC-based, PLCs), and control modes (on-off, PID, etc.). System designs for dc servo position and speed control, temperature control, lighting control, etc.','EET',3435),('104','Instruments and Transducers with Lab',4,3,1,'EET 2421 ','Transducer characteristics and applications. Sensor and measurement systems for major process variables: temperature, pressure, level, flow, and other physical variables. Design on signal conditioning circuits. 4-20mA current loops. Data acquisition and instrumentation networks.','EET',3451),('105','Computer Networking',3,3,0,'EET 2431.','Principles and applications of computer networking techniques, including the seven layered protocol model, hierarchy of commands, descriptions of the physical layers of the model and descriptions and analysis of popular techniques currently in existence. Development and implementation of NT networks.','EET',4335),('106','Microprocessor Systems Design',4,3,1,'EET 2431.','Design, application and operation of various electronics systems using microprocessors. Consideration will be given to the specific type of components required, the sources of manufactured components, and the construction of the circuits and systems. Emphasis will be placed on microcomputers and their related peripherals and the use of system design software, XILINX. Various electronic circuits will be designed, implemented, and troubleshot using PAL’s and PGA’s. A group electronics systems project using microprocessors will be completed and troubleshot using all aspects of the course.','EET',4434),('107','Composition I',3,3,0,'A grade of C or better in ENG 1300, TSI WRITING Essay score of 5,or an essay score of 4 and WRITING score of 363, TSI WRITING complete, or TSI WRITING exempt','English 1301 is an introduction to college-level communication with an emphasis on argumentation, which is the kind of writing/communication required most frequently in university coursework and the public sphere. This course focuses on writing as a recursive process that includes audience analysis, invention, organization, drafting, revising, and editing; oral presentation and visual analysis skills are used to reinforce composition processes.','ENG',1301),('108','Composition II',3,3,0,'A grade of C or better in ENG 1301 or placement by examination.','English 1302 will build on the skills developed in ENG 1301 by focusing on research and analytical skills. Emphasis will be placed on the analysis and summarization of complex written, oral, and visual texts and the need to accurately paraphrase, quote and document sources through the development of college-level research skills.','ENG',1302),('109','Creative Writing: The Word in the World',3,3,0,'NONE','This first-year writing course explores creative writing as a medium of personal expression and social exchange; and emphasizes the writing and analysis of at least two literary genres chosen from among poetry, fiction, and creative nonfiction, as well as the reading of literary works in translation, as creative artifacts of human imagination. The course facilitates critical, creative, and innovative communication about the literary arts and fulfills the Creative Arts Foundational Component Area required of all students.','ENG',1316),('11','Cultural Anthropology',3,3,0,'Completed or enrolled in ENG 1301 or 010 core complete.','Drawing on scientific and humanistic methods, this course looks at humanity’s cultural heritage with a broad comparative global perspective. In this course students will learn about humans as cultural beings. They also explore other cultures and read about ethnicity, marriage, kinship, religion, gender, economy, art, social stratification, and politics in simple non-western societies and compare them with those of complex advanced western societies. Throughout the course, students will be exposed to the nature of fieldwork and anthropological theory from its 19the century origins to the present.','ANTH',2302),('110','Introduction to the Study of English Grammar',3,3,0,'NONE','Introduction to basic grammar concepts and terminology through exploration of language variation and language systems.','ENG',1318),('111','Literature and Culture',3,3,0,'Completion of, or concurrent enrollment in, ENG 1302.','A study of literary and cultural texts pertinent to selected topics. Sample Topics: Literature and the Environment; Literature and Gender; Literature and Mass Culture; Ethnic American Literature.','ENG',2305),('112','Essay Writing',3,3,0,'Successful completion of ENG 1302 and the Language, Philosophy Culture Core Component.','Study, analysis and practice of advanced rhetorical principles in non-fiction, with a view to increasing clarity, effectiveness and precision in a student’s writing style.','ENG',3305),('113','Introduction to Creative Writing',3,3,0,'Successful completion of ENG 1302 and the Language, Philosophy Culture Core Component. May be repeated once for credit.','Techniques of writing fiction and poetry; emphasis on the student’s own work.','ENG',3309),('114','History of the English Language',3,3,0,'Successful completion of ENG 1302 and the Language, Philosophy, and Culture Core Component Area.','A study of the development of English speech, writing, spelling, syntax and vocabulary.','ENG',3302),('115','Engineering and Technology Fundamentals',3,3,0,'Credit or enrollment in MATH 1302.','Overview of techniques and fundamental principles used in engineering, science and technology. Topics include: dimensional analysis and units, measurements, representation of technical information, problem solving, and introduction to selected science and engineering topics.','ENGR',1302),('116','Computer-Aided Drafting and Design I',3,3,0,'ENGR 1302 , MATH 1301 and ENG 1301.','An introduction to Computer Aided Drafting and Design (CADD) systems commonly used in industry. Topics include introduction to CADD systems, basic drawing and editing commands, drawing annotations, dimensioning, cross hatching, creation and use of drawing symbols, generation of engineering drawing and drawing database.','ENGR',2304),('117','Engineering Economics',3,3,0,'ENGR 1400, ENG 1302, MATH 2401 and junior standing.','Time value of money, annual cost, present worth, future value, capitalized cost, break-even analysis, valuation and depreciation, income taxes. Economic evaluation of engineering alternatives and proposals. Use of spreadsheets. Introduction to optimization.','ENGR',3302),('118','3-D Fire Modeling',3,3,0,'ENGR 1302, ENG 1302, and MATH 1301.','Fire modeling of selected problems using the Fire Dynamics Simulator and SmokeView software packages. Topics covered include how to set dimensions from working drawings, determine cell number and size, nature of fire/flame spread, using slice files to confirm air movement, defining the initial fire, material properties, collecting and displaying information, and the effect of sprinkler placement.','ENGR',3310),('119','Fire Alarm Signaling Systems',3,3,0,'MATH 1301.','The design, installation, maintenance and utilization of portable fire-extinguishing appliances and pre-engineered systems. Operational capabilities and utilization requirements of fire detection and signaling systems. Fire detection and suppression applied in practical problems. Experimental demonstrations and computer simulation of hazard detection systems.','ENGR',3330),('12','Health, Medicine, and Culture',3,3,0,'ANTH 2301, ANTH 2302 or permission of the instructor.','This course will examine the anthropology of health including the concepts of illness, medicine, aging, and the role of the healer from a cross-cultural perspective. Topics will primarily focus on the interaction of culture and biology in relation to causes of disease, treatment of disease, and the attitudes of the population.','ANTH',3313),('13','Special Topics in Anthropology',3,3,0,'3 hours in anthropology or permission of the instructor.','Selected topics in anthropology. Topics may vary from semester to semester and may be repeated for credit.','ANTH',4390),('14','History of Art: Paleolithic to the Middle Ages',3,3,0,'NONE','An introduction to monuments of art from prehistoric times to c. 1400 AD. The course analyzes the variety of contexts and circumstances under which works of art were created, and explores the similarities and differences between artistic periods. This course satisfies the Fine Arts component of the Texas Core Curriculum. (ARTS 1303)','ART',1301),('15','History of Art: Renaissance to Present',3,3,0,'NONE','An introduction to monuments of art from the Renaissance to contemporary times. The course analyzes the variety of contexts and circumstances under which works of art were created, and explores the similarities and differences between artistic periods. This course satisfies the Creative Arts component of the Texas Core Curriculum. (ARTS 1304)','ART',1302),('16','Design and Materials',3,3,3,'NONE','Analysis of fundamental principles and elements in two-and three-dimensional design. Work with various materials and colors in relation to space and movement. (ARTS 1311)','ART',1303),('17','Design Color and Structure',3,3,3,'ART 1303 or equivalent','A continuation of the study of fundamental principles and elements in two- and three-dimensional design. (ARTS 1312)','ART',1304),('18','Drawing I',3,3,3,'NONE','Representation drawing with consideration of perspective, light and shade; use of charcoal, pencil, conte, pen and wash. (ARTS 1316)','ART',1305),('19','Drawing II',3,3,3,'ART 1305 or equivalent.','A continuation of representation drawing, with a consideration of perspective, light and shade; practice using charcoal, pencil, conte, pen and wash. (ARTS 1317)','ART',1306),('2','Financial Accounting',3,3,0,'MATH 1301','The purpose of the course is to (1) give students a grasp of accounting terminology, (2) help students learn the process of gathering, classifying and reporting financial information on financial statements, and (3) provide analytical skills necessary to understand the importance of financial statements in economic decision making. (ACCT 2301)','ACC',2301),('20','Computer Graphic Design',3,3,3,'NONE','Introduction to the basic operational skills of the computer and the development of creative techniques in two-dimensional design.','ART',1307),('21','Art History: Introduction to World Art',3,3,0,'NONE','Introduction to World Art is a survey of selected historical Asian, African, Islamic, North, South and Mesoamerican monuments of art and architecture. This course provides a framework for understanding and analyzing the art and architecture created by cultures outside of traditional West European models, and examines objects and monuments within their cultural religious, social, economic, and/or political contexts.','ART',1308),('22','Human Anatomy and Physiology I',3,3,0,'Credit or enrollment in BIOL 1103','A survey of Human Anatomy and Physiology required for students going to nursing or similar professional programs. Emphasis will be placed on cells and tissues of the human body and its skeletal, muscular, integumentary, nervous and sensory systems.','BIOL',1303),('23','General Biology Laboratory I',1,0,3,'Credit or enrollment in BIOL 1301.','Appropriate exercises and experiments requiring scientific observation and analysis that illustrate some of the basic techniques, concepts and facts presented in BIOL 1301. (BIOL 1106)','BIOL',1101),('24','Human Anatomy and Physiology II',3,3,0,'Credit for BIOL 1303/BIOL 1103 and enrollment in BIOL 1104.','A continuation in the survey of Human Anatomy and Physiology required for students going to nursing or similar professional programs. Emphasis will be placed on endocrine, circulatory, respiratory, digestive, excretory and reproductive systems.','BIOL',1304),('25','General Biology Laboratory II',1,0,3,'BIOL 1101 and credit or enrollment in BIOL 1302.','Appropriate exercises and experiments requiring scientific observation and analysis that illustrate some of the basic techniques, concepts and facts presented in BIOL 1302. (BIOL 1107)','BIOL',1102),('26','Cancer Biology',3,3,0,'General Genetics and laboratory (BIOL 3303/BIOL 3103)','A study of the molecular and cellular mechanisms of cancer including cell cycle regulation, genomic instability, cellular structural and metabolic changes, aberrant cell signaling and the cancer stem cell hypothesis. Drug development, drug resistance, and ethical considerations in cancer research and treatment will be discussed.','BIOL',3308),('27','Human Genetics',3,3,0,'BIOL 3303/BIOL 3103.','A study of inherited traits in humans with emphasis on the mapping of the human genome, molecular mechanisms of disease, karyotyping and chromosomal abnormalities, genetic testing, gene therapy, and ethical issues associated with human genetics.','BIOL',4303),('28','Environmental Biology',3,3,0,'BIOL 1302/BIOL 1102, CHEM 1308/CHEM 1108, and 4 hours of biology above the 1000-level.','Ecological principles and current topics regarding the interrelationships among organisms and their environments, including analysis of human activities that impact natural ecosystems and cause environmental problems.','BIOL',4360),('29','Business Cornerstone',3,3,0,'Sophomore standing.','This course is an introductory course for all business majors. The topics include critical thinking, team development, diversity, business ethics and career development. The critical thinking component introduces the concepts and techniques of critical thinking. The team development component focuses on the importance and role of teams in business, and the role of diversity in business settings. The ethics component introduces the basic ethical concepts, principles, and techniques of moral reasoning needed in business. The career development component focuses on strategies and decision-making skills for moving oneself toward implementation of career goals.','BA',3300),('3','Intermediate Accounting I',3,3,0,'Completion of the common core plus 18 additional hours, a grade of C or better in ACC 2301 and ACC 2302, and completion of or enrollment in BA 3300.','Development of a comprehensive analysis of financial accounting topics involved in preparing, interpreting and using financial statements that comply with generally accepted accounting principles. Designed to help students understand and apply the conceptual framework of financial reporting, asset measurement and revenue recognition.','ACC',3300),('30','Legal Environment of Business',3,3,0,'Completion of the common core plus 18 additional hours, and completion of, or enrollment in, BA 3300. BA 3300 may be waived upon completion of HUM 3310 or CJ 3300.','An introduction to business law, with special emphasis on the legal and ethical environment of business, both domestic and international. Topics include a description of the American legal system, crimes, torts, contracts, agency and legal liability, business organizations, and governmental regulations.','BA',3301),('31','Commercial Law',3,3,0,'BA 3301 and completion of, or enrollment in, BA 3300','A continuation of BA 3301, including laws governing sales, credit transactions, bankruptcy, negotiable instruments, corporations, partnerships and property. The emphasis of this course is commercial law and business.','BA',3302),('32','Global Environmental Issues in Business',3,3,0,'BA 3301 or instructor approval and completion of, or enrollment in, BA 3300.','Contemporary domestic and international environmental issues with emphasis on the legal framework within which these issues are addressed to provide an understanding of the associated business risks relating to these issues. Applicable federal and state regulations, their enforcement and effects on business will be covered. Consequences of noncompliance such as civil and criminal prosecution and tort liability will also be studied.','BA',3303),('33','International Business',3,3,0,'Completion of the common core plus 18 additional hours or instructor approval and completion of, or enrollment in, BA 3300.','Broad approach to the basic principles of business globalization. Emphasis is placed on the business enterprise as it conducts its commercial activity in environments that are different in their economic, political, legal, social and cultural aspects from the firm’s corresponding domestic environment.','BA',3320),('34','Entrepreneurial Revenue',3,3,0,'BA 3305 or MGT 4303.','Teaches students about the dynamics of marketing entrepreneurial products and services. Students will learn the effects of pricing and marketing strategies on the growing enterprise.','BA',3340),('35','Business Communication',3,3,0,'Completion or concurrent enrollment in BA 3300, completion of common core plus 18 additional hours, and a declared business major','Development of interpersonal business communication skills including issues affecting the communication process as it relates to organizational environments. Topics include written communication (business reports and collaborative writing), oral communication (business presentations, meetings, and interviews), listening, group communication, electronic communication technology, and international communication (how cultural mores and traditions impact communication in the international environment).','BA',3350),('36','Business Strategy',3,3,0,'BA 3300 and must be a declared business major and have completed all required general education and business core courses.','The capstone course in business emphasizing planning and decision-making, formulating strategies and implementing plans for action. Comprehensive cases provide the opportunity to study proper interrelationships among production, operations, finance, accounting, marketing and the many other functions involved in managing a business enterprise.','BA',4302),('37','Business Plan',3,3,0,'BA 3305 or MGT 4303; BA 3340, BA 3341, BA 3342.','The business plan is the road map for new ventures. It outlines the goals and objectives of the enterprise and describes how they will be achieved. It helps keep the venture on the path of growth and profitability, and provides a mechanism for communicating the firm’s achievements and goals with external parties, including potential investors.','BA',4305),('38','Introductory Chemistry Laboratory',1,0,3,'Credit or enrollment in CHEM 1305.','Appropriate laboratory experiments for the student who will not be a professional physical scientist. The experiments support the principles of chemistry developed in the lecture portion of the course and illustrate some of the basic approaches to chemical problems. (CHEM 1105)','CHEM',1105),('39','General Chemistry Laboratory I',1,0,3,'Credit or enrollment in CHEM 1307.','Experiments which illustrate basic laboratory techniques and procedures, physical and chemical properties, stoichiometry, solutions, and thermochemistry. (CHEM 1111)','CHEM',1107),('4','Intermediate Accounting II',3,3,0,'Completion of the common core plus 18 additional hours and a grade of C or better in ACC 3300.','Continuation of Intermediate Accounting I. This course furthers the development of analytical skills necessary for the measuring and reporting of assets, liabilities and equity. Accounting principles underlying the preparation of financial statements are studied in depth.','ACC',3301),('40','General Chemistry Laboratory II',1,0,3,'CHEM 1107 and credit or enrollment in CHEM 1308.','Emphasis on reactions in aqueous solutions, gas laws, equilibrium, kinetics and qualitative analysis, with an introduction to instrumental analysis. (CHEM 1112)','CHEM',1108),('41','Chemistry in Society',3,2,2,'NONE','This course presents the relevance of chemistry in everyday life, particularly in applications to environmental problems such as air pollution, ozone depletion, global warming, energy, water purity and acid rain. Fundamental concepts in chemistry introduced on a need-to-know basis include stoichiometry, atomic structure, chemical bonding, states of matter, electrolytic solutions and chemical reactions. This course meets the common core requirement in natural sciences.','CHEM',1304),('42','General Chemistry I',3,3,0,'Credit or enrollment in MATH 1301 and CHEM 1107, ENG 1301 (or 010 core complete), and one year of high school chemistry or CHEM 1305/CHEM 1105.','The first in a two course survey of the fundamentals of general chemistry for students majoring in the sciences. Descriptive material is correlated with the basic chemical principles and their applications. Modern concepts of atomic and molecular structure, chemical bonding, the gaseous state and the kinetic molecular theory of matter will be analyzed. There will be on stoichiometeric calculations of mass and molar relationships, energy relations and intermolecular forces.','CHEM',1307),('43','General Chemistry II',3,3,0,'A grade of C or better in CHEM 1307 and credit or enrollment in CHEM 1108.','The second in a two course survey of the fundamentals of general chemistry for students majoring in the sciences. Topics include liquids and solids, intermolecular forces, chemical kinetics, thermodynamics, homogeneous, heterogeneous and ionic equilibrium, modern concepts of acids and bases, electrochemistry, coordination chemistry, nuclear chemistry and selected topics.','CHEM',1308),('44','Quantitative Analysis Laboratory',1,0,3,'Credit or enrollment in CHEM 3310.','Quantitative methods of analysis including gravimetric, volumetric and instrumental. Instrumental methods will include absorption and emission spectroscopy, gas and liquid chromatography and electrochemical analysis.','CHEM',3110),('45','Physical Chemistry Laboratory I',1,0,3,'Credit for or enrollment in CHEM 3330.','Advanced experiments in physical chemistry including studies in thermodynamics, colligative properties of solutions, surface tension of surfactant containing solutions, solution viscosities, electrochemistry and the physical chemistry of polymeric materials. In addition to providing support for CHEM 3330, this course is designed to acquaint the student with the experimental approaches and laboratory techniques used in industrial research and development activities.','CHEM',3130),('46','Voice and Diction',3,3,0,'NONE','Strongly recommended for students for whom English is a second language. Introduction to phonetics and methods of voice development. Acquiring good speech habits through individual analysis, tape recordings, guided practice, class drills, oral readings and vocabulary building.','COMM',1301),('47','Mass Media',3,3,0,'NONE','An introduction to mass communications, including the functions in society of newspapers, magazines, radio and television. (COMM 1307)','COMM',1302),('48','Introduction to Communication',3,3,0,'NONE','An overview of skills important in developing effective communication. Students will gain experience in interpersonal, small group, and public communication. (SPCH 1311)','COMM',1304),('49','Beginning Public Speaking',3,3,0,'NONE','This course is designed to teach basic skills in organization and delivery of speeches in a variety of settings. Students will learn ways to collect and incorporate verbal support, use patterns of speech structure, and identify successful techniques for handling stage fright. Additional topics include audience analysis, outlining content, platform presence, and use of voice.','COMM',1306),('5','Intermediate Accounting III',3,3,0,'Completion of the common core plus 18 additional hours and a grade of C or better in ACC 3301.','Continuation of Intermediate Accounting II. This course focuses on understanding and solving some of the more complex topics of financial accounting and their impacts on users. Topics include leases, pensions and corporate income taxes. Additional special topics will be included.','ACC',3302),('50','Argumentation',3,3,0,'ENG 1302.','Theory and practice in argumentation, including inductive and deductive reasoning, attitude change, use of evidence and fallacies.','COMM',2304),('51','Introduction to Computer Technology',3,3,0,'MATH 1300 or placement by exam','Topics include the history and nature of computers, ethical and other societal issues, an overview of computer hardware and software (with an emphasis on computer applications and the use of standard software packages). The use of the Internet for communication and research is introduced.','CS',1305),('52','Introduction to computing with Python',3,3,0,'MATH 1300  or placement by exam.','Computational thinking involves transforming a real-world problem into a software-based approach for solving it. This course will engage students analytically in the creation of computer programs to solve a diverse set of real world problems related to kinematics, designing games, solving puzzles, searching, sorting, and basic data analysis. Using a problem solving approach, students will learn the basic process of designing algorithms as well as implementing them with a high level programming language.','CS',1311),('53','Computer Programming in Visual Basic',3,3,0,'Completion of, or enrollment in, MATH 1404, MATH 1505, or MATH 1306.','An introduction to programming using Visual Basic with an emphasis on event-driven programming. The Visual Basic environment includes objects, events, code, and properties. Topics also include statements, subprograms, data types, arrays, input-output, and user interface design.','CS',1312),('54','Introduction to Computer Science with Visual Basic',4,4,0,'Credit or enrollment in MATH 1404 or MATH 1505 or MATH 1306; and placement in ENG 1301 or above.','History, nature and uses of the computer; algorithms; number systems; information representation and organization with an overview of computer hardware and software, computing systems and major applications. An introduction to high-level languages and programming using Visual Basic with an emphasis on event-driven programming. Elements of the Visual Basic programming environment including objects, events, properties, user interface design and creating web-based applications are discussed. Practice with standard programming features such as control statements, subprograms, data types, arrays and input-output mechanisms.','CS',1408),('55','CS I-Introduction to Computer Science with C++',4,4,0,'Credit or enrollment in MATH 1404 or MATH 1505 or MATH 1306; and placement in ENG 1301 or above.','History, nature and uses of the computer; algorithms; number systems; information representation; and organization, with an overview of computer hardware and software, computing systems and major applications. Ethical and societal issues are discussed. An introduction to high-level languages with an emphasis on programming in C++. Control statements, subprograms, data types, arrays, and streams. Closed (supervised) laboratories are conducted on: an introduction to Microsoft Windows, and a C++ programming environment; appropriate programming exercises emphasizing top-down design methodology and simple and structured data types; and key topics of the discipline and areas of application. Designed as a first course for majors in Computer Science and Mathematics (COSC 1436)','CS',1410),('56','Introduction to Computer Science with C#',4,4,0,'Credit or enrollment in MATH 1404 or MATH 1505 or MATH 1306; and placement in ENG 1301 or above.','An introduction to programming using C# for design and development Windows applications with an emphasis on event-driven programming. Topics include objects, events, code, and properties. Control statements, subprograms, data types, arrays, input-output, and user-interface designs.','CS',1412),('57','Introduction to Computer Organization',3,3,0,'Grade of C or better in CS 1410 or CS 1408.','Organization of general-purpose computers; data representation and arithmetic; instruction sets architectures and addressing modes; memory hierarchies, input/output and storage, and alternative architecture. (COSC 2425)','CS',2301),('58','Digital Logic',3,3,0,'Grade of C or better in CS 1410 and MATH 2305.','Boolean expressions and theorems. Analysis and synthesis of combinational and sequential switching networks; optimization methods using random logic gates, multiplexers, decoders, registers, counters, and programmable logic devices. Exercises involve the design and simulation of digital circuits. Emphasis is on the use of Boolean Algebra, Truth Table, and Karnaugh Maps in the design, simulation, simplification, and testing of digital circuits.','CS',2302),('59','CS II-Introduction to Data Structures and Algorithms',4,4,0,'Grade of C or better in CS 1410 and credit or enrollment in MATH 2401.','Arrays, records (C++ structs), classes and data abstraction, object-oriented software development, pointers, dynamic data structures, linked structures, elementary and searching and sorting algorithms, recursion, an introduction to algorithm complexity analysis. (COSC 1437)','CS',2410),('6','nternational Accounting',3,3,0,'Completion of the common core plus 18 additional hours and ACC 2302.','An overview of international financial accounting standards, current problems of international operations and multinational corporations. It also provides comparative analysis of accounting principles and practices outside the United States.','ACC',3323),('60','Object-Oriented Programming and Concepts',3,3,0,'Grade of C or better in CS 2410.','Provides practical guidance on the construction of object-oriented systems. The Unified Modeling Language (UML) is used as a tool for analysis and design and the JAVA language is used for implementation. Key concepts of object-oriented programming methodology are discussed.','CS',3300),('61','Fundamentals of Game Development',3,3,0,'A grade of C or better in MATH 2307 and CS 2410.','This course provides students with a foundation in computer game development. Topics include the genres of games, principles of game design (such as character design, level design, and interface design), sprites and animations, physics, event handling, and visual effects.','CS',3310),('62','Software Engineering',3,3,0,'C or better in CS 3304','To provide students with the theoretical and practical understanding of the development of large software systems using the Unified Modeling Language (UML). The theoretical component is supported with readings, lectures, and class discussions. The practical components are reinforced with the development of a large-scale group project involving all phases of the software development life-cycle.','CS',3321),('63','Network Security',3,3,0,'CS 2410.','This course is an introduction to the fundamentals of computer network security. Topics include the rationales and necessity for securing computer networks, common security threats, methodologies for the design of network security systems, establishing security protocols and the identification of best practices of secure communications systems. In particular, this will cover an introduction to encryption and decryption, authentication, secure communication, network security protocols, firewalls and web security. This course provides the foundational knowledge for advanced study of security issues in computer networks.','CS',3326),('64','Undergraduate Research',3,3,0,'Junior standing and departmental approval. Course may be repeated for credit with department approval.','Independent investigation of a specific topic or problem in computer science under the guidance of a faculty member. The course is designed to give students research experience and independent study skills in an area of computer science. A written report and an oral presentation are required at the end of the course. Course cannot be used to fulfill upper-level CS elective requirement for CS degree plan.','CS',3394),('65','Web Programming',3,3,0,'Grade of C or better in CS 3304.','An introduction to Web programming using HTML, XML, JavaServer Pages, and Java Script, with an emphasis on developing and designing dynamic Web pages in the client-server model.','CS',4300),('66','Operating Systems',3,3,0,'Grade of C or better in CS 2301, CS 2302, and CS 3304.','Basic concepts of operating systems including concurrent process management, I/O device management, process scheduling, synchronization, deadlock, and memory management. UNIX used for standard examples.','CS',4315),('67','Database Systems',3,3,0,'Grade of C or better in CS 3304.','An introduction to the theory of database and file structures with an emphasis on general principles and algorithmic issues as well as a conceptual overview of the design, construction and maintenance of database and file processing systems. After the various models are considered, specific attention is given to advanced topics such as data integrity, optimization, and distributed environments.','CS',4318),('68','Statistical and Machine Learning',3,3,0,'A grade of C or better in CS 3304, or, a grade of C or better in DATA 3402 and credit for or concurrent enrollment in STAT 4310.','This course blends the predictive perspective of statistical pattern recognition and the algorithmic perspective of machine learning. Topics include, but are not limited to: applications of appropriate machine learning algorithms in various disciplines, prediction and performance metrics, data transformations, supervised and unsupervised learning, and ensemble methods.','CS',4319),('69','Mobile Computing',3,3,0,'Grade of C or better in CS 3420.','Introduction to software development for mobile devices such as smartphones and tablets. Topics include essential concepts of software development, Graphical User Interface design, hardware communication on mobile platforms, and development of practical apps for mobile devices. This course can be used to fulfill upper-level CS elective requirement for BS in CS degree plan. It may be used to fulfill the writing application course requirement (W-course) with the additional prerequisite of CS 4294.','CS',4340),('7','Advanced Accounting',3,3,0,'A grade of C or better in ACC 3302.','Business combinations, home office and branches, and partnerships, with concentration on accounting and reporting for purchase acquisitions using the equity method.','ACC',4303),('70','Special Topics in Computer Science',3,3,0,'Department approval. Course may be repeated for credit with department approval.','Intensive study of one or more major topics in computer science, especially with respect to a new or emerging area.','CS',4390),('71','Introduction to the Theater',3,3,0,'ENG 1300 or acceptable reading placement score.','Topics examine the five essential elements of theater: the audience, the actor, the script, the production and the physical theater. Attendance at plays required; no acting included.','DRA',1301),('72','Acting Principles and Practice',3,3,0,'NONE','Basic concepts of acting (including improvisations, elements of characterization, role playing and scene production) through class presentations, attendance at plays, personal contact with professional actors and viewing films and videos.','DRA',1303),('73','Acting II',3,3,0,'DRA 1303 or permission of instructor.','Concentration on advanced concepts of acting, auditioning, improvisations, characterizations, pantomime, voice development and scene presentation. Performance in university productions encouraged.','DRA',1301),('74','Stagecraft I',3,3,0,'NONE','An introduction to the basic aspects of scenery and lighting, including elementary construction techniques, types and kinds of lighting instruments and equipment, various building materials and the operation and care of tools and machinery.','DRA',1305),('75','Stage Design',3,3,0,'ENG 1301.','Examines the history and development of stage scenery and lighting. Includes consideration of design principles and techniques in each area as well as materials and tools used. Also looks at notable scenic and lighting designers from the past and present.','DRA',2301),('8','Forensic Accounting',3,3,0,'ACC 3300.','Introduction to the practice of forensic accounting and its relationship to information technology auditing. Emphasizes fraud examination as applied to accounting information systems as well as legal resolution to fraudulent acts.','ACC',4310),('80','Data Science I',3,3,0,'Grade of C or better in MATH 2305 and credit for or concurrent enrollment in MATH 2401.','This course is an introduction to the entire data science pipeline. Topics include, but are not limited to: data collection and transformation; exploratory data analysis; introduction to statistical software; data visualization and presentation.','DATA',2401),('81','Data Science II',4,4,0,'rade of C or better in CS 1311, DATA 2401, MATH 2307, MATH 3302.','This course is an intermediate treatment of the data science pipeline. Topics include, but are not limited to: prediction, estimation and statistical inference; elementary notions of data mining; intermediate use of statistical software; introduction to relational databases and queries; data visualization and presentation.','DATA',3401),('82','Data Collection, Transformation and Curation',4,4,0,'Grade of C or better in DATA 3401.','This course provides the principles of data curation over the entire data pipeline. Specifically, the collection of data of different forms from a variety of sources, the transformation and wrangling of acquired data into forms amenable for analysis, and the preparation of data for a variety of statistical methods and models. Additionally, students will learn how to ensure the safety and consistency of data as it passes through all stages of the process','DATA',3402),('83','Statistical and Machine Learning',3,3,0,'A grade of C or better in DATA 3402 and credit for or concurrent enrollment in STAT 4310; or, a grade of C or better in CS 3304.','This course blends the predictive perspective of statistical pattern recognition and the algorithmic perspective of machine learning. Topics include, but are not limited to: applications of appropriate machine learning algorithms in various disciplines, prediction and performance metrics, data transformations, supervised and unsupervised learning, and ensemble methods.','DATA',4319),('9','Special Topics in Accounting',3,3,0,'Junior standing.','Topics of special or current interest in the area of accounting taught by faculty or visiting lecturers who possess a special area of expertise.','ACC',4390),('91','Introduction to Economics',3,3,0,'ENG 1301.','Combines microeconomics and macroeconomics in one semester. A non-technical examination of economic theories, programs, and policies. The primary objective in this course is to develop an interest and appreciation for the relevance of economic analysis.','ECO',1301),('92','Principles of Economics I',3,3,0,'MATH 1301 or MATH 1310.','Principles of macro-economics. Topics include structure of the US economy, national income determination and the application of monetary and fiscal policies. Also includes analysis of international trade and finance. (ECON 2301)','ECO',1305),('93','Principles of Economics II',3,3,0,'MATH 1301 or MATH 1310.','Principles of micro-economics, with major emphasis on price and income distribution theory. Topics include demand theory, competition, oligopoly and monopoly, marginal productivity theory, international trade, and international finance. (ECON 2302)','ECO',2301),('94','Managerial Economics',3,3,0,'Completion of the common core plus 18 additional hours and ECO 2302.','Application of micro-economic theory to important business decision-making. Analytical methods in production, cost, demand, marketing and pricing. Regression analysis applied to test and to estimate empirical models.','ECO',2302),('95','Petroleum Economics',3,3,0,'MATH 1301, ECO 2301, and ECO 2302.','Introduction to the methods and practices used by the oil and other industries to examine the economic viability of upstream oil and gas projects. Prepares students to perform economic evaluations and to critically review those done by others. Topics include cash flow analysis, economic indicators, risk and uncertainty, fiscal analysis, and techniques for valuing oil and gas properties and companies.','ECO',3302),('96','Intermediate Microeconomics',3,3,0,'ECO 2302.','Comprehensive analysis of micro economic theories, policies, and applications will be undertaken. Topics include an analysis of the market system, marginal analysis and optimization behavior, consumer choice, production and cost, market structure models, resource markets, externalities, public choice, distribution theories and welfare economics.','ECO',3306),('97','International Economics',3,3,0,'Completion of the common core plus 18 additional hours, ECO 2301 and ECO 2302.','This course focuses on the principles of foreign trade and covers theories concerning the reasons for trade. The course examines the monetary and real aspects of international trade and includes analysis of foreign exchange markets and balance of payments problems.','ECO',3309),('98','Electric Circuits with Lab',4,3,1,'MATH 1301 and MATH 1302.','Theory and applications of electric circuits as found in typical engineering systems and daily living environment. Basic principles and analysis methods for dc and ac circuits are studied and circuit applications explored. Computer simulation software tools are used extensively to provide an interactive teaching and learning process. Hands-on experience is gained through circuit testing and troubleshooting exercises. This course lays the foundation for other Electrical Engineering Technology courses.','EET',1411),('99','Electronic Devices and Amplifiers with Lab',4,3,1,'EET 1411 and both PHYS 1308 /PHYS 1108 (or PHYS 2402 /PHYS 2102)','Study of the characteristics and operation of electronic devices including diodes, bipolar junction transistors and field effect transistors, operational amplifiers, 555 timers. Electronic circuitry for signal amplification and filtering, instrumentation, power regulation, electric drives. Use of computer software in electronics design.','EET',2421);
/*!40000 ALTER TABLE `course_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_mode`
--

DROP TABLE IF EXISTS `course_mode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_mode` (
  `mode_id` varchar(20) NOT NULL,
  `mode_name` varchar(50) NOT NULL,
  PRIMARY KEY (`mode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_mode`
--

LOCK TABLES `course_mode` WRITE;
/*!40000 ALTER TABLE `course_mode` DISABLE KEYS */;
INSERT INTO `course_mode` VALUES ('FtF','Face to Face'),('Hb','Hybrid'),('Itn','Internet');
/*!40000 ALTER TABLE `course_mode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_record`
--

DROP TABLE IF EXISTS `course_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_record` (
  `course_record_id` varchar(20) NOT NULL,
  `meeting_start` varchar(10) DEFAULT NULL,
  `meeting_end` varchar(10) DEFAULT NULL,
  `meeting_day1` varchar(10) DEFAULT NULL,
  `meeting_day2` varchar(10) DEFAULT NULL,
  `room` varchar(10) DEFAULT NULL,
  `course_status` int DEFAULT '1',
  `student_max` varchar(20) DEFAULT NULL,
  `student_join` varchar(20) DEFAULT '0',
  `subject_id` varchar(20) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  `course_id` varchar(20) DEFAULT NULL,
  `session_id` varchar(20) DEFAULT NULL,
  `mode_id` varchar(20) DEFAULT NULL,
  `location_id` varchar(20) DEFAULT NULL,
  `semester_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`course_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_record`
--

LOCK TABLES `course_record` WRITE;
/*!40000 ALTER TABLE `course_record` DISABLE KEYS */;
INSERT INTO `course_record` VALUES ('102005','17:15','19:45','Fri','','654',0,'34','0','ANTH','60844794','10','MS','Hb','1','201048'),('103036','14:00','15:15','Mon','Tues','814',0,'33','0','ENGR','30263133','115','ES','Itn','1','332777'),('109515','12:00','14:30','Sat','','704',0,'49','0','ART','96386214','14','RAS','Hb','1','422891'),('112543','16:30','19:00','Fri','','827',0,'39','0','ART','72629089','20','RAS','Itn','1','102001'),('120611','12:15','14:45','Sat','','810',0,'41','0','BIOL','40852884','22','SS','FtF','1','124960'),('122014','11:30','14:00','Sat','','270',0,'33','0','DATA','60844794','80','MS','FtF','1','471077'),('132119','14:30','15:45','Wed','Thurs','314',0,'44','0','ECO','95765013','97','EF','FtF','1','102001'),('177292','9:00','11:30','Sat','','389',0,'35','0','ANTH','24995143','11','ES','Hb','1','528304'),('178927','14:00','16:30','Fri','','386',0,'35','0','ACC','21019315','5','SS','Hb','1','300571'),('179884','12:30','15:00','Sat','','685',0,'43','0','ENG','39176927','112','SS','Hb','1','124960'),('186049','18:15','20:45','Fri','','669',1,'39','0','CS','24995143','60','RAS','Hb','1','528304'),('193408','14:00','15:15','Mon','','526',0,'26','0','CS','88701293','53','EF','Itn','1','528304'),('196480','9:30','12:00','Fri','','477',0,'42','0','DATA','24995143','80','MS','FtF','1','471077'),('196833','14:15','15:30','Mon','Tues','536',0,'44','0','ENG','21019315','111','MS','Hb','1','471077'),('202198','11:00','12:15','Mon','Tues','767',0,'47','0','CHEM','98145858','44','SS','Hb','1','465943'),('215376','10:45','13:15','Sat','','763',0,'39','0','ART','72629089','16','RAS','Hb','1','102001'),('235356','16:00','18:30','Sat','','823',0,'43','0','ANTH','94786594','12','RAS','Hb','1','471077'),('238636','9:45','12:15','Sat','','782',0,'43','0','ANTH','40852884','12','ES','FtF','1','201048'),('243342','14:30','15:45','Mon','Tues','189',0,'38','0','EET','39176927','102','MS','Itn','1','201048'),('262656','17:45','19:00','Wed','Thurs','401',0,'46','0','DATA','88701293','83','SS','Itn','1','124960'),('269012','13:00','14:15','Mon','Tues','169',0,'35','0','COMM','35098773','47','MS','Hb','1','465943'),('269769','18:30','21:00','Sat','','835',0,'48','0','DRA','60844794','75','SS','Hb','1','201048'),('326602','13:15','15:45','Fri','','397',0,'47','0','ANTH','35098773','10','RAS','Hb','1','422891'),('329706','18:45','20:00','Mon','Wed','248',1,'35','0','ANTH','72629089','11','RAS','Hb','1','528304'),('356711','15:45','17:00','Mon','Wed','559',1,'26','0','CS','21019315','59','RAS','Hb','1','528304'),('357046','9:45','12:15','Fri','','213',0,'32','0','CHEM','94786594','43','RAS','FtF','1','124960'),('376819','13:30','14:45','Mon','Tues','498',0,'47','0','DRA','88701293','71','EF','FtF','1','332777'),('379472','17:15','18:30','Wed','Thurs','524',0,'35','0','ENGR','35098773','119','RAS','Hb','1','300571'),('396210','16:45','18:00','Wed','Thurs','353',0,'38','0','ANTH','88701293','10','ES','Itn','1','465943'),('400431','13:00','14:15','Mon','Tues','602',0,'35','0','DATA','94786594','81','MS','FtF','1','300571'),('401357','11:45','13:00','Mon','Tues','973',0,'31','0','ECO','60844794','92','MS','Itn','1','471077'),('409498','17:30','18:45','Mon','Tues','328',0,'44','0','ENG','94786594','110','RAS','Itn','1','332777'),('418685','18:15','20:45','Sat','','867',0,'39','0','ECO','35098773','92','SS','Itn','1','102001'),('421952','16:15','18:45','Sat','','556',0,'38','0','ENGR','52164921','115','ES','FtF','1','102001'),('427999','16:45','18:00','Wed','Thurs','138',0,'39','0','EET','94786594','100','RAS','FtF','1','422891'),('439005','17:30','18:45','Tues','Thurs','334',1,'31','0','BA','94786594','31','EF','Hb','1','528304'),('444619','13:15','14:30','Mon','Tues','924',0,'38','0','CHEM','24995143','38','SS','Itn','1','465943'),('456102','16:30','19:00','Fri','','699',0,'36','0','ECO','60844794','95','ES','FtF','1','471077'),('467616','9:15','10:30','Mon','Tues','132',0,'33','0','ECO','88701293','92','EF','Hb','1','201048'),('471417','17:00','18:15','Mon','Wed','736',1,'35','0','ENGR','24995143','118','SS','Itn','1','528304'),('479115','16:15','18:45','Sat','','429',0,'41','0','ART','21019315','20','ES','Hb','1','465943'),('479921','16:00','17:15','Mon','Tues','416',0,'35','0','ACC','35098773','9','RAS','Hb','1','662578'),('485484','18:30','19:45','Mon','Tues','354',0,'38','0','ACC','24995143','6','EF','FtF','1','662578'),('494975','9:30','12:00','Fri','','954',0,'41','0','ENGR','96386214','115','RAS','Itn','1','662578'),('501851','19:45','21:00','Mon','Tues','244',0,'45','0','ANTH','30263133','13','EF','Itn','1','422891'),('522130','11:45','14:15','Fri','','957',0,'43','0','EET','98145858','104','EF','Itn','1','124960'),('542945','17:00','12:00','Fri','','387',0,'39','0','CHEM','30263133','40','RAS','Hb','1','471077'),('550035','8:00','9:15','Wed','Thurs','375',0,'45','0','BA','96386214','32','ES','Hb','1','471077'),('554148','16:45','19:15','Fri','','661',0,'33','0','CS','94786594','55','RAS','Itn','1','528304'),('561010','9:45','12:15','Sat','','765',0,'45','0','ENGR','21019315','118','ES','Itn','1','102001'),('578671','8:15','9:30','Wed','Thurs','290',0,'32','0','ENG','21019315','109','MS','FtF','1','662578'),('589094','11:45','14:15','Sat','','510',0,'30','0','ECO','94786594','91','EF','Hb','1','471077'),('603945','19:15','21:45','Sat','','617',1,'32','0','ANTH','72629089','10','EF','Hb','1','528304'),('616006','13:45','15:00','Mon','Wed','709',1,'29','0','ACC','35098773','4','ES','Hb','1','528304'),('616529','19:45','22:15','Fri','','541',0,'48','0','ENG','39176927','114','MS','FtF','1','124960'),('635599','8:30','9:45','Wed','Thurs','660',0,'39','0','CS','72629089','55','EF','Hb','1','300571'),('639022','18:15','20:45','Sat','','666',0,'35','0','ACC','98145858','9','MS','FtF','1','662578'),('643608','9:15','11:45','Sat','','173',0,'38','0','COMM','72629089','48','MS','FtF','1','332777'),('643710','17:45','20:15','Fri','','284',0,'41','0','ANTH','98145858','12','SS','FtF','1','102001'),('649305','17:30','18:45','Mon','Wed','518',1,'26','0','BA','98145858','36','MS','FtF','1','528304'),('659134','13:45','15:00','Mon','Tues','443',0,'36','0','ENGR','94786594','116','ES','FtF','1','465943'),('660055','12:30','13:45','Mon','Tues','268',0,'36','0','ENG','88701293','112','ES','FtF','1','662578'),('675680','11:30','14:00','Fri','','245',0,'36','0','COMM','21019315','46','SS','FtF','1','332777'),('690571','13:15','15:45','Sat','','282',1,'35','0','DATA','52164921','82','ES','Hb','1','528304'),('706602','9:30','10:45','Wed','Thurs','906',0,'39','0','BA','95765013','36','MS','Hb','1','102001'),('711193','14:45','16:00','Mon','Tues','759',0,'44','0','ANTH','30263133','10','EF','FtF','1','300571'),('718586','8:30','9:45','Tues','Thurs','216',1,'20','0','ANTH','39176927','11','RAS','FtF','1','528304'),('735079','9:15','11:45','Fri','','311',0,'45','0','CHEM','98145858','38','SS','FtF','1','300571'),('736408','14:30','17:00','Sat','','820',0,'34','0','CS','60844794','66','EF','Itn','1','124960'),('741227','18:15','20:45','Sat','','326',1,'39','0','BA','98145858','30','MS','Hb','1','528304'),('755522','16:15','18:45','Sat','','732',0,'32','0','EET','30263133','98','MS','Itn','1','124960'),('770331','14:15','16:45','Fri','','809',0,'46','0','ACC','35098773','7','EF','Hb','1','422891'),('820240','18:15','19:30','Mon','Tues','284',0,'35','0','CHEM','94786594','40','SS','Hb','1','124960'),('823661','17:15','18:30','Mon','Tues','781',0,'34','0','ART','35098773','19','EF','FtF','1','300571'),('844599','10:30','11:45','Wed','Thurs','416',0,'46','0','EET','35098773','104','MS','Hb','1','124960'),('858107','11:00','12:15','Mon','Wed','447',1,'33','0','BA','98145858','35','ES','Hb','1','528304'),('863958','11:30','12:45','Mon','Tues','192',0,'48','0','BA','39176927','33','MS','Itn','1','332777'),('870232','18:15','19:30','Mon','Tues','674',0,'35','0','ANTH','60844794','13','EF','FtF','1','471077'),('870768','14:00','15:15','Mon','Tues','906',0,'49','0','ENG','94786594','113','EF','FtF','1','201048'),('870847','13:15','15:45','Fri','','896',0,'39','0','EET','60844794','99','SS','Hb','1','662578'),('876327','17:45','19:00','Mon','Wed','787',0,'29','0','ENGR','60844794','117','MS','FtF','1','528304'),('889156','8:15','10:45','Sat','','830',0,'48','0','ECO','52164921','92','RAS','FtF','1','422891'),('894013','9:30','10:45','Mon','Wed','325',1,'30','0','BIOL','35098773','25','RAS','FtF','1','528304'),('906664','11:30','14:00','Fri','','353',0,'49','0','BIOL','98145858','24','EF','Hb','1','422891'),('909659','11:15','12:30','Mon','Wed','506',1,'30','0','BIOL','24995143','26','RAS','FtF','1','528304'),('911786','10:45','12:00','Mon','Tues','802',0,'44','0','EET','96386214','98','RAS','Hb','1','201048'),('913218','16:15','17:30','Mon','Wed','800',1,'27','0','ENGR','60844794','115','MS','Itn','1','528304'),('920963','12:15','13:30','Mon','Tues','669',0,'45','0','ACC','30263133','7','RAS','Itn','1','300571'),('929802','8:00','10:30','Sat','','470',1,'40','0','ART','21019315','21','EF','Itn','1','528304'),('930897','19:30','22:00','Sat','','766',0,'50','0','COMM','88701293','47','SS','FtF','1','124960'),('934065','18:00','20:30','Sat','','285',0,'31','0','DATA','30263133','81','ES','Hb','1','124960'),('946778','13:00','15:30','Fri','','440',0,'33','0','ECO','94786594','93','RAS','Itn','1','124960'),('960866','11:00','13:30','Fri','','610',0,'25','0','ENGR','94786594','117','SS','Itn','1','528304'),('964806','11:00','13:30','Fri','','384',0,'46','0','BIOL','21019315','26','ES','Itn','1','332777'),('965977','10:45','12:00','Mon','Wed','414',0,'35','0','COMM','95765013','48','RAS','FtF','1','528304'),('980306','10:00','11:15','Mon','Tues','683',0,'47','0','ANTH','24995143','13','SS','Itn','1','201048'),('987300','9:45','12:15','Fri','','735',0,'42','0','COMM','60844794','49','MS','Hb','1','201048'),('990551','17:00','18:15','Wed','Thurs','197',0,'33','0','DATA','40852884','80','ES','Itn','1','471077'),('999299','13:45','16:15','Fri','','824',0,'37','0','CS','24995143','66','ES','Hb','1','528304'),('999894','19:15','21:45','Fri','','627',0,'43','0','DATA','30263133','83','MS','Hb','1','465943');
/*!40000 ALTER TABLE `course_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_session`
--

DROP TABLE IF EXISTS `course_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_session` (
  `session_id` varchar(20) NOT NULL,
  `session_name` varchar(50) NOT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_session`
--

LOCK TABLES `course_session` WRITE;
/*!40000 ALTER TABLE `course_session` DISABLE KEYS */;
INSERT INTO `course_session` VALUES ('EF','Eight Week - First'),('ES','Eight Week - Second'),('MS','Mini Section'),('RAS','Regular Academic Session'),('SS','Second Start');
/*!40000 ALTER TABLE `course_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_subject`
--

DROP TABLE IF EXISTS `course_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_subject` (
  `subject_id` varchar(20) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_subject`
--

LOCK TABLES `course_subject` WRITE;
/*!40000 ALTER TABLE `course_subject` DISABLE KEYS */;
INSERT INTO `course_subject` VALUES ('ACC','Accounting'),('ANTH','Anthropology'),('ART','Art'),('BA','Business Administration'),('BIOL','Biology'),('CHEM','Chemistry'),('COMM','Communication'),('CS','Computer Science'),('DATA','Data Science'),('DRA','Drama'),('ECO','Economics'),('EET','Electrical Engineering Technology'),('ENG','English'),('ENGR','Engineering'),('FIN','Finance'),('GEOG','Geography'),('GEOL','Geology'),('HEA','Health'),('HIST','History'),('MATH','Mathematics'),('MBIO','Microbiology'),('MGT','Management'),('MKT','Marketing'),('MUS','Music'),('PHIL','Philosophy'),('PHYS','Physics'),('POLS','Political Science'),('PSY','Psychology'),('SOC','Sociology'),('SOCW','Social Work'),('STAT','Statistics');
/*!40000 ALTER TABLE `course_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `degree` (
  `degree_id` varchar(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` VALUES ('1','Undergradutate (BS/BA)'),('2','Master (MS/MA)'),('3','Doctor (PhD)');
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_location`
--

DROP TABLE IF EXISTS `school_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `school_location` (
  `location_id` varchar(20) NOT NULL,
  `location_name` varchar(100) NOT NULL,
  `location_address_street` varchar(50) NOT NULL,
  `location_address_city` varchar(50) NOT NULL,
  `location_address_state` varchar(50) NOT NULL,
  `location_address_zip` int NOT NULL,
  `location_phone` varchar(50) NOT NULL,
  `location_email` varchar(100) NOT NULL,
  `location_fax` varchar(50) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_location`
--

LOCK TABLES `school_location` WRITE;
/*!40000 ALTER TABLE `school_location` DISABLE KEYS */;
INSERT INTO `school_location` VALUES ('1','University of Houston-Downtown','One N Main St','Houston','TX',77002,'713-221-8000','uhdinfo@uhd.edu','713-223-7680');
/*!40000 ALTER TABLE `school_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester_term`
--

DROP TABLE IF EXISTS `semester_term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semester_term` (
  `term_id` varchar(20) NOT NULL,
  `term_name` varchar(10) DEFAULT NULL,
  `term_year` int DEFAULT NULL,
  `term_current` int DEFAULT '0',
  `term_start` datetime DEFAULT NULL,
  `term_end` datetime DEFAULT NULL,
  PRIMARY KEY (`term_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester_term`
--

LOCK TABLES `semester_term` WRITE;
/*!40000 ALTER TABLE `semester_term` DISABLE KEYS */;
INSERT INTO `semester_term` VALUES ('102001','Fall',2017,0,'2017-08-19 12:00:00','2017-12-11 12:00:00'),('124960','Spring',2017,0,'2017-01-13 12:00:00','2017-05-07 12:00:00'),('147156','Summer',2020,2,'2020-06-01 12:00:00','2020-07-25 12:00:00'),('201048','Fall',2018,0,'2018-08-19 12:00:00','2018-12-11 12:00:00'),('300571','Summer',2017,0,'2017-06-01 12:00:00','2017-07-25 12:00:00'),('332777','Spring',2018,0,'2018-01-13 12:00:00','2018-05-07 12:00:00'),('422891','Summer',2019,0,'2019-06-01 12:00:00','2019-07-25 12:00:00'),('465943','Spring',2019,0,'2019-01-13 12:00:00','2019-05-07 12:00:00'),('471077','Summer',2018,0,'2018-06-01 12:00:00','2018-07-25 12:00:00'),('528304','Spring',2020,1,'2020-01-13 12:00:00','2020-05-07 12:00:00'),('662578','Fall',2019,0,'2019-08-19 12:00:00','2019-12-11 12:00:00');
/*!40000 ALTER TABLE `semester_term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_information`
--

DROP TABLE IF EXISTS `staff_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_information` (
  `id` varchar(20) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(10) unsigned zerofill NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `zip` int NOT NULL,
  `salary` int NOT NULL DEFAULT '0',
  `birthday` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_information`
--

LOCK TABLES `staff_information` WRITE;
/*!40000 ALTER TABLE `staff_information` DISABLE KEYS */;
INSERT INTO `staff_information` VALUES ('21019315','Holder3','Kayden Contreras','Holder','1234abcd','Holder@gator.uhd.edu',3462191750,'410 Ann Ave.','Houston','TX',77215,0,'1985-03-27 00:00:00'),('24995143','hat9','Tong','Ha','1234abcd','hat9@uhd.edu',0987654321,'8518 Battle','Houston','TX',77040,0,'2004-02-19 00:00:00'),('30263133','Villa5','Abraham Lowe','Villa','1234abcd','Villa@gator.uhd.edu',0610619792,'7303 Linda Lane','Houston','TX',77204,0,'1978-12-26 00:00:00'),('35098773','Hays10','Lyric Mccormick','Hays','1234abcd','Hays@gator.uhd.edu',0695496588,'12 NE. Wilson St.','Houston','TX',77366,0,'1973-06-19 00:00:00'),('39176927','Wilkinson22','Mohammad Hudson','Wilkinson','1234abcd','Wilkinson@gator.uhd.edu',0528989915,'20 Canal Dr.','Houston','TX',77483,0,'1969-12-23 00:00:00'),('40852884','Yang22','Finnegan Knight','Yang','1234abcd','Yang@gator.uhd.edu',0176979827,'445 Surrey Ave.','Houston','TX',77588,0,'1991-07-03 00:00:00'),('52164921','Tapia9','Steven Mckay','Tapia','1234abcd','Tapia@gator.uhd.edu',0668559236,'457 Rose Ave.','Houston','TX',77118,0,'1966-09-30 00:00:00'),('60844794','Lester26','Jocelyn Thornton','Lester','1234abcd','Lester@gator.uhd.edu',0411671375,'93 Atlantic Drive','Houston','TX',77413,0,'1966-07-04 00:00:00'),('72629089','Moran22','Moses Olsen','Moran','1234abcd','Moran@gator.uhd.edu',0234345984,'109 Temple Lane','Houston','TX',77250,0,'1965-07-26 00:00:00'),('88701293','Mccoy19','Juliet Roman','Mccoy','1234abcd','Mccoy@gator.uhd.edu',0919926741,'960 Williams Court','Houston','TX',77918,0,'1975-11-11 00:00:00'),('94786594','Mcneil30','Mohammad Reyes','Mcneil','1234abcd','Mcneil@gator.uhd.edu',0645068476,'686 Constitution St.','Houston','TX',77809,0,'1992-09-05 00:00:00'),('95765013','henryd3','David','Henry','davidhenry1999','henryd3@gator.uhd.edu',0123405678,'3245 Spring Cypress','Houston','TX',77086,0,'1999-07-13 00:00:00'),('96386214','Bray22','Cyrus Moore','Bray','1234abcd','Bray@gator.uhd.edu',0827614604,'9621 Lantern St.','Houston','TX',77108,0,'1991-08-16 00:00:00'),('98145858','Mccullough5','Wyatt Clark','Mccullough','1234abcd','Mccullough@gator.uhd.edu',0692294842,'38 Cleveland Ave.','Houston','TX',77323,0,'1968-10-19 00:00:00');
/*!40000 ALTER TABLE `staff_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_record`
--

DROP TABLE IF EXISTS `student_course_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course_record` (
  `record_id` varchar(20) NOT NULL,
  `student_id` varchar(20) NOT NULL,
  `current_course_id` varchar(20) NOT NULL,
  `attempted` varchar(45) DEFAULT NULL,
  `earned` varchar(45) DEFAULT NULL,
  `final_letter_grade` varchar(1) DEFAULT NULL,
  `points` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_record`
--

LOCK TABLES `student_course_record` WRITE;
/*!40000 ALTER TABLE `student_course_record` DISABLE KEYS */;
INSERT INTO `student_course_record` VALUES ('115883','51984513','649305','3',NULL,NULL,NULL),('117287','51984513','479115','3','3','B','9'),('151742','51984513','561010','1','1','A','4'),('173102','51984513','215376','3','3','B','9'),('196228','51984513','444619','3','3','A','12'),('250843','51984513','690571','4',NULL,NULL,NULL),('284506','51984513','894013','1',NULL,NULL,NULL),('305765','51984513','269012','4','4','B','12'),('313041','51984513','635599','3','3','A','12'),('338772','51984513','999299','3',NULL,NULL,NULL),('433117','51984513','179884','4','4','B','12'),('443811','51984513','522130','1','1','A','4'),('448250','51984513','987300','3','3','A','12'),('460338','51984513','911786','4','4','B','12'),('491613','51984513','479921','1','1','A','4'),('495152','51984513','485484','3','3','B','9'),('558974','51984513','711193','1','0','F','0'),('568294','51984513','471417',NULL,NULL,NULL,NULL),('656288','51984513','735079','4','4','B','12'),('669586','51984513','660055','4','4','A','16'),('683259','51984513','178927','3','3','A','12'),('723008','51984513','418685','3','3','A','12'),('736667','51984513','999894','1','1','A','4'),('746699','51984513','578671','1','0','F','0'),('784242','51984513','102005','3','3','A','12'),('884641','51984513','467616','3','3','B','9'),('915044','51984513','262656','1','1','A','4'),('919593','51984513','844599','3','3','B','9'),('933791','51984513','706602','3','3','A','12');
/*!40000 ALTER TABLE `student_course_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_information`
--

DROP TABLE IF EXISTS `student_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_information` (
  `id` varchar(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` int(10) unsigned zerofill NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip` int(5) unsigned zerofill NOT NULL,
  `birthday` date DEFAULT NULL,
  `subject` varchar(100) NOT NULL,
  `degree` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_information`
--

LOCK TABLES `student_information` WRITE;
/*!40000 ALTER TABLE `student_information` DISABLE KEYS */;
INSERT INTO `student_information` VALUES ('23548181','masseyj7','Jacob','Massey','1234','masseyj7@student.gator.edu',0510437867,'398 Jackson Avenue','Garfield','NJ',07026,'2004-10-07','Undergradutate (BS/BA)','Data Science'),('51984513','hat8','Tong','Ha','1234abcd','hat8@student.gator.edu',3353568879,'8515 Battle Plains','Houston','TX',77040,'1990-02-18','Undergradutate (BS/BA)','Computer Science'),('68413517','aguilard2','Delbert','Aguilar','1234','aguilard2@student.gator.edu',0324231232,'7456 Country St.','Indianapolis','IN',46201,'2007-03-12','Undergradutate (BS/BA)','Data Science'),('68415313','vul6','Long','Vu','1234','vul6@gator.uhd.edu',0654789145,'666 Street Name','City Name','State',00254,'2001-05-16','Undergradutate (BS/BA)','Biology'),('81351353','taylorj1','John','Taylor','1234','taylorj1@student.gator.edu',0342354234,'877 Wellington Ave.','Maplewood','NJ',07040,'2002-11-01','Undergradutate (BS/BA)','Data Science'),('82371255','user','firstname','lastname','1234','firstlast@student.gator.edu',0123456789,'1111 Street','City','State',00000,'1990-02-02','Undergradutate (BS/BA)','Engineering'),('84511787','deanw6','winchester','dean','1234','deanw6@student.gator.edu',0123456789,'1234 abcd','houston','tx',77051,'2008-02-06','Undergradutate (BS/BA)','Geology'),('85165225','fegusona0','Alex','Feguson','1234','fegusona0@student.gator.edu',0231444113,'342 Breen Dr','Houston','TX',77068,'1983-02-10','Undergradutate (BS/BA)','Engineering'),('85562146','greenem2','Melba','Greene','1234','greenem2@student.gator.edu',0806835285,'961 Rock Creek St.','Niagara Falls','NY',14304,'1987-07-22','Undergradutate (BS/BA)','Geology'),('85761637','phamt4','Thao','Pham','1234','phamt4@student.gator.edu',0032473242,'62 Chestnut Road','Ontario','CA',91762,'1989-04-14','Undergradutate (BS/BA)','Geology'),('95162056','gutierreza3','Annette','Gutierrez','1234','gutierreza3@student.gator.edu',0573822862,'7384 Coffee Drive','Greensboro','NC',27405,'1993-08-23','Undergradutate (BS/BA)','Geology'),('95262014','austind5','Diana','Austin','1234','austind5@student.gator.edu',0202555019,'77 Laurel Street','Southampton','PA',18966,'1994-09-15','Undergradutate (BS/BA)','Computer Science');
/*!40000 ALTER TABLE `student_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_work`
--

DROP TABLE IF EXISTS `student_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_work` (
  `work_id` varchar(10) NOT NULL,
  `course_id` varchar(45) DEFAULT NULL,
  `work_type_id` varchar(45) DEFAULT NULL,
  `work_title` varchar(200) DEFAULT NULL,
  `work_description` varchar(1000) DEFAULT NULL,
  `grade_max` int DEFAULT '100',
  `percentage` int DEFAULT '0',
  `time_due` datetime DEFAULT NULL,
  PRIMARY KEY (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_work`
--

LOCK TABLES `student_work` WRITE;
/*!40000 ALTER TABLE `student_work` DISABLE KEYS */;
INSERT INTO `student_work` VALUES ('386431','999299','315486','Exam 1','Duration: 60min\nNote: Close book, 1 cheat sheet.\nChapter: 1, 2, 3, 4, 5\nSoftware: Netbean / Visual Studio\nLanguages: Java / C++ / C# / Python. ',100,20,'2020-03-31 00:00:00'),('397318','999299','684351','Homework Week 1','Introduce yourself!',100,10,'2020-03-31 00:00:00'),('874710','999299','684351','Homework Week 2','Do whatever you want!',100,30,'2020-03-31 00:00:00');
/*!40000 ALTER TABLE `student_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_work_record`
--

DROP TABLE IF EXISTS `student_work_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_work_record` (
  `student_work_record_id` varchar(10) NOT NULL,
  `student_id` varchar(45) DEFAULT NULL,
  `course_id` varchar(45) DEFAULT NULL,
  `grade_get` int DEFAULT NULL,
  `work_submission` varchar(5000) DEFAULT NULL,
  `time_complete` datetime DEFAULT NULL,
  `work_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_work_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_work_record`
--

LOCK TABLES `student_work_record` WRITE;
/*!40000 ALTER TABLE `student_work_record` DISABLE KEYS */;
INSERT INTO `student_work_record` VALUES ('168269','51984513','999299',71,'My name is someone','2020-03-24 20:57:27','397318'),('222921','51984513','999299',71,'I have no idea what you mean?','2020-03-24 21:25:41','386431'),('674641','51984513','999299',93,'my answer is anything','2020-03-24 20:59:55','874710');
/*!40000 ALTER TABLE `student_work_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_type`
--

DROP TABLE IF EXISTS `work_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_type` (
  `work_type_id` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`work_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_type`
--

LOCK TABLES `work_type` WRITE;
/*!40000 ALTER TABLE `work_type` DISABLE KEYS */;
INSERT INTO `work_type` VALUES ('158635','Exam'),('315486','Quiz'),('684351','Homework');
/*!40000 ALTER TABLE `work_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-26 12:29:21
