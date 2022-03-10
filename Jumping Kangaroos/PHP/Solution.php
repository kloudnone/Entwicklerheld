<?php
declare(strict_types=1);

function isCompletable(array $nums): bool
{
    $res = true;
        $jumpBalance = 1;
        $length = count($nums);

        for($i = 0; $i < $length; $i++) {
            $val = $nums[$i];
            $jumpBalance--;
            if($val === 0) {
                if(
                    $i < $length-1 
                    && $jumpBalance <= 0
                ) {
                    return false;
                } else if($jumpBalance < 0) {
                   break; 
                }
            } else if($jumpBalance < $val) {
                $jumpBalance = $val;
            }
        }

        if($jumpBalance < 0) {
            $res = false;
        }

        return $res;
}

function getMinimalNumberOfJumps(array $nums): int 
{
    if(
        count($nums) < 2
        || isCompletable($nums) === false
    ) {
        return 0;
    }
    $next = 0;
    $current = 0;
    $steps = 0;
    for($i=0;$i<count($nums);++$i) {
        $current = max($current,$i+$nums[$i]);
        if ($current >= count($nums)-1) {
            return $steps+1;
        }
        if($i === $next) {
            $next = $current;
            $steps++;
        }
    }
    return 0;
}