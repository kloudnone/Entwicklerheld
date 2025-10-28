<?php
declare(strict_types=1);

function fizzbuzz(int $number) {
    if ($number % 15 === 0) {
        $res = "fizzbuzz";
    } elseif ($number % 3 === 0) {
        $res = "fizz";
    } elseif ($number % 5 === 0) {
        $res = "buzz";
    } else {
        $res = $number;
    }

    return $res;
}