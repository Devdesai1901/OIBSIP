
CREATE TABLE `examquizs` (
  `id` int NOT NULL,
  `userid` varchar(50) NOT NULL,
  `qid` int NOT NULL,
  `uans` char(1) DEFAULT NULL,
  `cans` char(1) NOT NULL,
  `time` int NOT NULL DEFAULT '0'
);

-- --------------------------------------------------------

--
-- Table structure for table `exams`
--

CREATE TABLE `exams` (
  `id` int NOT NULL,
  `userid` varchar(50) NOT NULL,
  `examdate` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `result` varchar(20) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int NOT NULL,
  `question` varchar(50) NOT NULL,
  `qpic` varchar(50)  NOT NULL,
  `cans` char(1) NOT NULL
);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` varchar(50) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `gender` varchar(20)  DEFAULT NULL,
  `utype` varchar(20)  DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `role` varchar(20) NOT NULL
);

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `uname`, `pwd`, `gender`, `utype`, `email`, `age`, `education`, `occupation`, `address`, `role`) VALUES
('admin', 'Administrator', 'admin', 'Male', '0', NULL, NULL, NULL, NULL, NULL, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `examquizs`
--
ALTER TABLE `examquizs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `exams`
--
ALTER TABLE `exams`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `examquizs`
--
ALTER TABLE `examquizs`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `exams`
--
ALTER TABLE `exams`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;
COMMIT;

