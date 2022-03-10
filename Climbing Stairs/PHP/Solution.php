<?php
declare(strict_types=1);

function climbingStairs(int $numberOfStairs) {

    if ($numberOfStairs <= 2 && $numberOfStairs >= 0) {
        return $numberOfStairs;
    } elseif ($numberOfStairs < 0) {
        return 0;
    }

    $a = 0;
    $b = 1;
    $c = 2;

    while ($numberOfStairs > 2) {
        $a = $b;
        $b = $c;
        $c = $a + $b;
        $numberOfStairs = $numberOfStairs - 1;
    }

    return $c;
}