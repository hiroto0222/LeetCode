--
-- @lc app=leetcode id=1527 lang=mysql
--
-- [1527] Patients With a Condition
--

-- @lc code=start
# Write your MySQL query statement below

-- 1. return patient_id, patient_name and conditions
-- 2. where patient has DIAB1 prefix in conditions

SELECT *
FROM patients
WHERE conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%';

-- @lc code=end

