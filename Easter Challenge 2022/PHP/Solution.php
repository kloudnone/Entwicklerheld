<?php
declare(strict_types=1);

function calculate_easter_sunday(int $year): DateTime {
    
    $a = $year % 19;
    $b = (int)($year / 100);
    $c = (int)($b - ($b /4) - (int)((8 * $b + 13) / 25) + 19 * $a + 15) % 30;
    $d =  (int)$c - (int)($c / 28) * (1 - (int)($c / 28) * (int)(29 / ($c + 1)) * ((int)(21 - $a) / 11));
    $e = ($year + (int)($year / 4)+ $d + 2 - $b + (int)($b / 4)) % 7;
    $f = $d - $e;
    $month = 3 + (int)(($f + 40) / 44);
    $day = (int)($f + 28 - 31 * (int)($month / 4));

    $easterSunday = new DateTime();
    $easterSunday->setDate($year, (int)$month, (int)$day);
    
    return $easterSunday;
}

function calculate_easter_days(int $year): array {
    $easterSunday = calculate_easter_sunday($year);
    
    $easterFriday = clone $easterSunday;
    $easterFriday->modify('-2 day');

    $easterMonday = clone $easterSunday;
    $easterMonday->modify('+1 day');

    return [
        $easterFriday,
        $easterSunday,
        $easterMonday
    ];
}