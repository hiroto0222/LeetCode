--
-- @lc app=leetcode id=1873 lang=mysql
--
-- [1873] Calculate Special Bonus
--

-- @lc code=start
# Write your MySQL query statement below

-- return employee_id and bonus
-- bonus:
-- if employee_id is odd and name does not start with 'M' -> 100% of salary
-- else -> 0

SELECT employee_id, (
  CASE WHEN employee_id % 2 != 0 AND name NOT LIKE 'M%' THEN salary
  ELSE 0
  END
) AS bonus
FROM employees
ORDER BY employee_id;

-- @lc code=end

