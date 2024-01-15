Function FizzBuzz ([int]$Number) {
    $Threes = $Number%3
    $Fives = $Number%5

    if (($Threes -eq 0) -and ($Fives -eq 0)) {
        Write-Output "fizzbuzz"
    } elseif ($Threes -eq 0) {
        Write-Output "fizz"
    } elseif ($Fives -eq 0) {
        Write-Output "buzz"
    } else {
        Write-Output $Number
    }
}